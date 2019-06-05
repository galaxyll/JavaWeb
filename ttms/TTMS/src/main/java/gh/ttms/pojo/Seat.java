package gh.ttms.pojo;

import java.util.Date;

public class Seat {
    private Integer seatID;
    private Integer seatRow;
    private Integer seatColumn;
    private Integer status;
    private Date useDate;

    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }
}
