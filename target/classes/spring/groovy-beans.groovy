import spring.bean.config.Bean2
import spring.bean.config.Bean

beans {
    beanDemo(Bean){
        property="3333"
    }

    beanDemo2(Bean2){
        childBean=new Bean()
    }
}
