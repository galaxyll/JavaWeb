package gh.ttms.pojo.param;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DateAndName {
    private Date showDate;
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
}
