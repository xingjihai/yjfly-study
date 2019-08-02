package spring.bean.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @org.springframework.context.annotation.Bean(name="bean")
    public Bean buildBean(){
        Bean bean =new Bean();
        bean.setProperty( "222");
        return bean;
    }
}
