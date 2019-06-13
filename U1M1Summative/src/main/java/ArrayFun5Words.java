public class ArrayFun5Words {
    public String[] return5Words(String a, String b, String c, String d, String e) {
        String[] fiveWords = new String[5];
        fiveWords[0] = a;
        fiveWords[1] = b;
        fiveWords[2] = c;
        fiveWords[3] = d;
        fiveWords[4] = e;

        for (int i = 0; i < fiveWords.length; i++){
            System.out.println(fiveWords[i]);
        }
        return fiveWords;
    }
}
