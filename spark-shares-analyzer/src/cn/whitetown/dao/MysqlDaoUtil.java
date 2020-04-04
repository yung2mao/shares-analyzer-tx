package cn.whitetown.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author GrainRain
 * @date 2020/04/03 11:18
 **/
public class MysqlDaoUtil {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static void close(AutoCloseable ... autoCloseables){
        for(AutoCloseable autoCloseable:autoCloseables){
            if(autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    throw new RuntimeException();
                }finally {
                    autoCloseable = null;
                }
            }
        }
    }
}
