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

public class SearchOneEmpAction implements Action {
	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SearchOneEmpService soes = SearchOneEmpService.getInstance();
		EmpFormService efs = EmpFormService.getInstance(); // 꼭 서비스는 하나만 쓰는 게 아니다
		
		String empno = request.getParameter("empno");
		try {
			MvcEmpDomain med = soes.searchOneEmp(Integer.parseInt(empno));
			
			request.setAttribute("empData", med);
			request.setAttribute("deptnoList", efs.searchAllDeptno());
			
			//해당 데이터를 보여줄 JSP 설정
			moveURL = "emp/emp_detail";
			//이동방식 설정
			forwardFlag = true;
		} catch(NumberFormatException nfe) {
			moveURL = "emp/emp_err.html";
			forwardFlag = false;//redirect로 이동
		}//end catch
		
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
