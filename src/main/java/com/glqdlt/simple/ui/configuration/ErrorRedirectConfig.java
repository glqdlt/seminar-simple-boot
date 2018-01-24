package com.glqdlt.simple.ui.configuration;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorRedirectConfig extends ServerProperties {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        super.customize(container);
        container.addErrorPages(new ErrorPage("/error"));
    }
}
