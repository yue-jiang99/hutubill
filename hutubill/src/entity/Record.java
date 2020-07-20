package entity;

import java.util.Date;

/**
 * 消费记录类
 */

public class Record {

    private int id;             //主键
    private int spend;          //消费金额
    private int cid;            //分类id
    private String comment;     //消费备注
    private Date date;          //日期

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", spend=" + spend +
                ", cif=" + cid +
                ", comment='" + comment + '\'' +
                ", data=" + date +
                '}';
    }

    public Record(int id, int spend, int cid, String comment, Date data) {
        this.id = id;
        this.spend = spend;
        this.cid = cid;
        this.comment = comment;
        this.date = data;
    }

    public Record() {
    }

    public Record(int spend, int cid, String comment, Date data) {
        this.spend = spend;
        this.cid = cid;
        this.comment = comment;
        this.date = data;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date data) {
        this.date = data;
    }
}
