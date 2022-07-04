package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private HttpSession session;
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private BoardPaging boardPaging;

	@Override
	public void boardWrite(Map<String, String> map) {
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		boardDAO.boardWrite(map);
		
	}

	@Override
	public Map<String, Object> getBoardList(String pg) {
		//DB - 1페이지당 5개씩
		int endNum = Integer.parseInt(pg) * 5;
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardDAO.getBoardList(map);
		
		//세션
		String memId = (String) session.getAttribute("memId");
		
		//페이징 처리
		BoardPaging boardPaging = this.getBoardPaging(pg);
		
		//새로고침 방지
		if(session.getAttribute("memId") != null){
			session.setAttribute("memHit", "0"); //세션 삭제
		}
		
		Map<String, Object> sendMap = new HashMap<String, Object>();
		sendMap.put("memId", memId);
		sendMap.put("list", list);
		sendMap.put("boardPaging", boardPaging);
		
		return sendMap;
	}

	@Override
	public BoardPaging getBoardPaging(String pg) {
		int totalA = boardDAO.getTotalA();
		
		boardPaging.setCurrentPage(Integer.parseInt(pg));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		return boardPaging;
	}

	@Override
	public Map<String, Object> getBoardView(String seq) {
		//새로고침 방지
		if(session.getAttribute("memHit") != null){
			//조회수 증가
			boardDAO.setHit(seq); //조회수 증가
			session.removeAttribute("memHit"); //세션 삭제
		}
		
		BoardDTO boardDTO = boardDAO.getBoardView(seq);
		
		//세션
		String memId = (String) session.getAttribute("memId");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardDTO", boardDTO);
		map.put("memId", memId);
		
		return map;
	}

	@Override
	public void boardReply(Map<String, String> map) { //pseq, subject, content
		//원글
		BoardDTO boardDTO = boardDAO.getBoardView(map.get("pseq"));
		
		//세션
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("ref", boardDTO.getRef()+""); //원글ref
		map.put("lev", boardDTO.getLev()+""); //원글lev
		map.put("step", boardDTO.getStep()+""); //원글step
		
		boardDAO.boardReply(map);
	}

	@Override
	public Map<String, Object> boardSearch(Map<String, String> map) { //pg, searchOption, keyword
		//1페이지당 5개씩
		int endNum = Integer.parseInt(map.get("pg")) * 5;
		int startNum = endNum - 4;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		List<BoardDTO> list = boardDAO.getBoardSearch(map);
		
		//페이징처리
		int totalA = boardDAO.getTotalSearchA(map); //총글수
		boardPaging.setCurrentPage(Integer.parseInt(map.get("pg")));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		Map<String, Object> sendMap = new HashMap<String, Object>();
		sendMap.put("list", list);
		sendMap.put("boardPaging", boardPaging);
		return sendMap;
	}


}
