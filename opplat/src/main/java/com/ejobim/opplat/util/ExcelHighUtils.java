package com.ejobim.opplat.util;

/*import com.ejobim.opplat.domain.ExcelColumn;
import com.ejobim.opplat.domain.TbDict;
import com.ejobim.opplat.domain.TbEquipType;
import com.ejobim.opplat.domain.TbOrg;*/

import com.ejobim.opplat.common.annotation.ExcelColumn;
import com.ejobim.opplat.domain.Capability;
import com.ejobim.opplat.domain.vo.CapVo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author wjl
 * @description excel工具类
 * @date 2019/06/24 10:27
 **/
public class ExcelHighUtils {

   /* private final static Logger log = LoggerFactory.getLogger(ExcelHighUtils.class);

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


    public static <T> void writeExcelX(HttpServletResponse response, List<T> dataList, Class<T> cls,Map map){
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

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Sheet1");
        XSSFSheet sheet2 = wb.createSheet("Sheet2");
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

        {
            Row row = sheet2.createRow(ai.getAndIncrement());
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
        if (CollectionUtils.isNotEmpty(dataList)) {
            dataList.forEach(t -> {
                Row row1 = sheet2.createRow(ai.getAndIncrement());
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
            Integer type =(Integer)map.get("type");
            String fileName =(String) map.get("fileName");
            List<TbOrg> tbOrgList = (List<TbOrg>)map.get("tbOrgList");
            List<TbDict> list = (List<TbDict>)map.get("tbDicts");
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                if(type==1){
                    //水厂
                    //业务大区
                    if (i == 3) {
                        XSSFSheet mySheet = wb.getSheet("Sheet1");
                        List<String> region = new ArrayList<>();
                        tbOrgList.forEach(tbDict -> {
                            region.add(tbDict.getName());
                        });
                        String[] strings = new String[region.size()];
    
                        mySheet = setXSSFValidationMore(wb, region.toArray(strings), 1, 65535, i, i,1);
    
                    }
                    //水厂分级 1:直辖市及省会所在城市 2:地市级水厂  3:县级水厂  --父id 55
                    compositeDataX(i, 4, 55, list, wb,2);
    
                    //项目类别 1:市政污水处理厂 2: 村镇污水处理项目 3:工业园区污水厂 4: 再生水生产厂 5:再生水项目  --父id 57
                    compositeDataX(i, 7, 57, list, wb,3);
    
                    //集团运营 //是否集团运营 1运营 是  0：不运营 否 父id 117
                    compositeDataX(i, 11, 117, list, wb,4);
                    //核心工艺 //todo
    
                    // 1:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级A 2:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级B 3: 城镇污水处理厂污染物排放标准/GB18918-  2002/二级
                    // 4: 污水综合排放标准/GB8978 - 1996/一级 5: 污水综合排放标准/GB8978 - 1996/二级 6: 污水综合排放标准/GB8978 - 1996/三级
                    // 7;地表水环境质量标准/GB3838 - 2002/I类 8:地表水环境质量标准/GB3838 - 2002/II类 9: 地表水环境质量标准/GB3838 - 2002/III类 10:地表水环境质量标准/GB3838 - 2002/IV类 11;地表水环境质量标准/GB3838 - 2002/V类
                    // 12:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/A标准 13:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/B标准
                    // 14:广东省地方标准水污染物排放限值/DB4426 - 2001/一级 15:广东省地方标准水污染物排放限值/DB4426 - 2001/二级
                    // 16:四川省岷江、沱江流域水污染物排放标准/DB51/2311-2016 17:化学工业主要水染污物排放标准/DB32/939 - 2006/一级 18:化学工业主要水污染物排放标准/DB32/939 - 2006/二级
                    // 19: 河水净化厂水质标准：浊度≤2.0色度≤10 透明度≥15  父id 56
                    compositeDataX(i, 23, 56, list, wb,5);
    
                    // 计量口径类型 1:进水 2:出水 3:其他    -- (父id 65)
                    compositeDataX(i, 54, 65, list, wb,6);
    
                    // 污泥浓缩方式 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
                    compositeDataX(i, 56, 58, list, wb,7);
    
                    //污泥脱水方式(含水量约80%) //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
                    compositeDataX(i, 57, 81, list, wb,8);
    
                    //污泥预脱水方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
                    compositeDataX(i, 59, 88, list, wb,9);
    
                    // 污泥深度脱水方式(含水率约60%)  //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
                    compositeDataX(i, 61, 94, list, wb,10);
    
                    // 污泥运输方式 1: 政府运输 2:自行运输       --父id  99
                    compositeDataX(i, 63, 99, list, wb,11);
    
                    // 污泥处理方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
                    compositeDataX(i, 64, 102, list, wb,12);

            }else if(type==2) {
                List<TbEquipType> equipTypeList = (List<TbEquipType>)map.get("equipTypeList");
                //设备类型
                if (i == 2) {
                    List<String> collect = equipTypeList.stream().map(TbEquipType::getTypeName).collect(Collectors.toList());
                    String[] strings = new String[collect.size()];

                    setXSSFValidationMore(wb,collect.toArray(strings),i, 65535, i, i,1);
                }
                //安装地点
                if (i == 11) {
                    compositeDataX(i, 11, 9, list, wb,2);
                }
                //管理状态
                if(i==15){
                    //0:启用 1:停用 2:维修中  父id 141
                    compositeDataX(i, 15, 141, list, wb,3);
                }
                //期号
                if(i==19){
                    //1:一期 2:二期 3:三期 4:四期 父id 148
                    compositeDataX(i, 19, 148, list, wb,4);
                }
            }else if(type==3 ){
                    //巡检
                    List<String> equipNameList =( List<String>) map.get("equipNameList");
                    List<String> locationNameList =( List<String>) map.get("locationNameList");
                    //巡检点
                    if (i == 0) {
                        sheet.setColumnWidth(i, 10000);
                        String[] strings = new String[locationNameList.size()];
                        setXSSFValidationMore(wb,locationNameList.toArray(strings),i, 65535, i, i,1);
                    }
                    //设备类型
                    if (i == 1) {
                        sheet.setColumnWidth(i, 10000);
                        String[] strings = new String[equipNameList.size()];
                        setXSSFValidationMore(wb,equipNameList.toArray(strings),i, 65535, i, i,2);
                    }
                   // List<String> list =( List<String>) map.get("equipNameList");
            }else if(type==4){
                //维保要素
                    List<String> equipNameList =( List<String>) map.get("equipNameList");
                    //设备类型
                    if (i == 0) {
                        sheet.setColumnWidth(i, 5600);
                        String[] strings = new String[equipNameList.size()];
                        //setHSSFValidationMore(wb,equipNameList.toArray(strings),1, 1000000000, i, i,1);
                        setXSSFValidationMore(wb,equipNameList.toArray(strings),i, 65535, i, i,1);
                    }
            }else if(type==5){
                        //大修
                        //设备类型
                        if (i == 0) {
                            List<String> equipNameList =( List<String>) map.get("equipNameList");
                            sheet.setColumnWidth(i, 5600);
                            String[] strings = new String[equipNameList.size()];
                            setXSSFValidationMore(wb,equipNameList.toArray(strings),i, 65535, i, i,1);
                        }
                        if(i==5){
                            List<String> projectTypeList =( List<String>) map.get("projectTypeList");
                            String[] strings = new String[projectTypeList.size()];
                            setXSSFValidationMore(wb,projectTypeList.toArray(strings),i, 65535, i, i,2);
                            
                        }else if(i==6){
                            List<String> dList =( List<String>) map.get("isEntrustList");
                            String[] strings = new String[dList.size()];
                            setXSSFValidationMore(wb,dList.toArray(strings),i, 65535, i, i,3);
                        }
                        
            }else if(type==6){

                    //填报
                    List<String> tbEquipInfoList =( List<String>) map.get("tbEquipInfoList");
                    List<String> paramNameList =( List<String>) map.get("paramNameList");
                    //巡检点
                    List<String> locationNameList =( List<String>) map.get("locationNameList");
                    //巡检点
                    if (i == 0) {
                        sheet.setColumnWidth(i, 10000);
                        String[] strings = new String[locationNameList.size()];
                        setXSSFValidationMore(wb,locationNameList.toArray(strings),i, 65535, i, i,1);
                    }
                    //设备列表
                    if (i == 1) {
                        sheet.setColumnWidth(i, 10000);
                        String[] strings = new String[tbEquipInfoList.size()];
                        setXSSFValidationMore(wb,tbEquipInfoList.toArray(strings),i, 65535, i, i,2);
                    }
                    //指标类型
                    if (i == 2) {
                        sheet.setColumnWidth(i, 5600);
                        String[] strings = new String[paramNameList.size()];
                        setXSSFValidationMore(wb,paramNameList.toArray(strings),i, 65535, i, i,3);

                    }
                }
        }
          
        //冻结窗格
        //wb.getSheet("Sheet1").createFreezePane(0, 1, 0, 1);
        //浏览器下载excel
        buildExcelDocument(fileName,wb,response);
        //生成excel文件
        //buildExcelFile(".\\default.xlsx",wb);
    }
    
    *//**
     * 组合数据下拉框数据不超过255字符 HSSF
     * @param i
     * @param col
     * @param parentId
     * @param list
     * @param workbook
     *//*
    public static  void  compositeData(int i,int col,int parentId,List<TbDict> list ,HSSFWorkbook workbook){
        if (i == col) {

            List<String> factoryList = new ArrayList<>();
            list.forEach(tbDict -> {
                if(parentId==tbDict.getParentId()){
                    factoryList.add(tbDict.getValueName());
                }
            });
            String[] strings = new String[factoryList.size()];
                HSSFSheet mySheet = workbook.getSheet("Sheet1");
                mySheet = setHSSFValidation(mySheet, factoryList.toArray(strings), 1, 1000000000, i, i);
            }
    }

    *//**
     * 组合数据下拉框数据处理字典数据下拉框数据
     * @param i
     * @param col
     * @param parentId
     * @param list
     * @param wb
     *//*
    public static  void  compositeDataX(int i,int col,int parentId,List<TbDict> list ,XSSFWorkbook wb,int type){
        if (i == col) {

            List<String> factoryList = new ArrayList<>();
            list.forEach(tbDict -> {
                if(parentId==tbDict.getParentId()){
                    factoryList.add(tbDict.getValueName());
                }
            });
            String[] strings = new String[factoryList.size()];
            setXSSFValidationMore(wb,factoryList.toArray(strings),i, 65535, i, i,type);
        }
    }

    *//**
     * 浏览器下载excel
     * @param fileName
     * @param wb
     * @param response
     *//*

    public static  void  buildExcelDocument(String fileName, Workbook wb,HttpServletResponse response){
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

    *//**
     * 生成excel文件
     * @param path 生成excel路径
     * @param wb
     *//*
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

    *//**
     * 设置某些列的值只能输入预制的数据,显示下拉框.
     * @param sheet 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol   开始列
     * @param endCol  结束列
     * @return 设置好的sheet.
     *//*
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
        return sheet;
    }

    public static XSSFSheet setXSSFValidation(XSSFSheet sheet,
                                              String[] textlist, int firstRow, int endRow, int firstCol,
                                              int endCol) {
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createExplicitListConstraint(textlist);
        CellRangeAddressList addressList = null;
        XSSFDataValidation validation = null;

        addressList = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        validation = (XSSFDataValidation) dvHelper.createValidation(
                dvConstraint, addressList);
        // 07默认setSuppressDropDownArrow(true);
        // validation.setSuppressDropDownArrow(true);
        // validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
        return sheet;
    }

    *//**
     * HSSF 设置某些列的值只能输入预制的数据,显示下拉框.超过255字符
     * @param  workbook 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol   开始列
     * @param endCol  结束列
     * @return 设置好的sheet.
     *//*
    public static HSSFSheet setHSSFValidationMore(HSSFWorkbook workbook,
                                              String[] textlist, int firstRow, int endRow, int firstCol,
                                              int endCol) {

        HSSFSheet mySheet = workbook.getSheet("Sheet1");
        HSSFSheet hidden = workbook.createSheet("hidden");
        HSSFCell cell = null;
        for (int t = 0, length= textlist.length; t < length; t++) {
            String name = textlist[t];
            HSSFRow row = hidden.createRow(t);
            cell = row.createCell(0);
            cell.setCellValue(name);
        }

        CellRangeAddressList regions = new CellRangeAddressList(firstRow,endRow, firstCol, firstCol);
        //获取单元格的坐标
       // System.out.println(regions.getCellRangeAddress(0).formatAsString());

        Name namedCell = workbook.createName();
        namedCell.setNameName("hidden");
        namedCell.setRefersToFormula("hidden" + "!$A$1:$A$"+textlist.length);
        //加载数据,将名称为hidden的
        DVConstraint constraint = DVConstraint.createFormulaListConstraint("hidden");

        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);

        //将第二个sheet设置为隐藏
        workbook.setSheetHidden(1, true);
        mySheet.addValidationData(validation);
        return mySheet;
    }


    *//**
     * XSSF 设置某些列的值只能输入预制的数据,显示下拉框.超过255字符
     * @param  workbook 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol   开始列
     * @param endCol  结束列
     * @return 设置好的sheet.
     *//*
    public static XSSFSheet setXSSFValidationMore(XSSFWorkbook workbook,
                                                  String[] textlist, int firstRow, int endRow, int firstCol,
                                                  int endCol,int type) {

        XSSFSheet mySheet = workbook.getSheet("Sheet1");
        XSSFSheet hidden = workbook.createSheet("hidden"+type);
        XSSFCell cell = null;
        for (int t = 0, length= textlist.length; t < length; t++) {
            String name = textlist[t];
            XSSFRow row = hidden.createRow(t);
            cell = row.createCell(0);
            cell.setCellValue(name);
        }
        Name namedCell = workbook.createName();
        namedCell.setNameName("hidden"+type);
        namedCell.setRefersToFormula("hidden"+type+ "!$A$1:$A$"+textlist.length);
    
        XSSFDataValidationConstraint constraint = new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.LIST,"hidden"+type+"!$A$1:$A$"+textlist.length);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(1,65535, firstCol, endCol);
        // 数据有效性对象
        DataValidationHelper help = new XSSFDataValidationHelper((XSSFSheet) mySheet);
        DataValidation validation = help.createValidation(constraint, regions);
        mySheet.addValidationData(validation);
        //将新建的sheet页隐藏掉
        workbook.setSheetHidden(type, true);
        return mySheet;
    }

    *//**
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @author: evan @ 2014-01-09
     * @param workbook
     * @param sheetNum (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle  （sheet的名称）
     * @param headers    （表格的标题）
     * @param result   （表格的数据）
     * @param out  （输出流）
     * @throws Exception
     *//*
    public static  void exportXSSFExcel(XSSFWorkbook workbook, int sheetNum,
                            String sheetTitle, String[] headers, List<List<String>> result,
                            OutputStream out) throws Exception {
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    XSSFCell cell = row.createCell((short) cellIndex);
                    cell.setCellValue(str.toString());
                    cellIndex++;
                }
                index++;
            }
        }
    }
    *//**
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @author: evan @ 2014-01-09
     * @param workbook
     * @param sheetNum (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle  （sheet的名称）
     * @param headers    （表格的标题）
     * @param result   （表格的数据）
     * @param out  （输出流）
     * @throws Exception
     *//*
    public static  void exportExcel(HSSFWorkbook workbook, int sheetNum,
                            String sheetTitle, String[] headers, List<List<String>> result,
                            OutputStream out) throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell((short) i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (String str : m) {
                    HSSFCell cell = row.createCell((short) cellIndex);
                    cell.setCellValue(str.toString());
                    cellIndex++;
                }
                index++;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            OutputStream out = new FileOutputStream("D:\\test.xlsx");
            List<List<String>> yunxingData = new ArrayList<List<String>>();
            for (int i = 1; i < 5; i++) {
                List rowData = new ArrayList();
                rowData.add(String.valueOf(i));
                rowData.add("东霖柏鸿"+i);
                yunxingData.add(rowData);
            }
            List<List<String>> shebeiData = new ArrayList<List<String>>();
            for (int i = 1; i < 10; i++) {
                List rowData = new ArrayList();
                rowData.add(String.valueOf(i));
                rowData.add("东霖柏鸿"+i);
                shebeiData.add(rowData);
            }
            List<List<String>> huayanData = new ArrayList<List<String>>();
            for (int i = 1; i < 15; i++) {
                List rowData = new ArrayList();
                rowData.add(String.valueOf(i));
                rowData.add("东霖柏鸿"+i);
                huayanData.add(rowData);
            }
            String[] headers = { "时间", "字段名","字段单位","字段数值" };
            ExcelHighUtils eeu = new ExcelHighUtils();
            XSSFWorkbook workbook = new XSSFWorkbook();
            eeu.exportXSSFExcel(workbook, 0, "运行填报数据底稿", headers, yunxingData, out);
            eeu.exportXSSFExcel(workbook, 1, "设备填报数据底稿", headers, shebeiData, out);
            eeu.exportXSSFExcel(workbook, 2, "化验填报数据底稿", headers, huayanData, out);
            //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

    /**
     * 联动 start
     *
     * @param response
     * @param equipList
     * @param <T>
     */
    public static <T> void writeExcelLink(HttpServletResponse response, List<Capability> equipList) {
        List<Capability> equipListFilter = equipList.stream().filter(obj -> obj.getCapabilityName() != null).collect(Collectors.toList());
        List<CapVo> capVos = ClassTools.toTragetList(equipListFilter, CapVo.class);
        Map<String, List<CapVo>> capVoMap = capVos.stream().collect(Collectors.groupingBy(CapVo::getCapabilityName));
        XSSFWorkbook workbook = new XSSFWorkbook();

        //设置工作sheet
        writeExcelCap(response, CapVo.class, workbook, capVoMap);

        //浏览器下载excel
        buildExcelDocument("题库.xls",workbook,response);
    }

    public static <T> void writeExcelCap(HttpServletResponse response, Class<T> cls, XSSFWorkbook wb, Map<String, List<CapVo>> capVoMap) {
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

        XSSFSheet sheet = wb.createSheet("Sheet1");
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
        for (int i = 0; i < fieldList.size(); i++) {
            sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
            if (i == 5) {
                XSSFDataFormat format = wb.createDataFormat();
                XSSFCellStyle style = wb.createCellStyle();
                style.setDataFormat(format.getFormat("yyyy-MM-dd"));
                sheet.setDefaultColumnStyle(i, style);
            }
        }

        //设置下拉数据源
        creatHideSheet(wb, "site_equip", capVoMap);
        // 设置名称数据集
        creatExcelNameList(wb, "site_equip", capVoMap);
        // 创建一行数据
        for (int i = 1; i < 50; i++) {
            creatAppRow(sheet, i);
        }

        buildExcelDocument("维保要素模板.xlsx", wb, response);
    }

    /**
     * 创建数据域（下拉联动的数据）
     *
     * @param workbook
     * @param hideSheetName 数据域名称
     */
    private static void creatHideSheet(XSSFWorkbook workbook, String hideSheetName, Map<String, List<CapVo>> capVoMap) {
        // 创建数据域
        XSSFSheet sheet = workbook.createSheet(hideSheetName);
        // 用于记录行
        int rowRecord = 0;
        // 获取行（从0下标开始）
        XSSFRow siteRow = sheet.createRow(rowRecord);
        // 创建站点信息
        List<String> siteList = new ArrayList<>(capVoMap.keySet());
        creatRow(siteRow, siteList);
        // 根据站点插入对应设备信息
        rowRecord++;
        for (int i = 0; i < siteList.size(); i++) {
            List<String> list = new ArrayList<String>();
            list.add(siteList.get(i));
            List<String> equipList = capVoMap.get(siteList.get(i)).stream().map(CapVo::getCapabilityName).collect(Collectors.toList());
            list.addAll(equipList);
            //获取行
            XSSFRow recode = sheet.createRow(rowRecord);
            // 创建站点及设备数据行
            creatRow(recode, list);
            rowRecord++;
        }
        int sheetCounts = workbook.getNumberOfSheets();
        workbook.setSheetHidden(sheetCounts - 1, true);
    }

    /**
     * 名称管理
     *
     * @param workbook
     * @param hideSheetName 数据域的sheet名
     */
    private static void creatExcelNameList(XSSFWorkbook workbook, String hideSheetName, Map<String, List<CapVo>> equipMap) {
        // 创建站点信息
        List<String> siteList = new ArrayList<>(equipMap.keySet());
        Name name;
        name = workbook.createName();
        // 设置站点名称
        name.setNameName("能力项联动");
        name.setRefersToFormula(hideSheetName + "!$A$1:$"
                + getcellColumnFlag(siteList.size()) + "$1");
        // 设置站点下面的设备
        for (int i = 0; i < siteList.size(); i++) {
            List<String> num = new ArrayList<>();
            name = workbook.createName();
            num.add(0, siteList.get(i));
            List<String> equipList = equipMap.get(siteList.get(i)).stream().map(CapVo::getCapabilityName).collect(Collectors.toList());
            num.addAll(equipList);
            name.setNameName(siteList.get(i));
            name.setRefersToFormula(hideSheetName + "!$B$" + (i + 2) + ":$"
                    + getcellColumnFlag(num.size()) + "$" + (i + 2));

        }
    }

    // 根据数据值确定单元格位置（比如：28-AB）
    private static String getcellColumnFlag(int num) {
        String columFiled = "";
        int chuNum = 0;
        int yuNum = 0;
        if (num >= 1 && num <= 26) {
            columFiled = doHandle(num);
        } else {
            chuNum = num / 26;
            yuNum = num % 26;

            columFiled += doHandle(chuNum);
            columFiled += doHandle(yuNum);
        }
        return columFiled;
    }

    private static String doHandle(final int num) {
        String[] charArr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};
        return charArr[num - 1];
    }

    /**
     * 创建一行记录
     *
     * @param currentRow
     * @param text
     */
    public static void creatRow(XSSFRow currentRow, List<String> text) {
        if (text != null) {
            int i = 0;
            for (String cellValue : text) {
                // 注意列是从（1）下标开始
                XSSFCell userNameLableCell = currentRow.createCell(i++);
                userNameLableCell.setCellValue(cellValue);
            }
        }
    }

    /**
     * 浏览器下载excel
     *
     * @param fileName
     * @param wb
     * @param response
     */

    private static void buildExcelDocument(String fileName, Workbook wb, HttpServletResponse response) {
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
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
     * 创建一行数据
     *
     * @param xssfSheet
     */
    public static void creatAppRow(XSSFSheet xssfSheet, int naturalRowIndex) {
        // 获取行
        XSSFRow xssfRow = xssfSheet.createRow(naturalRowIndex);

        XSSFCell site = xssfRow.createCell(0);
        site.setCellValue("");

        XSSFCell equip = xssfRow.createCell(1);
        equip.setCellValue("");

        // 得到验证对象
        DataValidation data_validation_list1 = getDataValidationByFormula(xssfSheet,
                "站点", naturalRowIndex, 1);
        DataValidation data_validation_list2 = getDataValidationByFormula(xssfSheet,"INDIRECT($A$"
                + (naturalRowIndex + 1) + ")", naturalRowIndex, 2);
        // 工作表添加验证数据
        xssfSheet.addValidationData(data_validation_list1);
        xssfSheet.addValidationData(data_validation_list2);
    }
    /**
     * 使用已定义的数据源方式设置一个数据验证
     *
     * @param formulaString
     * @param naturalRowIndex
     * @param naturalColumnIndex
     * @return
     */
    public static DataValidation getDataValidationByFormula(XSSFSheet sheet,String formulaString,
                                                            int naturalRowIndex, int naturalColumnIndex) {

        // 加载下拉列表内容
        XSSFDataValidationConstraint xssfDataValidationConstraint =
                new XSSFDataValidationConstraint(DataValidationConstraint.ValidationType.LIST,formulaString);
        //DVConstraint constraint = DVConstraint.createFormulaListConstraint(formulaString);
        // 设置数据有效性加载在哪个单元格上。
        // 四个参数分别是：起始行、终止行、起始列、终止列
        int firstRow = naturalRowIndex;
        int lastRow = naturalRowIndex;
        int firstCol = naturalColumnIndex - 1;
        int lastCol = naturalColumnIndex - 1;
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
                lastRow, firstCol, lastCol);

        // 数据有效性对象
        //HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
        XSSFDataValidation validation = null;
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        validation = (XSSFDataValidation) dvHelper.createValidation(
                xssfDataValidationConstraint, regions);

        /*XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createExplicitListConstraint(textlist);
        CellRangeAddressList addressList = null;
        XSSFDataValidation validation = null;
        int firstRow = naturalRowIndex;
        int lastRow = naturalRowIndex;
        int firstCol = naturalColumnIndex - 1;
        int lastCol = naturalColumnIndex - 1;
        addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        validation = (XSSFDataValidation) dvHelper.createValidation(
                dvConstraint, addressList);*/
        return validation;
    }
}