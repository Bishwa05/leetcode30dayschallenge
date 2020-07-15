package july.week3;

public class ReverseWordsInAString
{

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] a = s.split(" ");
        for(int i = a.length-1; i>=0; --i){
            String s1 = a[i].trim();
            if(!"".equals(s1)) {
                sb.append(s1);
                if(i>0){
                    sb.append(" ");
                }
            }

        }
        return sb.toString().trim();

    }

    public static void main(String args[]){
        ReverseWordsInAString r = new ReverseWordsInAString();

        System.out.println(r.reverseWords("  hello world!  "));
    }
}
