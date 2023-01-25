package tasks.services;
import exceptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private final int id;
    private static int idGenerator;
    private String title;
    private final Type type;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        idGenerator++;
        this.id = idGenerator;
        setTitle(title);
        this.type = type;
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IncorrectArgumentException("Не корректная дата!");
        } else {
            this.dateTime = dateTime;
        }
        setDescription(description);

    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new IncorrectArgumentException("Введите заголовок!");
        } else {
            this.title = title;
        }
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new IncorrectArgumentException("Введите описание!");
        } else {
            this.description = description;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, dateTime, description);
    }

    @Override
    public String toString() {
        return "Задача " +
                "id = " + id +
                ", Заголовок: '" + title + '\'' +
                ", тип: " + type +
                ", дата: " + dateTime +
                ", описание: " + description;
    }

    public abstract boolean appearsIn(LocalDate localDate);

}
