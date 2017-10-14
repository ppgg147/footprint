package wjp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import wjp.bean.Active;
import wjp.bean.Group;
import wjp.bean.User;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

public class IMDao {
	private static String host = "https://a1.easemob.com/1102170319178516/cpufootprint/";
	private static String client_id = "YXA6fjIcwAylEeeot3vtcMVc6g";
	private static String client_secret = "YXA6Q6FpN-CK0upZYa3P6SwYrnoTnIA";
	private static Map<String, Object> params = new HashMap<String, Object>();
	public final static IMDao iMDao = new IMDao();

	/**
	 * 获取Token
	 * 
	 * @return
	 */
	private String getToken() {
		params = new HashMap<String, Object>();
		params.put("grant_type", "client_credentials");
		params.put("client_id", client_id);
		params.put("client_secret", client_secret);
		String js;
		Gson gosn = new Gson();
		js = gosn.toJson(params);
		String json = HttpXmlClient.Post(host + "token", js, "");
		String token = null;
		try {
			JSONObject obj = new JSONObject(json);
			token = obj.getString("access_token");
			int expires_in = obj.getInt("expires_in");
			CookieUtil.cookieUtil.addCookie("access_token", token,
					expires_in - 10);
		} catch (Exception e) {
			System.err.println("--未获取到token");
		}
		return token;
	}

	/**
	 * 注册环信
	 * 
	 * @param user
	 * @return
	 */
	public String regist(String mobilePhone,String password) {
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String js = "";
		Gson gosn = new Gson();
		String json = "";
		if (token != null&&!token.equals("")) {
			System.out.println("token: " + token);
			if (!mobilePhone.isEmpty()
					&& !password.isEmpty()) {
				String url = host + "users";
				params = new HashMap<String, Object>();
				params.put("username",mobilePhone);
				params.put("password",password);
				gosn = new Gson();
				js = gosn.toJson(params);
				json = HttpXmlClient.Post(url, js, "Bearer " + token);
				String uuid = null;
				try {
					JSONObject obj = new JSONObject(json);
					JSONArray entitiesObj = obj.getJSONArray("entities");
					if (entitiesObj.length() > 0) {
						JSONObject userObj = entitiesObj.getJSONObject(0);
						uuid = userObj.getString("uuid");
						return uuid;
					} else {
						return "";
					}
				} catch (Exception e) {
					e.printStackTrace();
					return "";
				}
			}
		}
		return "";
	}

	/**
	 * 创建环信群组
	 * 
	 * @param active
	 * @param mobliePhone
	 * @return
	 */
	public Group createGroup(Active active, String mobilePhone) {
		Group group = new Group();
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String js = "";
		Gson gosn = new Gson();
		String json = "";
		if (token != null) {
			String url = host + "chatgroups";
			params = new HashMap<String, Object>();
			params.put("groupname", active.getName());
			params.put("desc", "欢迎大家加入本群，请大家文明交谈。");
			params.put("public", false);
			params.put("approval", true);
			params.put("owner", mobilePhone);
			group.setName(active.getName());
			group.setDescription("欢迎大家加入本群，请大家文明交谈。");
			group.setIspublic(false);
			group.setOwner(mobilePhone);
			gosn = new Gson();
			js = gosn.toJson(params);
			json = HttpXmlClient.Post(url, js, "Bearer " + token);
			try {
				JSONObject obj = new JSONObject(json);
				JSONObject dataObj = obj.getJSONObject("data");
				group.setId(dataObj.getString("groupid"));
				return group;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * 获取环信群组
	 * 
	 * @param active
	 * @param mobliePhone
	 * @return
	 */
	public List<Group> listGroup(String mobilePhone) {
		List<Group> group = new ArrayList<Group>();
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String json = "";
		if (token != null) {
			String url = host + "users/" + mobilePhone + "/joined_chatgroups";
			json = HttpXmlClient.get(url, "Bearer " + token);
			Group model = new Group();
			try {
				JSONObject obj = new JSONObject(json);
				JSONArray dataArray = obj.getJSONArray("data");
				JSONObject dataObj = new JSONObject();
				for (int i = 0; i < dataArray.length(); i++) {
					dataObj = dataArray.getJSONObject(i);
					model.setId(dataObj.getString("groupid"));
					model.setName(dataObj.getString("groupname"));
					model.setHeadpicture("Images/Api/Heads/"
							+ dataObj.getString("groupid") + "_gh.png");
					group.add(model);
					model = new Group();
				}
				return group;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * 更新IM群组信息
	 * 
	 * @param id
	 * @param name
	 * @param description
	 */
	public String updateGroup(String id, String name, String description) {
		String result = null;
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String js = "";
		Gson gosn = new Gson();
		String json = "";
		if (token != null) {
			String url = host + "chatgroups/" + id;
			params = new HashMap<String, Object>();
			params.put("groupname", name);
			params.put("description", description);
			gosn = new Gson();
			js = gosn.toJson(params);
			json = HttpXmlClient.Post(url, js, "Bearer " + token);
			try {
				JSONObject obj = new JSONObject(json);
				result = obj.getString("uri");
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	/**
	 * 添加群组成员
	 * 
	 * @param id
	 * @param mobilePhone
	 * @return
	 */
	public String addUser(String id, String mobilePhone) {
		String result = null;
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String js = "";
		String json = "";
		if (token != null) {
			String url = host + "chatgroups/" + id + "/users/" + mobilePhone;
			;
			json = HttpXmlClient.Post(url, js, "Bearer " + token);
			try {
				JSONObject obj = new JSONObject(json);
				JSONObject dobj = obj.getJSONObject("data");
				result = dobj.getString("groupid");
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public Group groupDetail(String id) {
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String json = "";
		if (token != null) {
			String url = host + "chatgroups/" + id;
			json = HttpXmlClient.get(url, "Bearer " + token);
			Group model = new Group();
			try {
				JSONObject obj = new JSONObject(json);
				JSONArray dataArray = obj.getJSONArray("data");
				JSONObject dataObj = new JSONObject();
				if (dataArray.length() > 0) {
					dataObj = dataArray.getJSONObject(0);
					model.setId(dataObj.getString("id"));
					model.setName(dataObj.getString("name"));
					model.setDescription(dataObj.getString("description"));
					model.setIspublic(dataObj.getBoolean("public"));
					model.setMembersonly(dataObj.getBoolean("membersonly"));
					model.setAllowinvites(dataObj.getBoolean("allowinvites"));
					model.setMaxusers(dataObj.getInt("maxusers"));
					model.setAffiliations_count(dataObj
							.getInt("affiliations_count"));
					model.setHeadpicture("Images/Api/Heads/"
							+ dataObj.getString("id") + "_gh.png");
					return model;
				} else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public List<String> listMember(String id) {
		List<String> list = new ArrayList<String>();
		String cookieToken = CookieUtil.cookieUtil.getCookie("access_token");
		String token = cookieToken.equals("") ? getToken() : cookieToken;
		String json = "";
		if (token != null) {
			String url = host + "chatgroups/" + id
					+ "/users?pagenum=1&pagesize=200";
			json = HttpXmlClient.get(url, "Bearer " + token);
			try {
				JSONObject obj = new JSONObject(json);
				JSONArray dataArray = obj.getJSONArray("data");
				JSONObject dataObj = new JSONObject();
				String member = "";
				for (int i = 0; i < dataArray.length(); i++) {
					dataObj = dataArray.getJSONObject(i);
					try {
						member = dataObj.getString("member");
					} catch (Exception e) {
						member = dataObj.getString("owner");
					}
					list.add(member);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

}
