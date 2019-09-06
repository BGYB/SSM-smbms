package cn.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.ProviderDao;
import cn.bdqn.entity.Provider;
import cn.bdqn.util.PageBean;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	private ProviderDao prdao;
	
	@Override
	public PageBean<Provider> finall(String proCode, String proName, int pageNo,
			int pageSize) {
		PageBean<Provider> pageBean=new PageBean();
		pageBean.setPageSize(pageSize);
		int totalCount=prdao.getCount(proCode, proName);
		pageBean.setTotalCount(totalCount);
		pageBean.setPageNo(pageNo);
		int from=(pageBean.getPageNo()-1)*pageBean.getPageSize();
		List<Provider> pageList=prdao.finall(proCode, proName, from, pageSize);
		pageBean.setPageList(pageList);
		return pageBean;
	}

	

	//添加
	public boolean add(Provider provider) {
		int add=prdao.add(provider);
		if(add>0){
			return true;
		}
		return false;
	}



	@Override
	public int update(Provider provider) {
		// TODO Auto-generated method stub
		return prdao.update(provider);
	}



	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return prdao.delete(id);
	}



	@Override
	public Provider getid(int id) {
		// TODO Auto-generated method stub
		return prdao.getid(id);
	}



	@Override
	public List<Provider> getall() {
		// TODO Auto-generated method stub
		return prdao.getall();
	}

}
