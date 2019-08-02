package spring.life_cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()");
    }
}
