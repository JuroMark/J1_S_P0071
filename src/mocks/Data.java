package mocks;

import java.util.ArrayList;
import java.util.List;
import model.Task;

public class Data {
    public static List<Task> listdata() {
        List<Task> listdata = new ArrayList<>();
        listdata.add(new Task(1, 1, "Dev program", "28/08/2025", 8, 16, "Dev", "Lead"));
        listdata.add(new Task(2, 2, "Dev program", "28/08/2025", 8, 16, "Dev", "Lead"));
        listdata.add(new Task(3, 4, "Dev program", "28/08/2025", 8, 16, "Dev", "Lead"));
        return listdata;
    }
}