package gh.ttms.pojo.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import gh.ttms.pojo.Seat;

import java.util.Date;

public class InquireSeatStatusPojo {
    private String hallname;
    private Integer hallID;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date showDate;
    private Integer seatRow;
    private Integer seatCol;


    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(Integer seatCol) {
        this.seatCol = seatCol;
    }

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }


    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Integer getHallID() {
        return hallID;
    }

    public void setHallID(Integer hallID) {
        this.hallID = hallID;
    }
}
