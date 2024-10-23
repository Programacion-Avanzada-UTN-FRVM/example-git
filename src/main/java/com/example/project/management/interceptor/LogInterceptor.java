package com.example.project.management.interceptor;

import com.example.project.management.model.Log;
import com.example.project.management.model.LogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ua_parser.Parser;

@Component
@RequiredArgsConstructor
public class LogInterceptor implements HandlerInterceptor {

    private final Parser parser;
    private final LogRepository logRepository;

    private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {

        final var userAgentHeader = request.getHeader("user-agent");
        final var client = parser.parse(userAgentHeader);

        logRepository.save(
                new Log(
                        request.getMethod(),
                        request.getRequestURI(),
                        client.userAgent.family,
                        client.os.family,
                        client.device.family
                )
        );

        logger.info("Saved new log from log interceptor");

        return true;
    }
}
