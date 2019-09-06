package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Role;



public interface Roledao {
	public int add(Roledao roleDao); //添加
	
	public List<Role> finAll();  //查询全部
	
	

}
