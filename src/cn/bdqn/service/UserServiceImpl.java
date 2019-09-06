package cn.bdqn.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.Userdao;
import cn.bdqn.entity.User;
import cn.bdqn.util.PageBean;




@Service("userService")  //Service专门注解
public class UserServiceImpl implements UserService{

	@Autowired  //引用dao层
	private Userdao userdao;
	
	
	public List<User> finall() {
		// TODO Auto-generated method stub
		return userdao.finall();
	}


	


	//登入验证，先通过登入名查询出用户所有信息，根据前台提供的密码，进行密码比对
	public User finByuserCodePwass(String userCode, String userPassword) {
		User user=userdao.finByuserCode(userCode);
		if(user!=null && user.getUserPassword().equals(userPassword)){
			return user;
		}else{
			return null;
		}
		
	}





	//分页
	public PageBean<User> finBypage(int pageNo, int pageSize, String userName,
			Integer roleId) {
		PageBean<User> pageBean=new PageBean();
		pageBean.setPageSize(pageSize);
		int totalCount=userdao.getCountByConditions(userName,roleId);   //根据条件，计算数据总条数
		pageBean.setTotalCount(totalCount);
		pageBean.setPageNo(pageNo);
		int from=(pageBean.getPageNo()-1)*pageBean.getPageSize();
		List<User> pageList=userdao.findByPageConditions(from,pageBean.getPageSize(),userName,roleId);
		pageBean.setPageList(pageList);
		return pageBean;
	}





	@Override
	public boolean finByuserCode(String userCode) {
		User user=userdao.finByuserCode(userCode);
		if(user!=null){
			return true;
		}
		return false;
	}





	@Override
	public int add(User user) {
		return userdao.add(user);
	}





	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		int delete=userdao.delete(id);
		if(delete>0){
			return true;
		}
		return  false;
	}





	@Override
	public int updade(User user) {
		// TODO Auto-generated method stub
		return userdao.updade(user);
	}





	@Override
	public User getUser(Integer uid) {
		// TODO Auto-generated method stub
		return userdao.getUser(uid);
	}





	@Override
	public User finByuserPassword(String userName, String userPassword) {
		User user=userdao.finByuserName(userName);
		if(user!=null && user.getUserPassword().equals(userPassword)){
			return user;
		}else{
			return null;
		}
	}







}
