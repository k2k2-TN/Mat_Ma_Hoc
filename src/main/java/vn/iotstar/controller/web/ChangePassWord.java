package vn.iotstar.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.controller.SendEmail;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.User;


@WebServlet("/changePassword")
public class ChangePassWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/*--thay Ä‘á»•i máº­t kháº©u
	 * -list ra Ä‘Æ°á»£c máº­t kháº©u cá»§a ngÆ°á»�i dĂ¹ng hiá»‡n táº¡i , láº¥y id vĂ  select ngÆ°á»�i dĂ¹ng báº±ng hĂ m dao
	 * -cáº­p nháº­t láº¡i vá»›i máº­t kháº©u ngÆ°á»�i dĂ¹ng Ä‘Ă£ gá»­i lĂªn 
	 * -gá»­i thĂ´ng bĂ¡o
	 *  */
    
    
	UserDaoImpl userDao = new UserDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/web/changePassword.jsp").forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USERMODEL");
		String password = user.getPassword();
		String current_password = request.getParameter("password");
		String new_password = request.getParameter("newpassword");
		String re_password = request.getParameter("repassword");
//		Kiá»ƒm tra 
//		PrintWriter printWriter = response.getWriter();
//		printWriter.println(password);
//		printWriter.println(current_password);
//		printWriter.println(new_password);
//		printWriter.println(re_password);
//		//náº¿u máº­t kháº©u nháº­p vĂ o ko Ä‘Ăºng 
		String ThongBao = "";

		if(current_password.equals(password) &&  new_password.equals(re_password)) {
			user.setPassword(new_password);
			ThongBao ="Bạn đã xác nhận mật khẩu thành công !";
//			printWriter.println("nháº­p Ä‘Ăºng rĂ¹i !");
//			printWriter.println(user.getPassword());			
		}
		ThongBao = "Bạn đã đăng nhập sai thông tin. Vui lòng nhập lại !!!";
		userDao.update(user);
//		printWriter.println(user.getPassword());
//		
		request.setAttribute("ThongBao",ThongBao);
		request.getRequestDispatcher("views/web/changePassword.jsp").forward(request, response);
//		
		
	}

}
