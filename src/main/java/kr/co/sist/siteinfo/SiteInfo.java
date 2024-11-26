package kr.co.sist.siteinfo;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import lombok.Getter;
import lombok.ToString;

public class SiteInfo {
	private static SiteInfo si;
	
	@Getter
	private String protocol, server_name, context_root, site_name_kor, site_name_eng;
	
	private SiteInfo() {
		
	}
	
	public static SiteInfo getInstance() {
		if(si == null) {
			si = new SiteInfo();
		}//end if
		si.searchSiteInfo();
		return si;
	}//getInstance
	
	private void searchSiteInfo() {
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession handler = mbh.getHandler();
		
		try {
			SiteInfoDomain sd = handler.selectOne("selectSiteInfo");
			protocol = sd.getProtocol();
			server_name = sd.getServer_name();
			context_root = sd.getContext_root();
			site_name_kor = sd.getSite_name_kor();
			site_name_eng = sd.getSite_name_eng();
		} finally {
			mbh.closeHandler(handler);
		}//end finally
		
	}//searchSiteInfo
	
	
}//class
