package wjp.util;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

public class JsonUtils {

	/**
	 * ·µ»ØJson×Ö·û´®
	 * @param jsonString
	 */
	public static void SendJson(String jsonString) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try
		{
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			out.close();
			out.flush();
			return;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
