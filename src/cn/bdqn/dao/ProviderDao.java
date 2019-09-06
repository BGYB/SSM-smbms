package cn.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.Provider;


public interface ProviderDao {
	
	public List<Provider> getall();
	
	
	//查询全部
	public List<Provider> finall(
			@Param("proCode")String proCode ,
			@Param("proName")String proName,
			@Param("from") int from,
			@Param("pageSize") int pageSize
			);
	
	//计算总数
	public int getCount(
			@Param("proCode")String proCode ,
			@Param("proName")String proName
			);  //查询人数

	
	
	//添加
	public int add(Provider provider);
	
	//修改
	public int update(Provider provider);
	
	//删除
	public int delete(int id);
	
	//按id查询
	public Provider getid(int id);
}
