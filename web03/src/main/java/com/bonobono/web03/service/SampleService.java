package com.bonobono.web03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonobono.web03.mapper.SampleMapper;
import com.bonobono.web03.vo.Sample;

// java bean 생성
@Service
public class SampleService {
	// 해당하는 클래스 연결
	@Autowired		// 객체 생성
	private SampleMapper sampleMapper;
	
	// 전체 리스트 출력하는 메서드
	public List<Sample> getSampleList() {
		List<Sample> list = sampleMapper.selectSampleList();
		return list;
	}
	
	// 하나의 리스트를 출력하는 메서드
	public Sample getSampleOne() {
		return null;
	}
	
	// 테이블에 값을 추가하는 메서드
	public int addSample(Sample sample) {
		// 쿼리가 실행될 경우 1, 실행되지 않을 경우 0
		int result = sampleMapper.insertSample(sample);
		return result;
	}
	
	// 하나의 값을 삭제하는 메서드
	public int removeSample(Sample sample) {
		return 0;
	}
	
	// 하나의 값을 수정하는 메서드
	public int modifySample(Sample sample) {
		return 0;
	}
}
