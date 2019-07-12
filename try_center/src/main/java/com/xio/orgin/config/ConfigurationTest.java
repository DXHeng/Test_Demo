package com.xio.orgin.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MyPC
 */
@SpringBootConfiguration
public class ConfigurationTest {

    @Bean
    public Map createMap(){
        Map map = new HashMap();
        map.put("username","polarbear");
        map.put("age",25);
        return map;
    }
}