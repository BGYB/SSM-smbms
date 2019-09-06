package cn.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.dao.Roledao;
import cn.bdqn.dao.Userdao;
import cn.bdqn.entity.Role;

@Service("uroleService")  //Service专门注解
public class RoleServiceImpl implements RoleService{
	
	@Autowired  //引用dao层
	private Roledao roledao;
	@Override
	public List<Role> finAll() {
		// TODO Auto-generated method stub
		return roledao.finAll();
	}

}
