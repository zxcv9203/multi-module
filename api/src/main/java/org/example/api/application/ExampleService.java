package org.example.api.application;

import lombok.RequiredArgsConstructor;
import org.example.core.application.CoreExampleService;
import org.example.core.common.ResponseCode;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final CoreExampleService coreExampleService;

    public String success() {
        System.out.println(coreExampleService.callCore());
        return ResponseCode.SUCCESS.getMessage();
    }

    public String unknownError() {
        return ResponseCode.UNKNOWN_ERROR.getMessage();
    }
}
