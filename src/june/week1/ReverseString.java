package june.week1;

public class ReverseString {
    public void reverseString(char[] s) {

        int p2 = s.length -1;
        int p1 =0;

        while(p1<p2) {
            char c1 = s[p1];
            s[p1] = s[p2];
            s[p2] = c1;
            p1++;
            p2--;
        }

    }
}
