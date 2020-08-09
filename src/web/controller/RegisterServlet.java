package web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import bean.User;
import exception.UserExistException;
import service.IUserService;
import service.impl.UserServiceImpl;
import util.WebUtils;
import web.formbean.RegisterFormBean;

public class RegisterServlet extends HttpServlet {


	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}


	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		RegisterFormBean formbean = WebUtils.request2Bean(req,RegisterFormBean.class);
		if(formbean.validate() == false) {
			req.setAttribute("formbean", formbean);
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
			return;
		}
		
		User user = new User();
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user,formbean);
			IUserService service = new UserServiceImpl();
			service.insertUser(user);
			String message = String.format(
					"ע��ɹ�����3���Ϊ���Զ�������¼ҳ�棡<meta http-equiv='refresh' content='3;url=%s'/>", 
					req.getContextPath()+"/servlet/LoginUIServlet");
			req.setAttribute("message",message);
			req.getRequestDispatcher("/message.jsp").forward(req,resp);
		}catch(UserExistException e) {
			formbean.getErrors().put("userName", "ע���û��Ѵ���!");
			req.setAttribute("formbean", formbean);
			req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);			
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("message","�Բ���ע��ʧ�ܣ�");
			req.getRequestDispatcher("/message.jsp").forward(req, resp);
		}
	}
}
