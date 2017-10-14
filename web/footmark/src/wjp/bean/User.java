package wjp.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * �û���
 * @author WJP
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 4585215918033435694L;
	private Integer id=0;// /����Id
	private String mobilePhone;// �ֻ��ţ���¼Id��(Ψһ)
	private int flag=0;//�Ƿ��ǹ���Ա
	private String uuid;// ����Id
	private String password;// ��¼����
	private String headPicture;// ͷ�񣨴洢·����
	private String nickName;// �ǳ�
	private String realName;// ��ʵ����
	private String sex;// �Ա�
	private String birthday;// ����
	private String address;// ��ַ
	private String email;// ����
	private Date lastLoginTime;// �ϴε�¼ʱ��
	private Date registerTime;// ע��ʱ��
	private String token;// Token
	private String individualSignature;// ����ǩ��
	private Integer currentlyActiveId=0;// ��ǰ�Id
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String phone,String pass) {
		this.mobilePhone=phone;
		this.password=pass;
	}
	public Integer getId() {
		return id;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public int getFlag() {
		return flag;
	}
	public String getUuid() {
		return uuid;
	}
	public String getPassword() {
		return password;
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public String getNickName() {
		return nickName;
	}
	public String getRealName() {
		return realName;
	}
	public String getSex() {
		return sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public String getToken() {
		return token;
	}
	public String getIndividualSignature() {
		return individualSignature;
	}
	public Integer getCurrentlyActiveId() {
		return currentlyActiveId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setIndividualSignature(String individualSignature) {
		this.individualSignature = individualSignature;
	}
	public void setCurrentlyActiveId(Integer currentlyActiveId) {
		this.currentlyActiveId = currentlyActiveId;
	}	
}
