package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipAttachment;
import com.ejobim.opplat.domain.TbEquipAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipAttachmentMapper {
    int countByExample(TbEquipAttachmentExample example);

    int deleteByExample(TbEquipAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEquipAttachment record);

    int insertSelective(TbEquipAttachment record);

    List<TbEquipAttachment> selectByExample(TbEquipAttachmentExample example);

    TbEquipAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEquipAttachment record, @Param("example") TbEquipAttachmentExample example);

    int updateByExample(@Param("record") TbEquipAttachment record, @Param("example") TbEquipAttachmentExample example);

    int updateByPrimaryKeySelective(TbEquipAttachment record);

    int updateByPrimaryKey(TbEquipAttachment record);

    List<TbEquipAttachment>  selectByEquipNo(TbEquipAttachment tbEquipAttachment);
}