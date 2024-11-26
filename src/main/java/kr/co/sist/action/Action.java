package kr.co.sist.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 웹 파라메터 받기, 응답할 페이지명 반환, 페이지 이동 방식, 
 * 								업무 로직 구현 실행하는 클래스를 사용
 */
public interface Action {
	
	/**
	 * 웹 파라메터받기, 파라메터 유효성 검증, 업무로직 제공 클래스를 사용
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
	/**
	 * 응답할 페이지 명 반환
	 * @return
	 */
	public String moveURL();
	
	/**
	 * forward로 이동할 것인지 여부 결정 
	 * @return true - forward로 이동, false - redirect 이동
	 */
	public boolean isForward();
	
	
}
