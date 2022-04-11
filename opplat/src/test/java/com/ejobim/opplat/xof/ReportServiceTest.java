package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbAnalysisFillTask;
import com.ejobim.opplat.domain.TbReportModel;
import com.ejobim.opplat.domain.TbReportModelExtend;
import com.ejobim.opplat.domain.TbRoutingTask;
import com.ejobim.opplat.mapper.TbAnalysisFillTaskMapper;
import com.ejobim.opplat.mapper.TbReportModelExtendMapper;
import com.ejobim.opplat.mapper.TbRoutingTaskMapper;
import com.ejobim.opplat.service.ReportService;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.StringTools;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceTest {

    @Autowired
    ReportService reportService;

    @Autowired
    TbReportModelExtendMapper reportModelExtendMapper;

    @Autowired
    TbRoutingTaskMapper routingTaskMapper;

    @Autowired
    TbAnalysisFillTaskMapper analysisFillTaskMapper;

    @Test
    public void addRoutingDraftData() {
        TbRoutingTask routingTask = routingTaskMapper.selectByPrimaryKey("fa0586974d284604845a6102c112bb68");
        reportService.insertRoutingDraftData(routingTask);

    }

    @Test
    public void addAnalysisDraftData() {
        TbAnalysisFillTask analysisFillTask = analysisFillTaskMapper.selectByPrimaryKey("6734bce214d041a484371aee2ab06ea3");
        reportService.insertAnalysisDraftData(analysisFillTask);

    }

    @Test
    public void addReportDate() {
        reportService.insertReportDate("5d81bd3194e57500078c2ac1");
    }

    @Test
    public void inportModel() {
        String path = "D:\\文件\\SED\\报表系统模板.xlsx";
        //源表头
        List<String> title = new ArrayList<String>();
        //源表数据

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
            List<TbReportModelExtend> titleList = new ArrayList<>(200);
            List<TbReportModelExtend> cellList = new ArrayList<>(200);
            for (int i = 0; i < rowNum; i++) {
                Row row = sheet.getRow(i);
                if (i == 0) {
                    String oldName = "";
                    int startColumn = 0;
                    int columnCount = 0;
                    for (int j = row.getFirstCellNum(); j <= row.getLastCellNum() - 1; j++) {
                        Cell cell = row.getCell(j);
                        String rs = getCellValue(cell);
                        if (rs.equals("")) {
                            columnCount++;
                            if (j == row.getLastCellNum() - 1) {
                                System.out.println(startColumn + " |" + columnCount + ":" + oldName);
                                TbReportModelExtend modelExtend = createNewTbReportModelExtend(i, startColumn, columnCount, 1, oldName);
                                titleList.add(modelExtend);
                            }
                        } else {
                            if (!oldName.equals("")) {
                                System.out.println(startColumn + " |" + columnCount + ":" + oldName);
                                TbReportModelExtend modelExtend = createNewTbReportModelExtend(i, startColumn, columnCount, 1, oldName);
                                titleList.add(modelExtend);
                            }
                            startColumn = cell.getColumnIndex();
                            columnCount = 1;
                            oldName = rs;
                        }

                    }
                } else {
                    for (int j = row.getFirstCellNum(); j <= row.getLastCellNum() - 1; j++) {
                        Cell cell = row.getCell(j);
                        String rs = getCellValue(cell);
                        System.out.println(i + " |" + j + ":" + rs);
                        if (i == 1) {
                            TbReportModelExtend modelExtend = createNewTbReportModelExtend(i, j, 1, 1, rs);
                            cellList.add(modelExtend);
                        } else if (i == 2) {
                            TbReportModelExtend modelExtend = cellList.get(j);
                            modelExtend.setExtendCode(rs);

                        }
                    }
                }
            }
            for (TbReportModelExtend modelExtend : titleList) {
                reportModelExtendMapper.insertSelective(modelExtend);
            }
            for (TbReportModelExtend modelExtend : cellList) {
                reportModelExtendMapper.insertSelective(modelExtend);
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


    }


    private TbReportModelExtend createNewTbReportModelExtend(int row, int column, int cellWidth, int cellHeight, String name) {
        TbReportModelExtend reportModelExtend = new TbReportModelExtend();
        reportModelExtend.setExtendMathType(1);
        reportModelExtend.setExtendRowIndex(row);
        reportModelExtend.setExtendCellHeight(cellHeight);
        reportModelExtend.setExtendCellWidth(cellWidth);
        reportModelExtend.setExtendColumnIndex(column);
        reportModelExtend.setExtendColumnName(name);
        reportModelExtend.setExtendRmNo("fb2f755a8d5644e982e182cda42cad42");
        reportModelExtend.setExtendNo(StringTools.getUUID());
        reportModelExtend.setExtendFactoryNo("system");
        return reportModelExtend;
    }

    /**
     * 获取合并单元格的值
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {

                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell);
                }
            }
        }

        return null;
    }

    /**
     * 判断合并了行
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private boolean isMergedRow(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row == firstRow && row == lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     *
     * @param sheet
     * @param row    行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getCellValue(Cell cell) {
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

    @Test
    public void getReportModelExtendDetailDate() {
        List<Map<String, String>> list = reportService.getReportModelExtendDetailDate(DateUtils.parseDate("2019-12-02"), "a72c8f310b1b404db978162f0755add6");
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getReportModelList() {
        TbReportModel reportModel = new TbReportModel();
        reportModel.setRmFactoryNo("5d81bd3194e57500078c2ac1");
        reportModel.setRmName("测试");
        List<TbReportModel> list = reportService.getReportModelList(reportModel);
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void getDraftFieldList() {
        Map<String, Object> map = reportService.getDraftFieldList("5d81bd3194e57500078c2ac1");
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void getReportModelExtendList() {
        TbReportModelExtend reportModelExtendSearch = new TbReportModelExtend();
        reportModelExtendSearch.setExtendRmNo("4c1f1678bc454698961730d7d1b92d17");
        Date beginDate = DateUtils.parseDate("2019-12-01");
        Date endDate = DateUtils.parseDate("2019-12-20");
        List<TbReportModelExtend> list = reportService.getReportModelExtendList(reportModelExtendSearch, 2, beginDate, endDate);
        System.out.println(JSONObject.toJSONString(list));
    }
}