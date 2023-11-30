package lambdas;

import java.time.LocalDate;

public class Person {
    int age;
    private String name;
    private String email;
    private LocalDate birthday;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setBirthday(LocalDate date) {
        this.birthday = date;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void printPerson() {
        System.out.println("Person print placeholder");
    }
}
