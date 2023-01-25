import exceptions.TaskNotFoundException;
import tasks.services.Type;
import tasks.DailyTask;
import tasks.MonthlyTask;
import tasks.WeeklyTask;
import tasks.YearlyTask;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        MonthlyTask monthlyTask1 = new MonthlyTask("Title", Type.WORKING, LocalDateTime.of(2023, 1, 29, 18, 0), "Описание задачи");
        WeeklyTask weeklyTask1 = new WeeklyTask("Title", Type.WORKING, LocalDateTime.of(2023, 4, 25, 15, 0), "Описание задачи");
        YearlyTask yearlyTask1 = new YearlyTask("Title", Type.WORKING, LocalDateTime.of(2023, 3, 21, 11, 15), "Описание задачи");
        DailyTask dailyTask1 = new DailyTask("Title4", Type.WORKING, LocalDateTime.of(2023, 2, 23, 12,20), "Описание");
        DailyTask dailyTask2 = new DailyTask("asd", Type.WORKING, LocalDateTime.of(2023, 2, 12, 12,20), "Описание");

        tasks.services.TaskService taskService = new tasks.services.TaskService();
        taskService.add(monthlyTask1);
        taskService.add(weeklyTask1);
        taskService.add(yearlyTask1);
        taskService.add(dailyTask1);

//        try {
//            DailyTask dailyTask4 = new DailyTask("", Type.WORKING, LocalDateTime.of(2023, 2, 14, 12,20), "Описание");
//            taskService.add(dailyTask4);
//        } catch (Exception e) {
//            System.out.println("Проверьте правильность введения данных!");
//        }
//
//        System.out.println(taskService.getAllByDate(LocalDate.of(2023, 5, 16)));
        System.out.println(monthlyTask1.appearsIn(LocalDate.of(2023, 1, 20)));

        try {
            taskService.remove(1);
        } catch (TaskNotFoundException e) {
            System.out.println("Id не существует. Введите корректный id");
        }
//        System.out.println(taskService.getAllByDate(LocalDate.of(2023,2,14)));



    }
}