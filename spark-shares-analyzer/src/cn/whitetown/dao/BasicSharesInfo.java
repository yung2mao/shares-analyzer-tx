package cn.whitetown.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author GrainRain
 * @date 2020/04/03 11:27
 **/
public class BasicSharesInfo {
    public static boolean saveAreaAnalyzer(Map<String,Integer> areaMap){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = MysqlDaoUtil.getConnection();
            statement = connection.prepareStatement("insert into area_basic (id,province,num) values (null,?,?)");
            for(Map.Entry<String,Integer> entry:areaMap.entrySet()){
                statement.setString(1,entry.getKey());
                statement.setInt(2,entry.getValue());
                statement.addBatch();
            }
            statement.executeBatch();
            statement.clearBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            MysqlDaoUtil.close(statement,connection);
        }

    }
}
