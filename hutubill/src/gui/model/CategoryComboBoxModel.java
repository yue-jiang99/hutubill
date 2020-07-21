package gui.model;

import entity.Category;
import service.Categoryservice;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    public List<Category> cs = new Categoryservice().getCategoryRecordNumber();
    Category c;

    public CategoryComboBoxModel() {
        /**
         * 默认选择第一个
         * 即数据库记录里面的最后一个
         */
        if(!cs.isEmpty()){
            c = cs.get(0);
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category)anItem;
    }

    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty()){
            return c;
        }else{
            return null;
        }
    }


    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
