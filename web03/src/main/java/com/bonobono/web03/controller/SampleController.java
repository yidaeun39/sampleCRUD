package com.bonobono.web03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bonobono.web03.service.SampleService;
import com.bonobono.web03.vo.Sample;

@Controller
public class SampleController {
	// 객체 생성
	@Autowired		
	private SampleService sampleService;
	
	// 1. 입력 폼
	// Get방식
	@GetMapping("/addSample")	
	public String addSample() {
		// 자동으로 view 파일로 forward
		return "addSample";		// view 이름은 template폴더(생략)의 addSample.html
	}
	
	// 2. 입력 액션
	// Post방식
	@PostMapping("/addSample")
	public String addSample(@RequestParam(value="") String sampleName) {
							// request.getParameter("sampleName")
		// redirect가 앞에 붙을경우 request.sendRedirect
		System.out.println("sampleName -> " + sampleName);
		// Sample VO 객체를 생성하고 화면에서 입력받은 값을 setting
		Sample sample = new Sample();
		sample.setSampleName(sampleName);
		// 값이 setting된 객체를 addSample메서드에 매개변수 자리에 넣고 호출
		int result = sampleService.addSample(sample);
		// 메서드가 실행, 쿼리문이 실행되어 테이블에 값이 입력될 경우 1, 그렇지 않을 경우 0을 출력
		System.out.println("입력 쿼리 실행 여부 -> " + result);
		// sampleList로 redirect
		return "redirect:/sampleList";
	}
	
	// 3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {
		// list라는 이름으로 getSampleList메서드의 리턴값을 view에 forward
		model.addAttribute("list", sampleService.getSampleList());
		return "sampleList";
	}
	
	// 4. 삭제
	@GetMapping("/removeSample")
	public String removeSample(@RequestParam(value="") int sampleId) {
		// get방식으로 보낸 Parameter값을 매개변수로 받고 확인
		System.out.println("sampleId -> " + sampleId);
		// Sample객체를 생성하고 그 객체에 값을 setting
		Sample sample = new Sample();
		sample.setSampleId(sampleId);
		// 값이 setting된 객체를 removeSample변수 매개변수 자리에 넣고 호출
		int result = sampleService.removeSample(sample);
		// 메서드가 실행되고 쿼리가 호출되면 리턴값이 1, 아닐경우 0
		// 콘솔창에서 쿼리 실행 여부 확인 후 sampleList로 redirect
		System.out.println("삭제 쿼리 실행 여부 -> " + result);
		return "redirect:/sampleList";
	}
	
	// 5. 수정 폼
	@GetMapping("/selectOneSample")
	public String selectOneSample(@RequestParam(value="") int sampleId, Model model) {
		System.out.println("sampleId -> " + sampleId);
		Sample sample = sampleService.getSampleOne(sampleId);
		// 선택된 하나의 라인의 값이 담긴 객체
		model.addAttribute("sample", sample);
		// sample 객체를 가지고 view 파일로 forward
		return "modifyForm";
	}
	
	// 6. 수정 액션
	@PostMapping("/modifySample")
	public String modifySample(@RequestParam(value="") int sampleId, @RequestParam(value="") String sampleName) {
		System.out.printf("아이디 : %d, 이름 : %s", sampleId, sampleName);
		
		return null;
	}
}
