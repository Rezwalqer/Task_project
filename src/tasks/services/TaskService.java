package tasks.services;

import exceptions.TaskNotFoundException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    private final Map<Integer, Task> taskMap;
    private final Collection<Task> removedTasks;

    public TaskService() {
        this.taskMap = new HashMap<>();
        this.removedTasks = new ArrayList<>();
    }

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task remove(int id) throws TaskNotFoundException {
        if (taskMap.containsKey(id)) {
            Collections.addAll(removedTasks, taskMap.get(id));
            Task temp = taskMap.get(id);
            taskMap.remove(id);
            return temp;
        } else {
            throw new TaskNotFoundException();
        }
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {

        return taskMap.values().stream()
                .filter(task1 -> task1.appearsIn(localDate))
                .collect(Collectors.toList());

    }
}
