package may21.week4;

public class ToLowerCase
{
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c>='A' && c<='Z') {
                char x = (char)('a'+ c -'A');
                sb.append(x);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
