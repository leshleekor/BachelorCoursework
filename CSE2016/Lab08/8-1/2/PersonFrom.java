// Lab#08-01
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
      System.out.println(q.getCity()); 
      // 서울 
      System.out.println(p.getName()); 
      // 마음
      System.out.println(p.sameName(p)); 
      // True
      System.out.println(q.sameName(p)); 
      // False
      System.out.println(q.same(q)); 
      // True
    }
}