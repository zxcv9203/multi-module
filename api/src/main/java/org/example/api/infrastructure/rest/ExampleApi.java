package org.example.api.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.example.api.application.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleApi {

    private final ExampleService exampleService;

    @GetMapping("/success")
    public String save() {
        return exampleService.success();
    }

    @GetMapping("/error")
    public String find() {
        return exampleService.unknownError();
    }
}
