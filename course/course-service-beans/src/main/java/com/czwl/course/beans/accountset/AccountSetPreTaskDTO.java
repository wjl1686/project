package com.czwl.course.beans.accountset;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 账套前置任务
 *
 * @Author: srg
 * @Date: 2020/4/8 11:05
 */
@Data
@NoArgsConstructor
public class AccountSetPreTaskDTO implements Serializable {

    /**
     * 账套任务id
     */
    private Long id;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 任务编码
     */
    private String code;
}
