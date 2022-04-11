package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbObjectData;
import com.ejobim.opplat.domain.TbObjectDataExample;
import java.util.List;

import com.ejobim.opplat.domain.condition.TaskInfoCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbObjectDataMapper {
    int countByExample(TbObjectDataExample example);

    int deleteByExample(TbObjectDataExample example);

    int insert(TbObjectData record);

    int insertSelective(TbObjectData record);

    List<TbObjectData> selectByExample(TbObjectDataExample example);

    int updateByExampleSelective(@Param("record") TbObjectData record, @Param("example") TbObjectDataExample example);

    int updateByExample(@Param("record") TbObjectData record, @Param("example") TbObjectDataExample example);


    void insertBatch(List<TbObjectData> fieldlist);

    List<TbObjectData>  selectBatchByUri(@Param("list") List<String> list);

    String  selectDatUriByEquipUri(@Param("equipUri") String equipUri);

    List<String> selectObjectUriByDataUri(@Param("dataUri") String dataUri);

    List<String> selectRootObjectUriList(TaskInfoCondition condition);

    List<TbObjectData>  selectByDataUri(String dataUri);

    List<TbObjectData> selectBatchByDataUri(List<String> list);
}