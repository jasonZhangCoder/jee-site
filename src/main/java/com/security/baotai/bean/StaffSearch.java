package com.security.baotai.bean;

import java.util.Date;

public class StaffSearch {
    private Integer start;

    private Integer maxRows;

    private Date entryDateStart;

    private Date entryDateEnd;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    public Date getEntryDateStart() {
        return entryDateStart;
    }

    public void setEntryDateStart(Date entryDateStart) {
        this.entryDateStart = entryDateStart;
    }

    public Date getEntryDateEnd() {
        return entryDateEnd;
    }

    public void setEntryDateEnd(Date entryDateEnd) {
        this.entryDateEnd = entryDateEnd;
    }

}
