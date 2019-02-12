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
	// 객체 생성
	@Autowired		
	private SampleMapper sampleMapper;
	
	// 전체 리스트 출력하는 메서드
	public List<Sample> getSampleList() {
		List<Sample> list = sampleMapper.selectSampleList();
		return list;
	}
	
	// 하나의 리스트를 출력하는 메서드
	public Sample getSampleOne(int sampleId) {
		// SampleController에서 매개변수로 입력받은 sampleId의 값을 sampleMapper의 selectSampleOne메서드에 입력
		Sample sample = sampleMapper.selectSampleOne(sampleId);
		return sample;
	}
	
	// 테이블에 값을 추가하는 메서드
	public int addSample(Sample sample) {
		// 쿼리가 실행될 경우 1, 실행되지 않을 경우 0
		int result = sampleMapper.insertSample(sample);
		return result;
	}
	
	// 선택한 컬럼 하나를 삭제하는 메서드
	public int removeSample(Sample sample) {
		int result = sampleMapper.deleteSample(sample);
		return result;
	}
	
	// 하나의 값을 수정하는 메서드
	public int modifySample(Sample sample) {
		return 0;
	}
}
