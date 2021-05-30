package com.rmit.app.config;

import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class JsonConfig implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter converter;

    @Override
    public void afterPropertiesSet() throws Exception {
        configureJacksonToFailOnUnknownProperties();
    }

    private void configureJacksonToFailOnUnknownProperties() {
        MappingJackson2HttpMessageConverter httpMessageConverter = converter.getMessageConverters().stream()
                .filter(mc -> mc.getClass()
                        .equals(MappingJackson2HttpMessageConverter.class))
                .map(mc -> (MappingJackson2HttpMessageConverter) mc)
                .findFirst()
                .get();

        httpMessageConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
