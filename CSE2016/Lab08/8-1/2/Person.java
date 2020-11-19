// Lab#08-01
// 2018042797 Seunghyeon Lee
public class Person {
    private String name;

    public Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public boolean sameName(Person other) {
        return getName().equals(other.getName());
    }
}