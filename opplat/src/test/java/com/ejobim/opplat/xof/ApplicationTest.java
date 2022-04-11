package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.*;
import com.ejobim.opplat.domain.condition.BewgQueryTreeCondition;
import com.ejobim.opplat.mapper.*;
import com.ejobim.opplat.rest.HollySys;
import com.ejobim.opplat.service.*;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.JSON2Bean;
import com.ejobim.opplat.util.Map2ParameterConfig;
import com.ejobim.opplat.util.ReadExcelUtil;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    HollySys hollySys;
    @Autowired
    TbFactoryService tbFactoryService;

    @Autowired
    BewgService bewgService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    //同步水厂数据
    @Test
    public void getAllFactoryTest(){
        List<TbFactoryInfo> factoryInfoList =  hollySys.getFactoryList();
        int index = 0;
        for(int i=0;i<factoryInfoList.size();i++){
            TbFactoryInfo factoryInfo = factoryInfoList.get(i);
            System.out.println(factoryInfo.getFactoryName() + "," + factoryInfo.getFactoryNo());
            //hollySys.getFactoryTree(factoryInfo.getUri(),factoryInfo.getFactoryNo(),2);
            //hollySys.saveFactoryModelToFile(factoryInfo.getFactoryNo(),factoryInfo.getUri());
        }
    }


    @Test
    public  void  getFactroyTreeTest(){
        //hollySys.getFactoryTree("/Hollysys_Bewg_modelNew4/5d4d3330fc3b7f00062a2308","5d4d3330fc3b7f00062a2308",1);
        hollySys.saveFactoryModelToFile("5dca44d6953716000a816732","/Hollysys_Bewg_modelNew5/5dca44d6953716000a816732");
    }


    public void createFillTask(){
        Date startDate = DateUtils.parseDate("2019-04-17");
        Date endDate = DateUtils.parseDate("2019-04-19");
        // 二污 5c662ed96201b70001413521  一污 5c6f5f581c5fda0001211081 草铺5c748f4f1c5fda00013b904d
        tbFactoryService.createFillTask("5c748f4f1c5fda00013b904d",startDate,endDate,null);
    }

    @Autowired
    TbParameterConfigMapper parameterConfigMapper;
    @Autowired
    private ParameterConfigService parameterConfigService;
    @Autowired
    private FillFieldService fillFieldService;

    @Autowired
    private TbFactoryInfoMapper  tbFactoryInfoMapper;


    @Test
    //配置填报字段
    public void addParameterConfig(){

        TbFactoryInfoExample example = new TbFactoryInfoExample();
        TbFactoryInfoExample.Criteria criteria = example.createCriteria();

        List<TbFactoryInfo> tbFactoryInfoList = tbFactoryInfoMapper.selectByExample(example);



        TbParameterConfigExtend configExtend = new TbParameterConfigExtend();

        fillFieldService.createFieldFromConfig("5cb7d2087ec0fa0007383cdc");


    }



    /**
     * 创建巡检任务
     */

    @Autowired
    private TbSysUseService tbSysUseService;


    public void createInspectTask(){
//        Date startDate = DateUtils.parseDate("2019-03-23");
//        Date endDate = DateUtils.parseDate("2019-03-23");
//        // 二污 5c662ed96201b70001413521  一污 5c6f5f581c5fda0001211081
//        inspectService.addInspcetTask("5c941eada965433789b0f1313009223b",startDate,endDate,"08:00");
//        List<Map<String,Object>> list =  tbInspcetModelExtendExample.getTbInspcetModelExtendDetailList("6c80422408c54765a60e62ab966c096b");
//        for(Map<String,Object> map:list){
//            for(String key:map.keySet()){
//                System.out.println(key + ":" + map.get(key).toString());
//            }
//        }

        List<String> orgList = new ArrayList<>();
        orgList.add("155334605942100005");
        tbSysUseService.getUserFactoryList(orgList,1);
    }

    @Test
    public  void test11(){
//        String str = "/Hollysys_Bewg_modelNew/5c6a50f56201b7000141eea2/IW_CODA_1/COD,/Hollysys_Bewg_modelNew/5c6a50f56201b7000141eea2/IW_FTA_1/FT,/Hollysys_Bewg_modelNew/5c6a50f56201b7000141eea2/IW_NH3-NA_1/NH3N,/Hollysys_Bewg_modelNew/5c6a50f56201b7000141eea2/IW_PHT_1/PH";
//        String[] split = str.split(",");
        String info = "[{\"path\":\"IWQ,IW_COD\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"IWQ,IW_PH\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"IWQ,IW_FT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"IWQ,IW_FTACC\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"IWQ,IW_NH3-N\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"OWQ,OW_PH\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"OWQ,OW_COD\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"OWQ,OW_TN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"OWQ,OW_FT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"OWQ,OW_NH3-N\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"OWQ,OW_TP\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6630366201b700014135dc\"},{\"path\":\"ITP_1,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6955336201b70001414201\"},{\"path\":\"ITP_2,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6955336201b70001414201\"},{\"path\":\"ITP_3,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6955336201b70001414201\"},{\"path\":\"GR_1,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c695e146201b700014142c0\"},{\"path\":\"GR_2,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c695e146201b700014142c0\"},{\"path\":\"GR_3,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c695e146201b700014142c0\"},{\"path\":\"RZP_1,FLT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a1e866201b70001415584\"},{\"path\":\"RZP_1,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a1e866201b70001415584\"},{\"path\":\"RZP_1,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a20b66201b70001418a60\"},{\"path\":\"RZP_2,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a20b66201b70001418a60\"},{\"path\":\"DOT_1,DO\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a20b66201b70001418a60\"},{\"path\":\"MLSST_1,MLSS\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a20b66201b70001418a60\"},{\"path\":\"BA_1,IF\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,AFL\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,MTT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,OPT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,IPT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,OATT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,IATT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_1,PF\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,IF\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,AFL\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,MTT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,OPT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,IPT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,OATT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,IATT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_2,PF\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,IF\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,AFL\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,MTT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,OPT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,IPT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,OATT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,IATT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"BA_3,PF\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6b79c0fd23240001d61018\"},{\"path\":\"QJB-W_1,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a4e956201b7000141ecee\"},{\"path\":\"QJB-W_2,RUN\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a4e956201b7000141ecee\"},{\"path\":\"IW_FTA_1,FT_ACC\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a50f56201b7000141eea2\"},{\"path\":\"IW_FTA_1,FT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a50f56201b7000141eea2\"},{\"path\":\"OW_FIT_1,FT\",\"uri\":\"/Hollysys_Bewg_modelNew/5c6a51c76201b7000141eee1\"}]";
        JSONArray array = JSONArray.parseArray(info);
        JSONObject dataInfo1 = bewgService.getDataInfoNew(array);
        System.out.println(dataInfo1);
    }

    @Autowired
    TbCalcService tbCalcService;


    @Test
    public void testCalc(){
        JSONObject item = new JSONObject();
        JSONArray basePropertys = new JSONArray();
        basePropertys.add(createProperty("处理水量","V1","m3/d",1,null,null));
        basePropertys.add(createProperty("需药剂去除的磷浓度","V2","mg/L",1,null,null));
        basePropertys.add(createProperty("药剂有效成分含量","V3","%",1,null,null));
        basePropertys.add(createProperty("理论值系数","V4","",1,null,null));
        basePropertys.add(createProperty("药剂价格","V5","元/吨",1,null,null));

        JSONObject resultObject1 = new JSONObject();
        JSONArray resultList = new JSONArray();//结果列表一

        JSONArray array = new JSONArray();
        array.add("V1");
        array.add("V2");
        array.add("V3");
        resultList.add(createProperty("理论投加药剂量","V6","吨/d",4,"V6==V1*V2*27/31*102/54/1000/1000/V3*100",array));

        array = new JSONArray();
        array.add("V6");
        array.add("V4");
        resultList.add(createProperty("实际投加药剂量","V7","吨/d",4,"V7=V6*V4",array));

        array = new JSONArray();
        array.add("V1");
        array.add("V7");
        resultList.add(createProperty("投配率（以产品计）","V8","mg/L",4,"V8=V7*1000/V1*1000",array));

        array = new JSONArray();
        array.add("V1");
        array.add("V5");
        array.add("V7");
        resultList.add(createProperty("药剂成本","V9","元/m3",4,"V9=V7*V5/V1",array));

        resultObject1.put("propertyName","PAC");
        resultObject1.put("resultList",resultList);



        JSONObject resultObject2 = new JSONObject();
        JSONArray resultList2 = new JSONArray();//结果列表一

        JSONArray array2 = new JSONArray();
        array2.add("V1");
        array2.add("V2");
        array2.add("V3");
        resultList2.add(createProperty("理论投加药剂量","V6","吨/d",4,"V6==V1*V2/31*162.5/1000/1000/V3*100",array2));

        array2 = new JSONArray();
        array2.add("V6");
        array2.add("V4");
        resultList2.add(createProperty("实际投加药剂量","V7","吨/d",4,"V7=V6*V4",array2));

        array2 = new JSONArray();
        array2.add("V1");
        array2.add("V7");
        resultList2.add(createProperty("投配率（以产品计）","V8","mg/L",4,"V8=V7*1000/V1*1000",array2));

        array2 = new JSONArray();
        array2.add("V1");
        array2.add("V5");
        array2.add("V7");
        resultList2.add(createProperty("药剂成本","V9","元/m3",4,"V9=V7*V5/V1",array2));

        resultObject2.put("propertyName","三氯化铁");
        resultObject2.put("resultList",resultList2);


        JSONObject resultObject3 = new JSONObject();
        JSONArray resultList3 = new JSONArray();//结果列表一

        JSONArray array3 = new JSONArray();
        array3.add("V1");
        array3.add("V2");
        array3.add("V3");
        resultList3.add(createProperty("理论投加药剂量","V6","吨/d",4,"V6==V1*V2/1000/31*27*342/54/1000/V3*100",array3));

        array3 = new JSONArray();
        array3.add("V6");
        array3.add("V4");
        resultList3.add(createProperty("实际投加药剂量","V7","吨/d",4,"V7=V6*V4",array3));

        array3 = new JSONArray();
        array3.add("V1");
        array3.add("V7");
        resultList3.add(createProperty("投配率（以产品计）","V8","mg/L",4,"V8=V7*1000/V1*1000",array3));

        array3 = new JSONArray();
        array3.add("V1");
        array3.add("V5");
        array3.add("V7");
        resultList3.add(createProperty("药剂成本","V9","元/m3",4,"V9=V7*V5/V1",array3));

        resultObject3.put("propertyName","硫酸铝");
        resultObject3.put("resultList",resultList3);
        JSONArray mainResultList = new JSONArray();
        mainResultList.add(resultObject1);
        mainResultList.add(resultObject2);
        mainResultList.add(resultObject3);
        JSONObject resultObject4 = JSONObject.parseObject(resultObject3.toString().toString());
        resultObject4.getJSONArray("resultList").getJSONObject(0).put("calc","V6=V1*V2/1000/31*56/1000/V3*100");
        resultObject4.put("propertyName","聚合硫酸铁");

        mainResultList.add(resultObject4);
        JSONObject resultObject5 = JSONObject.parseObject(resultObject3.toString().toString());
        resultObject5.getJSONArray("resultList").getJSONObject(0).put("calc","V6=V1*V2/1000/31*278/1000/V3*100");
        resultObject5.put("propertyName","硫酸亚铁");
        mainResultList.add(resultObject5);
        JSONObject resultObjec6 = JSONObject.parseObject(resultObject3.toString().toString());
        resultObjec6.getJSONArray("resultList").getJSONObject(0).put("calc","V6=V1*V2/1000/31*127/1000/V3*100");
        resultObjec6.put("propertyName","氯化亚铁");
        mainResultList.add(resultObjec6);

        item.put("calcList",mainResultList);
        item.put("baseProperty",basePropertys);
        item.put("description","化学除磷是通过投加化学药剂形成不溶性磷酸盐沉淀，通过固液分离将磷从污水中除去。用于磷沉析的金属盐药剂主要是二价或三价Fe盐、Al盐，根）据其反应摩尔比进行理论计算。应用时注意：1）需药剂去除的磷浓度指正磷酸盐浓度；2）PAC有效成分为Al2O3，聚合硫酸铁有效成分为全铁，硫酸亚铁有效成分为FeSO4·7H2O。3）理论值系数，实际投加药剂时一般比理论计算值偏大，根据实际加药效果，可取系数1.5~2.5。4）如向生化池末端或二沉池进口投加除磷药剂，可参考计算值；如加在高效沉淀池，建议结合絮凝效果需要的药量综合考虑：当计算除磷所需药耗>满足絮凝条件所需药耗时，采用计算值；当计算除磷所需药耗<满足絮凝条件所需药耗时，采用后者。");

        TbCalc tbCalc = new TbCalc();
        tbCalc.setCalcName("化学除磷");
        tbCalc.setCalcContent(item.toString());
        System.out.println(item.toString());
        tbCalcService.addTbCalc(tbCalc);



    }

    @Test
    public void testCalc1(){
        /**
         * type 1:必填参数 2：须计算得出的中间参数 3：可选参数 4：结果
         */
        JSONObject item = new JSONObject();
        JSONArray baseProperties = new JSONArray();
        baseProperties.add(createProperty("进水流量","V1","m3/d",1,null,null));
        baseProperties.add(createProperty("外回流流量","V2","m3/d",1,null,null));
        baseProperties.add(createProperty("进入二沉池的MLSS","V3","mg/L",1,null,null));
        baseProperties.add(createProperty("二沉池表面积","V4","m2",1,null,null));

        JSONObject resultObject1 = new JSONObject();
        JSONArray resultList = new JSONArray();//结果列表一

        JSONArray array = new JSONArray();
        array.add("V1");
        array.add("V4");
        resultList.add(createProperty("水力表面负荷","V5","m3/m2.h",4,"V5=V1/24/V4",array));

        array = new JSONArray();
        array.add("V1");
        array.add("V2");
        array.add("V3");
        array.add("V4");
        resultList.add(createProperty("固体负荷","V6","kgSS/d",4,"V6=(V1+V2)*V3/1000/V4",array));

        resultObject1.put("propertyName","PAC");
        resultObject1.put("resultList",resultList);

        JSONArray mainResultList = new JSONArray();
        mainResultList.add(resultObject1);

        item.put("calcList",mainResultList);
        item.put("baseProperty",baseProperties);
        item.put("description","说明：二沉池表面负荷（日平均流量）一般设计范围在0.6-1.0m3/m2.h；固体负荷一般在140-160kg/(m2.d)");

        TbCalc tbCalc = new TbCalc();
        tbCalc.setCalcName("二沉池表面负荷");
        tbCalc.setCalcContent(item.toString());
        System.out.println(item.toString());
        tbCalcService.addTbCalc(tbCalc);

    }

    @Test
    public void testCalc2(){
        /**
         * type 1:必填参数 2：须计算得出的中间参数 3：可选参数 4：结果
         */
        JSONObject item = new JSONObject();
        JSONArray baseProperties = new JSONArray();
        baseProperties.add(createProperty("介质密度ρ","V1","kg/m3",1,null,null));
        baseProperties.add(createProperty("平均流量Q","V2","m3/h",1,null,null));
        baseProperties.add(createProperty("平均扬程H","V3","m",1,null,null));
        baseProperties.add(createProperty("平均功率P","V4","kW",1,null,null));

        JSONObject resultObject1 = new JSONObject();
        JSONArray resultList = new JSONArray();//结果列表一

        JSONArray array = new JSONArray();
        array.add("V1");
        array.add("V2");
        array.add("V3");
        array.add("V4");
        resultList.add(createProperty("固体负荷","V6","%",4,"V6=V1*V2/3.6*9.8*V3/1000/V4",array));



        resultObject1.put("propertyName","PAC");
        resultObject1.put("resultList",resultList);

        JSONArray mainResultList = new JSONArray();
        mainResultList.add(resultObject1);

        item.put("calcList",mainResultList);
        item.put("baseProperty",baseProperties);
        item.put("description","1.未安装流量计的污水泵流量可按以下公式计算：Q=实测电流*0.5/实际扬程H/输送介质每吨每米能耗（取值范围为0.0038～0.006KWH/吨/米，实际工况与额定工况相差越大，取值越小）；\n" +
                "2.未安装流量计的污泥泵（一般效率较低，流量较小，单位提升能耗较高）可采用容积替代法测定其流量，再计算设备效率。");

        TbCalc tbCalc = new TbCalc();
        tbCalc.setCalcName("水泵效率");
        tbCalc.setCalcContent(item.toString());
        System.out.println(item.toString());
        tbCalcService.addTbCalc(tbCalc);

    }

    @Test
    public void testCalc3(){
        /**
         * type 1:必填参数 2：须计算得出的中间参数 3：可选参数 4：结果
         */
        JSONObject item = new JSONObject();
        JSONArray baseProperties = new JSONArray();
        baseProperties.add(createProperty("总功率","V1","KW",1,null,null));
        baseProperties.add(createProperty("空气流量","V2","Nm3/min",1,null,null));
        baseProperties.add(createProperty("背压","V3","Kpa",1,null,null));
        baseProperties.add(createProperty("海拔高度","V4","m",1,null,null));

        JSONObject resultObject1 = new JSONObject();
        JSONArray resultList = new JSONArray();//结果列表一

        JSONArray array = new JSONArray();
        array.add("V3");
        resultList.add(createProperty("进口压力","V5","Kpa",4,"V5=101.325-V3/12*0.133",array));

        array = new JSONArray();
        array.add("V2");
        array.add("V4");
        array.add("V5");
        resultList.add(createProperty("气动消耗功率","V6","KW",4,"V6=353.19*V2/60*286.88/0.2857*(((V5+V4)/V5)^0.2857-1)/1000",array));

        array = new JSONArray();
        array.add("V1");
        array.add("V6");
        resultList.add(createProperty("风机效率","V7","%",4,"V7=100*V6/V1",array));

        resultObject1.put("propertyName","PAC");
        resultObject1.put("resultList",resultList);

        JSONArray mainResultList = new JSONArray();
        mainResultList.add(resultObject1);

        item.put("calcList",mainResultList);
        item.put("baseProperty",baseProperties);
        item.put("description","");

        TbCalc tbCalc = new TbCalc();
        tbCalc.setCalcName("风机效率");
        tbCalc.setCalcContent(item.toString());
        System.out.println(item.toString());
        //tbCalcService.addTbCalc(tbCalc);

    }

    private double  doCalc(JSONObject calcJSON,JSONObject inputJson){
        JSONArray propertyList = calcJSON.getJSONArray("propertyList");
        Binding binding = new Binding();
        for(int i=0;i<propertyList.size();i++){
            binding.setVariable(propertyList.getString(i),inputJson.getDoubleValue(propertyList.getString(i)));
        }
        binding.setVariable("language", "Groovy");
        String calcMath = calcJSON.getString("calc");
        calcMath = calcMath.replace("^","**");
        GroovyShell shell = new GroovyShell(binding);
        Object value =shell.evaluate(calcMath);
        System.out.println(calcJSON.getString("propertyName") + ":" +  value.toString());
        return Double.valueOf(value.toString());
//        JSONObject MJaon = new JSONObject();
//        JSONObject pJson = new JSONObject();
//        pJson.put("yanyangrongji",500);
//        pJson.put("queyangrongji",3000);
//        pJson.put("haoyangrongji",5000);
//        pJson.put("yanyang_mlss",3500);
//        pJson.put("queyang_mlss",4000);
//        pJson.put("haoyang_mlss",4000);
//        pJson.put("panniliag",400);
//        pJson.put("pannimlss",8000);
//        MJaon.put("valueInfo",pJson);
//        MJaon.put("tabName","污泥泥龄");
//        TbCalc tbCalc = tbCalcService.getTbCalc(MJaon.getString("tabName"));
//        JSONObject item = JSONObject.parseObject(tbCalc.getCalcContent());
//        System.out.println(doMath(MJaon,item));
    }

    private double doMath( JSONObject json, JSONObject item){

//        double flow = json.getDouble("flow");
//        double bod5 = json.getDouble("bod5");
//        double mlvss = json.getDouble("mlvss");
//        double rongji = json.getDouble("rongji");

        Binding binding = new Binding();
        for(String key :json.getJSONObject("valueInfo").keySet()){
            binding.setVariable(key,json.getJSONObject("valueInfo").getDoubleValue(key));
        }
        String math = "";
        if(!json.containsKey("mathId")){
            System.out.println(item.getJSONArray("mathList").toString());
            System.out.println(item.getJSONArray("mathList").getJSONObject(0).toString());
            math = item.getJSONArray("mathList").getJSONObject(0).getJSONObject("math").getString("result");
        }

//        binding.setVariable("bod5",bod5);
//        binding.setVariable("mlvss",mlvss);
//        binding.setVariable("rongji",rongji);

        binding.setVariable("language", "Groovy");

        GroovyShell shell = new GroovyShell(binding);
        Object F1 =shell.evaluate(math);

        return Double.valueOf(F1.toString());
    }

    /**
     * 基础输入项配置
     * @param name 名称
     * @param code 编号
     * @param unit 单位
     * @param type 类型 1：输入值，2：中间值（需要计算），3：中间值（可计算可输入），4：最终结果
     * @param calc 计算公式
     * @return
     */
    private JSONObject createProperty(String name,String code,String unit,int type,String calc,JSONArray propertyList){
        JSONObject json = new JSONObject();
        json.put("propertyName",name);
        json.put("code",code);
        json.put("unit",unit);
        json.put("type",type);
        if(calc!=null){
            json.put("calc",calc);
        }
        json.put("propertyList",propertyList);
        return json;
    }

    @Autowired
    TbParamMapper tbParamMapper;
    @Test
    public void testSaveTbParam() {
        BewgQueryTreeCondition condition = new BewgQueryTreeCondition();
        //{"forward":"true","depth":10,"relations":["/0/45"],"id":"5c528443147b260001341a70","namespace":"Hollysys_Bewg_modelNew","queryTypeDefinition":"true"}
        condition.setForward("true");
        condition.setDepth("9");
        List<String> real = new ArrayList<>();
        real.add("/0/45");
        condition.setRelations(real);
        condition.setId("5c528443147b260001341a70");//5c51bb665c074c00011b47ee  1  5c528443147b260001341a70   2
        condition.setNamespace("Hollysys_Bewg_modelNew");
        condition.setQueryTypeDefinition("true");
        JSONObject jsonObject = bewgService.queryTreeNode(condition);


        List<TbParam> list = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("result").getJSONObject(0).getJSONArray("children");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

            TbParam tbParam = JSON2Bean.getObjectfromJson(2,jsonObject1,null);
            if(jsonObject1.get("children")!=null){
                checkJSON(jsonObject1,"—",list,tbParam.getUri());
            }
            list.add(tbParam);
        }

        for(TbParam tbParam :list){
            System.out.println(tbParam.toString());
            tbParamMapper.insert(tbParam);
        }
    }



    private void checkJSON(JSONObject jsonObject,String level,List<TbParam> list,String parentUri){
        JSONArray jsonArray = jsonObject.getJSONArray("children");
        for (int j = 0; j < jsonArray.size(); j++) {
            JSONObject child = jsonArray.getJSONObject(j);
            TbParam tbParam = JSON2Bean.getObjectfromJson(2,child,parentUri);
            list.add(tbParam);
            if(child.containsKey("children")&&child.get("children")!=null){
                checkJSON(child,"—" + level,list,tbParam.getUri());
            }
        }
    }

    @Test
    public void getUserInfo(){
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb2RlIjoiODUyOWRiZDc3ZGU2NDU4MzIzYmNhNzk4NzU5N2MyZGVmOWVhMTgxMzYzYjk4MTE4YThhMGU5OTdlNWZlZjI1ZiIsInppZCI6InVhYSIsInRlbmFudE5hbWUiOiJiZXdnIiwidXNlcl9uYW1lIjoieGliaWFuIiwibmlja05hbWUiOiLluK3lv60iLCJpc3MiOiJodHRwOi8vMTkyLjE2OC42Ni4xNTg6MTgwODAvdWFhL29hdXRoL3Rva2VuIiwidGVuYW50SWQiOiJmNmFkMzY4YjRlZTUwYzA4NTM2ZmEzNjJlZjhjZDM2N2JmNTMzYzM0OWRkOGNjOTg5YzE5MmM5NTM4MGZkYzdkOGQ4NWQ0ODE1MzU1NWU0OTRiNzljZmEwZDlhZTNjZjEiLCJleHAiOjE1NzMyMzQ3NjAsImlhdCI6MCwianRpIjoiOWFkNjVkY2ItZTNiZC00M2Y4LWJmYjQtYzNlZTY0Y2MzMWRjIiwiY2xpZW50X2lkIjoiYmV3Zy1wcm8ifQ.eYmtS9VT_Jft3XK1vBDwULl3_X51mk9h_8aZZl7MvkMhCFnoPTzVVvXAmCnd9y6GnLdU5WPbkJFmaRxXjQJFKkBr7Wl7aEH9rsMvtG1UyeiSW3XGwZ0lReRIJBfio8xADkHBUwkLcSzhchuu-7QlT3Awhz7RWmPizo0G4C6rA6d3P5rVX3Zkzp-cOXSsHQ9PzdaTzlK8BRwy6lMMGVVypx3vcH9-z99vb3Bvd3CspllU7k0Qbr74qjIxXyhEVNWmgJUg8zfzYqyxFrSRDMDeZ8hXFS7domsEvn4FSBWO6N8s7V8wsz-V-VKbnDzhv4Vi6_fO1q0M0mVFjpMYF9h7Vw";
        String info = stringRedisTemplate.opsForValue().get(token);
        System.out.println(info);
    }


}
