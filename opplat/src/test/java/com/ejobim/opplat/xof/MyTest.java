package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.mapper.TbCalcMapper;
import com.ejobim.opplat.mapper.TbSynObjectMapper;
import com.ejobim.opplat.service.GroupService;
import com.ejobim.opplat.service.SynService;
import com.ejobim.opplat.service.TbCalcService;
import com.ejobim.opplat.service.TbFactoryService;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    TbCalcMapper calcMapper;

    @Autowired
    TbFactoryService factoryService;

    @Autowired
    TbSynObjectMapper synObjectMapper;

    String dataName = "seddb";

    String docDirPath  = "D:/data";

    @Autowired
    GroupService groupService;

    @Autowired
    TbCalcService calcService;

    @Test
    public void test() {
        //List<Map<String,Object>> list =  calcService.getTableDetailInfo("select * from tb_app_info");
//        System.out.println(JSONObject.toJSONString(list));
    }

    /**
     * 生成数据库设计文档
     */
    @Test
    public void createWord() {
        XWPFDocument xdoc = new XWPFDocument();
        XWPFParagraph title = xdoc.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun rt = title.createRun();
        rt.setBold(true);
        rt.setFontFamily("微软雅黑");
        rt.setText(dataName+"数据库设计文档");
        rt.setFontSize(12);
        rt.setColor("333333");

        Map<String, String[][]> datas = dataInfo(dataName);
        Set<String> keySet = datas.keySet();
        for (String table : keySet) {
                       XWPFParagraph headLine1 = xdoc.createParagraph();
            headLine1.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runHeadLine1 = headLine1.createRun();
            runHeadLine1.setText(table);
            runHeadLine1.setFontSize(10);
            runHeadLine1.setFontFamily("微软雅黑");
            runHeadLine1.setColor("333333");


            String[][] clumns = datas.get(table);

            XWPFTable dTable = xdoc.createTable(clumns.length + 1, 5);
            createTable(dTable, xdoc, clumns);
            setEmptyRow(xdoc, rt);
        }
        // 在服务器端生成
        FileOutputStream fos = null;
        try {
            String docPath = docDirPath+ File.separator+dataName+"_"+(new Date()).getTime()+".docx";
            FileUtils.forceMkdirParent(new File(docPath));
            fos = new FileOutputStream(docPath);
            xdoc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库每个表的信息
     *
     * @param data
     * @return
     */
    public Map<String, String[][]> dataInfo(String data) {

        List<Map<String, Object>> list = calcMapper.selectDataInfo(data);
        Map<String, String[][]> datas = new HashMap<String, String[][]>();
        for (Map<String, Object> map : list) {
            String table_name = map.get("table_name") + "";
            String table_comment = map.get("table_comment") + "";
            datas.put( table_comment+ "-" + table_name, tableInfo(data + "." + table_name));
        }
        return datas;
    }

    /**
     * 获取每个表的字段信息
     *
     * @param table
     * @return
     */
    public String[][] tableInfo(String table) {
        List<Map<String, Object>> list = calcMapper.selectTableInfo(table);
        String[][] tables = new String[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            String[] info = new String[5];
            info[0] = map.get("Field") + "";
            info[1] = map.get("Type") + "";
            info[2] = "YES".equals(map.get("Null").toString())?"非":"是";
            info[3] = "";
            if("PRI".equals(map.get("Key").toString())){
                info[3] = "主键";
            }else if("MUL".equals(map.get("Key").toString())){
                info[3] = "外键";
            }

            info[4] = map.get("Comment") + "";
            tables[i] = info;
        }
        return tables;

    }

    /**
     * 生成表格
     *
     * @param xTable
     * @param xdoc
     */
    public static void createTable(XWPFTable xTable, XWPFDocument xdoc, String[][] clumns) {
        String bgColor = "EEEEEE";
        CTTbl ttbl = xTable.getCTTbl();
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
        tblWidth.setW(new BigInteger("8600"));
        tblWidth.setType(STTblWidth.DXA);
        setCellText(xdoc, getCellHight(xTable, 0, 0), "字段名", bgColor, 1800,true);
        setCellText(xdoc, getCellHight(xTable, 0, 1), "类型", bgColor, 1500,true);
        setCellText(xdoc, getCellHight(xTable, 0, 2), "非空", bgColor, 1000,true);
        setCellText(xdoc, getCellHight(xTable, 0, 3), "主键", bgColor, 1000,true);
        setCellText(xdoc, getCellHight(xTable, 0, 4), "说明", bgColor, 2800,true);
        bgColor = "FFFFFF";
        int length = clumns.length;
        for (int i = 0; i < length; i++) {
            setCellText(xdoc, getCellHight(xTable, i + 1, 0), clumns[i][0], bgColor, 1800,false);
            setCellText(xdoc, getCellHight(xTable, i + 1, 1), clumns[i][1], bgColor, 1500,false);
            setCellText(xdoc, getCellHight(xTable, i + 1, 2), clumns[i][2], bgColor, 1000,false);
            setCellText(xdoc, getCellHight(xTable, i + 1, 3), clumns[i][3], bgColor, 1000,false);
            setCellText(xdoc, getCellHight(xTable, i + 1, 4), clumns[i][4], bgColor, 2800,false);
        }
    }

    // 设置表格高度
    private static XWPFTableCell getCellHight(XWPFTable xTable, int rowNomber, int cellNumber) {
        XWPFTableRow row = null;
        row = xTable.getRow(rowNomber);
        row.setHeight(100);
        XWPFTableCell cell = null;
        cell = row.getCell(cellNumber);
        return cell;
    }

    /**
     * 单元格设置文本
     *
     * @param xDocument
     * @param cell
     * @param text
     * @param bgcolor
     * @param width
     */
    private static void setCellText(XWPFDocument xDocument, XWPFTableCell cell, String text, String bgcolor,
                                    int width,boolean bold) {
        CTTc cttc = cell.getCTTc();
        CTTcPr cellPc = cttc.addNewTcPr();
        cellPc.addNewTcW().setW(BigInteger.valueOf(width));
        cellPc.addNewVAlign().setVal(STVerticalJc.CENTER);
        CTTrPr cellPr = cell.getTableRow().getCtRow().addNewTrPr();
        cellPr.addNewTrHeight().setVal(BigInteger.valueOf(500));
        XWPFParagraph pIO = cell.addParagraph();
        cell.removeParagraph(0);
        cell.setColor(bgcolor);

        XWPFRun rIO = pIO.createRun();
        rIO.setFontFamily("微软雅黑");
        rIO.setBold(bold);
        rIO.setColor("000000");
        rIO.setFontSize(10);
        rIO.setText(text);
    }

    // 设置表格间的空行
    public static void setEmptyRow(XWPFDocument xdoc, XWPFRun r1) {
        XWPFParagraph p1 = xdoc.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);
        p1.setVerticalAlignment(TextAlignment.CENTER);
        r1 = p1.createRun();
    }

    @Test
    public void getFactoryCode(){
        List<String> orgList = factoryService.getFactoryOrg("F1005001000300000000001");
    }

    @Test
    public void updateGroupInfo(){
        String info = "{\"description\":\"测\",\"factoryList\":[{\"uri\":\"/Hollysys_Bewg_modelNew/5c89ec97e082bb00011d9e8c\",\"factoryNo\":\"5c89ec97e082bb00011d9e8c\",\"factoryName\":\"莒南嘉诚\",\"isMain\":1}]}";
        OrgGroupInfo orgGroupInfo = new OrgGroupInfo();
        orgGroupInfo.setId(6);
        orgGroupInfo.setGroupDetailInfo(info);
        groupService.updateGroup(orgGroupInfo);
    }

    @Test
    public void getTree(){
        String factoryNo = "5d4d3330fc3b7f00062a2308";
        TbSynObjectExample example = new TbSynObjectExample();
        example.createCriteria().andFactoryNoEqualTo(factoryNo);
        List<TbSynObject> list = synObjectMapper.selectByExample(example);
        List<TbSynObject> equipList = new ArrayList<>();

        List<String> uriList = list.stream().map(TbSynObject::getUri).collect(Collectors.toList());
        for(TbSynObject synObject:list){
            if(synObject.getFieldType().equals(2)){
                int index = uriList.indexOf(synObject.getParentUri());
                if(!equipList.contains(list.get(index))){
                    equipList.add(list.get(index));
                }

            }
        }

        List<List<TbSynObject>> pointpList = new ArrayList<>(equipList.size());

        for(TbSynObject synObject:equipList){
            List<TbSynObject> pList = new ArrayList<>();
            for(TbSynObject tbSynObject:list){
                if(synObject.getUri().equals(tbSynObject.getParentUri())&&tbSynObject.getFieldType().equals(2)){
                    pList.add(tbSynObject);
                }
            }
            pointpList.add(pList);
        }

        List<String> strList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("设备名称,");
        stringBuffer.append("设备URI,");
        stringBuffer.append("测点名称,");
        stringBuffer.append("测点URI");
        strList.add(stringBuffer.toString());
        for(int i=9;i<equipList.size();i++){
            TbSynObject equipInfo = equipList.get(i);

            List<TbSynObject> children = pointpList.get(i);
            int index = 0;
            for(TbSynObject point:children){
                stringBuffer = new StringBuffer();
                if(index==0){
                    stringBuffer.append(equipInfo.getName());
                    stringBuffer.append(",");
                    stringBuffer.append(equipInfo.getUri());
                    stringBuffer.append(",");
                }else{
                    stringBuffer.append(",,");
                }

                stringBuffer.append(point.getName());
                stringBuffer.append(",");
                stringBuffer.append(point.getUri());
                strList.add(stringBuffer.toString());
                index++;
            }
        }
        try {
            com.ejobim.opplat.util.FileUtils.writeLineFile(strList,"D:\\tt.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
