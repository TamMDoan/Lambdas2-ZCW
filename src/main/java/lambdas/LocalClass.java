package lambdas;

public class LocalClass implements CheckPerson{
    @Override
    public boolean test(Person p) {
        return p.getAge() > 20;
    }
}
