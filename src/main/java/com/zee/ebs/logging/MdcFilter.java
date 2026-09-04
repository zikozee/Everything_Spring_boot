package com.zee.ebs.logging;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

/**
 * @dev : Ezekiel Eromosei
 * @date : 04 Sep, 2026
 */

@Slf4j
@AllArgsConstructor
public class MdcFilter extends OncePerRequestFilter {

    private static final String REQUEST_ID = "requestId";
    private static final String REQUEST_ID_HEADER = "X-Request-ID";

    private final String applicationName;


    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        String requestId = request.getHeader(REQUEST_ID_HEADER);

        if (requestId == null || requestId.isBlank()) {
            requestId = UUID.randomUUID().toString();
        }

        long startTime = System.currentTimeMillis();
        try {
            MDC.put(REQUEST_ID, requestId);
            MDC.put("service.name", applicationName);
            MDC.put("method", request.getMethod());
            MDC.put("path", request.getRequestURI());

            response.setHeader(REQUEST_ID_HEADER, requestId);

            filterChain.doFilter(request, response);

        }finally {
            long duration = System.currentTimeMillis() - startTime;
            MDC.put("status", String.valueOf(response.getStatus()));
            MDC.put("duration_ms", String.valueOf(duration));

            log.info("HTTP {} {} completed with status {} in  {} ms", request.getMethod(), request.getRequestURI(), response.getStatus(), duration);

            MDC.remove(REQUEST_ID);
            MDC.remove("method");
            MDC.remove("path");
            MDC.remove("service.name");
        }
    }
}
