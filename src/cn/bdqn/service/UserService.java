package cn.bdqn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.User;
import cn.bdqn.util.PageBean;

public interface UserService {
	
public List<User> finall();    //查询所有

public User finByuserCodePwass(String userCode, String userPassword);//登入
public User finByuserPassword(String userName,String userPassword);//密码验证
	
public PageBean<User> finBypage(int pageNo,int pageSize,String userName,Integer roleId);

public boolean finByuserCode(String userCode);  //Ajax验证用户名重复

public int add(User user); //添加

public boolean delete(int id);//删除
public int updade(User user);//修改
public User getUser(Integer  uid);//按id查询用户

}
