package cn.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.Bill;


public interface BillDao {

	public List<Bill> getall(
			@Param("productName") String productName,
			@Param("providerId") Integer providerId,
			@Param("isPayment") Integer isPayment,
			@Param("from") int from,
			@Param("pageSize") int pageSize
			);
	
	
	
	//计算总数
		public int getCount(
				@Param("productName") String productName,
				@Param("providerId") Integer providerId,
				@Param("isPayment") Integer isPayment
				);  //查询人数
	
	//添加
		public int add(Bill bill);
		
		//修改
		public int update(Bill bill);
		
		//删除
		public int delete(int id);
		
		//按id查询
		public Bill getid(int id);

}
