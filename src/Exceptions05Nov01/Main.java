package Exceptions05Nov01;
/*
Напишите тесты для методов doTask класса Programmer и
класса TeamLead (последний проект на занятие).
Используйте параметризованные тесты
 */


import Exceptions05Nov01.exception.ProgrammerBusyException;
import Exceptions05Nov01.exception.ProgrammerUnavailableException;

public class Main {
    public static void main(String[] args) {
        Programmer p1 = new Programmer("Jack");
        p1.setStatus(Status.UNAVAILABLE);

        try {
            System.out.println(p1.doTask("task"));

        } catch (ProgrammerBusyException e){
            System.out.println(e.getMessage());
            System.out.println("Ждем .....");
        }catch (ProgrammerUnavailableException e){
            System.out.println(e.getMessage());
            System.out.println("Срочно ищем другого .....");
        }


    }

}
