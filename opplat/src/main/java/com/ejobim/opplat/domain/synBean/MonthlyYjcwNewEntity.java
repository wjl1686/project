package com.ejobim.opplat.domain.synBean;
/**
 * 月报药剂财务实体(新)
 */
public class MonthlyYjcwNewEntity {

    //药剂类型 1:混凝剂；2：助凝剂 ；3：消毒剂；4：营养物质；5：酸 ；6：碱 ；7：污泥絮凝剂 ；8：污泥混凝剂；9：其他脱水药剂 ；10：水处理药剂其他；
    private Integer Type;
    // 批次号：年+月+月度周数，例如2019年12月第一周数据，就传20191201 ,
    private String BBQ_;
    //水厂编号
    private String USERID_;
    //指标编号
    private String A4;
    //序号
    private String B4;
    //化学名称
    private String C4;
    //简称或化学式
    private String D4;
    //剂型
    private String E4;
    //药剂有效成分
    private String F4;
    //药剂有效成分含量
    private String G4;
    //药剂含量计算
    private Double H4;
    //药剂投加位置工艺段
    private String I4;
    //药量（财务口径）
    private Double J4;
    //不含税药剂单价
    private Double K4;
    //药剂费用（财务口径）
    private Double L4;

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public String getBBQ_() {
        return BBQ_;
    }

    public void setBBQ_(String BBQ_) {
        this.BBQ_ = BBQ_;
    }

    public String getUSERID_() {
        return USERID_;
    }

    public void setUSERID_(String USERID_) {
        this.USERID_ = USERID_;
    }

    public String getA4() {
        return A4;
    }

    public void setA4(String a4) {
        A4 = a4;
    }

    public String getB4() {
        return B4;
    }

    public void setB4(String b4) {
        B4 = b4;
    }

    public String getC4() {
        return C4;
    }

    public void setC4(String c4) {
        C4 = c4;
    }

    public String getD4() {
        return D4;
    }

    public void setD4(String d4) {
        D4 = d4;
    }

    public String getE4() {
        return E4;
    }

    public void setE4(String e4) {
        E4 = e4;
    }

    public String getF4() {
        return F4;
    }

    public void setF4(String f4) {
        F4 = f4;
    }

    public String getG4() {
        return G4;
    }

    public void setG4(String g4) {
        G4 = g4;
    }

    public Double getH4() {
        return H4;
    }

    public void setH4(Double h4) {
        H4 = h4;
    }

    public String getI4() {
        return I4;
    }

    public void setI4(String i4) {
        I4 = i4;
    }

    public Double getJ4() {
        return J4;
    }

    public void setJ4(Double j4) {
        J4 = j4;
    }

    public Double getK4() {
        return K4;
    }

    public void setK4(Double k4) {
        K4 = k4;
    }

    public Double getL4() {
        return L4;
    }

    public void setL4(Double l4) {
        L4 = l4;
    }
}
