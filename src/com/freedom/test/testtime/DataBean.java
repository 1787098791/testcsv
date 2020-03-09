package com.freedom.test.testtime;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author ：wujie
 * @date ：Created in 2019/12/20 14:24
 * @description：模拟数据实体
 * @version: 1.0.0
 */
public class DataBean implements Serializable {

    private String dateStr;

    private Date date;

    private Integer count;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        DataBean dataBean = (DataBean) o;
        return dateStr.equals(dataBean.dateStr);
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "dateStr='" + dateStr + '\'' +
                ", date=" + date +
                ", count=" + count +
                '}';
    }
}
