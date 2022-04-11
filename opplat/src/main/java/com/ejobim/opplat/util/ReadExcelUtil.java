package com.ejobim.opplat.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReadExcelUtil {

    private static boolean terminateParseFlag = false;
    /*//源表头
      private List<String> title = new ArrayList<>();
      //源表数据
      private List<Map<String, Object>> result = new ArrayList<>();
      //源文件中缺少字段信息的无效数据信息记录
      private List<String> errorList = new ArrayList<String>();*/
    /** 获取单元格的值
     *
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        String cellValue = "";
        DataFormatter formatter = new DataFormatter();
        if (cell != null) {
            // 判断单元格数据的类型，不同类型调用不同的方法
            switch (cell.getCellTypeEnum()) {
                // 数值类型
                case NUMERIC:
                    // 进一步判断 ，单元格格式是日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = formatter.formatCellValue(cell);
                    } else {
                        // 数值(手机号)
                        double value = cell.getNumericCellValue();
                        DecimalFormat df = new DecimalFormat("#");
                        cellValue = df.format(value);
                    }
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                // 判断单元格是公式格式，需要做一种特殊处理来得到相应的值
                case FORMULA: {
                    try {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    } catch (IllegalStateException e) {
                        cellValue = String.valueOf(cell.getRichStringCellValue());
                        e.printStackTrace();
                    }
                }
                break;
                case BLANK:
                    cellValue = "";
                    break;
                case ERROR:
                    cellValue = "";
                    break;
                default:
                    cellValue = cell.toString().trim();
                    break;
            }
        }
        return cellValue.trim();
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static Map<String, Object> readExcel(String path, String splitStr, int controlParseNum) {
        //源表头
        List<String> title = new ArrayList<String>();
        //源表数据
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        //源文件中缺少字段信息的无效数据信息记录
        List<String> errorList = new ArrayList<String>();
        Map<String, Object> mapR = new HashMap<String, Object>();
        FileInputStream inStream = null;
        Workbook workBook = null;
        Sheet sheet = null;
        int rowNum = 0;
        try {
            inStream = new FileInputStream(path);
            workBook = WorkbookFactory.create(inStream);
            sheet = workBook.getSheetAt(0);
            // 获取总行数
            rowNum = sheet.getLastRowNum() + 1;
            for (int i = 0; i < rowNum; i++) {
//                if(!terminateParseFlag && controlParseNum != -1){
                    Row row = sheet.getRow(i);
                    if (i == 0) {
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            // 读取第一行 存入标题
                            Cell cell = row.getCell(j);
                            // 获取单元格的值
                            String str = getCellValue(cell);
                            title.add(str);
                        }
                    } else {
                        Map<String, Object> beanRow=new HashMap<String, Object>();
                        for(int k = 0; k <title.size();k++){
                            // 读取数据行
                            Cell cell = row.getCell(k);
                            // 获取单元格的值
                            String str = getCellValue(cell);
                            beanRow.put(title.get(k), "".equals(str) ? " " : str);
                        }
                        result.add(beanRow);
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }

        mapR.put("title", title);
        mapR.put("result", result);
        mapR.put("total", rowNum);
        mapR.put("errorList", errorList);
        return mapR;
    }


/*

    public static void main(String[] args) throws IOException {
        Map<String, Object> map = ReadExcelUtil.readExcel("D:\\文件\\param.xlsx", ",", -1);
        List<Map<String,Object>> result = (List<Map<String,Object>> )map.get("result");
        List<TbParameterConfig> parameterConfigList = new ArrayList<>();
        TbParameterConfig oldParameterConfig = null;
        for(Map<String,Object> item:result){
            int oldParameterType = oldParameterConfig==null?-1:oldParameterConfig.getParamType().intValue();
            Map2ParameterConfig map2ParameterConfig = new Map2ParameterConfig(item,oldParameterType);
            if(map2ParameterConfig.getParameterConfig().getParamFillType().intValue()==3){
                System.out.println(map2ParameterConfig.getParameterConfig().toString());
            }
            oldParameterConfig = map2ParameterConfig.getParameterConfig();
//            System.out.println(item);
        }
    }
*/

}
class WDWUtil {

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}