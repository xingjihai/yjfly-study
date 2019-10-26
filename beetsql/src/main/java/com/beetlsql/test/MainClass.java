package com.beetlsql.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.test.User;

import net.sf.json.JSONArray;

public class MainClass {
    public static void main(String[] args) {
//        String driver = "com.mysql.jdbc.Driver";
        String driver = "com.p6spy.engine.spy.P6SpyDriver";
        String url = "jdbc:mysql://localhost:3306/login_test";
        String userName = "root";
        String password = "123456";
        
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/com/beetlsql/sql 目录下
        SQLLoader loader = new ClasspathLoader("/com/beetlsql/sql");
        // 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
        // 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});


//        //使用内置的生成的sql 新增用户，如果需要获取主键，可以传入KeyHolder
//        User user = new User();
//        user.setAge(19);
//        user.setName("xiandafu");
//        sqlManager.insert(user);
//
//        //使用内置sql查询用户
//        int id = 1;
//        user = sqlManager.unique(User.class,id);
//        System.out.println( JSONObject.fromObject(user) );
//
//        //模板更新,仅仅根据id更新值不为null的列
//        User newUser = new User();
//        newUser.setId(1);
//        newUser.setAge(20);
//        sqlManager.updateTemplateById(newUser);
//
//        //模板查询
//        User query = new User();
//        query.setName("xiandafu");
//        List<User> list = sqlManager.template(query);
//
//
//        //使用user.md 文件里的select语句，参考下一节。
//        User query2 = new User();
//        query.setName("xiandafu");
//        List<User> list2 = sqlManager.select("user.select",User.class,query2);
        
        
        
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name","xiandafu");
        paramMap.put("age","19");
        List<User> list3 = sqlManager.select("user.select",User.class,paramMap);
        System.out.println( JSONArray.fromObject(list3) );
        // 这一部分需要参考mapper一章
//        UserDao dao = sqlManager.getMapper(UserDao.class);
//        List<User> list3 = dao.select(query2);
    }
}
