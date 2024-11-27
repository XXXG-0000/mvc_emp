package kr.co.sist.user.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;

public class EmpFormProcessAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MvcEmpVO meVO = new MvcEmpVO();
		meVO.setEmpno(Integer.parseInt(request.getParameter("empno")));
		meVO.setEname(request.getParameter("ename"));
		meVO.setJob(request.getParameter("job"));
		meVO.setSal(Integer.parseInt(request.getParameter("sal")));
		meVO.setComm(Integer.parseInt(request.getParameter("comm")));
		meVO.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		
		EmpFormProcessService efps = EmpFormProcessService.getInstance();		
		//1. 세션 얻기
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("addFlag");
		boolean flag = false;
		if(obj != null) {
			flag = ((Boolean)obj).booleanValue();
		}//end if
		
		if(!flag) {
			session.setAttribute("empAddResult", efps.addEmp(meVO));
			session.setAttribute("addFlag", true);
		}//end if
		
		//session.setAttribute("empAddResult", efps.addEmp(meVO));
		moveURL = "emp/add_result";
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
