package com.czwl.course.beans.accountset;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: srg
 * @Date: 2020/4/7 9:42
 */
@Data
@NoArgsConstructor
public class AccountSetStatDTO extends BaseDTO {

    /**
     * 账套库总上架套数
     */
    private int putawaySum;

    /**
     * 账套被课程引用次数
     */
    private int citations;

    /**
     * 我开发的账套总数
     */
    private int myDevSum;

}
