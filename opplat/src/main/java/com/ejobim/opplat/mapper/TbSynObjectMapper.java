package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSynObject;
import com.ejobim.opplat.domain.TbSynObjectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbSynObjectMapper {
    int countByExample(TbSynObjectExample example);

    int deleteByExample(TbSynObjectExample example);

    int deleteByPrimaryKey(String uri);

    int insert(TbSynObject record);

    int insertSelective(TbSynObject record);

    List<TbSynObject> selectByExample(TbSynObjectExample example);

    TbSynObject selectByPrimaryKey(String uri);

    List<TbSynObject> getParamLists(@Param("factoryNo") String factoryNo, @Param("uri") String uri,@Param("fieldType") Integer fieldType,
                                    @Param("browseName") String browseName,@Param("displayName") String displayName,@Param("hasValue") Integer hasValue);

    int updateByExampleSelective(@Param("record") TbSynObject record, @Param("example") TbSynObjectExample example);

    int updateByExample(@Param("record") TbSynObject record, @Param("example") TbSynObjectExample example);

    int updateByPrimaryKeySelective(TbSynObject record);

    int updateByPrimaryKey(TbSynObject record);

    List<TbSynObject> getParamLists(@Param("factoryNo") String factoryNo, @Param("param") String param);

    int insertBatch(List<TbSynObject> list);

    List<TbSynObject> findSynObjectList(String factoryNo);

    List<TbSynObject> selectBatchUris(@Param("uris") List<String> uris);

    List<TbSynObject>  selectSynObjectByParentUri(TbSynObject tbSynObject);

    List<TbSynObject>  selectSynObjectByConds(TbSynObject tbSynObject);

    List<TbSynObject>   selectSynObjectByFactoryNo(TbSynObject tbSynObject);

    List<TbSynObject>  getSynObjectInfo();
    
}