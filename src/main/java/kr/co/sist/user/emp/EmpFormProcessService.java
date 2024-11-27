package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpFormProcessService {

	private static EmpFormProcessService efps;
	
	private EmpFormProcessService() {
		
	}
	
	public static EmpFormProcessService getInstance() {
		if(efps == null) {
			efps = new EmpFormProcessService();
		}//end if
		return efps;
	}//SearchAllEmpService
	
	public boolean addEmp(MvcEmpVO meVO) {
		boolean flag = false;
		EmpDAO eDAO = EmpDAO.getInstance();
		try {
			flag = eDAO.insertEmp(meVO) == 1;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return flag;
	}//addEmp
	
}//class
