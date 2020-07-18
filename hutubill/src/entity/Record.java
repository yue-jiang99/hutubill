package entity;

import javax.xml.crypto.Data;

/**
 * 消费记录类
 */

public class Record {

    private int id;             //主键
    private int spend;          //消费金额
    private int cif;            //分类id
    private String comment;     //消费备注
    private Data data;          //日期

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", spend=" + spend +
                ", cif=" + cif +
                ", comment='" + comment + '\'' +
                ", data=" + data +
                '}';
    }

    public Record(int id, int spend, int cif, String comment, Data data) {
        this.id = id;
        this.spend = spend;
        this.cif = cif;
        this.comment = comment;
        this.data = data;
    }

    public Record() {
    }

    public Record(int spend, int cif, String comment, Data data) {
        this.spend = spend;
        this.cif = cif;
        this.comment = comment;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getCif() {
        return cif;
    }

    public void setCif(int cif) {
        this.cif = cif;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
