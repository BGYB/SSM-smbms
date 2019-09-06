package cn.bdqn.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.bdqn.entity.Role;
import cn.bdqn.entity.User;
import cn.bdqn.service.RoleService;
import cn.bdqn.service.UserService;
import cn.bdqn.util.PageBean;

@Controller
@RequestMapping("/user")  //拦截根目录下的user，进入方法体
public class UserContorller {
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
		
		
		
		        //分页显示
				@RequestMapping("showBypage.do")
				public String showBypage(
						@RequestParam(value="pageNo",required=false,defaultValue="1")  //required值为false，表示可有可无，默认值是1
						Integer pageNo,
						@RequestParam(value="queryname",required=false)
						String  userName,
						@RequestParam(value="queryUserRole",required=false)
						Integer roleId,
						Model model
						){
						
						if(userName!=null){
							try {
								userName=new String(userName.getBytes("IOS-8859-1"),"UTF-8");
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							model.addAttribute("queryname", userName);  //把数据存储给前台，前台在提交回来
						}
						
						if(roleId!=null){
							model.addAttribute("queryUserRole", roleId);//把数据存储给前台，前台在提交回来
						}
					
					PageBean pageBean=new PageBean();
					int pageSize=4;
					PageBean<User> PageBean=userService.finBypage(pageNo, pageSize, userName, roleId);
					List<Role> roleList=roleService.finAll();
					model.addAttribute("PageBean", PageBean);
					model.addAttribute("roleList", roleList);  //用户角色集合
					return "userlist";
				}
		
		
		
		//跳转用户添加用户页面
		@RequestMapping(value="/useradd.html")
		public String useradd(){
			return "useradd";   //跳转到useradd.jsp页面
		}
		
		
		
		//查询用户角色表,Ajax请求数据
		@ResponseBody  //此注释:作用是表明最后return出去的不是某个页面，是return出去的是数据
		@RequestMapping(value="/getRoleList.do")
		//@RequestMapping(value="/getRoleList.do",produces={"application/json;charset=UTF-8"})  //改变乱码问题
		public Object getRoleList(){
//			
//			String jsonStr=null;
//			List<Role> roleList=roleService.finAll();
//			jsonStr=JSON.toJSONStringWithDateFormat(roleList, "yyyy-MM-dd");  //集合转换JSON格式，更改时间格式
//			System.out.println(jsonStr);
//			return jsonStr;
			

			List<Role> roleList=roleService.finAll();
			return roleList;
		}
		
		
		//Spring-MVC配置fastjson的消息转换器，直接返回值，后台自动解析JSON数据<------用户名重复验证，Ajax请求数据
				@ResponseBody
				@RequestMapping(value="/checkUserCode.do")
				public Object checkUserCode(
						@RequestParam
						String userCode
						){
					
					boolean isExist=userService.finByuserCode(userCode);  
					Map<String, Object> map=new HashMap<String, Object>();
					if(isExist){
						map.put("userCode", "exist");
					}else{
						map.put("userCode", "noexist");
					}
					return map;
					
				}
		
				
//				//原有Ajax，返回JSON数据<-------用户名重复验证，Ajax请求数据
//				@ResponseBody
//				@RequestMapping(value="/checkUserCode.do")
//				//@RequestMapping(value="/checkUserCode.do",produces={"application/json;charset=UTF-8"})
//				public String checkUserCode(
//						@RequestParam
//						String userCode
//						){
//					
//					boolean isExist=userService.finByuserCode(userCode);  
//					Map<String, Object> map=new HashMap<String, Object>();
//					if(isExist){
//						map.put("userCode", "exist");
//					}else{
//						map.put("userCode", "noexist");
//					}
//					String jsonStr=null;
//					jsonStr=JSON.toJSONString(map);
//					System.out.println(jsonStr);
//					return jsonStr;
//					
//					
//				}
		
				
		
		//获取数据添加
		@RequestMapping(value="/useradd.do")
		public String addUser(User user,HttpSession session,Model model){
			User userLogin=(User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
			if(userLogin==null){
				return "redirect:/login.html";  //重定向
			}
			
			user.setCreatedBy(userLogin.getId());  //创建者
			user.setCreationDate(new Date());   //创建时间
			int ret = userService.add(user);
			if(ret>0){
				return "success";  //跳转成功页面
			}else{
				return "error";   //跳转error页面
			}
			
		}
		
		
		
	//根据id查询用户
	@RequestMapping("userModifyByid.do")	
	public String userModifyByid(
			@RequestParam
			Integer uid,
			Model model
			
			){
			User user=userService.getUser(uid);
			model.addAttribute("user", user);
			return "usermodify";
		
	}
		
		
		
	//修改
	@RequestMapping("userModify.do")
	public String userModify(User user,HttpSession session,
			@RequestParam
			Integer uid,
			Model model){
		User userLogin=(User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
		if(userLogin==null){
			return "redirect:/login.html";
		}
		
		user.setId(uid);
		user.setCreatedBy(userLogin.getId());  //创建者
		user.setCreationDate(new Date());   //创建时间
		System.out.println(user.getBirthday());
		int ret = userService.updade(user);
		if(ret>0){
			return "success";  //跳转成功页面
		}else{
			return "error";   //跳转error页面
		}
		
	}
		
		
		
	//删除，Ajax请求数据
	@ResponseBody
	@RequestMapping(value="/delete.do")
	public Object delete(
			@RequestParam
			Integer uid     //拿取id
			){
		
		boolean isExist=userService.delete(uid); //根据id删除
		Map<String, Object> map=new HashMap<String, Object>();
		if(isExist){
			map.put("delResult", "true");
		}else{
			map.put("delResult", "false");
		}
		return map;
	}	
		
	
	
	//Ajax根据id查询用户
		@ResponseBody
		@RequestMapping("/getuserById.do")	
		public Object getuserById(
				@RequestParam
				Integer uid,
				Model model
				
				){
				User user=userService.getUser(uid);
				System.out.println(user.getAge());
				return user;
			
		}
	
	
	
	//跳转密码修改页面
	@RequestMapping("/pwdmodify.html")	
	public String pwdmodify(){
		
		return "pwdmodify";
		
	}
	
	
	//密码验证
	@ResponseBody
	@RequestMapping(value="/modifypwd.html")
	public Object modifypwd(
			@RequestParam("oldpassword")
			String userPassword,
			HttpSession session
			){
			
			User userLogin= (User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
			String userName=userLogin.getUserName();
			User user=userService.finByuserPassword(userName, userPassword);
			
			Map<String, Object> map=new HashMap<String, Object>();
			if(user!=null){
				map.put("result", "true");
			}else{
				map.put("result", "false");
			}
			return map;
	}
	
	
	//修改密码
	@RequestMapping(value="/UpdatePwass.html")
	public String userpwass(
			@RequestParam("rnewpassword")
			String userPassword,
			User user,
			HttpSession session
			
			){
		User userLogin= (User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
		int uid=userLogin.getId();
		user.setId(uid);
		int update=userService.updade(user);
		
		if(update>0){
			System.out.println("修改成功");
			return "redirect:/main.html";
			
		}
			System.out.println("修改失败");
				return "redirect:/user/UpdatePwass.html";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
//	//原有Ajax，返回JSON数据，删除，Ajax请求数据,
//		@ResponseBody
//		@RequestMapping(value="/delete.do",produces={"application/json;charset=UTF-8"})
//		public String delete2(
//				@RequestParam
//				Integer uid     //拿取id
//				){
//			
//			boolean isExist=userService.delete(uid); //根据id删除
//			Map<String, Object> map=new HashMap<String, Object>();
//			if(isExist){
//				map.put("delResult", "true");
//			}else{
//				map.put("delResult", "false");
//			}
//			String jsonStr=null;
//			jsonStr=JSON.toJSONString(map);
//			System.out.println(jsonStr);
//			return jsonStr;
//		}		
		
		
		
		
		
		
		
		
		
		
		
		//显示所有
		@RequestMapping("showAll.do")
		public String showAll(Model model){
			List<User> userList=userService.finall();
			List<Role> roleList=roleService.finAll();
			model.addAttribute("userList", userList);
			model.addAttribute("roleList", roleList);
			return "userlist";
		}
		
		
	
		
		//注销
		@RequestMapping("/logout.do")
		public String logout(HttpSession session){
			session.invalidate();  //使整个session失效
			return "redirect:/login.html";  //重定向
		}
	
}
