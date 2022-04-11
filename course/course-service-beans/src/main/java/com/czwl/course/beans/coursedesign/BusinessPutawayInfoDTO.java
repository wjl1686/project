package com.czwl.course.beans.coursedesign;

import com.czwl.course.beans.accountset.PutawayInfoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 业务中多条定价传输对象
 *
 * @Author: srg
 * @Date: 2020/7/1 20:43
 */
@Data
@NoArgsConstructor
public class BusinessPutawayInfoDTO {

    private List<PutawayInfoDTO> putawayInfoDTOList;

    private Long businessId;

    private Integer businessType;

    private Integer sellWay;
}
