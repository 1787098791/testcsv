package com.freedom.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private Connection connection;
    private static DataSource dataSource;
    static {
        //创建属性流
        Properties prop = new Properties();
        //加载配置文件
        try {
            prop.load(new FileInputStream("db.properties"));
            /*HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDataSourceProperties(prop);
            dataSource = new HikariDataSource(hikariConfig);*/
            //创建Druid连接池
             dataSource = DruidDataSourceFactory.createDataSource(prop);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public  Connection getConnection(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public  void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
