package wnderful.imgannotator.publicData.reponseCode.userResponseCode;

public enum  LostPointsRepCode {
    SUCCESS(0,"积分扣除成功"),
    FAIL(1,"积分扣除失败"),
    NOTFOUND(2,"用户不存在"),
    NOTENOUGH(3,"余额不足"),
    UNPROPER(4,"扣除积分必须大于零");

    private int code;
    private String message;

    LostPointsRepCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
