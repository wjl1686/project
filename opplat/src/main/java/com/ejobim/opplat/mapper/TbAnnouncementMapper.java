package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbAnnouncement;
import com.ejobim.opplat.domain.TbAnnouncementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAnnouncementMapper {
    int countByExample(TbAnnouncementExample example);

    int deleteByExample(TbAnnouncementExample example);

    int deleteByPrimaryKey(String annoucementNo);

    int insert(TbAnnouncement record);

    int insertSelective(TbAnnouncement record);

    List<TbAnnouncement> selectByExampleWithBLOBs(TbAnnouncementExample example);

    List<TbAnnouncement> selectByExample(TbAnnouncementExample example);

    TbAnnouncement selectByPrimaryKey(String annoucementNo);

    int updateByExampleSelective(@Param("record") TbAnnouncement record, @Param("example") TbAnnouncementExample example);

    int updateByExampleWithBLOBs(@Param("record") TbAnnouncement record, @Param("example") TbAnnouncementExample example);

    int updateByExample(@Param("record") TbAnnouncement record, @Param("example") TbAnnouncementExample example);

    int updateByPrimaryKeySelective(TbAnnouncement record);

    int updateByPrimaryKeyWithBLOBs(TbAnnouncement record);

    int updateByPrimaryKey(TbAnnouncement record);
}