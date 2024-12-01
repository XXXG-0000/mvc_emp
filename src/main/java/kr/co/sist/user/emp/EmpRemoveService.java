package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpRemoveService {

	private static EmpRemoveService ers;
	
	private EmpRemoveService() {
		
	}
	
	public static EmpRemoveService getInstance() {
		if(ers == null) {
			ers = new EmpRemoveService();
		}//end if
		return ers;
	}//SearchAllEmpService
	
	public boolean removeEmp(MvcEmpVO meVO) {
		boolean flag = false;
		EmpDAO eDAO = EmpDAO.getInstance();
		try {
			flag = eDAO.deleteEmp(meVO) == 1;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return flag;
	}//addEmp
	
}//class
