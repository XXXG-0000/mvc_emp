package kr.co.sist.user.emp;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MvcEmpVO {
	private int empno, sal, comm, deptno;
	private String ename, job;
	private Timestamp hiredate;	

}
