package auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginCheck1 extends HttpServlet
	{
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		//レスポンス送信の文字コードを設定
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

	    String user = request.getParameter("user");
	    String pass = request.getParameter("pass");

	    HttpSession session = request.getSession(true);

	    boolean check = authUser(user, pass);
	    if (check){
	      /* 認証済みにセット */
	      session.setAttribute("login", "OK");

	      /* 本来のアクセス先へ飛ばす */
	      String target = (String)session.getAttribute("target");
	      response.sendRedirect(target);
	    }else{
	      /* 認証に失敗したら、ログイン画面に戻す */
	      session.setAttribute("status", "Not Auth");
	      response.sendRedirect("/UnibaDenki/Login");
	    }
	  }

	  protected boolean authUser(String user, String pass){
	    /* 取りあえずユーザー名とパスワードが入力されていれば認証する */
	    if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
	      return false;
	    }

	    return true;
	  }
	}