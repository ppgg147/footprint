package wjp.bean;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable{
	private static final long serialVersionUID = 1718338030792690527L;
	public boolean success;
	public int code=200;
	public T data;
	public List<T> datas;
	public String info;
	public Result() {
		this.code=200;
	}
}
