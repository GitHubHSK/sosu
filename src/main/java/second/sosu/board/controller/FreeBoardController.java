package second.sosu.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping(value="/freeboard/{FR_CATEGORY}.sosu") 
	public ModelAndView freeList(@PathVariable String FR_CATEGORY, CommandMap commandMap, HttpSession session) throws Exception {
		
		commandMap.put("MO_CATEGORY", FR_CATEGORY);
		
		List<Map<String,Object>> list= freeboardService.freeList(commandMap.getMap(), session);	
		
		ModelAndView mv = new ModelAndView("/board/freeboard");
		mv.setViewName("board/freeboard");
		
		mv.addObject("list",list);
		mv.addObject("session", session.getAttribute("M_IDX"));
		
		return mv; 
	}
	
	//자유게시글 상세
	@RequestMapping(value="/freeboard/{FR_CATEGORY}/{FR_IDX}.sosu")
	public ModelAndView freeDetail(@PathVariable String FR_CATEGORY, @PathVariable int FR_IDX, CommandMap commandMap) throws Exception {	
		
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		commandMap.put("FR_IDX", FR_IDX);

		Map<String,Object> map = freeboardService.freeDetail(commandMap.getMap());	
		
		//List<Map<String, Object>> Flist = freeboardService.freeDetailImg(commandMap.getMap());
		
		ModelAndView mv = new ModelAndView("/board/freeDetail");
		mv.setViewName("board/freeDetail");
		
		mv.addObject("map", map);
		//mv.addObject("Flist", Flist);

		return mv;
	}
	
	//자유게시글 작성 폼
	@RequestMapping(value="/freeboard/insertForm/{FR_CATEGORY}.sosu")
	public ModelAndView insertForm(@PathVariable String FR_CATEGORY, CommandMap commandMap) throws Exception {
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		
		ModelAndView mv = new ModelAndView("/board/insertfree");
		mv.setViewName("board/insertfree");
	
		return mv;
	}
	
	//자유게시글 작성
	@RequestMapping(value="/freeboard/insertfree.sosu") 
	public ModelAndView insertfree(String FR_CATEGORY,CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception {

		commandMap.put("M_IDX", Integer.parseInt(String.valueOf(session.getAttribute("M_IDX"))));

		ModelAndView mv = new ModelAndView("redirect:/freeboard/" + FR_CATEGORY + ".sosu");

		freeboardService.insertFree(commandMap.getMap(), session, request);
			
		return mv;
	}
	
	//자유게시글 수정 폼
	@RequestMapping(value="/freeboard/updateForm/{FR_CATEGORY}/{FR_IDX}.sosu")
	public ModelAndView updatefreeForm(@PathVariable String FR_CATEGORY, @PathVariable int FR_IDX, CommandMap commandMap) throws Exception {	
			
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		commandMap.put("FR_IDX", FR_IDX);
				
		Map<String, Object> map = freeboardService.freeDetail(commandMap.getMap());	
		
		ModelAndView mv = new ModelAndView("/board/updatefree");	
		mv.setViewName("board/updatefree");

		mv.addObject("map", map);

		return mv;
	}
	
	//자유게시글 수정
	@RequestMapping(value="/freeboard/updatefree.sosu")
	public ModelAndView updatefree(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception {
		
		Map<String, Object> map = freeboardService.freeDetail(commandMap.getMap());
		
		String idx = map.get("FR_IDX").toString();
		String cate = map.get("FR_CATEGORY").toString();		
		ModelAndView mv = new ModelAndView("redirect:/freeboard/" + cate + "/" + idx + ".sosu");
		
		freeboardService.updateFree(commandMap.getMap(), session, request);
		
		mv.addObject("FR_IDX", commandMap.get("FR_IDX"));
		
		return mv;
	}
		
	//자유게시글 삭제
	@RequestMapping(value="/freeboard/{FR_CATEGORY}/deletefree.sosu")
	public ModelAndView deletefree(@PathVariable String FR_CATEGORY, CommandMap commandMap) throws Exception {
		
		commandMap.put("FR_CATEGORY", FR_CATEGORY);
		
		ModelAndView mv = new ModelAndView("redirect:/freeboard/" + FR_CATEGORY + ".sosu");
	
		freeboardService.deleteFree(commandMap.getMap());
		
		return mv;
	}
	
	//자유게시판 검색
	@PostMapping(value="/freeboard/{FR_CATEGORY}.sosu") 
	public ModelAndView freeSearch(@PathVariable String FR_CATEGORY, CommandMap commandMap) throws Exception { 
		
		commandMap.put("MO_CATEGORY", FR_CATEGORY);
	  
		List<Map<String, Object>> list = freeboardService.freeSearch(commandMap.getMap()); 
		
		ModelAndView mv = new ModelAndView("/board/freeboard");
		mv.setViewName("board/freeboard");
		
		mv.addObject("list", list);
	  	
		return mv; 
	}
	
	//자유게시판 찜
	//@RequestMapping(value="/freeboard/insertZzim/{FR_CATEGORY}/{FR_IDX}.sosu")
	//public ModelAndView insertZzim(@PathVariable String FR_CATEGORY, @PathVariable int FR_IDX, CommandMap commandMap, HttpSession session, RedirectAttributes rttr) throws Exception { // 여러 데이터 맵형식 저장
	//	ModelAndView mv = new ModelAndView("redirect:/freeboard/" + FR_CATEGORY + "/" + FR_IDX + ".sosu"); // 화면에 보여줄 jsp 파일을 의미(view)
		
	//	freeboardService.insertZzim(commandMap.getMap(), session);
	//	rttr.addAttribute("zzimCount", commandMap.get("zzimCount")); // 별점 총합 (별점평가수)
		
	//	return mv;
	//}
	
	//자유게시판 찜 삭제
	//@RequestMapping("/freeboard/deleteZzim/{FR_CATEGORY}/{FR_IDX}.sosu")
	//public ModelAndView deleteZzim(@PathVariable String FR_CATEGORY, @PathVariable int FR_IDX, CommandMap commandMap, HttpSession session, RedirectAttributes rttr) throws Exception { // 여러 데이터 맵형식 저장
	//	ModelAndView mv = new ModelAndView("redirect:/freeboard/" + FR_CATEGORY + "/" + FR_IDX + ".sosu"); // 화면에 보여줄 jsp 파일을 의미(view)
		
	//	freeboardService.deleteZzim(commandMap.getMap(), session);
	//	rttr.addAttribute("zzimCount", commandMap.get("zzimCount")); // 별점 총합 (별점평가수)
		
	//	return mv;
	//}
}