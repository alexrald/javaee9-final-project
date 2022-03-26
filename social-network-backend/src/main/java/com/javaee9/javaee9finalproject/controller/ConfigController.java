package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.dto.InitialConfig;
import com.javaee9.javaee9finalproject.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/config")
@CrossOrigin("http://localhost:4200")
// CORS - Cross-Origin Resource Sharing
// @CrossOrigin annotation allows browser to process requests from a different origin
// In this case, the resource is shared between localhost:8080 (backend) and localhost:4200 (frontend)
// See more in https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy
// and https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS/Errors

public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping()
    public InitialConfig provideInitialConfig() {
        log.info("provideInitialConfig was called");

        return configService.getInitialConfig();
    }


}
