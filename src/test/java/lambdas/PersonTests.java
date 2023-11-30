package lambdas;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Date;


public class PersonTests {


    @Test
    public void testPersonConstructor(){
        Person person = new Person();
        Assert.assertNotNull(person);
    }

    @Test
    public void testPersonGetAge(){
        Person person = new Person();
        int expected = 23;
        person.setAge(expected);
        int actual = person.getAge();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPersonGetName(){
        Person person = new Person();
        String expected = "Tam";
        person.setName(expected);
        String actual = person.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPersonGetEmail(){
        Person person = new Person();
        String expected = "thisIsAn3m41l@email.com";
        person.setEmail(expected);
        String actual = person.getEmail();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPersonGetBirthday(){
        Person person = new Person();
        LocalDate date = LocalDate.of(2000, 2, 20);
        person.setBirthday(date);
        LocalDate actual = person.getBirthday();

        Assert.assertEquals(date, actual);

    }

    /*
     * Found this online to try and test souts
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;
    private final PrintStream printStream2 = System.err;

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(outputStream2));
    }

    @After
    public void restoreStreams(){
        System.setOut(printStream);
        System.setErr(printStream2);
    }

    @Test
    public void testPersonPrintPerson(){
        Person person = new Person();
        person.setName("Tam");
        person.setAge(24);
        person.setBirthday(LocalDate.of(2000, 2, 20));
        person.setEmail("email@email.com");

        person.printPerson();

        Assert.assertEquals("", outputStream.toString());

    }
}
