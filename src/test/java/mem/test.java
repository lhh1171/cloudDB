package mem;

public class test {
    public static void main(String[] args) {
        String a="aaaa";
        String b="aaaa";
        String c="aaab";
        String d="aa";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(d.hashCode());
    }

}

//    /** Cache the hash code for the string */
//    private int hash; // Default to 0
//    public int hashCode() {
//        int h = hash;
//        if (h == 0 && value.length > 0) {
//            char val[] = value;
//
//            for (int i = 0; i < value.length; i++) {
//                h = 31 * h + val[i];
//            }
//            hash = h;
//        }
//        return h;
//    }