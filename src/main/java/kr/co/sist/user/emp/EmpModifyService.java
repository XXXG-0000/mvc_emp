package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpModifyService {

	private static EmpModifyService eus;
	
	private EmpModifyService() {
		
	}
	
	public static EmpModifyService getInstance() {
		if(eus == null) {
			eus = new EmpModifyService();
		}//end if
		return eus;
	}//SearchAllEmpService
	
	public boolean modifyEmp(MvcEmpVO meVO) {
		boolean flag = false;
		EmpDAO eDAO = EmpDAO.getInstance();
		try {
			flag = eDAO.updateEmp(meVO) == 1;
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return flag;
	}//addEmp
	
}//class
