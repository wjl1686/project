package com.ejobim.opplat.util;

import com.ejobim.opplat.domain.ExcelColumn;
import com.ejobim.opplat.domain.TbDict;
import com.ejobim.opplat.domain.TbEquipType;
import com.ejobim.opplat.domain.TbOrg;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
public class ExcelUtils {

    private final static Logger log = LoggerFactory.getLogger(ExcelUtils.class);

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

    public static <T> void writeExcel(HttpServletResponse response, List<T> dataList, Class<T> cls, List<TbDict> list, List<TbOrg> tbOrgList, String fileName, int type, List<TbEquipType> equipTypeList){
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
        if(type==1) {
            //水厂
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
              /*  //业务大区
                if (i == 3) {
                    HSSFSheet mySheet = wb.getSheet("Sheet1");
                    List<String> region = new ArrayList<>();
                    tbOrgList.forEach(tbDict -> {
                        region.add(tbDict.getName());
                    });
                    String[] strings = new String[region.size()];

                    mySheet = setHSSFValidation(mySheet, region.toArray(strings), 1, 1000000000, i, i);

                }
                //水厂分级 1:直辖市及省会所在城市 2:地市级水厂  3:县级水厂  --父id 55
                compositeData(i, 4, 55, list, wb);

                //项目类别 1:市政污水处理厂 2: 村镇污水处理项目 3:工业园区污水厂 4: 再生水生产厂 5:再生水项目  --父id 57
                compositeData(i, 7, 57, list, wb);

                //集团运营 //是否集团运营 1运营 是  0：不运营 否 父id 117
                compositeData(i, 11, 117, list, wb);
                //核心工艺 //todo

                // 1:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级A 2:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级B 3: 城镇污水处理厂污染物排放标准/GB18918-  2002/二级
                // 4: 污水综合排放标准/GB8978 - 1996/一级 5: 污水综合排放标准/GB8978 - 1996/二级 6: 污水综合排放标准/GB8978 - 1996/三级
                // 7;地表水环境质量标准/GB3838 - 2002/I类 8:地表水环境质量标准/GB3838 - 2002/II类 9: 地表水环境质量标准/GB3838 - 2002/III类 10:地表水环境质量标准/GB3838 - 2002/IV类 11;地表水环境质量标准/GB3838 - 2002/V类
                // 12:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/A标准 13:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/B标准
                // 14:广东省地方标准水污染物排放限值/DB4426 - 2001/一级 15:广东省地方标准水污染物排放限值/DB4426 - 2001/二级
                // 16:四川省岷江、沱江流域水污染物排放标准/DB51/2311-2016 17:化学工业主要水染污物排放标准/DB32/939 - 2006/一级 18:化学工业主要水污染物排放标准/DB32/939 - 2006/二级
                // 19: 河水净化厂水质标准：浊度≤2.0色度≤10 透明度≥15  父id 56
                compositeData(i, 23, 56, list, wb);

                // 计量口径类型 1:进水 2:出水 3:其他    -- (父id 65)
                compositeData(i, 54, 65, list, wb);

                // 污泥浓缩方式 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
                compositeData(i, 56, 58, list, wb);

                //污泥脱水方式(含水量约80%) //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
                compositeData(i, 57, 81, list, wb);

                //污泥预脱水方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
                compositeData(i, 59, 88, list, wb);

                // 污泥深度脱水方式(含水率约60%)  //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
                compositeData(i, 61, 94, list, wb);

                // 污泥运输方式 1: 政府运输 2:自行运输       --父id  99
                compositeData(i, 63, 99, list, wb);

                // 污泥处理方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
                compositeData(i, 64, 102, list, wb);
            }*/
            }
        }else if(type==2){
            //设备
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                //设备类型
                if (i == 2) {
                    List<String> collect = equipTypeList.stream().map(TbEquipType::getTypeName).collect(Collectors.toList());
                    String[] strings = new String[collect.size()];

                    setHSSFValidationMore(wb,collect.toArray(strings),1, 1000000000, i, i);
                }
                //安装地点
                if (i == 11) {
                    compositeData(i, 11, 9, list, wb);
                }
                //管理状态
                if(i==15){
                    //0:启用 1:停用 2:维修中  父id 141
                    compositeData(i, 15, 141, list, wb);
                }
                //期号
                if(i==19){
                    //1:一期 2:二期 3:三期 4:四期 父id 148
                    compositeData(i, 19, 148, list, wb);
                }

            }
        }else if(type==3){
            //导出排班数据
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
            }
        }
        //冻结窗格
        //wb.getSheet("Sheet1").createFreezePane(0, 1, 0, 1);
        //浏览器下载excel
        buildExcelDocument(fileName,wb,response);
        //生成excel文件
        //buildExcelFile(".\\default.xlsx",wb);
    }

    public static <T> void writeExcelX(HttpServletResponse response, List<T> dataList, Class<T> cls, List<TbDict> list, List<TbOrg> tbOrgList, String fileName, int type, List<TbEquipType> equipTypeList){
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
        if(type==1) {
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                //业务大区
                if (i == 3) {
                   // XSSFSheet mySheet = wb.getSheet("Sheet1");
                    List<String> region = new ArrayList<>();
                    tbOrgList.forEach(tbDict -> {
                        region.add(tbDict.getName());
                    });
                    String[] strings = new String[region.size()];

                    setXSSFValidationMore(wb, region.toArray(strings), 1, 1000000000, i, i);

                }
                //水厂分级 1:直辖市及省会所在城市 2:地市级水厂  3:县级水厂  --父id 55
                compositeDataX(i, 4, 55, list, wb);

                //项目类别 1:市政污水处理厂 2: 村镇污水处理项目 3:工业园区污水厂 4: 再生水生产厂 5:再生水项目  --父id 57
                compositeDataX(i, 7, 57, list, wb);

                //集团运营 //是否集团运营 1运营 是  0：不运营 否 父id 117
                compositeDataX(i, 11, 117, list, wb);
                //核心工艺 //todo

                // 1:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级A 2:城镇污水处理厂污染物排放标准/GB18918 - 2002/一级B 3: 城镇污水处理厂污染物排放标准/GB18918-  2002/二级
                // 4: 污水综合排放标准/GB8978 - 1996/一级 5: 污水综合排放标准/GB8978 - 1996/二级 6: 污水综合排放标准/GB8978 - 1996/三级
                // 7;地表水环境质量标准/GB3838 - 2002/I类 8:地表水环境质量标准/GB3838 - 2002/II类 9: 地表水环境质量标准/GB3838 - 2002/III类 10:地表水环境质量标准/GB3838 - 2002/IV类 11;地表水环境质量标准/GB3838 - 2002/V类
                // 12:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/A标准 13:城镇污水处理厂水污染物排放标准/DB11/890 - 2012/B标准
                // 14:广东省地方标准水污染物排放限值/DB4426 - 2001/一级 15:广东省地方标准水污染物排放限值/DB4426 - 2001/二级
                // 16:四川省岷江、沱江流域水污染物排放标准/DB51/2311-2016 17:化学工业主要水染污物排放标准/DB32/939 - 2006/一级 18:化学工业主要水污染物排放标准/DB32/939 - 2006/二级
                // 19: 河水净化厂水质标准：浊度≤2.0色度≤10 透明度≥15  父id 56
                compositeDataX(i, 23, 56, list, wb);

                // 计量口径类型 1:进水 2:出水 3:其他    -- (父id 65)
                compositeDataX(i, 54, 65, list, wb);

                // 污泥浓缩方式 1;带式浓缩 2:重力-机械浓缩 3:重力浓缩 4:离心浓缩 5:气浮浓缩 6:转鼓浓缩 7:其他 0:无  --父id 58
                compositeDataX(i, 56, 58, list, wb);

                //污泥脱水方式(含水量约80%) //1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   --父id 81
                compositeDataX(i, 57, 81, list, wb);

                //污泥预脱水方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无   ---父id 88
                compositeDataX(i, 59, 88, list, wb);

                // 污泥深度脱水方式(含水率约60%)  //1:板框压滤  2:石灰干化  3:其他  0:无   -- 父id 94
                compositeDataX(i, 61, 94, list, wb);

                // 污泥运输方式 1: 政府运输 2:自行运输       --父id  99
                compositeDataX(i, 63, 99, list, wb);

                // 污泥处理方式  1:带式脱水 2:离心脱水  3:叠螺脱水  4: 其他 0: 无     --父id 102
                compositeDataX(i, 64, 102, list, wb);
            }
        }else if(type==2){
            for (int i = 0; i < fieldList.size(); i++) {
                sheet.setColumnWidth(i, fieldList.get(i).getAnnotation(ExcelColumn.class).value().length() * 700);
                //设备类型
                if (i == 2) {
                    List<String> collect = equipTypeList.stream().map(TbEquipType::getTypeName).collect(Collectors.toList());
                    String[] strings = new String[collect.size()];

                    setXSSFValidationMore(wb,collect.toArray(strings),1, 1000000000, i, i);
                }
                //安装地点
                if (i == 11) {
                    compositeDataX(i, 11, 9, list, wb);
                }
                //管理状态
                if(i==15){
                    //0:启用 1:停用 2:维修中  父id 141
                    compositeDataX(i, 15, 141, list, wb);
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
    public static  void  compositeDataX(int i,int col,List<String> list ,XSSFWorkbook workbook){
        if (i == col) {
            XSSFSheet mySheet = workbook.getSheet("Sheet1");
            String[] strings = new String[list.size()];
            mySheet = setXSSFValidation(mySheet, list.toArray(strings), 1, 1000000000, i, i);
            }
    }

    /**
     * 组合数据下拉框数据
     * @param i
     * @param col
     * @param parentId
     * @param list
     * @param workbook
     */
    public static  void  compositeData(int i,int col,int parentId,List<TbDict> list ,HSSFWorkbook workbook){
        if (i == col) {

            List<String> factoryList = new ArrayList<>();
            list.forEach(tbDict -> {
                if(parentId==tbDict.getParentId()){
                    factoryList.add(tbDict.getValueName());
                }
            });
            String[] strings = new String[factoryList.size()];

            if(i== 23){
                setHSSFValidationMore(workbook,factoryList.toArray(strings),1, 1000000000, i, i);

            }else {
                HSSFSheet mySheet = workbook.getSheet("Sheet1");
            /*HSSFSheet hidden = wb.createSheet("hidden");
            wb.setSheetHidden(1, true);
            Name namedCell = wb.createName();
            namedCell.setNameName("hidden");
            namedCell.setRefersToFormula("hidden!A1:A" +  factoryList.toArray(strings).length);*/
                mySheet = setHSSFValidation(mySheet, factoryList.toArray(strings), 1, 1000000000, i, i);
            }

        }
    }


    public static  void  compositeDataX(int i,int col,int parentId,List<TbDict> list ,XSSFWorkbook workbook){
        if (i == col) {

            List<String> factoryList = new ArrayList<>();
            list.forEach(tbDict -> {
                if(parentId==tbDict.getParentId()){
                    factoryList.add(tbDict.getValueName());
                }
            });
            String[] strings = new String[factoryList.size()];

            if(i== 23){
                setXSSFValidationMore(workbook,factoryList.toArray(strings),1, 1000000000, i, i);

            }else {
                XSSFSheet mySheet = workbook.getSheet("Sheet1");
            /*HSSFSheet hidden = wb.createSheet("hidden");
            wb.setSheetHidden(1, true);
            Name namedCell = wb.createName();
            namedCell.setNameName("hidden");
            namedCell.setRefersToFormula("hidden!A1:A" +  factoryList.toArray(strings).length);*/
            setXSSFValidation(mySheet, factoryList.toArray(strings), 1, 1000000000, i, i);
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

    public static XSSFSheet setXSSFValidation(XSSFSheet sheet,
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
     * 设置某些列的值只能输入预制的数据,显示下拉框.超过255字符
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
        System.out.println(regions.getCellRangeAddress(0).formatAsString());

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


    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.超过255字符
     * @param  workbook 要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow 结束行
     * @param firstCol   开始列
     * @param endCol  结束列
     * @return 设置好的sheet.
     */
    public static XSSFSheet setXSSFValidationMore(XSSFWorkbook workbook,
                                                  String[] textlist, int firstRow, int endRow, int firstCol,
                                                  int endCol) {

        XSSFSheet mySheet = workbook.getSheet("Sheet1");
        XSSFSheet hidden = workbook.createSheet("hidden");
        XSSFCell cell = null;
        for (int t = 0, length= textlist.length; t < length; t++) {
            String name = textlist[t];
            XSSFRow row = hidden.createRow(t);
            cell = row.createCell(0);
            cell.setCellValue(name);
        }

        CellRangeAddressList regions = new CellRangeAddressList(firstRow,endRow, firstCol, firstCol);
        //获取单元格的坐标
        System.out.println(regions.getCellRangeAddress(0).formatAsString());

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
}