package cn.bdqn.entity;

import java.util.Date;

public class Bill {
	
		private Integer id;  //主键ID
		private String billCode; //账单编码
		private String productName; // '商品名称
	  	private String productDesc; //'商品描述
	  	private String productUnit; //'商品单位
	  	private  Float productCount; //'商品数量
	  	private  Float  totalPrice; // '商品总额
	  	private  Integer isPayment;//是否支付（1：未支付 2：已支付）
	  	private  Integer createdBy;//'创建者（userId）
	  	private Date creationDate;//'创建时间
	 	private  Integer modifyBy;//'更新者（userId）
	  	private Date modifyDate;//'更新时间
	  	private  Integer providerId;//'供应商ID
	  	
	  	private String proName; //供应商
	  	
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getBillCode() {
			return billCode;
		}
		public void setBillCode(String billCode) {
			this.billCode = billCode;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductDesc() {
			return productDesc;
		}
		public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}
		public String getProductUnit() {
			return productUnit;
		}
		public void setProductUnit(String productUnit) {
			this.productUnit = productUnit;
		}
		public Float getProductCount() {
			return productCount;
		}
		public void setProductCount(Float productCount) {
			this.productCount = productCount;
		}
		public Float getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(Float totalPrice) {
			this.totalPrice = totalPrice;
		}
		public Integer getIsPayment() {
			return isPayment;
		}
		public void setIsPayment(Integer isPayment) {
			this.isPayment = isPayment;
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
		public Integer getProviderId() {
			return providerId;
		}
		public void setProviderId(Integer providerId) {
			this.providerId = providerId;
		}
		public Bill(Integer id, String billCode, String productName,
				String productDesc, String productUnit, Float productCount,
				Float totalPrice, Integer isPayment, Integer createdBy,
				Date creationDate, Integer modifyBy, Date modifyDate,
				Integer providerId) {
			super();
			this.id = id;
			this.billCode = billCode;
			this.productName = productName;
			this.productDesc = productDesc;
			this.productUnit = productUnit;
			this.productCount = productCount;
			this.totalPrice = totalPrice;
			this.isPayment = isPayment;
			this.createdBy = createdBy;
			this.creationDate = creationDate;
			this.modifyBy = modifyBy;
			this.modifyDate = modifyDate;
			this.providerId = providerId;
		}
		public Bill() {
			super();
		}
	  	
	  	
		
}
