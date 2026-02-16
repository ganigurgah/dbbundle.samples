package com.valora.test.dbbundlejsfcontrol.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;

@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean<FormContentFilter> disableFormContentFilter(FormContentFilter filter) {
        FilterRegistrationBean<FormContentFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}
