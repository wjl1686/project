package com.ejobim.opplat.common;

public class Dict {
    public final static int TASK_STATUS_UNDEPLOY=0;

    public  enum validStatus {
        YES("YES", 1), NO("NO", 2);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private validStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (validStatus c : validStatus.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

    public  enum dataStatus {
        YES("YES", 0), NO("NO", 1);
        // 成员变量
        private String name;
        private int code;
        // 构造方法
        private dataStatus(String name, int code) {
            this.name = name;
            this.code = code;
        }
        // 普通方法
        public static String getName(int code) {
            for (dataStatus c : dataStatus.values()) {
                if (c.getCode() == code) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
    }

    public  enum  AjaxStatus {
        YES("成功", 0), FAIL("保存失败", 2),NOLOGIN("未登陆", 11), NOFIND("未找到资源", 4)
        , RECOMMITE("重复提交", 5) , NOROLE("没有权限", 6)
        , UNKONWN("未知错误", 666),NUMBER_EXIST("编号已存在",100)
        ,CHOOSE_USER("请选择评价人",101),NO_SPARE_PARTS("备品备件不足",102),EQUIP_NUMBER_EXIST("设备代码存在",103)
        ,PARAM_IS_NULL("参数不能为空",104),SERVICE_RROR("服务器错误",401)
        ,NO_SET_CALLBACK("未设置驳回信息",301),RECREATE("重复创建",302),NOSTART("未开始的任务",303),GROUPNAME_EXIST("组名存在",304),
        SCHEDULING_PLAN_EXIST("该时间点排班存在",305),USER_NO_CHEDULING_INFO("该用户再无班组排班信息",306),USER_NO_GOING_SCHEDULING_PLAN("该班组没有正在运行的排班信息",307),QRCODE_EXIST("交班二维码已经生成",308),
        NO_TIME_LIMIT("不在交班时间范围内",309),FINSH_SCHEDULING("已经交接班",310),MODEL_IS_NULL("该模式下未配置设备",311),MODEL_NAME_REPEAT("巡检模式名称重复",312),LOCATTION_NAME_REPEAT("巡检点名称或顺序重复",313),
        RE_CREATE("重复创建", 314),RE_EQUIP_CODE("设备code重复",315), RE_NAB_IDEAL("工艺名称或工艺顺序存在",316),NAME_EXIST("填报名称存在",317),NFC_NO_EXIST("nfc卡号已经存在",318),
        NFC_NO_OR_NAME_EXIST("nfc卡号或名称已经存在",319),SORT_EXIST("该顺序已存在",320),ROUTING_START_EXIST("不可取消已开始的巡检任务",321),SYSTEM_REPORT("不可删除系统报表模板",322)
        , TASK_STATUS_CHANGED("工单状态已发生变更",323), EQUIP_STATUS_NO_CHANGE("一致的状态",324), EQUIP_GROUP_NO_PlAN("设备班暂无排班或已创建,无法创建巡检工单",325),
        FAULT_NAME_EXIST("故障名称存在",326)
        ,FACTORY_TIME_EQUIP_HAS("运行班只支持2班和3班",401),FACTORY_TIME_COUNT_ERROR("设备班或化验班班次需要两个时间点",402)
        ,FACTORY_TIME_EQUIP_ERROR("设备班班次开始时间点要小于结束时间点",404), SCHEDULE_RULE_TIME("后一排班规则启用时间至少晚于前一规则10天",403)
        , SCHEDULE_HAS_FINISH("已经是最新排班",405), IMPORT_FAI("数据导入失败",500),IMPORT_FACTORY_FAI("数据导入成功,同步水厂基本信息失败",501),IMPORT_SHUI_FAI("数据导入成功,同步水质信息失败",502),IMPORT_TUO_FAI("数据导入成功,同步脱水信息失败",502);

        private String statusName;
        private Integer statusCode;

        private AjaxStatus(String statusName,Integer statusCode){
            this.statusName = statusName;
            this.statusCode = statusCode;
        }




        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }
    }

    public enum fillFormType{

        ROUTING_FIELD("巡检填报", 1),ANALYSIS_FIELD("化验填报", 2),MULTI_FIELD("日常填报", 3);

        private String fieldTypeName;
        private Integer fieldTypeCode;

        private fillFormType(String fieldTypeName,Integer fieldTypeCode){
            this.fieldTypeName = fieldTypeName;
            this.fieldTypeCode = fieldTypeCode;
        }

        public String getFieldTypeName() {
            return fieldTypeName;
        }

        public void setFieldTypeName(String fieldTypeName) {
            this.fieldTypeName = fieldTypeName;
        }

        public Integer getFieldTypeCode() {
            return fieldTypeCode;
        }

        public void setFieldTypeCode(Integer fieldTypeCode) {
            this.fieldTypeCode = fieldTypeCode;
        }
    }

    /**
     * 根据CODE获取状态枚举对象
     * @param code
     * @return
     */
    public static AjaxStatus getAjaxStatus(int code) {
        for (AjaxStatus ajaxStatus : AjaxStatus.values()) {
            if(ajaxStatus.getStatusCode()==code) {
                return ajaxStatus;
            }
        }
        return  AjaxStatus.UNKONWN;
    }

    //删除标记—已删除
    public static final int DELETE_YES = 1;
    //删除标记—正常
    public static final int DELETE_NO = 0;

    //巡检工单状态—计划状态
    public static final int ROUTING_TASK_STATUS_PLAN = 0;
    //巡检工单状态—已开始
    public static final int ROUTING_TASK_STATUS_STAET = 1;
    //巡检工单状态—已完成
    public static final int ROUTING_TASK_STATUS_COMMIT = 2;
    //巡检工单状态—已取消
    public static final int ROUTING_TASK_STATUS_CANCEL = 4;

    //机构类型-水厂
    public static final int ORG_TYPE_FACTORY = 5;


    //异常状态0：未处理 1：转工单 2：不需要处理 3:转工艺 4:转工艺/维修
    public static  final int ERROR_STATUS_NROM = 0;
    public static  final int ERROR_STATUS_TASK = 1;
    public static  final int ERROR_STATUS_NONE = 2;
    public static  final int ERROR_STATUS_GYTZ = 3;
    public static  final int ERROR_STATUS_TASK_AND_GYTZ = 4;

}
