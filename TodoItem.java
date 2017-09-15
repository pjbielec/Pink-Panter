package com.przemyslawjbielec.pinkpanter.datamodel;

import java.time.LocalDate;

/**
 * Created by Przemek on 07.07.2017.
 */
public class TodoItem {

    private String shortDescription;
    private String longDescription;
    private LocalDate deadline;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public TodoItem(String shortDescription, String longDescription, LocalDate deadline) {

        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
}
