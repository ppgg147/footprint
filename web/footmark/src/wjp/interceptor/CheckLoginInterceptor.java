package wjp.interceptor;

import java.util.Map;

import wjp.action.UserAction;

import com.opensymphony.xwork2.ActionInvocation;

public class CheckLoginInterceptor implements Interceptor {
	private static final long serialVersionUID = -5694097321335697256L;
	public static final String LOGIN_KEY = "LOGIN";
	public static final String LOGIN_PAGE = "global.login";

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		System.out.println("begin check login interceptor!");
		// 对LoginAction不做该项拦截
		Object action = actionInvocation.getAction();
		if (action instanceof UserAction) {
			System.out
					.println("exit check login, because this is login action.");
			return actionInvocation.invoke();
		}

		// 确认Session中是否存在LOGIN
		Map session = actionInvocation.getInvocationContext().getSession();
		String login = (String) session.get(LOGIN_KEY);
		if (login != null && login.length() > 0) {
			// 存在的情况下进行后续操作。
			System.out.println("already login!");
			return actionInvocation.invoke();
		} else {
			// 否则终止后续操作，返回LOGIN
			System.out.println("no login, forward login page!");
			return LOGIN_PAGE;
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
