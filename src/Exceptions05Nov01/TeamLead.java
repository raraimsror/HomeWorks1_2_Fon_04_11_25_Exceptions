package Exceptions05Nov01;

import Exceptions05Nov01.exception.*;

import java.util.List;

public class TeamLead {
    private String name;
    private List<Programmer> list;
    private Status status;

    public TeamLead(String name, List<Programmer> list) {
        this.name = name;
        this.list = list;
        this.status = Status.AVAILABLE;
    }

    @Override
    public String toString() {
        return "TeamLead{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", status=" + status +
                '}';
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String doTask(String taskMsg){
        if (status==Status.BUSY){
            throw new TeamLeadBusyException(name + " занят другой задачей");
        }
        if (status==Status.UNAVAILABLE){
            throw new TeamLeadUnavailableException(name + " не доступен");
        }

        for (var p : list){
            try {
                String result = p.doTask(taskMsg);
                System.out.println(p + " решил задачу");
                return result;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        throw new TaskNotDoneException("Все программисты не доступны или заняты!");
    }


}
