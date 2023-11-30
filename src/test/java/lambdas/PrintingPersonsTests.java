package lambdas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PrintingPersonsTests {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;
    private final PrintStream printStream2 = System.err;
    public List<Person> personList;

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(outputStream2));
    }
    @Before
    public void setUp(){
        personList = new ArrayList<>();
        Person person = new Person();
        person.setName("Tam");
        person.setAge(19);
        person.setBirthday(LocalDate.of(2000,2,20));
        person.setSex(Person.Sex.FEMALE);
        Person person2 = new Person();
        person2.setBirthday(LocalDate.of(2015,1,5));
        person2.setName("Maria");
        person2.setAge(42);
        person2.setSex(Person.Sex.MALE);

        personList.add(person);
        personList.add(person2);
    }

    @After
    public void restoreStreams(){
        System.setOut(printStream);
        System.setErr(printStream2);
    }
    @Test
    public void testPrintingPersonsPrint(){
        LocalClass localClass = new LocalClass();

        // LocalClass's test checks to see if a person's age is > 20
        PrintingPersons.printPersons(personList, localClass);

        Assert.assertEquals("Person " + personList.get(1).getName() + " print placeholder", outputStream.toString().trim());

    }

    @Test
    public void testPrintPersonsPrintWithAnon(){
        // THIS IS THE ANON (I think) VVVVVVV
        CheckPerson anonTest = new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getName().length() < 4;
            }
        };

        PrintingPersons.printPersons(personList, anonTest);

        Assert.assertEquals("Person " + personList.get(0).getName() + " print placeholder", outputStream.toString().trim());

    }

    @Test
    public void testPrintingPersonWithLambda(){
        LocalDate dateToCompare = LocalDate.of(2010,1,1);

        personList.forEach((p) -> {
            if(p.getBirthday().isBefore(dateToCompare)){
                p.printPerson();
        }});

        Assert.assertEquals("Person " + personList.get(0).getName() + " print placeholder", outputStream.toString().trim());
    }
}
