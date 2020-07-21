package gui.model;

import entity.Category;
import service.Categoryservice;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CategoryTableModel implements TableModel {

    String[] columnNames = new String[]{"��������","���Ѵ���"};
    public List<Category> cs = new Categoryservice().getCategoryRecordNumber();
    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category = cs.get(rowIndex);
        if (0 == columnIndex){
            return category.getName();
        }
        if (1 == columnIndex){
            return category.getRecordNumber();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
