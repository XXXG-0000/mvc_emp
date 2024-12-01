package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class SearchOneEmpService {

	private static SearchOneEmpService soes;
	
	private SearchOneEmpService() {
		
	}
	
	public static SearchOneEmpService getInstance() {
		if(soes == null) {
			soes = new SearchOneEmpService();
		}//end if
		return soes;
	}//SearchAllEmpService
	
	public MvcEmpDomain searchOneEmp(int empno){
		MvcEmpDomain med = null;
		
		EmpDAO eDAO = EmpDAO.getInstance();
		
		try {
			med = eDAO.selectOneEmp(empno);
			med.setEmpno(empno);//문제 없을 경우 med에 empno set
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return med;
	}
}
