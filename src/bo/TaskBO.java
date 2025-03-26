package bo;

import java.util.Comparator;
import java.util.List;
import model.Task;

public class TaskBO {
    private List<Task> list;

    public TaskBO() {
    }

    public TaskBO(List<Task> list) {
        this.list = list;
    }

    public List<Task> getList() {
        return list;
    }

    public void setList(List<Task> list) {
        this.list = list;
    }

    public boolean add() {
        Task task = new Task();
        task.input(this);
        return list.add(task);
    }

    public void delete(Task task) {
        list.remove(task);
    }

    public Task getTaskByCode(int code) {
        for (Task task : list) {
            if (task.getId() == code) {
                return task;
            }
        }
        return null;
    }

    public void display() {
        String header = String.format(
                "%-5s %-15s %-10s %-12s %-8s %-10s %-10s",
                "ID", "Name", "TaskType", "Date", "Time", "Assignee", "Reviewer");
        System.out.println(header);
        list.sort(Comparator.comparingInt(Task::getId));
        for (Task task : list) {
            task.display();
        }
    }

    public List<Task> getListTask() {
        return list;
    }
}
