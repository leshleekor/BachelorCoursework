// Lab#08-03
// 2018042797 Seunghyeon Lee
public class PersonFrom extends Person {
    private String city;

    public PersonFrom(String n, String c) {
        super(n);
        city = c;
    }

    public String getCity() {
        return city;
    }

    public boolean same(PersonFrom other) {
        return sameName(other) && city.equals(other.getCity());
    }

    public static void main(String[] args) {
        Person p = new Person("마음");
        PersonFrom q = new PersonFrom("소리","서울");

        System.out.println(p.sameName(q)); 
        // False 

        Person x = q; System.out.println(x.getName()); 
        // 소리

        PersonFrom x = p; System.out.println(x.getCity());
        // 오류!!

        Person x = q; System.out.println(x.getCity());
        // 오류!!

        System.out.println(q.same(p));
        // 오류!!
    }
}