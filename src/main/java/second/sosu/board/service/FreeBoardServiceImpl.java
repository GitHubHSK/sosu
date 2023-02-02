package second.sosu.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import second.sosu.board.dao.FreeBoardDAO;

@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "freeboardDAO")
	private FreeBoardDAO freeboardDAO;
	
	//리뷰 페이징 리스트
	@Override 
	public List<Map<String, Object>>freeList(Map<String, Object> map, HttpSession session) throws Exception {		
		return freeboardDAO.freeList(map, session);
	}
	
	//자유게시글 상세
	@Override
	public Map<String, Object>freeDetail(Map<String, Object> map) throws Exception {		
		return freeboardDAO.freeDetail(map);
	}
	
	//자유게시글 작성
	@Override
	public void insertFree(Map<String, Object> map, HttpSession session) throws Exception {		
		freeboardDAO.insertFree(map, session);
	}
	
	//자유게시글 사진 파일 등록
	@Override
	public void insertFreeFile(Map<String, Object> map, HttpSession session) throws Exception {		
		freeboardDAO.insertFreeFile(map, session);
	}
	
	//자유게시글 프로필 리스트
	@Override
	public void freeMemberList(Map<String, Object> map, HttpSession session) throws Exception {		
		freeboardDAO.freeMemberList(map, session);
	}
	
	//자유게시글 수정
	@Override
	public void updateFree(Map<String, Object> map, HttpServletRequest request) throws Exception {	
		freeboardDAO.updateFree(map);
	}
	
	//자유게시글 사진 파일 수정
	@Override
	public void updateFreeFile(Map<String, Object> map) throws Exception {	
		freeboardDAO.updateFreeFile(map);
	}

	//자유게시글 삭제
	@Override
	public void deleteFree(Map<String, Object> map) throws Exception {	
		freeboardDAO.deleteFree(map);
	}
	
	//자유게시글 삭제 이미지 파일 삭제
	@Override
	public void deleteFreeFile(Map<String, Object> map) throws Exception {	
		freeboardDAO.deleteFreeFile(map);
	}
}