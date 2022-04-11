package com.ejobim.opplat.common;

public class WorkFlowCommon {
    public   enum  OverhaulStatus {
        NEWPLAN(0,"NEWPLAN", "新建"), COMMITPLAN(1,"COMMITPLAN", "提交")
        ,FACTORYCHECK(2,"FACTORYCHECK","厂审批"),ZUTUANCHECK(3,"ZUTUANCHECK","组团审批")
        ,YEWUCHECK(4,"YEWUCHECK","业务区审批"),DAQUCHECK(5,"DAQUCHECK","大区审批")
        ,JITUANCHECK(6,"JITUANCHECK","集团审批");
        // 成员变量
        private String statusCode;
        private String statusName;
        private int statusIndex;
        // 构造方法
        private OverhaulStatus(int statusIndex,String statusCode,String statusName) {
            this.statusCode = statusCode;
            this.statusIndex = statusIndex;
            this.statusName = statusName;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public int getStatusIndex() {
            return statusIndex;
        }

        public void setStatusIndex(int statusIndex) {
            this.statusIndex = statusIndex;
        }
    }

    public   enum  OverhaulTaskStatus {
        NEW(0,"NEW", "计划未审核",0), COMMIT(1,"COMMIT", "待下发",0)
        ,LIXIANG(2,"LIXIANG","立项",0),ZHAOBIAO(3,"ZHAOBIAO","招标比价",0)
        ,HETONG(4,"HETONG","合同",0),ZHIXING(5,"ZHIXING","项目执行",2)
        ,YANSHOU(6,"YANSHOU","竣工验收",2),JIESUAN(7,"JIESUAN","结算",2);
        // 成员变量
        private String statusCode;
        private String statusName;
        private int statusIndex;
        private int platIndex;//该步骤运行的平台
        // 构造方法
        private OverhaulTaskStatus(int statusIndex,String statusCode,String statusName,int platIndex) {
            this.statusCode = statusCode;
            this.statusIndex = statusIndex;
            this.statusName = statusName;
            this.platIndex = platIndex;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public int getStatusIndex() {
            return statusIndex;
        }

        public void setStatusIndex(int statusIndex) {
            this.statusIndex = statusIndex;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public int getPlatIndex() {
            return platIndex;
        }

        public void setPlatIndex(int platIndex) {
            this.platIndex = platIndex;
        }
    }

    public   enum  MaintainTaskStatus {
        NEW(0,"NEW", "计划未审核",0), COMMIT(1,"COMMIT", "待下发",0)
        ,LIXIANG(2,"LIXIANG","立项",0),ZHAOBIAO(3,"ZHAOBIAO","招标比价",0)
        ,HETONG(4,"HETONG","合同",0)
        ,DAIRUN(10,"DAIRUN","待执行",0)
        ,ZHIXING(11,"ZHIXING","项目执行",2) ,WWZHIXING(5,"WWZHIXING","项目执行",1)
        ,YANSHOU(12,"YANSHOU","竣工验收",0),WWYANSHOU(6,"WWYANSHOU","竣工验收",0);
        // 成员变量
        private String statusCode;
        private String statusName;
        private int statusIndex;
        private int platIndex;//该步骤运行的平台
        // 构造方法
        private MaintainTaskStatus(int statusIndex,String statusCode,String statusName,int platIndex) {
            this.statusCode = statusCode;
            this.statusIndex = statusIndex;
            this.statusName = statusName;
            this.platIndex = platIndex;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public int getStatusIndex() {
            return statusIndex;
        }

        public void setStatusIndex(int statusIndex) {
            this.statusIndex = statusIndex;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public int getPlatIndex() {
            return platIndex;
        }

        public void setPlatIndex(int platIndex) {
            this.platIndex = platIndex;
        }
    }

    public static OverhaulStatus getOverhaulPlanNextStatus(String  statusCode){
        OverhaulStatus overhaulStatus = null;
        for(OverhaulStatus status:OverhaulStatus.values()){
            if(status.getStatusCode().equals(statusCode)){
                overhaulStatus =  status;
            }
        }
        for(OverhaulStatus status:OverhaulStatus.values()){
            if(status.getStatusIndex()==overhaulStatus.getStatusIndex()+1){
                return status;
            }
        }
        return null;
    }

    public static OverhaulTaskStatus getOverhaulTaskNextStatus(String  statusCode){
        OverhaulTaskStatus taskStatus = null;
        for(OverhaulTaskStatus status:OverhaulTaskStatus.values()){
            if(status.getStatusCode().equals(statusCode)){
                taskStatus =  status;
            }
        }
        for(OverhaulTaskStatus status:OverhaulTaskStatus.values()){
            if(status.getStatusIndex()==taskStatus.getStatusIndex()+1){
                return status;
            }
        }
        return null;
    }

    public static MaintainTaskStatus getMaintainTaskNextStatus(String  statusCode){
        MaintainTaskStatus taskStatus = null;
        for(MaintainTaskStatus status:MaintainTaskStatus.values()){
            if(status.getStatusCode().equals(statusCode)){
                taskStatus =  status;
            }
        }
        for(MaintainTaskStatus status:MaintainTaskStatus.values()){
            if(status.getStatusIndex()==taskStatus.getStatusIndex()+1){
                return status;
            }
        }
        return null;
    }


    public static MaintainTaskStatus getMaintainTaskCurrentStatus(String  statusCode){
        MaintainTaskStatus taskStatus = null;
        for(MaintainTaskStatus status:MaintainTaskStatus.values()){
            if(status.getStatusCode().equals(statusCode)){
                return  status;
            }
        }
        return null;
    }

    public final  static Integer PC_PLAT = 0;
    public final  static Integer PC_MOBILE_PLAT = 1;
    public final  static Integer MOBILE_PLAT = 2;

    //计划状态
    public final  static Integer WORK_TASK_STATUS_PLAN = 0;
    //工单状态
    public final  static Integer WORK_TASK_STATUS_ORDER = 1;
    //重修
    public final  static Integer WORK_TASK_STATUS_ORDER_REPEAT = 3;
    //已完成
    public final  static Integer WORK_TASK_STATUS_FINISH = 2;

    //取消的计划，主动取消
    public final  static Integer WORK_TASK_STATUS_CANCEL= -1;
    //取消的计划 ,审批不通过
    public final  static Integer WORK_TASK_STATUS_CHECK_FAIL= -2;
    //无法执行
    public final  static Integer WORK_TASK_STATUS_FAIL= 10;
    //无法执行 已处理
    public final  static Integer WORK_TASK_STATUS_FAIL_HANDLE= 11;

    public final static String SBWX_YCSB = "YCFX";
    public final static String SBWX_WXJH = "WXJH";
    public final static String SBWX_WXGD = "WDGD";


    public final static String WBJH = "WBJH";
    public final static String WBGD = "WBGD";
    public final static String SBTZ = "SBTZ";
    public final static String GYTZ = "GYTZ";

    public final static String SBWX = "SBWX";
    public final static String SBWXN = "SBWXN";

    public final static String SBWB = "SBWB";
    public final static String SBDX = "SBDX";
    public final static String SBFF = "SBFF";

    public final static int WX_TYPE = 4;
    public final static int WB_TYPE =5;
    public final static int DX_TYPE =6;
    public final static int FF_TYPE =7;
    public final static int GYTZ_TYPE =9;
    public final static int SBTZ_TYPE =10;

    public static String getTaskTypeName(int type){
        switch (type){
            case WX_TYPE:
                return "设备维修";
            case WB_TYPE:
                return "设备维保";
            case DX_TYPE:
                return "设备大修";
            case FF_TYPE:
                return "设备防腐";
            case GYTZ_TYPE:
                return "工艺调整";
            case SBTZ_TYPE:
                return "设备调整";
            default:
                return null;
        }
    }

    public final static String WORK_FLOW_ROUTE_OWN = "USEOWN";

    public final static Integer FLOW_CODE_FULL = -1;



    /**
     * 步骤正常
     */
    public final static Integer FLOW_NORM = 0;

    /**
     * 步骤被回退
     */
    public final static Integer FLOW_RETURN = 1;


    public final static Integer GROUP_TYPE_SB = 2;
    public final static Integer GROUP_TYPE_YX = 1;

    public final static Integer USER_TYPE_MANAGER = 1;
    public final static Integer USER_TYPE_NORM = 0;

    public final static Integer ENTRUST_YES = 1;
    public final static Integer ENTRUST_NO = 0;

    public final static Integer TEMP_YES = 1;
    public final static Integer TEMP_NO = 0;


}
