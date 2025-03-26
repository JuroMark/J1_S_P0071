package main;

import java.util.ArrayList;

import bo.TaskBO;
import mocks.Data;
import model.Task;
import utils.Validate;

public class Main {
    public static void main(String[] args) {
        TaskBO taskbo = new TaskBO(new ArrayList<>());

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Delete Task");
            System.out.println("3. Show Task");
            System.out.println("4. Load sample data");
            System.out.println("5. Exit");
            int choice = utils.Validate.getInt("Enter your choice: ",
                    "Eror!! Enter again!!",
                    "Enter again!!",
                    1, 5);
            switch (choice) {
                case 1:
                    taskbo.add();
                    break;
                case 2:
                    int deleteId = Validate.getInt(
                            "Enter id want to delete: ",
                            "Eror!! Enter again!!",
                            "Enter again!!", 1,
                            taskbo.getList().size());
                    Task task = taskbo.getTaskByCode(deleteId);
                    taskbo.delete(task);
                    break;
                case 3:
                    System.out.println("----------------------------- Task ------------------------------");
                    taskbo.display();
                    break;
                case 4:
                    taskbo.getListTask().addAll(Data.listdata());
                    System.out.println("Load sample data success");
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
            }

        }

    }
}