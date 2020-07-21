package dao;

import entity.Category;
import entity.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

        /**
         * 统计总数
         * @return
         */
        public int getTotal(){
            int total = 0;
            try (Connection conn = DBUtil.getConnection(); Statement state = conn.createStatement()){
                String sql = "select count(*) from category";
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
         * @param  category
         */
        public void add(Category category){
            String sql = "insert into category values(null,?,?) ";
            try(Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1,category.getName());
                ps.execute();
                ResultSet rs =ps.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    category.setId(id);
                }

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /**
         * 更新
         * @param category
         */
        public void update(Category category){
            String sql = "update config set key_ = ?,value = ?,where id = ?";
            try(Connection conn = DBUtil.getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(2,category.getName());
                ps.setInt(3,category.getId());

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
                String sql = "delete from category where id = ?"+id;
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
        public Category get(int id){
            Category category = null;
            try(Connection conn = DBUtil.getConnection();Statement ps = conn.createStatement()) {
                String sql = "select * from category where id = "+id;
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()){
                    category = new Category();
                    category.setId(id);
                    category.setName(rs.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return category;
        }

        /**
         * 整体查询
         * @return
         */
        public List<Category> getCategory(){
            return getCategory(0,Short.MAX_VALUE);
        }
        /**
         * 分页查询
         * @param start
         * @param count
         * @return
         */
        public List<Category> getCategory(int start,int count){
            List<Category> categories = new ArrayList<Category>();

            String sql = "select * from category order by id desc limit ?,? ";
            try(Connection conn = DBUtil.getConnection();PreparedStatement ps = conn.prepareStatement(sql)){

                ps.setInt(1,start);
                ps.setInt(2,count);

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    Category category = new Category();
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    category.setId(id);
                    category.setName(name);
                    categories.add(category);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return categories;
        }

}
