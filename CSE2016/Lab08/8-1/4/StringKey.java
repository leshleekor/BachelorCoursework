// Lab#08-04
// 2018042797 Seunghyeon Lee
public class StringKey implements Key {
    private String k;
    public StringKey(String i) {
        k = i;
    }
    public boolean equals(Key m) {
        if (m instanceof StringKey)
            return k == ((StringKey)m).getString();
        else
            return false;
    }
    public String getString() {
        return k;
    }
}
