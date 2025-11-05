package Exceptions05Nov01;

import Exceptions05Nov01.exception.ProgrammerBusyException;
import Exceptions05Nov01.exception.ProgrammerUnavailableException;

public class Programmer {
    private String name;
    private Status status;

    public Programmer(String name) {
        this.name = name;
        this.status = Status.AVAILABLE;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String doTask(String taskMsg){
        if (status==Status.BUSY){
            throw new ProgrammerBusyException(name + " занят другой задачей");
        }
        if (status==Status.UNAVAILABLE){
            throw new ProgrammerUnavailableException(name + " не доступен");
        }

        return taskMsg.toUpperCase();
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
