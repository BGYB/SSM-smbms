package cn.bdqn.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;


@Controller
public class IndexContorller {
	@Autowired
	private UserService userService;
	
	
	//显示登入页面
	@RequestMapping("/login.html")
	public String showLogin(){
		return "login";
	}
	
	
	//显示登入后页面
		@RequestMapping("/main.html")
		public String showMain(){
			return "frame";
		}
		
		
		
		//登入<-------通过Model进行传参
				@RequestMapping("/login.do")
				public String show(
						@RequestParam
						String userCode,
						@RequestParam
						String userPassword,
						HttpSession session,
						Model model
						){
						//int a=5/0;
					User user=userService.finByuserCodePwass(userCode,userPassword);
					
					if(user!=null){
						session.setAttribute("userLogin", user);
						return "redirect:/main.html";  //重定向
					}else{
						String error="用户名或密码错误！";
						model.addAttribute("error", error);
						return "redirect:/login";
					}
					
				}	
		
		
		
		
		
		
		
		
		
		
	//文件上传
	@RequestMapping("/upload.html")	
	public String upload(){
		return "upload";
		
	}
	
	//多文件上传
	@RequestMapping("/doUpload")
	public String doupload(
			@RequestParam("userName")
			String userNmae,
			@RequestParam("pic")
			MultipartFile[] pic,  //声明数组
			HttpSession session,
			Model model
			){
		
		System.out.println(userNmae+"上传了文件！");
		String filePath=session.getServletContext().getRealPath("statics"+File.separator+"images"); //separator转意文字为“\”
		System.out.println(filePath);
		List<String> picList=new ArrayList<String>();
		
		for(MultipartFile pi:pic){  //遍历数组
			if(!pi.isEmpty()){  //不为空时
				
				String picName=pi.getOriginalFilename();  //拿取上传图片原有名
				
				//生成新的文件名字，有毫秒数+随机数+原有名
				String newPicName=System.currentTimeMillis()+""+Math.round((Math.random()*10000))+picName;
				File fileto=new File(filePath,newPicName);  //上传到tomcat服务器上，路径和名字
				try {
					pi.transferTo(fileto);  //调用上传方法
					System.out.println("上传成功！");  
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "error";
				 }
				picList.add(newPicName); //添加到集合
				
			}
		
				//File fileto=new File("F:\\upload",picName);  //路径和名字
		
		}
		
		model.addAttribute("userNmae", userNmae);
		model.addAttribute("picList", picList);
		
		return "doupload";
		
	}
		
	
}
