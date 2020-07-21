package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Categoryservice {
    CategoryDAO categoryDAO = new CategoryDAO();
    RecordDAO recordDAO = new RecordDAO();


    /**
     * 获取全部的消费类别信息
     * 1）从消费类别的表中获取全部的消费类别信息（此时并没有每种类别的消费次数信息）
     * 2）遍历消费类别 以消费类别为条件查询消费记录表 并计算大小
     * @return
     */
    public List<Category> getCategoryRecordNumber(){
        List<Category> cs = new CategoryDAO().getCategory();
        for (Category category:cs){
            List<Record> rs = recordDAO.getRecord(category.getId());
            category.setRecordNumber(rs.size());
        }
        Collections.sort(cs,(c1,c2)->c2.getRecordNumber()-c1.getRecordNumber());
        return cs;
    }

    /**
     * 增加一种消费种类
     * @param name
     */
    public void add(String name){
        categoryDAO.add(new Category(name));
    }

    /**
     * 更新一种消费类别
     * @param id
     * @param name
     */
    public void update(int id,String name){
        Category c = new Category(name);
        c.setId(id);
        categoryDAO.update(c);
    }

    /**
     * 根据id删除一种消费类别
     * @param id
     */
    public void delete(int id){
        categoryDAO.delete(id);
    }
}
