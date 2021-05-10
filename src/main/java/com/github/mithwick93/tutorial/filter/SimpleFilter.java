package com.github.mithwick93.tutorial.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterchain
    ) throws IOException, ServletException {
        LOG.info("Remote Host:" + request.getRemoteHost());
        LOG.info("Remote Address:" + request.getRemoteAddr());
        filterchain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterconfig) {
    }
}