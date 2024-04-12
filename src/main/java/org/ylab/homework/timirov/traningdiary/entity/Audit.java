package org.ylab.homework.timirov.traningdiary.entity;

import java.time.LocalDateTime;

public class Audit {
    private String action;
    private LocalDateTime date;

    public Audit(String action, LocalDateTime date) {
        this.action = action;
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
