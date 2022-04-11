package com.ejobim.opplat.util;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbParam;

import java.util.Date;

public class JSON2Bean {
    public static  TbParam getObjectfromJson(int type,JSONObject jsonObject,String parentUri){
        TbParam tbParam = new TbParam();
        tbParam.setName(StringTools.clearNumber(jsonObject.getString("name")));
        tbParam.setParentUri(parentUri);
        tbParam.setType(type);
        tbParam.setUri(jsonObject.getString("uri"));
        tbParam.setCreateTime(new Date());
        return tbParam;
    }
}
