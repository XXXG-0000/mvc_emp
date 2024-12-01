package kr.co.sist.user.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;

public class EmpRemoveAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MvcEmpVO meVO = new MvcEmpVO();
		
		try{ 
			meVO.setEmpno(Integer.parseInt(request.getParameter("empno")));
		
			EmpRemoveService ers = EmpRemoveService.getInstance();		
			
			request.setAttribute("empRemoveResult", ers.removeEmp(meVO));	
			
			moveURL = "emp/remove_result";
			forwardFlag = true;
		} catch(NumberFormatException nfe) {
			moveURL = "emp/emp_err.html";
			forwardFlag = false;
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
