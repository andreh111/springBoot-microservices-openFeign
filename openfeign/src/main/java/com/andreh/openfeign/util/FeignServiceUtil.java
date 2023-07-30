package com.andreh.openfeign.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feignDemo", url = "http://localhost:8080/user")
public interface FeignServiceUtil {
    @GetMapping("/name")
    String getName();

    @GetMapping("/address")
    String getAddress();

    @GetMapping("/status")
    String getStatus();
}
