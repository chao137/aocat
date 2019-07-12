package cn.edu.cuit.aocat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.cuit.aocat.entity.User;

public class UrlInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String url = request.getRequestURI();
		if (url.indexOf("tologin.do") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return true;
		} else {
			System.out.println("nobady login");
			request.getRequestDispatcher("/tologin").forward(request, response);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
