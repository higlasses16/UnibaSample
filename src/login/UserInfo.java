package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class UserInfo extends HttpServlet
	{
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		//セッション・オブジェクトから復元
		HttpSession session = request.getSession(true);
		String userid = (String)session.getAttribute("userid");
		String password = (String)session.getAttribute("password");

		//レスポンス送信の文字コードを設定
		response.setContentType("text/html; charset=UTF-8");

		//Webブラウザに画面送信
		PrintWriter out = response.getWriter();
		out.println("<HTML><BODY>");
		out.println("<H1>パスワードの表示</H1><BR>");
		out.println("<TABLE><TR><TD>ユーザーID</TD>");
		out.println("<TD>"+userid+"</TD></TR>");
		out.println("<TR><TD>パスワード</TD>");
		out.println("<TD>"+password+"</TD></TR></TABLE>");
		out.println("</BODY></HTML>");
	}

}
