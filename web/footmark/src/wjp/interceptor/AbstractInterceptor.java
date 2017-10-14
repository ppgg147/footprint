package wjp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;

public abstract class AbstractInterceptor implements Interceptor {
	private static final long serialVersionUID = -566013305294357441L;

	public void init() {
	}

	public void destroy() {
	}

	public abstract String intercept(ActionInvocation invocation)
			throws Exception;
}
