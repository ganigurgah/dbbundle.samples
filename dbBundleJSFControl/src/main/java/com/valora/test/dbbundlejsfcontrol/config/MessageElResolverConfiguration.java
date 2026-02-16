package com.valora.test.dbbundlejsfcontrol.config;

import com.valora.dbbundle.el.JsfMessageELResolver;
import com.valora.dbbundle.service.DbBundleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageElResolverConfiguration {

    @Autowired
    private DbBundleService dbBundleService;

    @PostConstruct
    public void registerELResolver() {
        JsfMessageELResolver.setStaticDbBundleService(dbBundleService);
    }
}
