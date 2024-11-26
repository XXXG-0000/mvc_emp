package kr.co.sist.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.siteinfo.SiteInfo;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Action> mainMap = new HashMap<String, Action>();
	
	static {
		//Map에 설정할 Action을 넣기
		//site 정보 로딩
		SiteInfo siteInfo = SiteInfo.getInstance();
		System.out.println(siteInfo.getProtocol());
		System.out.println(siteInfo.getServer_name());
		System.out.println(siteInfo.getContext_root());
		System.out.println(siteInfo.getSite_name_kor());
		System.out.println(siteInfo.getSite_name_eng());		
	}
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		pagePreProcess(request, response);
	}//doGet
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //전처리 후크
		pagePreProcess(request, response);
	}//doPost
	
	private void pagePreProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void movePage(HttpServletRequest request, HttpServletResponse response, 
			String moveURL, boolean isForward) throws ServletException, IOException {
		if(isForward) {
			RequestDispatcher rd = request.getRequestDispatcher(moveURL + ".jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(moveURL);
		}//end else
	}//movePage
	
}//class
