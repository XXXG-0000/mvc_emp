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
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;
import kr.co.sist.main.MainAction;
import kr.co.sist.siteinfo.SiteInfo;
import kr.co.sist.siteinfo.SiteInfoDomain;
import kr.co.sist.user.emp.EmpFormAction;
import kr.co.sist.user.emp.EmpFormProcessAction;
import kr.co.sist.user.emp.EmpModifyAction;
import kr.co.sist.user.emp.EmpRemoveAction;
import kr.co.sist.user.emp.SearchAllEmpAction;
import kr.co.sist.user.emp.SearchOneEmpAction;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Action> mainMap = new HashMap<String, Action>();
	private SiteInfoDomain siDomain;
	public static String uploadDir;
	
	static {
		//Map에 설정할 Action을 넣기 // 11.27
		mainMap.put("M001", new MainAction());
		mainMap.put("ESA001", new SearchAllEmpAction());
		mainMap.put("EA001", new EmpFormAction());
		mainMap.put("EA002", new EmpFormProcessAction());
		mainMap.put("ES001", new SearchOneEmpAction());
		mainMap.put("EU001", new EmpModifyAction());
		mainMap.put("ED001", new EmpRemoveAction());
	}//static
	
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
		uploadDir = siDomain.getUpload_dir();
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
		
		//입력된 cmd로 사용할 Action을 선택한다.
		String  cmd = request.getParameter("cmd");
		if(!mainMap.containsKey(cmd)) { //URL 입력이 잘못 되었을 경우
			cmd = "M001"; // 메인 페이지로 전송한다.
		}
		
		Action action = mainMap.get(cmd);//cmd에 해당하는 자식을 부모로 받는다.
		//부모의 이름으로 모든 자식을 사용할 수 있다 => 객체 다형성
		
		action.execute(request, response); //자식이 일을 수행
		String moveURL = action.moveURL(); //이동할 URL
		boolean isForward = action.isForward(); // 
		
		//자식이 반환한 값을 사용
		movePage(request, response, moveURL, isForward); // 해당 페이지로 이동
		
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
