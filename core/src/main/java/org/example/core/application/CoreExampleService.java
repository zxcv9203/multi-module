package org.example.core.application;

import org.springframework.stereotype.Service;

@Service
public class CoreExampleService {

    public String callCore() {
        return "core 모듈의 서비스 호출 성공";
    }
}
