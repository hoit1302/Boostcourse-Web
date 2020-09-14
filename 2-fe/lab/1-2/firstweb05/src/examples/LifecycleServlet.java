package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	
	/* 해당 url로 클라이언트가 서버에게 요청. 서버는 url을 받아서 lifecycle이라는 url 매핑은 lifecycleservlet이라는 정보를 알아냄*/
	/* 이 해당 클래스가 메모리에 존재하는 지 체크하고 없으면 객체 생성 -> 생성자 */
    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성!"); // 콘솔에 출력, 응답 결과로 보내줘 X 
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init aaaa 호출!");
	}

	public void destroy() {
		System.out.println("destroy 호출!");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/firstweb/LifecycleServlet'>");
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");                                                 
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service 호출!");
//	}

	
}
