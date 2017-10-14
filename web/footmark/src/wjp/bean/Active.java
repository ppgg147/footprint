package wjp.bean;

import java.io.Serializable;
import java.util.Date;

public class Active implements Serializable {
	private static final long serialVersionUID = 8066111342007791758L;
	private Integer id=0;//iD����
	private String name;//�����
	private String province;//ʡ��
	private String collectionSite;//���ϵص�
	private String activitySite;//��ص�
	private Date beginTime;//��ʼʱ��
	private Date endTime;//����ʱ��
	private int personMaxNum;//�������
	private double activityLongitude;//��ص㾭��
	private double activityLatitude;//��ص㾭��
	private String description;//����
	private String imagePaths;//ͼƬ·������ �� ; �� �ָ���
	private Date createTime;//����ʱ��
	private User user;//������
	private Group group;//��ӦȺ��
	public Active() {
		// TODO Auto-generated constructor stub
	}
	
	public Active(String name, String province, String collectionSite,
			String activitySite, Date beginTime, Date endTime,
			int personMaxNum, double activityLongitude,
			double activityLatitude, String description, String imagePaths,
			Date createTime, User user) {
		super();
		this.name = name;
		this.province = province;
		this.collectionSite = collectionSite;
		this.activitySite = activitySite;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.personMaxNum = personMaxNum;
		this.activityLongitude = activityLongitude;
		this.activityLatitude = activityLatitude;
		this.description = description;
		this.imagePaths = imagePaths;
		this.createTime = createTime;
		this.user = user;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Active [id=" + id + ", name=" + name + ", province=" + province
				+ ", collectionSite=" + collectionSite + ", activitySite="
				+ activitySite + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", personMaxNum=" + personMaxNum
				+ ", activityLongitude=" + activityLongitude
				+ ", activityLatitude=" + activityLatitude + ", description="
				+ description + ", imagePaths=" + imagePaths + ", createTime="
				+ createTime + "]";
	}

	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getProvince() {
		return province;
	}
	public String getCollectionSite() {
		return collectionSite;
	}
	public String getActivitySite() {
		return activitySite;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public int getPersonMaxNum() {
		return personMaxNum;
	}
	public double getActivityLongitude() {
		return activityLongitude;
	}
	public double getActivityLatitude() {
		return activityLatitude;
	}
	public String getDescription() {
		return description;
	}
	public String getImagePaths() {
		return imagePaths;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public User getUser() {
		return user;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setCollectionSite(String collectionSite) {
		this.collectionSite = collectionSite;
	}
	public void setActivitySite(String activitySite) {
		this.activitySite = activitySite;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setPersonMaxNum(int personMaxNum) {
		this.personMaxNum = personMaxNum;
	}
	public void setActivityLongitude(double activityLongitude) {
		this.activityLongitude = activityLongitude;
	}
	public void setActivityLatitude(double activityLatitude) {
		this.activityLatitude = activityLatitude;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImagePaths(String imagePaths) {
		this.imagePaths = imagePaths;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
