package cn.bdqn.entity;

import java.util.Date;

public class Provider {
	
	    private Integer id;//主键ID
	    private String proCode;//供应商编码
	    private String proName;//供应商名称
	    private String proDesc;//供应商详细描述
	    private String proContact;//供应商联系人
	    private String proPhone;//联系电话
	    private String proAddress;//地址
	    private String  proFax;//传真
	  	private Integer createdBy;//'创建者
		private Date creationDate;//创建时间
		private Date modifyDate;//修改时间
		private Integer modifyBy;//更新者（userId）
		private String picPath;//图片
		public Integer getId() {
			return id;
		}
		public String getPicPath() {
			return picPath;
		}
		public void setPicPath(String picPath) {
			this.picPath = picPath;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getProCode() {
			return proCode;
		}
		public void setProCode(String proCode) {
			this.proCode = proCode;
		}
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public String getProDesc() {
			return proDesc;
		}
		public void setProDesc(String proDesc) {
			this.proDesc = proDesc;
		}
		public String getProContact() {
			return proContact;
		}
		public void setProContact(String proContact) {
			this.proContact = proContact;
		}
		public String getProPhone() {
			return proPhone;
		}
		public void setProPhone(String proPhone) {
			this.proPhone = proPhone;
		}
		public String getProAddress() {
			return proAddress;
		}
		public void setProAddress(String proAddress) {
			this.proAddress = proAddress;
		}
		public String getProFax() {
			return proFax;
		}
		public void setProFax(String proFax) {
			this.proFax = proFax;
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
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}
		public Integer getModifyBy() {
			return modifyBy;
		}
		public void setModifyBy(Integer modifyBy) {
			this.modifyBy = modifyBy;
		}
		public Provider(Integer id, String proCode, String proName,
				String proDesc, String proContact, String proPhone,
				String proAddress, String proFax, Integer createdBy,
				Date creationDate, Date modifyDate, Integer modifyBy) {
			super();
			this.id = id;
			this.proCode = proCode;
			this.proName = proName;
			this.proDesc = proDesc;
			this.proContact = proContact;
			this.proPhone = proPhone;
			this.proAddress = proAddress;
			this.proFax = proFax;
			this.createdBy = createdBy;
			this.creationDate = creationDate;
			this.modifyDate = modifyDate;
			this.modifyBy = modifyBy;
		}
		public Provider() {
			super();
		}
		public Provider(Integer id, String proCode, String proName,
				String proDesc, String proContact, String proPhone,
				String proAddress, String proFax, Integer createdBy,
				Date creationDate, Date modifyDate, Integer modifyBy,
				String picPath) {
			super();
			this.id = id;
			this.proCode = proCode;
			this.proName = proName;
			this.proDesc = proDesc;
			this.proContact = proContact;
			this.proPhone = proPhone;
			this.proAddress = proAddress;
			this.proFax = proFax;
			this.createdBy = createdBy;
			this.creationDate = creationDate;
			this.modifyDate = modifyDate;
			this.modifyBy = modifyBy;
			this.picPath = picPath;
		}
		
		
		
}
