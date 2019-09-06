package cn.bdqn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bdqn.entity.Bill;
import cn.bdqn.entity.Provider;
import cn.bdqn.entity.User;
import cn.bdqn.service.BillService;
import cn.bdqn.service.ProviderService;
import cn.bdqn.util.PageBean;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService billService;
	@Autowired
	ProviderService providerService;
	
	//分页及，查看订单页面，
	@RequestMapping("/showBill.html")
	public String showBill(
		@RequestParam(value="pageNo",required=false,defaultValue="1")  //required值为false，表示可有可无，默认值是1
		Integer pageNo,
		@RequestParam(value="queryProductName",required=false)
		String  productName,
		@RequestParam(value="queryProviderId",required=false)
		Integer providerId,
		@RequestParam(value="queryIsPayment",required=false)
		Integer isPayment,
		Model model
		
		){
		PageBean pageBean=new PageBean();
		int pageSize=4;
		PageBean<Bill> PageBean=billService.finBypage(pageNo, pageSize, productName, providerId, isPayment);
		List<Provider> providerList=providerService.getall();
		model.addAttribute("queryProductName", productName);  //商品名称，存储转发到前台，防止数据丢失
		model.addAttribute("queryProviderId", providerId);  //供应商名称，存储转发到前台，防止数据丢失
		model.addAttribute("queryIsPayment", isPayment);  //是否付款，存储转发到前台，防止数据丢失
		model.addAttribute("PageBean", PageBean);
		model.addAttribute("providerList", providerList);
		return "billlist";
		
	}
	
	
	//修改查看用户
	@RequestMapping("/view/{id}")
	public String View(
			@PathVariable("id")
			Integer id,
			Model model
			
			){
		Bill bill=billService.getid(id);
		model.addAttribute("bill", bill);
		
		return "billmodify";
		
	}
	
	//Ajax查询供应商,最后返回集合，后台billmodify.js<----解析为JSON数据，进行字符串拼接
	@ResponseBody
	@RequestMapping("/ViewByProName.do")
	public Object ViewByProName(){
		List<Provider> providerList=providerService.getall();
		return providerList;
	}
	
	
	
	//修改
	@RequestMapping("/UpdateBill.html")
	public String UpdateBill(
			@RequestParam
			Integer id,
			Bill bill,
			HttpSession session
			
			){
		User userLogin=(User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
		if(userLogin==null){
			return "redirect:/login.html";  //重定向
		}
		bill.setId(id);
		bill.setModifyDate(new Date());
		bill.setModifyBy(userLogin.getId());
		
		int update=billService.update(bill);
		if(update>0){
			return "success3";  //跳转成功页面
		}else{
			return "error";   //跳转error页面
			
		}
		
	}
	
	
	
	
	//跳转添加页面
	@RequestMapping("/AddBill.html")
	public String AddBill(){
		return "billadd";
		
		
	}
	
	//添加
	@RequestMapping("/AddBybill.html")
	public String AddBybill(
			Bill bill,
			HttpSession session
			){
		
		User userLogin=(User) session.getAttribute("userLogin");  //拿取用户名，判断是否登入
		if(userLogin==null){
			return "redirect:/login.html";  //重定向
		}
		
		System.out.println("进入了添加页面");
		bill.setCreatedBy(userLogin.getId());
		bill.setCreationDate(new Date());
		
		int add=billService.add(bill);
		if(add>0){
			return "success3";  //跳转成功页面
		}else{
			return "error";   //跳转error页面
			
		}
		
	}
	
	
	
	//删除
	@ResponseBody
	@RequestMapping("/delete.do/{billid}")
	public Object delete(
			@PathVariable
			Integer billid     //拿取id
			){
		System.out.println(billid);
		int delete=billService.delete(billid);
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(delete>0){
			map.put("delResult", "true");
		}else{
			map.put("delResult", "false");
		}
				
		return map;
		
	}
	
	
	
	

	//Ajax根据id查询用户
		@ResponseBody
		@RequestMapping("/ShowBybill.html/{billid}")	
		public Object getuserById(
				@PathVariable
				Integer billid,     //拿取id
				Model model
				
				){
			System.out.println(billid);
			Bill bill=billService.getid(billid);
			return bill;
			
		}
	
	
	
}