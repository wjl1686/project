package com.ejobim.opplat.domain.synBean;

public class ApiReturnEntity {
    private String ResultType;
    private String Message;
    private String DataResult;

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getDataResult() {
        return DataResult;
    }

    public void setDataResult(String dataResult) {
        DataResult = dataResult;
    }

    public String toString() {
        return "ResultType:" + ResultType + ",Message:" +Message + ",DataResult:" + DataResult;
    }
}
