package org.example.api.application;

import org.example.core.common.ResponseCode;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public String success() {
        return ResponseCode.SUCCESS.getMessage();
    }

    public String unknownError() {
        return ResponseCode.UNKNOWN_ERROR.getMessage();
    }
}
