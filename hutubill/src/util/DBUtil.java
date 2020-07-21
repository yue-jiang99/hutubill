package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  ���ݿ⹤����
 *  1)�ṩһ�����ݿ����ӵķ�ʽ
 *  2)�ر�����dec�Ĳ�����DAO��ʵ��
 */
public class DBUtil {

    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";

    /**
     * ��̬�����δ����
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("��������ʧ��!");
        }
    }
    /**
     * ����һ������ �����Ӵ���ʧ���򷵻�һ����ֵ
     * @return
     */
    public static Connection getConnection(){
        try {
            String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
            return DriverManager.getConnection(url, loginName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
