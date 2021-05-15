package may21.week3;

public class ValidNumber
{
    public boolean isNumber(String s)
    {

        if (s == null || s.trim().length() == 0)
            return false;

        boolean numberSeen = false;
        boolean eSeen = false;
        boolean decimalSeen = false;

        s = s.trim();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
            case '.':
                if (decimalSeen || eSeen)
                    return false;
                decimalSeen = true;
                break;
            case 'E':
            case 'e':
                if (eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberSeen = false;
                break;
            case '+':
            case '-':
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
                numberSeen = false;
                break;
            default:
                if (c >= '0' && c <= '9')
                    numberSeen = true;
                else return false;
            }

        }

        return numberSeen;
    }
}
