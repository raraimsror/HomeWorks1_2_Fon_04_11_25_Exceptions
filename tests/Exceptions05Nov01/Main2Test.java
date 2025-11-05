package Exceptions05Nov01;

import Exceptions05Nov01.exception.TaskNotDoneException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;


class Main2Test {
    @Test
    void positiveExceptionTestImMain2() {
        Programmer jack = new Programmer("Jack");
        Programmer john = new Programmer("John");
        Programmer mike = new Programmer("Mike");

        jack.setStatus(Status.BUSY);
        john.setStatus(Status.UNAVAILABLE);
        mike.setStatus(Status.BUSY);

        TeamLead teamLead = new TeamLead("Lena", List.of(jack, john, mike));
        teamLead.setStatus(Status.AVAILABLE);


        assertThrows(TaskNotDoneException.class, () -> {
            teamLead.doTask("дан приказ");
        });
}

}

