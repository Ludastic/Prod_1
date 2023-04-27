package com.example.prod;

public class ListEntity {
    private final String tName;
    private final String stName;
    private final String stText;

    public ListEntity(String taskName, String subtaskName, String subtaskText) {
        this.tName = taskName;
        this.stName = subtaskName;
        this.stText = subtaskText;
    }

    public String GettaskName() {
        return tName;
    }
    public String GetSubtaskName() {
        return stName;
    }
    public String GetSubtaskText() {
        return stText;
    }

}
