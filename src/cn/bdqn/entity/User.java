package cn.bdqn.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private Integer id;					//主键ID
	private String userCode;			//用户编码
	private String userName;			//用户名称
	private String userPassword;		//用户密码
	private Integer gender;				//性别�?:女�? 2:男）
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;				//出生日期
	private String phone;				//手机
	private String address;				//地址
	private Integer userRole;			//用户角色（取自角色表-角色id�?
	private Integer createdBy;			//创建者（userId�?
	private Date creationDate;			//创建时间
	private Integer modifyBy;			//更新者（userId�?
	private Date modifyDate;			//更新时间
	private String idPicPath;			//证件照路�?
	private String workPicPath;			//工作照路�?
	
	private String userRoleName;   //用户角色
	private int age;  //年纪
	
//	public int getAge() {
//		Date now=new  Date();
//		return now.getYear()-this.birthday.getYear();
//	}


	public Integer getId() {
		return id;
	}

	public User(Integer id, String userCode, String userName, String userPassword,
		Integer gender, Date birthday, String phone, String address,
		Integer userRole, Integer createdBy, Date creationDate,
		Integer modifyBy, Date modifyDate, String idPicPath,
		String workPicPath, String userRoleName, int age) {
	super();
	this.id = id;
	this.userCode = userCode;
	this.userName = userName;
	this.userPassword = userPassword;
	this.gender = gender;
	this.birthday = birthday;
	this.phone = phone;
	this.address = address;
	this.userRole = userRole;
	this.createdBy = createdBy;
	this.creationDate = creationDate;
	this.modifyBy = modifyBy;
	this.modifyDate = modifyDate;
	this.idPicPath = idPicPath;
	this.workPicPath = workPicPath;
	this.userRoleName = userRoleName;
	this.age = age;
}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getIdPicPath() {
		return idPicPath;
	}
	public void setIdPicPath(String idPicPath) {
		this.idPicPath = idPicPath;
	}
	public String getWorkPicPath() {
		return workPicPath;
	}
	public void setWorkPicPath(String workPicPath) {
		this.workPicPath = workPicPath;
	}


	public User(Integer id, String userCode, String userName,
			String userPassword, Integer gender, Date birthday, String phone,
			String address, Integer userRole, Integer createdBy,
			Date creationDate, Integer modifyBy, Date modifyDate,
			String idPicPath, String workPicPath) {
		super();
		this.id = id;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.idPicPath = idPicPath;
		this.workPicPath = workPicPath;
	}


	public User() {
		super();
	}

	public User(String userCode, String userName, String userPassword,
			Integer gender, Date birthday, String phone, String address,
			Integer userRole) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
	}

	public User(String userCode, String userName, String userPassword,
			Integer gender, String phone, String address, Integer userRole) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
	}
	
	
}
