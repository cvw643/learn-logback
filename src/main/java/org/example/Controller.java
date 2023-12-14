package org.example;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created in 2023-12-13
 *
 * @author York Huang
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class Controller {
    private final Tracer tracer;

    @GetMapping("/hello")
    Map<String, String> hello() {
        log.info("Hello");
        log.info("World");

        Map<String, String> result = new HashMap<>();

        result.put("traceId", MDC.get("traceId"));
        result.put("spanId", MDC.get("spanId"));

        return result;
    }

}
