package com.example.prod;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
@Entity (tableName = "task_table")
public class Task {
    @PrimaryKey
    private String name;
    private Integer XP;
    private String descript;
    private Date dateStart;
    private Date dateEnd;
    private Boolean isDone;
    private ArrayList<Task> subTask;
    public Task(String name, Integer XP, String descript, Date dateStart,
                Date dateEnd, ArrayList<Task> subTask) {
        this.name = name;
        this.XP = XP;
        this.descript = descript;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.subTask = subTask;
        this.isDone = false;
        for (Task sbt: subTask) {
            sbt.setDone(false);
        }
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setSubTask(ArrayList<Task> subTask) {
        this.subTask = subTask;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getXP() {
        return XP;
    }

    public void setXP(Integer XP) {
        this.XP = XP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
