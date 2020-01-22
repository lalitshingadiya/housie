package com.game.housie.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyReader {


    @Autowired
    Environment env;

    @Value("${customname}")
    private String customname;


    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname;
    }
// @Autowired
  //  private Environment env;


    public void getAllProperty(){
        System.out.println(customname);
       System.out.println(env.getProperty("server.servlet.contextPath"));
    }
}
