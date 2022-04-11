package com.czwl.course.beans.coursedesign;

import com.czwl.course.beans.accountset.AccountSetTaskDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 账套任务保存排序DTO
 *
 * @Author: srg
 * @Date: 2020/7/1 20:50
 */
@Data
@NoArgsConstructor
public class AccountSetTaskSortDTO {

    private List<AccountSetTaskDTO> taskList;

    private Long accountSetId;
}
