package cn.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.User;



public interface Userdao {
	public List<User> finall();    //查询所有
	public User finByuserCode(String userCode);  //登入
	public User finByuserName(String userName);  //密码验证
	
	public int add(User user); //添加
	
	//分页对应的总记录数
	public int getCountByConditions(
			@Param("userName")
			String userName, 
			@Param("roleId")
			Integer roleId);
	//分页对应的集合
	public List<User> findByPageConditions(
			@Param("from")
			int from,
			@Param("pageSize")
			int pageSize,
			@Param("userName")
			String userName, 
			@Param("roleId")
			Integer roleId);
	
	public int delete(int id);//删除
	public int updade(User user);//修改
	public User getUser(Integer  uid);//按id查询用户
	
}
