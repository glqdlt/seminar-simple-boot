package com.glqdlt.simple.ui.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class HttpSessionListenerImpl implements HttpSessionListener{

    private static final Logger log = LoggerFactory.getLogger(HttpSessionListenerImpl.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 세션 타임아웃 10*60 => 10분 설정.
        se.getSession().setMaxInactiveInterval(10*60);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
