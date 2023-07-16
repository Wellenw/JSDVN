package cn.tedu.pojo;

public class JsonResult {
    /*状态码*/
    private Integer state = 1; //1表示OK,0表示ERROR
    /*状态信息*/
    private String message = "ok";
    /*封装正确的查询结果*/
    private Object data;

    public JsonResult() {}

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    //当出现异常时,可以通过此构造方法对异常信息进行封装
    public JsonResult(Throwable ex) {
        this(0,ex.getMessage());
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
