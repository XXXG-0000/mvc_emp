package kr.co.sist.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class MainAction implements Action {
		
	private String moveURL;			//이동할 URL
	private boolean forwardFlag;	//진행 여부 알리는 플래그

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		moveURL="index";
		forwardFlag = true;
	}

	@Override
	public String moveURL() {
		return moveURL;
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

}
