package com.ejobim.opplat.hypo;

import com.ejobim.opplat.domain.TbFillFormField;
import com.ejobim.opplat.domain.TbObjectData;
import com.ejobim.opplat.domain.TbParameterConfig;
import com.ejobim.opplat.domain.TbSynObject;
import com.ejobim.opplat.mapper.TbObjectDataMapper;
import com.ejobim.opplat.service.FillFieldService;
import com.ejobim.opplat.service.ParameterConfigService;
import com.ejobim.opplat.service.ReportService;
import com.ejobim.opplat.service.TbSynObjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HypoApplicationTest {

    @Autowired
    private FillFieldService fillFieldService;

    @Autowired
    private TbSynObjectService tbSynObjectService;

    @Autowired
    private ParameterConfigService parameterConfigService;

    @Autowired
    private TbObjectDataMapper tbObjectDataMapper;

    @Autowired
    private ReportService reportService;

    /**
     * 1.根据配置工厂编号、browerName  查出 syn_object uri
     * 2.设置object_data 对象
     *      object_uri = uri
     *      设置data_uri = config_no
     *      createtime
     *      factory_no =
     *      dataform =
     *
     *      水厂+browername查找 param_model
     *      文件格式
     *      关联browerName '' data_uri(config_no) newData() factoryNO param_model
     *
     *
     */
    @Test
    //@Transactional
    public void saveConn() throws IOException {
        String factoryNo = "5c807a2910d1df00013dbaa3";
        String path = "D:/"+factoryNo+".txt";
        File file = new File(path);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        List<TbObjectData> tbObjectDataList = new ArrayList<>();

        String recode = "";
        while((recode=br.readLine())!=null){
            String[] split = recode.split("!");
            System.out.println(split[0]);
            System.out.println(split[1]);
            //查询uri
            TbSynObject tbSynObject = new TbSynObject();
            tbSynObject.setBrowsename(split[0]);
            tbSynObject.setFactoryNo(factoryNo);
            List<TbSynObject> tbSynObjects = tbSynObjectService.selectSynObjectListByConds(tbSynObject);
            String objectUri = tbSynObjects.get(0).getUri();

            //查询config_no
            TbFillFormField tbFillFormField = new TbFillFormField();
            //tbFillFormField.setFactoryNo(factoryNo);
            tbFillFormField.setConfigNo(split[1]);
            List<TbFillFormField> tbFillFormFieldList = fillFieldService.selectFillFieldList(tbFillFormField);
            String browerName = tbFillFormFieldList.get(0).getFieldCode();


            TbParameterConfig tbParameterConfig = new TbParameterConfig();
            tbParameterConfig.setBrowseName(browerName);
            List<TbParameterConfig> tbParameterConfigList = parameterConfigService.selectParameterConfigList(tbParameterConfig);
            Integer paramModel = tbParameterConfigList.get(0).getParamModel();

            TbObjectData tbObjectData = new TbObjectData();
            tbObjectData.setObjectUri(objectUri);
            tbObjectData.setDataUri(split[1]);
            tbObjectData.setCreateTime(new Date());
            tbObjectData.setFactoryNo(factoryNo);
            tbObjectData.setDataFrom(paramModel);

            tbObjectDataMapper.insert(tbObjectData);

        }

    }

    @Test
    public void saveReportDateRecord() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        String factoryNo = "5c662ed96201b70001413521";
        String startDate = "2019-05-02";
        String endDate = "2019-05-03";
        String rmNo = "d296f62e4b22406fb1daa5e481888020";
        int num = reportService.saveReportDateRecord(factoryNo,startDate,endDate,rmNo);
        System.out.println(num);
    }
}
