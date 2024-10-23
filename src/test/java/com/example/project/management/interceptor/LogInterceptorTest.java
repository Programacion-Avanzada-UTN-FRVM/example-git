package com.example.project.management.interceptor;

import com.example.project.management.model.LogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class LogInterceptorTest {

    @Autowired
    private LogInterceptor logInterceptor;

    @MockBean
    private LogRepository logRepository;

    @MockBean
    private HttpServletRequest request;

    @MockBean
    private HttpServletResponse response;

    @Test
    void testPostHandle() {
        when(request.getHeader("user-agent"))
                .thenReturn("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36, acceptLanguage:en-US,en;q=0.9");
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestURI()).thenReturn("/v1/test");

        logInterceptor.preHandle(request, response, new Object());

        verify(logRepository).save(argThat(log ->
                log.getHttpMethod().equals("GET") &&
                        log.getRequestURI().equals("/v1/test") &&
                        log.getBrowser().equals("Chrome") &&
                        log.getOS().equals("Mac OS X") &&
                        log.getDevice().equals("Mac")
        ));
    }
}