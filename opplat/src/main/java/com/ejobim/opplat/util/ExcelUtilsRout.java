package com.ejobim.opplat.util;

import com.ejobim.opplat.domain.ExcelColumn;
import com.ejobim.opplat.domain.TbEquipInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wjl
 * @description excel工具类
 * @date 2019/06/24 10:27
 **/
public class ExcelUtilsRout {

    private final static Logger log = LoggerFactory.getLogger(ExcelUtilsRout.class);

    private final static String EXCEL2003 = "xls";
    private final static String EXCEL2007 = "xlsx";

    public static <T> List<T> readExcel(String path, Class<T> cls,MultipartFile file){

        String fileName = file.getOriginalFilename();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            log.error("上传文件格式不正确");
        }
        List<T> dataList = new ArrayList<>();
        Workbook workbook = null;
        try {
            InputStream is = file.getInputStream();
            if (fileName.endsWith(EXCEL2003)) {
//                FileInputStream is = new FileInputStream(new File(path));
                workbook = new HSSFWorkbook(is);
            }
            if (fileName.endsWith(EXCEL2007)) {
//                FileInputStream is = new FileInputStream(new File(path));
                workbook = new XSSFWorkbook(is);
            }
            if (workbook != null) {
                //类映射  注解 value-->bean columns
                Map<String, List<Field>> classMap = new HashMap<>();
                List<Field> fields = Stream.of(cls.getDeclaredFields()).collect(Collectors.toList());
                fields.forEach(
                        field -> {
                            ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
                            if (annotation != null) {
                                String value = annotation.value();
                                if (StringUtils.isBlank(value)) {
                                    return;//return起到的作用和continue是相同的 语法
                                }
                                if (!classMap.containsKey(value)) {
                                    classMap.put(value, new ArrayList<>());
                                }
                                field.setAccessible(true);
                                classMap.get(value).add(field);
                            }
                        }
                );
                //索引-->columns
                Map<Integer, List<Field>> reflectionMap = new HashMap<>(16);
                //默认读取第一个sheet
                Sheet sheet = workbook.getSheetAt(0);

                boolean firstRow = true;
                for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    //首行  提取注解
                    if (firstRow) {
                        for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                            Cell cell = row.getCell(j);
                            String cellValue = getCellValue(cell);
                            if (classMap.containsKey(cellValue)) {
                                reflectionMap.put(j, classMap.get(cellValue));
                            }
                        }
                        firstRow = false;
                    } else {
                        //忽略空白行
                        if (row == null) {
                            continue;
                        }
                        try {
                            T t = cls.newInstance();
                            //判断是否为空白行
                            boolean allBlank = true;
                            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                                if (reflectionMap.containsKey(j)) {
                                    Cell cell = row.getCell(j);
                                    String cellValue = getCellValue(cell);
                                    if (StringUtils.isNotBlank(cellValue)) {
                                        allBlank = false;
                                    }
                                    List<Field> fieldList = reflectionMap.get(j);
                                    fieldList.forEach(
                                            x -> {
                                                try {
                                                    handleField(t, cellValue, x);
                                                } catch (Exception e) {
                                                    log.error(String.format("reflect field:%s value:%s exception!", x.getName(), cellValue), e);
                                                }
                                            }
                                    );
                                }
                            }
                            if (!allBlank) {
                                dataList.add(t);
                            } else {
                                log.warn(String.format("row:%s is blank ignore!", i));
                            }
                        } catch (Exception e) {
                            log.error(String.format("parse row:%s exception!", i), e);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(String.format("parse excel exception!"), e);
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    log.error(String.format("parse excel exception!"), e);
                }
            }
        }
        return dataList;
    }

    private static <T> void handleField(T t, String value, Field field) throws Exception {
        Class<?> type = field.getType();
        if (type == null || type == void.class || StringUtils.isBlank(value)) {
            return;
        }
        if (type == Object.class) {
            field.set(t, value);
            //数字类型
        } else if (type.getSuperclass() == null || type.getSuperclass() == Number.class) {
            if (type == int.class || type == Integer.class) {
                field.set(t, NumberUtils.toInt(value));
            } else if (type == long.class || type == Long.class) {
                field.set(t, NumberUtils.toLong(value));
            } else if (type == byte.class || type == Byte.class) {
                field.set(t, NumberUtils.toByte(value));
            } else if (type == short.class || type == Short.class) {
                field.set(t, NumberUtils.toShort(value));
            } else if (type == double.class || type == Double.class) {
                field.set(t, NumberUtils.toDouble(value));
            } else if (type == float.class || type == Float.class) {
                field.set(t, NumberUtils.toFloat(value));
            } else if (type == char.class || type == Character.class) {
                field.set(t, CharUtils.toChar(value));
            } else if (type == boolean.class) {
                field.set(t, BooleanUtils.toBoolean(value));
            } else if (type == BigDecimal.class) {
                field.set(t, new BigDecimal(value));
            }
        } else if (type == Boolean.class) {
            field.set(t, BooleanUtils.toBoolean(value));
        } else if (type == Date.class) {
            //
            field.set(t, value);
        } else if (type == String.class) {
            field.set(t, value);
        } else {
            Constructor<?> constructor = type.getConstructor(String.class);
            field.set(t, constructor.newInstance(value));
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
            } else {
                return new BigDecimal(cell.getNumericCellValue()).toString();
            }
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return StringUtils.trimToEmpty(cell.getStringCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return StringUtils.trimToEmpty(cell.getCellFormula());
        } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            return "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            return "ERROR";
        } else {
            return cell.toString().trim();
        }

    }

    public static <T> void writeExcel(HttpServletResponse response, List<T> dataList, Class<T> cls, Map map){
        Field[] fields = cls.getDeclaredFields();
        List<Field> fieldList = Arrays.stream(fields)
                .filter(field -> {
                    ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
                    if (annotation != null && annotation.col() > 0) {
                        field.setAccessible(true);
                        return true;
                    }
                    return false;
                }).sorted(Comparator.comparing(field -> {
                    int col = 0;
                    ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
                    if (annotation != null) {
                        col = annotation.col();
                    }
                    return col;
                })).collect(Collectors.toList());

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet1");
        AtomicInteger ai = new AtomicInteger();
        {
            Row row = sheet.createRow(ai.getAndIncrement());
            AtomicInteger aj = new AtomicInteger();
            //写入头部
            fieldList.forEach(field -> {
                ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
                String columnName = "";
                if (annotation != null) {
                    columnName = annotation.value();
                }
                Cell cell = row.createCell(aj.getAndIncrement());
                CellStyle cellStyle = wb.createCellStyle();
                cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
                cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
                cellStyle.setAlignment(CellStyle.ALIGN_CENTER);


                cellStyle.setFillForegroundColor((short) 13);
                Font font = wb.createFont();
                font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
                cellStyle.setFont(font);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(columnName);
                cellStyle.setLocked(true);
            });
        }
        if (CollectionUtils.isNotEmpty(dataList)) {
            dataList.forEach(t -> {
                Row row1 = sheet.createRow(ai.getAndIncrement());
                AtomicInteger aj = new AtomicInteger();
                fieldList.forEach(field -> {
                    Class<?> typeClass = field.getType();
                    Object value = "";
                    try {
                        value = field.get(t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Cell cell = row1.createCell(aj.getAndIncrement());
                    if (value != null) {
                        if (typeClass == Date.class) {
                            cell.setCellValue(value.toString());
                        } else {
                            cell.setCellValue(value.toString());
                        }
                        cell.setCellValue(value.toString());

                    }
                });
            });
        }
        Integer type = (Integer)map.get("type");
        String fileName = (String)map.get("fileName");
        List<String> list =( List<String>) map.get("equipNameList");
        if(type==1) {
            //巡检
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                if (i == 0) {
                    sheet.setColumnWidth(i, 5600);
                    String[] strings = new String[list.size()];
                    setHSSFValidationMore(wb,list.toArray(strings),1, 1000000000, i, i,1);
                }
            }
        }else if(type==2){
            //维保要素
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                //设备类型
                if (i == 0) {
                    sheet.setColumnWidth(i, 5600);
                    String[] strings = new String[list.size()];
                    setHSSFValidationMore(wb,list.toArray(strings),1, 1000000000, i, i,1);
                }
            }
        } else if(type==3){
            //大修模板
            List<String> projectTypeList =( List<String>) map.get("projectTypeList");
            List<String> dList = new ArrayList<>();
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                //设备类型
                if (i == 0) {
                    sheet.setColumnWidth(i, 5600);
                    String[] strings = new String[list.size()];
                    setHSSFValidationMore(wb,list.toArray(strings),1, 1000000000, i, i,1);
                }
                if(i==5 || i==6){
                    HSSFSheet mySheet = wb.getSheet("Sheet1");
                    if(i==5){
                        dList =( List<String>) map.get("projectTypeList");
                    }else if(i==6){
                        dList =( List<String>) map.get("isEntrustList");
                    }
                    String[] strings = new String[dList.size()];
                    mySheet = setHSSFValidation(mySheet, dList.toArray(strings), 1, 1000000000, i, i);
                }
             
            /*HSSFSheet hidden = wb.createSheet("hidden");
            wb.setSheetHidden(1, true);
            Name namedCell = wb.createName();
            namedCell.setNameName("hidden");
            namedCell.setRefersToFormula("hidden!A1:A" +  factoryList.toArray(strings).length);*/
               
            }
        }else if(type==4){
            //填报
            List<String> tbEquipInfoList =( List<String>) map.get("tbEquipInfoList");
            List<String> paramNameList =( List<String>) map.get("paramNameList");
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                //设备列表
                if (i == 0) {
                    sheet.setColumnWidth(i, 5600);
                    String[] strings = new String[tbEquipInfoList.size()];
                    setHSSFValidationMore(wb,tbEquipInfoList.toArray(strings),1, 1000000000, i, i,1);
                }
                //指标类型
                if (i == 1) {
                   /* HSSFSheet mySheet = wb.getSheet("Sheet1");
                    String[] strings = new String[paramNameList.size()];
                    mySheet = setHSSFValidation(mySheet, paramNameList.toArray(strings), 1, 1000000000, i, i);*/
                   /* sheet.setColumnWidth(i, 5600);
                    String[] strings = new String[paramNameList.size()];
                    setHSSFValidationMore(wb,paramNameList.toArray(strings),1, 1000000000, i, i,1);*/
                    sheet.setColumnWidth(i, 5600);
                    String[] strings = new String[paramNameList.size()];
                    setHSSFValidationMore(wb,paramNameList.toArray(strings),1, 1000000000, i, i,2);
                }
            }
        }
        //冻结窗格
        wb.getSheet("Sheet1").createFreezePane(0, 1, 0, 1);
        //浏览器下载excel
        buildExcelDocument(fileName,wb,response);
        //生成excel文件
        //buildExcelFile(".\\default.xlsx",wb);
    }
    

    /**
     * 组合数据下拉框数据
     * @param i
     * @param col
     * @param list
     * @param workbook
     */
    public static  void  compositeData(int i,int col,List<TbEquipInfo> list ,HSSFWorkbook workbook){
        if (i == col) {

            List<String> factoryList = new ArrayList<>();
           /* list.forEach(tbDict -> {
                if(parentId==tbDict.getParentId()){
                    factoryList.add(tbDict.getValueName());
                }
            });*/
            String[] strings = new String[factoryList.size()];
            if(i== 0 || i==3){
                //setHSSFValidationMore(workbook,factoryList.toArray(strings),1, 1000000000, i, i);
            }else {
                HSSFSheet mySheet = workbook.getSheet("Sheet1");
                mySheet = setHSSFValidation(mySheet, factoryList.toArray(strings), 1, 1000000000, i, i);
            }

        }
    }

    
    /**
     * 浏览器下载excel
     * @param fileName
     * @param wb
     * @param response
     */

    private static  void  buildExcelDocument(String fileName, Workbook wb,HttpServletResponse response){
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8"));
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            OutputStream outputStream = response.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.flush();
            wb.write(bufferedOutputStream);
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成excel文件
     * @param path 生成excel路径
     * @param wb
     */
    private static  void  buildExcelFile(String path, Workbook wb){
        File file = new File("C:\\Users\\wjl\\Desktop\\11223355.xlsx");
        if (file.exists()) {
            file.delete();
        }
        try {
            wb.write(new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.
     * @param sheet 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol   开始列
     * @param endCol  结束列
     * @return 设置好的sheet.
     */
    public static HSSFSheet setHSSFValidation(HSSFSheet sheet,
                                              String[] textlist, int firstRow, int endRow, int firstCol,
                                              int endCol) {
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,endRow, firstCol, endCol);

        // 数据有效性对象
        HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
        sheet.addValidationData(data_validation_list);


       /* DVConstraint constraint1 = DVConstraint.createFormulaListConstraint("hidden");
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 0, 0);
        HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint1);
        sheet.addValidationData(validation);*/
        return sheet;
    }
    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.超过255字符  通过type 区分
     * @param  workbook 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol   开始列
     * @param endCol  结束列
     * @return 设置好的sheet.
     */
    public static HSSFSheet setHSSFValidationMore(HSSFWorkbook workbook,
                                              String[] textlist, int firstRow, int endRow, int firstCol,
                                              int endCol,int type) {

        HSSFSheet mySheet = workbook.getSheet("Sheet1");
        HSSFSheet hidden = workbook.createSheet("hidden"+type);
        HSSFCell cell = null;
        for (int t = 0, length= textlist.length; t < length; t++) {
            String name = textlist[t];
            HSSFRow row = hidden.createRow(t);
            cell = row.createCell(0);
            cell.setCellValue(name);
        }

        CellRangeAddressList regions = new CellRangeAddressList(firstRow,endRow, firstCol, firstCol);
        //获取单元格的坐标
        //System.out.println(regions.getCellRangeAddress(0).formatAsString());

        Name namedCell = workbook.createName();
        namedCell.setNameName("hidden"+type);
        namedCell.setRefersToFormula("hidden"+type + "!$A$1:$A$"+textlist.length);
        //加载数据,将名称为hidden的
        DVConstraint constraint = DVConstraint.createFormulaListConstraint("hidden"+type);

        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);

        //将第二个sheet设置为隐藏 1
        workbook.setSheetHidden(type, true);
        mySheet.addValidationData(validation);
        return mySheet;
    }
}