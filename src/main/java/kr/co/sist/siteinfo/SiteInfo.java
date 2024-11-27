package kr.co.sist.siteinfo;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import lombok.Getter;
import lombok.ToString;

public class SiteInfo {
	private static SiteInfo si;
	
	@Getter
	private String protocol, server_name, context_root, site_name_kor, site_name_eng;
	
	@Getter
	private SiteInfoDomain siDomain;
	
	private SiteInfo() {
		
	}
	
	public static SiteInfo getInstance() {
		if(si == null) {
			si = new SiteInfo();
		}//end if
		si.searchSiteInfo("D");
		return si;
	}//getInstance
	
	private void searchSiteInfo(String env) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession handler = mbh.getHandler();
		
		try {
			siDomain = handler.selectOne("selectSiteInfo", env);
		} finally {
			mbh.closeHandler(handler);
		}//end finally
		
	}//searchSiteInfo
	
	
}//class
