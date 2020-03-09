package com.freedom.test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * @author ：wujie
 * @date ：Created in 2019/10/30 11:43
 * @description：任务类
 * @version:
 */
public class TaskThread implements Serializable,Runnable {

    /**
     * 码号
     */
    private List<String> code;

    /**
     * 记录标记
     */
    private Integer tag=0;


    private DBUtils dbUtils;

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public DBUtils getDbUtils() {
        return dbUtils;
    }

    public void setDbUtils(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    //标志加锁
    public synchronized  int getTag() {
        return tag++;
    }

    @Override
    public void run() {
        Connection connection=dbUtils.getConnection();
        PreparedStatement preparedStatement=null;
        int theTag=0;
        while((theTag=getTag())<code.size()){
            //System.out.println(theTag);
            try{
                String theCode = code.get(theTag);
                connection.setAutoCommit(false);
                String sql="insert into ec_coupon_unique_code\n" +
                        "                    (id,coupon_id,unique_code,lock_status,tenant_code,created_at,created_by)\n" +
                        "            values\n" +
                        "                    (?,?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, UUID.randomUUID().toString().replaceAll("-",""));
                preparedStatement.setString(2,"wj");
                preparedStatement.setString(3,"wj_"+theCode);
                preparedStatement.setInt(4,0);
                preparedStatement.setString(5,"tt");
                long time = new java.util.Date().getTime();
                preparedStatement.setDate(6,new Date(time));
                preparedStatement.setString(7,"wj");
                preparedStatement.execute();

                connection.commit();
            }catch (Exception e){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                throw new RuntimeException(e);
            }
            finally {
                if (preparedStatement!=null){
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        dbUtils.close(connection);
    }
}
