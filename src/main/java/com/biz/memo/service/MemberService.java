package com.biz.memo.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.biz.memo.dao.MemberDao;
import com.biz.memo.model.MemberVO;



@Service
public class MemberService {
	

	@Autowired
	SqlSession sqlSession;
	
	MemberDao mDao;
	
	
	@Autowired
	public void getMapper() {
		mDao = sqlSession.getMapper(MemberDao.class);
	}

	
	
	public MemberVO login(MemberVO memberVO) {

		String m_userid = memberVO.getM_userid();
		String m_password = memberVO.getM_password();
		
//		memberVO = mDao.findByUserId(m_userid);
//		
//		if(memberVO.getM_password().equals(m_password)) {
//			//login 성공
//		}
		
		//id와 비밀번호를 모두 select문으로 조회해서
		//회원정보 가져오기
		//만약 id와 비밀번호가 일치하면
		//정상적인 VO를 retunr
		//그렇지 않다면 null값을 return
		memberVO = mDao.login(memberVO);
		
		
		return memberVO;
	}
	
	
}
