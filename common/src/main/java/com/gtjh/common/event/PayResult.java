package com.gtjh.common.event;

import com.google.gson.Gson;

/**
 * Created by android on 2018/8/20.
 */
/*import android.text.TextUtils;
public class PayResult {
    private String resultStatus;	private String result;
    private String memo;
    public PayResult(String rawResult) {
        if (TextUtils.isEmpty(rawResult))
            return;
        String[] resultParams = rawResult.split(";");
        for (String resultParam : resultParams) {
            if (resultParam.startsWith("resultStatus")) {
                resultStatus = gatValue(resultParam, "resultStatus");
            }
            if (resultParam.startsWith("result")) {
                result = gatValue(resultParam, "result");
            }
            if (resultParam.startsWith("memo")) {
                memo = gatValue(resultParam, "memo");
            }
        }
    }
    @Override
    public String toString() {
        return "resultStatus={" + resultStatus + "};memo={" + memo	+ "};result={" + result + "}";
    }
    private String gatValue(String content, String key) {
        String prefix = key + "={";	return content.substring(content.indexOf(prefix) + prefix.length(),	content.lastIndexOf("}"));
    }
    *//**	* @return the resultStatus	*//*
    public String getResultStatus() {
        return resultStatus;
    }
    *//**	* @return the memo	*//*
    public String getMemo() {
        return memo;
    }
    *//**	* @return the result	*//*
    public String getResult() {
        return result;
    }
}*/
public class PayResult {
    private String result;
    private String resultStatus;

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public PayResult(Object s){
        Gson gson=new Gson();
        PayResult payResult=gson.fromJson(gson.toJson(s),PayResult.class);
        setResult(payResult.getResult());
        setResultStatus(payResult.getResultStatus());
    }
}
