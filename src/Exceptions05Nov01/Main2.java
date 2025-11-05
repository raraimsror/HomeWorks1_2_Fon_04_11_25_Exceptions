package Exceptions05Nov01;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");
        Programmer mike = new Programmer("Mike");


        TeamLead teamLead = new TeamLead("Lena", List.of(
                jack,
                john,
                mike
        ));

        teamLead.setStatus(Status.AVAILABLE);
        jack.setStatus(Status.BUSY);
        john.setStatus(Status.UNAVAILABLE);
        mike.setStatus(Status.BUSY);


        try {
            teamLead.doTask("дан приказ ");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }





    }
}
