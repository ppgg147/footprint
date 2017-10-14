package wjp.util;

import java.io.IOException;  
import java.io.UnsupportedEncodingException;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  

import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;  
import org.apache.http.ParseException;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.client.methods.HttpUriRequest;  
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.protocol.HTTP;  
import org.apache.http.util.EntityUtils;  

public class HttpXmlClient {

	public static String Post(String url, String js,String Authorization) {  
		final String CONTENT_TYPE_TEXT_JSON = "text/json";
		DefaultHttpClient client = new DefaultHttpClient(
				new PoolingClientConnectionManager());
		HttpPost httpPost = new HttpPost(url);       
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
		httpPost.setHeader("Accept", "application/json");
		if(!Authorization.equals("")){
			httpPost.setHeader("Authorization", Authorization);
		}
		StringEntity se;
		try {
			if(!js.equals("")&&js!=null){		
				se = new StringEntity(js);
				se.setContentEncoding("UTF-8");
				se.setContentType(CONTENT_TYPE_TEXT_JSON);
				httpPost.setEntity(se);
			}
			HttpResponse response2 = null;
			response2 = client.execute(httpPost);
			HttpEntity entity2 = null;
			entity2 = response2.getEntity();
			String s2 = EntityUtils.toString(entity2, "UTF-8");
			System.out.println(s2);
			return  s2;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";			
	}  
	private String post(String url, Map<String, String> params) {  
		DefaultHttpClient httpclient = new DefaultHttpClient();  

		String body = null;          
		HttpPost post = postForm(url, params);          
		body = invoke(httpclient, post);        
		httpclient.getConnectionManager().shutdown();           
		return body;  
	}  

	public static String get(String url,String Authorization) {  
		DefaultHttpClient client = new DefaultHttpClient(
				new PoolingClientConnectionManager());
		//HttpPost httpPost = new HttpPost(url);    
		HttpGet httpGet=new HttpGet(url);
		httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
		httpGet.setHeader("Accept", "application/json");
		if(!Authorization.equals("")){
			httpGet.setHeader("Authorization", Authorization);
		}
		StringEntity se;
		try {		
			HttpResponse response2 = null;
			response2 = client.execute(httpGet);
			HttpEntity entity2 = null;
			entity2 = response2.getEntity();
			String s2 = EntityUtils.toString(entity2, "UTF-8");
			System.out.println(s2);
			return  s2;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";			
	}  


	private static String invoke(DefaultHttpClient httpclient,  
			HttpUriRequest httpost) {  

		HttpResponse response = sendRequest(httpclient, httpost);  
		String body = paseResponse(response);  

		return body;  
	}  

	private static String paseResponse(HttpResponse response) {  
		HttpEntity entity = response.getEntity();  

		String charset = EntityUtils.getContentCharSet(entity);    

		String body = null;  
		try {  
			body = EntityUtils.toString(entity);  
		} catch (ParseException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  

		return body;  
	}  

	private static HttpResponse sendRequest(DefaultHttpClient httpclient,  
			HttpUriRequest httpost) {  
		HttpResponse response = null;  
		httpost.setHeader("Content-Type", "application/json");
		try {  
			response = httpclient.execute(httpost);  
		} catch (ClientProtocolException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		return response;  
	}  

	private static HttpPost postForm(String url, Map<String, String> params){           
		HttpPost httpost = new HttpPost(url);  
		List<NameValuePair> nvps = new ArrayList <NameValuePair>();            
		Set<String> keySet = params.keySet();  
		for(String key : keySet) {  
			nvps.add(new BasicNameValuePair(key, params.get(key)));  
		}            
		try {  
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));  
		} catch (UnsupportedEncodingException e) {  
			e.printStackTrace();  
		}  

		return httpost;  
	}  
}  