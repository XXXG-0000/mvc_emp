package kr.co.sist.user.emp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;
import kr.co.sist.user.controller.MainController;

public class EmpFormAction implements Action {
	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpFormService efs = EmpFormService.getInstance();
		
		//view로 전달할 데이터를 scope 객체(request, session, application) 설정
		request.setAttribute("empno", efs.searchNextEmpno());
		request.setAttribute("deptnoList", efs.searchAllDeptno());
		
		//file upload가 된다고 할 경우 => 운영환경과 개발 환경이 다르다
		File uploadDir = new File(MainController.uploadDir);
		System.out.println(uploadDir);
		
		HttpSession session = request.getSession();
		session.setAttribute("addFlag", false);
		
		//해당 데이터를 보여줄 JSP 설정
		moveURL = "emp/emp_add_frm";
		//이동방식 설정
		forwardFlag = true;
	}//execute	

	@Override
	public String moveURL() {
		return moveURL;
	}//moveURL

	@Override
	public boolean isForward() {
		return forwardFlag;
	}//isForward

}
