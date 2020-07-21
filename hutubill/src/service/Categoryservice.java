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
     * ��ȡȫ�������������Ϣ
     * 1�����������ı��л�ȡȫ�������������Ϣ����ʱ��û��ÿ���������Ѵ�����Ϣ��
     * 2������������� ���������Ϊ������ѯ���Ѽ�¼�� �������С
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
     * ����һ����������
     * @param name
     */
    public void add(String name){
        categoryDAO.add(new Category(name));
    }

    /**
     * ����һ���������
     * @param id
     * @param name
     */
    public void update(int id,String name){
        Category c = new Category(name);
        c.setId(id);
        categoryDAO.update(c);
    }

    /**
     * ����idɾ��һ���������
     * @param id
     */
    public void delete(int id){
        categoryDAO.delete(id);
    }
}
