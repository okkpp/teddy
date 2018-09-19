package okkpp.common.result;

/**
 * 使用泛型是为了方便swagger解析结果
 * 
 * @author okkpp
 *
 * @param <T>
 */
public class Result<T> {

	private int code;
	private String msg;
	private T data;
	
	public Result() {
		this.code = Response.MSG.getCode();
	};
	public Result(T data) {
		this(Response.DATA.getCode(), null, data);
	}
	public Result(String msg) {
		this(Response.MSG.getCode(), msg);
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
		return new Result<>(Response.FAILED.getCode(), "failed");
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
enum Response {
	FAILED(-200),MSG(200),DATA(300),PAGED(400);
	private int code;
	private Response(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}