package cn.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.BillDao;
import cn.bdqn.entity.Bill;
import cn.bdqn.util.PageBean;

@Service("billService")
public class BillServiceImpl implements BillService{

	@Autowired
	BillDao billdao;
	
	@Override
	public PageBean<Bill> finBypage(int pageNo, int pageSize,
			String productName, Integer providerId, Integer isPayment) {
		PageBean<Bill> pageBean=new PageBean();
		pageBean.setPageSize(pageSize);
		int totalCount=billdao.getCount(productName, providerId, isPayment); //计算总记录数
		pageBean.setTotalCount(totalCount);
		pageBean.setPageNo(pageNo);
		int from=(pageBean.getPageNo()-1)*pageBean.getPageSize();
		List<Bill> pageList=billdao.getall(productName, providerId, isPayment, from,pageBean.getPageSize());
		pageBean.setPageList(pageList);
		return pageBean;
	}
	
	
	
	
	

	@Override
	public int add(Bill bill) {
		// TODO Auto-generated method stub
		return billdao.add(bill);
	}

	@Override
	public int update(Bill bill) {
		// TODO Auto-generated method stub
		return billdao.update(bill);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return billdao.delete(id);
	}

	@Override
	public Bill getid(int id) {
		// TODO Auto-generated method stub
		return billdao.getid(id);
	}

}
