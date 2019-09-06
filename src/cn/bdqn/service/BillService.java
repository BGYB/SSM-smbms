package cn.bdqn.service;

import cn.bdqn.entity.Bill;
import cn.bdqn.entity.User;
import cn.bdqn.util.PageBean;

public interface BillService {
	public PageBean<Bill> finBypage(int pageNo,int pageSize,String productName,Integer providerId,Integer isPayment);
	
			//添加
			public int add(Bill bill);
			
			//修改
			public int update(Bill bill);
			
			//删除
			public int delete(int id);
			
			//按id查询
			public Bill getid(int id);

}
