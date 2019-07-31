package com.trilogyed.tasker.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {
    private int id;
//    @NotEmpty(message = "Description required")
    private String description;
//    @NotNull(message = "Date must be a valid input")
    private LocalDate createDate;
//    @NotNull(message = "Date must be a valid input")
    private LocalDate dueDate;
//    @NotEmpty(message = "Category required")
    private String category;
    private String advertisement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel task = (TaskViewModel) o;
        return id == task.id &&
                Objects.equals(description, task.description) &&
                Objects.equals(createDate, task.createDate) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(category, task.category)&&
                Objects.equals(advertisement, task.advertisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category, advertisement);
    }

}
