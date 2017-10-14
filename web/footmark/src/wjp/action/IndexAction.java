package wjp.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	private static final long serialVersionUID = 8476991723368780484L;
	public String index(){
		return "index";
	}
	public String main(){
		return SUCCESS;
	}
	
}
