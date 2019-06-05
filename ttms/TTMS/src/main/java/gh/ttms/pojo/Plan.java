package gh.ttms.pojo;

import java.util.Date;

public class Plan {
    private String moviename;
    private Integer hallID;
    private Date playDate;
    private Double ticketPrice;

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public Integer getHallID() {
        return hallID;
    }

    public void setHallID(Integer hallID) {
        this.hallID = hallID;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
