package dao;

import entity.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO {
    /**
     * 统计总数
     * @return
     */
    public int getTotal(){
        int total = 0;
        try (Connection conn = DBUtil.getConnection();Statement state = conn.createStatement()){
            String sql = "select count(*) from config";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total"+total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 增加
     * @param config
     */
    public void add(Config config){
        String sql = "insert into config values(null,?,?) ";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,config.getKey());
            ps.setString(2,config.getValue());


            if(	ps.executeUpdate()>0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    config.setId(id);
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param config
     */
    public void update(Config config){
        String sql = "update config set key_ = ?,value = ? where id = ?";
        try(Connection conn = DBUtil.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,config.getKey());
            ps.setString(2,config.getValue());
            ps.setInt(3,config.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id){
        try (Connection conn =DBUtil.getConnection();Statement ps =conn.createStatement()){
            String sql = "delete from config where id = ?"+id;
            ps.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    public Config get(int id){
        Config config = null;
        try(Connection conn = DBUtil.getConnection();Statement ps = conn.createStatement()) {
            String sql = "select * from config where id = "+id;
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()){
                config = new Config();
                String key = rs.getString("key_");
                String value = rs.getString("value");
                config.setKey(key);
                config.setValue(value);
                config.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    /**
     * 整体查询
     * @return
     */
    public List<Config> list(){
        return list(0,Short.MAX_VALUE);
    }
    /**
     * 分页查询
     * @param start
     * @param count
     * @return
     */
    public List<Config> list(int start,int count){
        List<Config> configs = new ArrayList<Config>();

        String sql = "select * feom config order by id desc limit ?,? ";
        try(Connection conn = DBUtil.getConnection();PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Config config = new Config();
                int id = rs.getInt(1);
                String key = rs.getString("key_");
                String value = rs.getString("value");
                config.setId(id);
                config.setKey(key);
                config.setValue(value);
                configs.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return configs;
    }
    public Config getByKey(String key){
        Config config = null;
        String sql = "select * from config where key_ = ?";
        try(Connection conn = DBUtil.getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,key);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                config = new Config();
                config.setKey(key);
                config.setId(rs.getInt("id"));
                config.setValue(rs.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

}
