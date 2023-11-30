package lambdas;

import org.junit.Assert;
import org.junit.Test;

public class LocalClassTests {
    @Test
    public void testLocalClassConstructor(){
        LocalClass localClass = new LocalClass();
        Assert.assertNotNull(localClass);
    }

    @Test
    public void testLocalClassInstanceCheckPerson(){
        LocalClass localClass = new LocalClass();
        Assert.assertTrue(localClass instanceof CheckPerson);
    }

    @Test
    public void testLocalClassTestFalse(){
        LocalClass localClass = new LocalClass();
        Person person = new Person();
        person.setAge(20);

        Assert.assertFalse(localClass.test(person));
    }

    @Test
    public void testLocalClassTestTrue(){
        LocalClass localClass = new LocalClass();
        Person person = new Person();
        person.setAge(30);

        Assert.assertTrue(localClass.test(person));
    }

}
