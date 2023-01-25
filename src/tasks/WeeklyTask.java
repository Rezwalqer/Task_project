package tasks;

import tasks.services.Task;
import tasks.services.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {

        return localDate.isEqual(getDateTime().toLocalDate())
                || localDate.getDayOfWeek() == getDateTime().getDayOfWeek()
                && localDate.isAfter(getDateTime().toLocalDate());
    }
}
