package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
@WebServlet("/ttt") //�Ȱ��� TenServlet�� ����Ǿ��µ� ��û�ϴ� �ּڰ��� �޶����� ��!!!
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Ŭ���̾�Ʈ�� ������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); // ������ Ÿ�� ����
		PrintWriter out = response.getWriter(); // ��¥ ���� ������ �־��� ��� ����
		out.println("<h1>1-10���� ���!!</h1>"); // println print ����� �ʿ� ���� ������ �ȸԾ�
		for (int i = 1; i <= 10; i++)
			out.println(i + "<br>");
		out.close();
	}

}
