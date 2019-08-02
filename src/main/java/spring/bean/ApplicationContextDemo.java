package spring.bean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import spring.bean.config.Bean;
import spring.bean.config.Bean2;
import spring.bean.config.BeansConfig;

/**
 * 依赖：
 * <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-context</artifactId>
 <version>${spring-version}</version>
 </dependency>
 */
public class ApplicationContextDemo {
    public static void main(String[] args) {

        //一、初始化方式一：配置文件  FileSystemXmlApplicationContext和ClassPathXmlApplicationContext
        ApplicationContext ctx=new FileSystemXmlApplicationContext("D:\\develop\\workspace_idea_my\\yjfly-study\\src\\main\\resources\\spring\\beans.xml" );
//        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/beans.xml" );
        Bean bean =ctx.getBean("bean",Bean.class );
        bean.setProperty("111");
        System.out.println( bean.getProperty() );
        System.out.println( "BeanDefinitionCount:"+ctx.getBeanDefinitionCount() );

        //二、初始化方式二：注解配置   AnnotationConfigApplicationContext
        ApplicationContext annoCtx=new AnnotationConfigApplicationContext(BeansConfig.class);
        Bean bean1 = annoCtx.getBean("bean",Bean.class);
        System.out.println( bean1.getProperty() );

        //三、groovy方式配置
        ApplicationContext groovyCtx=new GenericGroovyApplicationContext("classpath:spring/groovy-beans.groovy");
        Bean bean2 = groovyCtx.getBean("beanDemo",Bean.class);  //getBean("bean") 会找不到
        System.out.println( bean2.getProperty() );
        Bean2 bean3 = groovyCtx.getBean("beanDemo2",Bean2.class);
        System.out.println( bean3.getChildBean() );
        System.out.println( bean3.getChildBean().getProperty() );
    }
}
