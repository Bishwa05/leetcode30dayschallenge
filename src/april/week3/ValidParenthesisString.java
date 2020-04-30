package april.week3;

public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        int noOpening =0;
        int noAst =0;
        int noClosing =0;
        int noAstBackward =0;
        int n = s.length();

        if(s.length() ==0) return true;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                noOpening++;
            } else if(c =='*'){
                noAst++;
            } else{

                if(noOpening>0){
                    noOpening--;
                }else if(noAst>0){
                    noAst--;
                } else {
                    return false;
                }
            }

            c = s.charAt(n-1-i);

            if(c == ')'){
                noClosing++;
            } else if(c =='*'){
                noAstBackward++;
            } else{

                if(noClosing>0){
                    noClosing--;
                }else if(noAstBackward>0){
                    noAstBackward--;
                } else {
                    return false;
                }
            }

        }


        return true;
    }

    public static void main(String arg[]){
        //String s ="(())((())()()(*)(*()(())())())()()((()())((()))(*";
        String s = "()()";
        System.out.println(checkValidString(s));
    }
}
