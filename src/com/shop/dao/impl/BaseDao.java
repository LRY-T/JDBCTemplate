package com.shop.dao.impl;
import java.sql.*;
/*
*JDBC操作模板：所有关于CRUD（增删改查）的操作
 */
public class BaseDao {
    //声明JDBC接口
    protected Connection connection;//声明数据库连接对象
    protected PreparedStatement pst;//声明数据库运输车对象
    protected ResultSet res;//声明存储数据的结果集
    /*
    *获取数据库连接
     */
    public void getConnection(){
        String URL = "jdbc:mysql://localhost:3306/smbms?serverTimezone=UTC";
        String User = "root";
        String password = "123456";
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库的连接
            connection = DriverManager.getConnection(URL,User,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    *关闭资源
     */
    public void closeAll(){
        if (res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
    *通用增删改功能
    * @param sql:要执行的语句
    * @param params:占位符对应的数值
    * @return 影响命令的行数
     */
    public int executeUpdate(String sql,Object[]params){
        //连接数据库
        getConnection();
        //发送数据库语句
        try {
            pst = connection.prepareStatement(sql);
            //为占位符赋值
            if (params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject((i+1),params[i]);
                }
            }
            return pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeAll();
        }
    }

    /**
     * 通用查询功能
     * @param sql:要执行的语句
     * @param params:占位符对应的数值
     * @return 结果集
     */
    public ResultSet executeQuery(String sql,Object[] params){
        getConnection();
        try {
            pst = connection.prepareStatement(sql);
            if (params != null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            return pst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
