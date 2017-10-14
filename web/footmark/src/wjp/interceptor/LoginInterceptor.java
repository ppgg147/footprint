package wjp.interceptor;

import java.util.Map;

import wjp.action.IndexAction;
import wjp.action.UserAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {
	private static final long serialVersionUID = -4409507846064552966L;
	public static final String LOGIN_KEY = "isLogin";
	public static final String LOGIN_PAGE = "index";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Object action = actionInvocation.getAction();
		//只对IndexAction不做该项拦截
		if (action instanceof IndexAction) {
			// 确认Session中是否存在LOGIN
			Map session = actionInvocation.getInvocationContext().getSession();
			boolean isLogin = false;
			try {
				isLogin = (Boolean) session.get(LOGIN_KEY);
			} catch (Exception e) {
			}
			if (isLogin) {
				// 存在的情况下进行后续操作。
				return actionInvocation.invoke();
			} else {
				// 否则终止后续操作，返回LOGIN
				return LOGIN_PAGE;
			}
		} else {
			return actionInvocation.invoke();
		}

	}
}