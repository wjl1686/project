package com.ejobim.opplat.domain.synBean;

/**
 * 药剂预算实体(新)
 */
public class MonthlyYjysNewEntity {

    /*Type (integer, optional): 药剂类型 1:混凝剂；2：助凝剂 ；3：消毒剂；4：营养物质；5：酸 ；6：碱 ；7：污泥絮凝剂 ；8：污泥混凝剂；9：其他脱水药剂 ；10：水处理药剂其他； ,
    BBQ_ (string, optional): 批次号：年+月+月度周数，例如2019年12月第一周数据，就传20191201 ,
    USERID_ (string, optional): 水厂编号 ,
    BTYPE_ (string, optional),
    DB2INDEX_ (number, optional),
    SHTAG_ (string, optional),
    SHTAG2_ (string, optional),
    OPTION_ (string, optional),
    ISHJ_ (string, optional),
    A5 (string, optional): 指标编号 ,
    B5 (string, optional): 序号 ,
    C5 (string, optional): 化学名称 ,
    D5 (string, optional): 简称或化学式 ,
    E5 (string, optional): 剂型 ,
    F5 (string, optional): 药剂有效成分 ,
    G5 (string, optional): 药剂有效成分含量（%） ,
    H5 (number, optional): 药剂含量计算 ,
    I5 (string, optional): 药剂投加位置工艺段 ,
    J5 (number, optional): 不含税药剂单价 ,
    K5 (number, optional): 年均值 ,
    L5 (number, optional): 一月 ,
    O5 (number, optional): 二月 ,
    R5 (number, optional): 三月 ,
    U5 (number, optional): 四月 ,
    X5 (number, optional): 五月 ,
    AA5 (number, optional): 六月 ,
    AD5 (number, optional): 七月 ,
    AG5 (number, optional): 八月 ,
    AJ5 (number, optional): 九月 ,
    AM5 (number, optional): 十月 ,
    AP5 (number, optional): 十一月 ,
    AS5 (number, optional): 十二月 ,
    AV5 (number, optional): 对应水量/对应干泥量 ,
    AW5 (number, optional): 药量 ,
    AX5 (number, optional): 药剂费用 ,
    AY5 (number, optional): 药剂成本 ,
    AZ5 (number, optional): 不含税药剂单价 ,
    BA5 (number, optional): 年均值 ,
    BB5 (number, optional): 有效成分药耗---- 一月 ,
    BC5 (number, optional): 有效成分药耗----二月 ,
    BD5 (number, optional): 有效成分药耗----三月 ,
    BE5 (number, optional): 有效成分药耗----四月 ,
    BF5 (number, optional): 有效成分药耗----五月 ,
    BG5 (number, optional): 有效成分药耗----六月 ,
    BH5 (number, optional): 有效成分药耗----七月 ,
    BI5 (number, optional): 有效成分药耗----八月 ,
    BJ5 (number, optional): 有效成分药耗----九月 ,
    BK5 (number, optional): 有效成分药耗----十月 ,
    BL5 (number, optional): 有效成分药耗----十一月 ,
    BM5 (number, optional): 有效成分药耗----十二月 ,
    BN5 (number, optional): 对应水量/对应干泥量----一月 ,
    BO5 (number, optional): 对应水量/对应干泥量----二月 ,
    BP5 (number, optional): 对应水量/对应干泥量----三月 ,
    BQ5 (number, optional): 对应水量/对应干泥量----四月 ,
    BR5 (number, optional): 对应水量/对应干泥量----五月 ,
    BS5 (number, optional): 对应水量/对应干泥量----六月 ,
    BT5 (number, optional): 对应水量/对应干泥量----七月 ,
    BU5 (number, optional): 对应水量/对应干泥量----八月 ,
    BV5 (number, optional): 对应水量/对应干泥量----九月 ,
    BW5 (number, optional): 对应水量/对应干泥量----十月 ,
    BX5 (number, optional): 对应水量/对应干泥量----十一月 ,
    BY5 (number, optional): 对应水量/对应干泥量----十二月 ,
    BZ5 (number, optional): 对应水量/对应干泥量----年水量 ,
    CA5 (number, optional): 预算申报----药量 ,
    CB5 (number, optional): 药剂费用 ,
    CC5 (number, optional): 药剂成本 ,
    CP5 (string, optional): 编制说明 ,
    CQ5 (string, optional): 大区审核意见 ,
    CR5 (number, optional): 增值税发票水率 ,
    CS5 (number, optional): 含税费用*/
    //药剂类型 1:混凝剂；2：助凝剂 ；3：消毒剂；4：营养物质；5：酸 ；6：碱 ；7：污泥絮凝剂 ；8：污泥混凝剂；9：其他脱水药剂 ；10：水处理药剂其他；
    private Integer Type;
    // 批次号：年+月+月度周数，例如2019年12月第一周数据，就传20191201 ,
    private String BBQ_;
    //水厂编号
    private String USERID_;
    //指标编号
    private String A5;
    //序号
    private String B5;
    //化学名称
    private String C5;
    //简称或化学式
    private String D5;
    //剂型
    private String E5;
    //药剂有效成分
    private String F5;
    //药剂有效成分含量（%）
    private String G5;
    //药剂含量计算
    private Double H5;
    //药剂投加位置工艺段
    private String I5;
    //不含税药剂单价
    private Double J5;
    //年均值上期(水处理药耗)
    private Double K5;

    //一月
    private Double L5;
    //二月
    private Double O5;
    //三月
    private Double R5;
    //四月
    private Double U5;
    //五月
    private Double X5;
    //六月
    private Double AA5;
    //七月
    private Double AD5;
    //八月
    private Double AG5;
    //九月
    private Double AJ5;
    //十月
    private Double AM5;
    //十一月
    private Double AP5;
    //十二月
    private Double AS5;

    //对应水量/对应干泥量
    private Double AV5;
    //药量
    private Double AW5;
    //药剂费用
    private Double AX5;
    //药剂成本
    private Double AY5;
    //不含税药剂单价
    private Double AZ5;
    //年均值(预算水处理药耗)
    private Double BA5;

    //有效成分药耗---- 一月
    private Double BB5;
    //有效成分药耗----二月
    private Double BC5;
    //有效成分药耗----三月
    private Double BD5;
    //有效成分药耗----四月
    private Double BE5;
    // 有效成分药耗----五月
    private Double BF5;
    //有效成分药耗----六月
    private Double BG5;
    //有效成分药耗----七月
    private Double BH5;
    //有效成分药耗----八月
    private Double BI5;
    //有效成分药耗----九月
    private Double BJ5;
    //有效成分药耗----十月
    private Double BK5;
    //有效成分药耗----十一月
    private Double BL5;
    //有效成分药耗----十二月
    private Double BM5;


    // 对应水量/对应干泥量----一月
    private Double BN5;
    // 对应水量/对应干泥量----二月 ,
    private Double BO5;
    //对应水量/对应干泥量----三月
    private Double BP5;
    //对应水量/对应干泥量----四月
    private Double BQ5;
    //对应水量/对应干泥量----五月
    private Double BR5;
    // 对应水量/对应干泥量----六月
    private Double BS5;
    //对应水量/对应干泥量----七月
    private Double BT5;
    //对应水量/对应干泥量----八月
    private Double BU5;
    //对应水量/对应干泥量----九月
    private Double BV5;
    //对应水量/对应干泥量----十月
    private Double BW5;
    // 对应水量/对应干泥量----十一月
    private Double BX5;
    // 对应水量/对应干泥量----十二月
    private Double BY5;
    //对应水量/对应干泥量----年水量
    private Double BZ5;

    //预算申报----药量
    private Double CA5;
    //  药剂费用
    private Double CB5 ;
    // 药剂成本
    private Double CC5 ;
    // 编制说明
    private String CP5 ;
    //大区审核意见
    private String CQ5 ;
    // 增值税发票水率
    private String CR5 ;
    //含税费用
    private Double CS5 ;

}
