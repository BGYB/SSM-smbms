package cn.bdqn.service;

import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.Provider;
import cn.bdqn.util.PageBean;

public interface ProviderService {
	//查询全部
		public PageBean<Provider> finall(String proCode ,String proName,int pageNo,int pageSize);
		
		
		
		
		//添加
		public boolean add(Provider provider);
		
		
		//修改
		public int update(Provider provider);
		
		//删除
		public int delete(int id);
		
		//按id查询
		public Provider getid(int id);
		
		//查询
		public List<Provider> getall();

}
