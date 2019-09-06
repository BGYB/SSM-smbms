package cn.bdqn.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.entity.User;

//登录权限拦截器
public class SysInterceptor implements HandlerInterceptor{
	
	
	//进入请求前
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
				Object object) throws Exception {
			String path=request.getContextPath();  //获取根目录
			
			//request.getSchema()可以返回当前页面使用的协议，http 或是 https;request.getServerPort()返回页面所在的服务器使用的端口
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			User user=(User) request.getSession().getAttribute("userLogin");
			
			if(user==null){
				response.sendRedirect(basePath+"login.html");
				return false;
			}else{
				return true;
			}
			
		}
	
	

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		System.out.println("拦截器完成后");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("进入了拦截后");

		
	}

	

}
