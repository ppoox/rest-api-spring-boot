package com.ppoox.api.biz.sample;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SampleService {

    private static final List<Sample> MOCK_SAMPLE_LIST = Arrays.asList(
            new Sample(1, "abc"),
            new Sample(2, "def"));

    /**
     * 샘플 리스트 반환
     * @return List
     */
    public List<Sample> getSampleList() {
        return MOCK_SAMPLE_LIST;
    }
}
