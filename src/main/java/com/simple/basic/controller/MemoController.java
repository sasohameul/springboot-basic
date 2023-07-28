package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.service.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	@Qualifier("memoService")
	private MemoService memoService;

	@GetMapping("/memoList")
	public String memoList(Model model) {
		
		ArrayList<MemoVO> list = memoService.getList();
		model.addAttribute("list",list);
		System.out.println(list);
		
		return "memo/memoList";
	}
	
	@GetMapping("/memoWrite")
	public String memoWrite(){
		
		return"memo/memoWrite";
	}
	
	@PostMapping("/memoForm")
	public String memoForm(@Valid @ModelAttribute("vo") MemoVO vo,
														Errors errors,
														Model model) {
		
		
		//System.out.println(errors.hasErrors());
		//System.out.println(errors);
		if(errors.hasErrors()) {
			
			List<FieldError>list = errors.getFieldErrors();
			
			for(FieldError err : list) {
				
				if(err.isBindingFailure()) {
					model.addAttribute("valid_" + err.getField(), "잘못된 입력값입니다.");
					
				} else {
					
					model.addAttribute("valid_"+err.getField(), err.getDefaultMessage());
				}
				
			}
			
			return "memo/memoWrite";
		} 
		
		memoService.MemoRegist(vo);
		
		return "redirect:/memo/memoList";
	}
	
	@GetMapping("/memoDelete")
	public String memoDelete(@RequestParam("index") int index) {
		
		memoService.MemoDelete(index);
		
		return "redirect:/memo/memoList";
	}
	
	
}
