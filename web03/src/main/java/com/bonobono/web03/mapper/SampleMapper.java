package com.bonobono.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.bonobono.web03.vo.Sample;

@Mapper
public interface SampleMapper {
	List<Sample> selectSampleList();
	
	int insertSample(Sample sample);
	
	int deleteSample(Sample sample);

	Sample selectSampleOne(int sampleId);
}
