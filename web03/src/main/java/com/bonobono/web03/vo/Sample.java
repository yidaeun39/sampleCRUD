package com.bonobono.web03.vo;

import org.springframework.context.annotation.Configuration;

// lombok을 사용할 경우 @getter @setter
// vo는 싱글톤 방식이 더 나음
// 객체를 생성하기 위해서 어노테이션 추가
@Configuration
public class Sample {
	private int sampleId;		// sample 테이블의 sample_id 컬럼과 동일
	private String sampleName;	// sample 테이블의 sample_name 컬럼과 동일
	
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	@Override
	public String toString() {
		return "Sample [sampleId=" + sampleId + ", sampleName=" + sampleName + "]";
	}
}
