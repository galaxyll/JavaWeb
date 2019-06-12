package gh.ttms.pojo;

public class Hall {
    private Integer hallID;
    private String hallname;
    private String type;
    private Integer hallRow;
    private Integer hallColumn;
    private String status;

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getHallRow() {
        return hallRow;
    }

    public void setHallRow(Integer hallRow) {
        this.hallRow = hallRow;
    }

    public Integer getHallColumn() {
        return hallColumn;
    }

    public void setHallColumn(Integer hallColumn) {
        this.hallColumn = hallColumn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Integer getHallID() {
        return hallID;
    }

    public void setHallID(Integer hallID) {
        this.hallID = hallID;
    }
}
