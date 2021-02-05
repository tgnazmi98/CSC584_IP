package bean;

public class RecordBean {
    int id;
    int sid;
    int bid;
    String sdate;
    String edate;

    public RecordBean() {
    }

    public RecordBean(int sid, int bid, String sdate, String edate) {
        this.sid = sid;
        this.bid = bid;
        this.sdate = sdate;
        this.edate = edate;
    }

    public RecordBean(int id, int sid, int bid, String sdate, String edate) {
        this.id = id;
        this.sid = sid;
        this.bid = bid;
        this.sdate = sdate;
        this.edate = edate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }
}
