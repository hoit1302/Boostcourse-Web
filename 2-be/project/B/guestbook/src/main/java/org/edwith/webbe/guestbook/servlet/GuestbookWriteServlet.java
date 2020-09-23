package org.edwith.webbe.guestbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8"); //jsp에서 입력받은 문자를 한글로 작업

        GuestbookDao guestbookDao = new GuestbookDao();
    	String name = request.getParameter("name");
		String content = request.getParameter("content");
		Guestbook guestbook = new Guestbook(name, content);
		guestbookDao.addGuestbook(guestbook);
		
		response.sendRedirect("/guestbooks");
    }

}
