package cn.bdqn.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.bdqn.entity.Provider;
import cn.bdqn.entity.User;
import cn.bdqn.service.ProviderService;
import cn.bdqn.util.PageBean;

@Controller
@RequestMapping("/provider")
public class ProviderContorller {
	
	@Autowired
	ProviderService prservice;
	
	@RequestMapping("/showAll.do")
	public String showAll(
			@RequestParam(value="pageNo",required=false,defaultValue="1")  //required值为false，表示可有可无，默认值是1
			Integer pageNo,
			@RequestParam(value="queryProCode",required=false)
			String  proCode,
			@RequestParam(value="queryProName",required=false)
			String proName,
			Model model
			
			){
			System.out.println(proCode);
			PageBean pageBean=new PageBean();
			int pageSize=4;
			PageBean<Provider> PageBean=prservice.finall(proCode, proName, pageNo, pageSize);
			model.addAttribute("queryProCode", proCode);  //供应商编码，存储转发到前台，防止数据丢失
			model.addAttribute("queryProName", proName);  //供应商名称，存储转发到前台，防止数据丢失
			model.addAttribute("PageBean", PageBean);
			return "providerlist";
		
	}
	
	
	//根据id查询，详情
	@RequestMapping("/ShowProvider.do")
	public String ShowProvider(
			@RequestParam
			Integer proid,
			Model model){
		Provider provider=prservice.getid(proid);
		model.addAttribute("provider", provider);
		
		return "providermodify";
		
	}
	
	
	
	//修改
	@RequestMapping("/modifyProvider.do")
	public String modifyProvider(Provider provider,HttpSession session,
			@RequestParam
			Integer proid
			){
		User userLogin=(User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
		if(userLogin==null){
			return "redirect:/login.html";  //重定向
		}
		provider.setId(proid);
		provider.setCreatedBy(userLogin.getId()); //创建人id
		provider.setCreationDate(new Date());  //创建时间
		provider.setModifyDate(new Date());
		provider.setModifyBy(userLogin.getId());
		
		int update=prservice.update(provider);
		
		if(update>0){
			return "succsee2";
		}
		
		return "error";
		
	}
	
	
	
	//添加页面
	@RequestMapping("/provider.html")
	public String show(){
		return "provideradd";
	}
	
	//添加
	@RequestMapping("/AddProvider.html")
	public String addprovider(Provider provider,@RequestParam("pic")MultipartFile pic,HttpSession session){
		User userLogin=(User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
		if(userLogin==null){
			return "redirect:/login.html";  //重定向
		}
		
		provider.setCreatedBy(userLogin.getId()); //创建人id
		provider.setCreationDate(new Date());  //创建时间
		provider.setModifyDate(new Date());  //修改时间
		provider.setModifyBy(userLogin.getId());  //修改人id
		
		String filePath=session.getServletContext().getRealPath("statics"+File.separator+"images"); //separator转意文字为“\”
		if(!pic.isEmpty()){  //不为空时
			
			String picName=pic.getOriginalFilename();  //拿取上传图片原有名
			
			//生成新的文件名字，有毫秒数+随机数+原有名
			String newPicName=System.currentTimeMillis()+""+Math.round((Math.random()*10000))+picName;
			File fileto=new File(filePath,picName);  //上传到tomcat服务器上，路径和名字
			System.out.println(newPicName);
			try {
				pic.transferTo(fileto);  //调用上传方法
				System.out.println("上传成功！");  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error";
			 }
			provider.setPicPath(picName); //图片名字
		}
		
		boolean add=prservice.add(provider);
		
		if(add){
			return "succsee2";
		}
		
		return "error";
		
		
	}
	
	
	//删除
	@ResponseBody
	@RequestMapping("/delete.html")
	public Object delete(
			@RequestParam
			Integer proid     //拿取id
			){
		
		int delete=prservice.delete(proid);
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(delete>0){
			map.put("delResult", "true");
		}else{
			map.put("delResult", "false");
		}
				
//		String jsonStr=null;
//		jsonStr=JSON.toJSONString(map);
//		System.out.println(jsonStr);
//		return jsonStr;
		return map;
		
	}
	
	
	//Ajax
	@ResponseBody
	@RequestMapping("/ShowByprovider.html")
	public Object ShowByprovider(
			@RequestParam
			Integer proid,
			Model model){
		Provider provider=prservice.getid(proid);
		
		return provider;
		
	}
	
}
