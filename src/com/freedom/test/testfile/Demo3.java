package com.freedom.test.testfile;



import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author ：wujie
 * @date ：Created in 2019/10/30 11:37
 * @description：测试连接池
 * @version: 1.0.0
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("db.properties"));
        //创建Druid连接池
        //DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接

    }
}
