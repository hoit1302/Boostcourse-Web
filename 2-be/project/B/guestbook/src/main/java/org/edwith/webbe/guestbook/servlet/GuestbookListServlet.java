package org.edwith.webbe.guestbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	GuestbookDao guestbookDao = new GuestbookDao();
    	List<Guestbook> guestbooks = guestbookDao.getGuestbooks();
    	request.setAttribute("list", guestbooks);
    	
    	RequestDispatcher requestDispatcher;
    	requestDispatcher = getServletContext().getRequestDispatcher("/guestbooks.jsp");
    	requestDispatcher.forward(request, response);
    }

}