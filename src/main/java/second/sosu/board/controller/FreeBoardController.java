package second.sosu.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import second.sosu.board.service.FreeBoardService;
import second.sosu.common.domain.CommandMap;

@Controller
public class FreeBoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="freeboardService")
	private FreeBoardService freeboardService;
	
	//자유게시판 리스트(카테고리 포함)
	@RequestMapping(value="/freeboard/{FR_CATEGORY}.sosu") 
	public ModelAndView freeList(@PathVariable String FR_CATEGORY, CommandMap commandMap, HttpSession session) throws Exception {
		
		commandMap.put("MO_CATEGORY", FR_CATEGORY);
		
		ModelAndView mv = new ModelAndView("/board/freeboard");

		List<Map<String,Object>> list= freeboardService.freeList(commandMap.getMap(), session);	
		mv.addObject("list",list);
		mv.addObject("session", session.getAttribute("M_IDX"));
		
		return mv; 
	}
	
	//자유게시글 상세
	@RequestMapping(value="/freeboard/{FR_CATEGORY}/{FR_IDX}.sosu")
	public ModelAndView freeDetail(@PathVariable String FR_CATEGORY, @PathVariable int FR_IDX, CommandMap commandMap) throws Exception {	
		
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		commandMap.put("FR_IDX", FR_IDX);
		
		ModelAndView mv = new ModelAndView("/board/freeDetail");
		
		Map<String,Object> map = freeboardService.freeDetail(commandMap.getMap());	
		mv.addObject("map", map);	

		return mv;
	}
	
	//자유게시글 작성 폼
	@RequestMapping(value="/freeboard/insertForm/{FR_CATEGORY}.sosu")
	public ModelAndView insertForm(@PathVariable String FR_CATEGORY, CommandMap commandMap) throws Exception {
		
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		
		ModelAndView mv = new ModelAndView("/board/insertfree");	
		String M_NICKNAME = (String)commandMap.get("M_NICKNAME");
		mv.addObject("M_NICKNAME", M_NICKNAME);
	
		return mv;
	}
	
	//자유게시글 작성
	@RequestMapping(value="/freeboard/insertfree.sosu") 
	public ModelAndView insertfree(CommandMap commandMap, HttpSession session) throws Exception {
		
		List<Map<String, Object>> list = freeboardService.freeList(commandMap.getMap(), session);
		
		commandMap.put("M_IDX", Integer.parseInt(String.valueOf(session.getAttribute("M_IDX"))));
		
		String cate = list.get(0).get("FR_CATEGORY").toString();// 리스트에서 카테고리 값 스트링으로 가져오기		
		ModelAndView mv = new ModelAndView("redirect:/freeboard/" + cate + ".sosu");

		freeboardService.insertFree(commandMap.getMap(), session);
			
		return mv;
	}
	
	//자유게시글 수정 폼
	@RequestMapping(value="/freeboard/updateForm/{FR_CATEGORY}/{FR_IDX}.sosu")
	public ModelAndView updatefree(@PathVariable String FR_CATEGORY, @PathVariable int FR_IDX, CommandMap commandMap) throws Exception {	
		ModelAndView mv = new ModelAndView("/board/updatefree");
		
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		commandMap.put("FR_IDX", FR_IDX);
		
		Map<String, Object> map = freeboardService.freeDetail(commandMap.getMap());	
		mv.addObject("map", map);

		return mv;
	}
	
	//자유게시글 수정
	@RequestMapping(value="/freeboard/updatefree.sosu")
	public ModelAndView updatefree(CommandMap commandMap) throws Exception {
		
		Map<String, Object> map = freeboardService.freeDetail(commandMap.getMap());
		
		String idx = map.get("FR_IDX").toString();
		String cate = map.get("FR_CATEGORY").toString();		
		ModelAndView mv = new ModelAndView("redirect:/freeboard/" + cate + "/" + idx + ".sosu");
		
		freeboardService.updateFree(commandMap.getMap());
		
		return mv;
	}
		
	//자유게시글 삭제
	@RequestMapping(value="/freeboard/deletefree.sosu")
	public ModelAndView deletefree(CommandMap commandMap) throws Exception {
		
		Map<String, Object> map = freeboardService.freeDetail(commandMap.getMap());

		String cate = map.get("FR_CATEGORY").toString();		
		ModelAndView mv = new ModelAndView("/redirect:/freeboard/" + cate + ".sosu");
	
		freeboardService.deleteFree(commandMap.getMap());
		
		return mv;
	}
}