package sept.week3;

public class LengthOfLastWord
{
    public int lengthOfLastWord(String s) {
        if(s.trim().length()==0) return 0;

        String [] l = s.split(" ");
        //if(l.length <=1) return 0;

        String f = l[l.length-1];
        return f.length();
    }
}
