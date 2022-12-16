package com.sunwing.platform.cloud.robbon.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class RibbonConfig {

    @Bean
    private IRule rule(){
        return  new RandomRule();
    }

}
