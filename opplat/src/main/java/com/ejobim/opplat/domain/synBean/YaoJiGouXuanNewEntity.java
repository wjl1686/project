package com.ejobim.opplat.domain.synBean;
/**
 * 药剂勾选实体(新)
 */
public class YaoJiGouXuanNewEntity {

   /* Type (integer, optional):  ,
    USERID_ (string, optional): 水厂编号 ,
    A3 (string, optional): 指标编号 ,
    B3 (string, optional): 序号 ,
    C3 (string, optional): 化学名称 ,
    D3 (string, optional): 简称或化学式 ,
    E3 (string, optional): 剂型 ,
    F3 (string, optional): 药剂有效成分 ,
    G3 (string, optional): 药剂有效成分含量 ,
    H3 (string, optional): 有效成分 ,
    I3 (string, optional): 药剂投加药位置 ,
    J3 (string, optional): 是否填报*/
   //药剂类型 1:混凝剂；2：助凝剂 ；3：消毒剂；4：营养物质；5：酸 ；6：碱 ；7：污泥絮凝剂 ；8：污泥混凝剂；9：其他脱水药剂 ；10：水处理药剂其他；
    private Integer Type;
   //水厂编号
    private String USERID_;
    //指标编号
    private String A3;
    //序号
    private String B3;
    //化学名称
    private String C3;
    //简称或化学式
    private String D3;
    //剂型
    private String E3;
    //药剂有效成分
    private String F3;
    //药剂有效成分含量
    private String G3;
    //有效成分
    private String H3;
    //药剂投加药位置
    private String I3;
    //是否填报 1 填报
    private String J3;

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public String getUSERID_() {
        return USERID_;
    }

    public void setUSERID_(String USERID_) {
        this.USERID_ = USERID_;
    }

    public String getA3() {
        return A3;
    }

    public void setA3(String a3) {
        A3 = a3;
    }

    public String getB3() {
        return B3;
    }

    public void setB3(String b3) {
        B3 = b3;
    }

    public String getC3() {
        return C3;
    }

    public void setC3(String c3) {
        C3 = c3;
    }

    public String getD3() {
        return D3;
    }

    public void setD3(String d3) {
        D3 = d3;
    }

    public String getE3() {
        return E3;
    }

    public void setE3(String e3) {
        E3 = e3;
    }

    public String getF3() {
        return F3;
    }

    public void setF3(String f3) {
        F3 = f3;
    }

    public String getG3() {
        return G3;
    }

    public void setG3(String g3) {
        G3 = g3;
    }

    public String getH3() {
        return H3;
    }

    public void setH3(String h3) {
        H3 = h3;
    }

    public String getI3() {
        return I3;
    }

    public void setI3(String i3) {
        I3 = i3;
    }

    public String getJ3() {
        return J3;
    }

    public void setJ3(String j3) {
        J3 = j3;
    }
}
