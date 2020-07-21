package service;


import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Date;

public class Recordservice {
    public void add(int spend, Category c, String comment, Date date){
        new RecordDAO().add(new Record(spend,c.getId(),comment,date));
    }
}
