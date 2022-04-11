package com.ejobim.opplat.wjl;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.OpplatApplicationTests;
import com.ejobim.opplat.domain.TbFillFormField;
import com.ejobim.opplat.domain.TbFillFormFieldExtend;
import com.ejobim.opplat.domain.TbFillFormTask;
import com.ejobim.opplat.domain.TbMedicineDict;
import com.ejobim.opplat.domain.condition.QueryConditon;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.service.AppService;
import com.ejobim.opplat.service.BewgService;
import com.ejobim.opplat.service.TbFactoryService;
import com.ejobim.opplat.service.TbMedicineService;
import com.ejobim.opplat.util.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.databene.contiperf.PerfTest;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class Tests extends OpplatApplicationTests {
    @Autowired
    private TbFillFormFieldMapper tbFillFormFieldMapper;
    @Autowired
    private TbFillFormFieldExtendMapper tbFillFormFieldExtendMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    BewgService bewgService;

    @Test
    public void testTbFillFormFieldList() {
        TbFillFormField tbFillFormField = new TbFillFormField();
        tbFillFormField.setFieldName("填报瞬时流量");
        tbFillFormField.setFieldCode("MA_FT");
        List<TbFillFormField> tbFillFormFields = tbFillFormFieldMapper.selectTbFillFormFieldList(tbFillFormField);
        System.out.println(tbFillFormFields.size());
    }

    @Test
    public void save() {
        TbFillFormFieldExtend tbFillFormFieldExtend = new TbFillFormFieldExtend();
        tbFillFormFieldExtend.setStartTime(new Date().toString());
        tbFillFormFieldExtend.setConfigNo("Hollysys_Bewg_modelNew/5c6e674a1c5fda0001210d6e");
        tbFillFormFieldExtend.setType(1);
        tbFillFormFieldExtend.setCreateTime(new Date());
        tbFillFormFieldExtendMapper.insertSelective(tbFillFormFieldExtend);

    }

    @Test
    public void test11() {
        String str = "/Hollysys_Bewg_modelNew3/5cef23a75a5d2200077c6bf8/OWQ/OW_FIT_1/FT";
        String[] split = str.split(",");
        JSONObject dataInfo1 = bewgService.getDataInfoNew(split);
        System.out.println(dataInfo1);
    }

    @Autowired
    private TbMedicineDictMapper tbMedicineDictMapper;

    @Test
    public void testList() throws IOException {

        List<TbMedicineDict> list = new ArrayList<TbMedicineDict>();
        InputStream is = new FileInputStream("C:/药剂指标.xls");

        HSSFWorkbook excel = new HSSFWorkbook(is);
        TbMedicineDict stu = null;
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < excel.getNumberOfSheets(); numSheet++) {
            HSSFSheet sheet = excel.getSheetAt(numSheet);
            if (sheet == null)
                continue;
            // 循环行Row
            for (int rowNum = 3; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow row = sheet.getRow(rowNum);
                stu = new TbMedicineDict();
                if (row == null)
                    continue;
                if (rowNum == 156)
                    break;
                HSSFCell cell0 = row.getCell(0);
                stu.setId(Integer.valueOf(cell0.getStringCellValue().equals("") ? null : cell0.getStringCellValue()));
                System.out.println(rowNum);
                HSSFCell cell1 = row.getCell(1);
                stu.setTragetNo(cell1.getStringCellValue());

                HSSFCell cell2 = row.getCell(2);
                stu.setMedicineCategory(cell2.getStringCellValue());

                HSSFCell cell3 = row.getCell(3);
                stu.setCategoryType(cell3.getStringCellValue());

                HSSFCell cell4 = row.getCell(4);
                stu.setMedicineName(cell4.getStringCellValue());


                HSSFCell cell5 = row.getCell(5);
                stu.setChemical(cell5.getStringCellValue());

                HSSFCell cell6 = row.getCell(6);
                stu.setMedicineType(cell6.getStringCellValue());

                HSSFCell cell7 = row.getCell(7);
                stu.setMedicineVaid(cell7.getStringCellValue());

                HSSFCell cell8 = row.getCell(8);
                stu.setMedicineContent(cell8.getStringCellValue());

                HSSFCell cell9 = row.getCell(9);
                stu.setChoose(cell9.getStringCellValue());
                list.add(stu);
            }
        }

        for (TbMedicineDict t : list) {
            tbMedicineDictMapper.insertSelective(t);
        }
        System.out.println(list.toString());

    }

    @Autowired
    private TbSynObjectMapper tbSynObjectMapper;
    @Autowired
    private TbMedicineService tbMedicineService;

    @Test
    public void testda() {
        //System.out.println(tbMedicineService.findMedicineDictList(new TbMedicineDict()).size());
        //System.out.println(tbSynObjectMapper.findSynObjectList("").toString());
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

        System.err.println("groupBy:" + groupBy.toString());
        //'5c662ed96201b70001413524'
        // {1=[Apple{id=1, name='苹果1', money=3.25, num=10}, Apple{id=1, name='苹果2', money=1.35, num=20}], 2=[Apple{id=2, name='香蕉', money=2.89, num=30}], 3=[Apple{id=3, name='荔枝', money=9.99, num=40}]}
    }

    @Autowired
    private TbFillFormDetailMapper tbFillFormDetailMapper;

    @Test
    public void testGetTbfill() {
           /* List<TbFillFormDetail> tbFillFormDetails = tbFillFormDetailMapper.selectTbFillFormDetailByFactroyNo("5c662ed96201b70001413521");
            Map<String,List<TbFillFormDetail>> map = new HashMap<>();
            map=tbFillFormDetails.stream().collect(Collectors.groupingBy(TbFillFormDetail::getFillTakeTime));
            System.out.println(tbFillFormDetails.toString());
            System.out.println(map.toString());*/
        String factroyNo = "5c662ed96201b70001413521";
        TbFillFormField tbFillFormField = new TbFillFormField();
        tbFillFormField.setFactoryNo(factroyNo);
        List<TbFillFormField> tbFillFormFields = tbFillFormFieldMapper.selectTbFillFormFieldList(tbFillFormField);
        System.out.println(tbFillFormFields.size());

    }

    @Autowired
    private TbFillFormTaskMapper tbFillFormTaskMapper;

    @Test
    public void testGetTbTask() {
        TbFillFormTask tbFillFormTask = new TbFillFormTask();
        tbFillFormTask.setFillTaskNo("1093c9f6b4e947129a53c975430d3d20");
        List<TbFillFormTask> tbFillFormTasks = tbFillFormTaskMapper.selectTbFillFormTaskList(tbFillFormTask, null, null, null);
        System.out.println(tbFillFormTasks.size());

    }

    @Autowired
    private TbFactoryService tbFactoryService;

    @Test
    public void testCreatTask() {
        Date date = DateUtils.parseDate("2019-03-16");
        Date date1 = DateUtils.parseDate("2019-03-16");
        tbFactoryService.createFillTask("5c662ed96201b70001413521", date, date1, null);
    }

    @Test
    public void testOrgInfo() {
        QueryConditon queryConditon = new QueryConditon();
        queryConditon.setPageNum(1);
        queryConditon.setPageSize(1000000);
        //bewgService.getOrgInfo(queryConditon);
        bewgService.getUserInfo(queryConditon);
    }

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void testSend() {

        amqpTemplate.convertAndSend("order_queue", "hello");
        stringRedisTemplate.opsForValue().increment("sku_quey", 1);
    }

    private static final int USER_NUMMS = 200;

    //定时并发
    private static CountDownLatch cdl = new CountDownLatch(USER_NUMMS);
    @Autowired
    private AppService appService;
    @Test
    @PerfTest(invocations = 100,threads = 10)
    public void testSend11() {

      /* for(int i=0;i<USER_NUMMS;i++){
           new Thread(new Ticket()).start();
           cdl.countDown();
       }*/
        appService.testLock();
    }
}




