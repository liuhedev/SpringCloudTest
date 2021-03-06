package com.liuhedev.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhe
 * @date 2020/08/04
 */
@RestController
@RequestMapping("bus")
@RefreshScope
public class BusController {

    @Value("${ip}")
    private String ip;

    @GetMapping("refresh")
    public ResponseEntity refreshBus() {
        return ResponseEntity.ok(ip);
    }
}
