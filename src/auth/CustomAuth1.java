package auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomAuth1 extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    String target = request.getRequestURI();

	    HttpSession session = request.getSession(false);

	    if (session == null){
	      /* まだ認証されていない */
	      session = request.getSession(true);
	      session.setAttribute("target", target);

	      response.sendRedirect("/UnibaDenki/Login");
	    }else{
	      Object loginCheck = session.getAttribute("login");
	      if (loginCheck == null){
	        /* まだ認証されていない */
	        session.setAttribute("target", target);
	        response.sendRedirect("/UnibaDenki/Login");
	      }
	    }

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>ユーザー認証テスト</title>");
	    out.println("</head>");
	    out.println("<body>");

	    out.println("<p>テストページ1</p>");

	    out.println("<p><a href=\"/UnibaDenki/CustomAuth2\">テストページ2へ</a></p>");

	    out.println("</body>");
	    out.println("</html>");
	  }
	}