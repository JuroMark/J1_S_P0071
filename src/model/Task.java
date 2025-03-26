package model;

import bo.TaskBO;
import utils.Validate;
import constant.IMessage;
import constant.IConstant;

import java.time.LocalDate;

public class Task {
    private static int count;
    private int id;
    private int taskTypeId;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    public Task() {
        this.id = ++count;
    }

    public Task(int id,
            int taskTypeId,
            String requirementName,
            String date,
            double planFrom,
            double planTo,
            String assign,
            String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void input(TaskBO task) {
        this.id = ++count;
        this.taskTypeId = Validate.getInt(
                "Enter task type id: ",
                IMessage.ENTER_AGAIN,
                IMessage.ENTER_AGAIN,
                1,
                4);
        this.requirementName = Validate.getString(
                "Enter requirement name: ",
                IConstant.REGULAR_STRING,
                IMessage.ENTER_AGAIN);
        this.date = Validate.getDate(
                "Enter date: ",
                "Date out of range!",
                "Enter again!",
                "dd/MM/yyyy",
                LocalDate.MIN, LocalDate.MAX);

        do {
            this.planFrom = Validate.getDouble(
                    "Enter plan from: ",
                    IMessage.ENTER_AGAIN,
                    IMessage.ENTER_AGAIN,
                    8,
                    17.5);
            this.planTo = Validate.getDouble(
                    "Enter plan to: ",
                    IMessage.ENTER_AGAIN,
                    IMessage.ENTER_AGAIN,
                    this.planFrom,
                    this.planFrom + 8);
            if (this.planTo > 17.5) {
                System.out.println(IMessage.ENTER_AGAIN);
            }
        } while (this.planTo > 17.5);
        this.assign = utils.Validate.getString(
                "Enter assign: ",
                IConstant.REGULAR_STRING,
                IMessage.ENTER_AGAIN);
        this.reviewer = utils.Validate.getString(
                "Enter reviewer",
                IConstant.REGULAR_STRING,
                IMessage.ENTER_AGAIN);
    }

    public void display() {
        System.out.printf("%-5d%-15s%-5d%-15s%-8.1f%-10s%-10s\n",
                this.id,
                this.requirementName,
                this.taskTypeId,
                this.date,
                this.planTo - this.planFrom,
                this.assign,
                this.reviewer);

    }

}
