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
		// ��LoginAction������������
		Object action = actionInvocation.getAction();
		if (action instanceof UserAction) {
			System.out
					.println("exit check login, because this is login action.");
			return actionInvocation.invoke();
		}

		// ȷ��Session���Ƿ����LOGIN
		Map session = actionInvocation.getInvocationContext().getSession();
		String login = (String) session.get(LOGIN_KEY);
		if (login != null && login.length() > 0) {
			// ���ڵ�����½��к���������
			System.out.println("already login!");
			return actionInvocation.invoke();
		} else {
			// ������ֹ��������������LOGIN
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
