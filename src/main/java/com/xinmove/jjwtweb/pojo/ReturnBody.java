package com.xinmove.jjwtweb.pojo;

/**
 * @ClassName ReturnBody
 * @Descripption 返回体
 * @Author chenweitao
 * @Date 2019/1/25 14:25
 **/
public class ReturnBody {

    /* 状态 */
    private boolean state;

    /* 数据 */
    private Object data;

    /* 消息 */
    private String message;

    public static ReturnBody success(Object data) {
        return new ReturnBody(true, data, "操作成功");
    }

    public static ReturnBody success(Object data, String message) {
        return new ReturnBody(true, data, message);
    }

    public static ReturnBody fail(String message) {
        return new ReturnBody(false, "", message);
    }

    public static ReturnBody fail(Object data, String message) {
        return new ReturnBody(false, data, message);
    }

    public ReturnBody(boolean state, Object data, String message) {
        this.state = state;
        this.data = data;
        this.message = message;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnBody{" +
                "state=" + state +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
