package okkpp.common.result;

public class Result<T> {

	private int code;
	private String msg;
	private T data;
	
	public Result() {
		this.code = 200;
	};
	public Result(T data) {
		this(300, null, data);
	}
	public Result(String msg) {
		this(200, msg);
	}
	public Result(int code, String msg) {
		this(code, msg, null);
	}
	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	public static Result<String> success() {
		return new Result<>("success");
	}
	public static Result<String> failed() {
		return new Result<>(-200, "failed");
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
