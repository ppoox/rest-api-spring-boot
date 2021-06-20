package com.ppoox.api.biz.sample;

import com.ppoox.api.sys.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@Slf4j
@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    /**
     * 기본 GET
     * @return Result
     */
    @GetMapping
    public ResponseEntity<Result> getSample() {
        log.info("called GET");

        Result result = Result.successInstance();
        result.setData(sampleService.getSampleList());

        return ResponseEntity.ok(result);
    }

    /**
     * 에러 GET
     * @return Result
     */
    @GetMapping("error")
    public ResponseEntity<Result> getErrorSample() {
        log.info("called error GET");

        Result result = new Result().fail();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    /**
     * 기본 POST
     * @return Result
     */
    @PostMapping
    public ResponseEntity<Result> postSample() {
        log.info("called POST");

        Result result = Result.successInstance();
        result.setData(sampleService.getSampleList());

        return ResponseEntity.ok(result);
    }

    /**
     * validation 사용(단일)
     * @param no - 샘플 번호
     * @return Result
     */
    @GetMapping("/validation-single")
    public ResponseEntity<Result> validationSingleSample(
            @Validated
            @NotEmpty(message = "번호는 필수입니다.")
            @RequestParam("no")
            int no
            ) {
        log.info(Integer.toString(no));

        return ResponseEntity.ok(Result.successInstance());
    }

    /**
     * validation 사용(다중)
     * @param sample - 다중 샘플 파라미터를 받는 모델.
     * @return Result
     */
    @GetMapping("/validation-multi")
    public ResponseEntity<Result> validationMultiSample(@Validated Sample sample) {
        log.info("called validationMultiSample");
        log.info(Integer.toString(sample.getNo()));
        log.info(sample.getName());
        log.info(sample.getPhoneNumber());

        return ResponseEntity.ok(Result.successInstance());
    }
}
