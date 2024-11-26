package kr.co.sist.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;
import kr.co.sist.siteinfo.SiteInfo;
import kr.co.sist.siteinfo.SiteInfoDomain;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Action> mainMap = new HashMap<String, Action>();
	private SiteInfoDomain siDomain;
	
	static {
		//Map에 설정할 Action을 넣기
	}
	
	public void init() {
		//site 정보 로딩
		SiteInfo siteInfo = SiteInfo.getInstance();
		siDomain = siteInfo.getSiDomain();
		
		ServletContext application = getServletContext();
		
		StringBuilder defaultURL = new StringBuilder();
		defaultURL.append(siDomain.getProtocol())
		.append(siDomain.getServer_name())
		.append(siDomain.getContext_root()==null?"":siDomain.getContext_root());
		
		//모든 접속자가 하나의 정보만 가지고 사용되어야 하기 때문에 applicationScpoe에 설정
		application.setAttribute("defaultURL", defaultURL.toString());
		application.setAttribute("site_kor", siDomain.getSite_name_kor());
		application.setAttribute("site_eng", siDomain.getSite_name_eng());
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
		
		movePage(request, response, "index", true);
		
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
