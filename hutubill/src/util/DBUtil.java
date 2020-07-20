package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  数据库工具类
 *  1)提供一个数据库连接的方式
 *  2)关闭连接dec的操作在DAO层实现
 */
public class DBUtil {
    public static final String driver = "com.mysql.jdbc.Driver";
    static String setSSL = "flase";
    static String ip = "localhost";
    static int port = 3306;
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";

    /**
     * 静态代码块未加载
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败!");
        }
    }
    /**
     * 返回一个连接 若连接创建失败则返回一个空值
     * @return
     */
    public static Connection getConnection(){
        try {
            String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&useSSL=%s", ip, port, database, encoding,setSSL);
            return DriverManager.getConnection(url, loginName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
