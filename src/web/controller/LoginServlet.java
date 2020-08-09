package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.IUserService;
import service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		IUserService service = new UserServiceImpl();
		User user = service.loginUser(account, password);
		if(user==null) {
			String message = String.format("对不起，用户名或密码有误！请重新登录！2秒后自动跳转到登录页面。。。"
					+ "<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			System.out.println(user);//
			String message = String.format("恭喜：%s登录成功！即将跳到首页！"
					+ "<meta http-equitv='refresh' conten='1;url=%s'",
					user.getAccount(),
					request.getContextPath()+"/index.jsp");
			request.setAttribute(message, message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
