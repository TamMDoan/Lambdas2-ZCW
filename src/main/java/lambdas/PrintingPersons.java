package lambdas;

import java.util.List;

public class PrintingPersons {
    public static void printPersons(List<Person> roster, CheckPerson tester){
        for(Person p : roster){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

}
