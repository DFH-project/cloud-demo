package cn.itcast.feign.config;

import org.springframework.context.annotation.Bean;


public class FeignConfiguration {

    @Bean
    public feign.Logger.Level feignLoggerLevel(){
        return feign.Logger.Level.NONE;
    }

}
