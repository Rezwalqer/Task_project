package tasks.services;

public enum Type {
    PERSONAL("Личная"),
    WORKING("Рабочая");

    private final String type;

    Type(String type) {
        this.type = type;
    }
}
