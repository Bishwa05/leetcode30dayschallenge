package august;

public class DetectCapital
{
    public boolean detectCapitalUse(String word) {
        boolean capitalFound = true;
        boolean smallFound = true;
        boolean fChar = false;

        for(int i=0; i< word.length(); i++){
            if(word.charAt(i)>= 65 && word.charAt(i)< 65+26){
                smallFound = false;
                if(i==0){
                    fChar = true;
                    smallFound = true;
                }

            }

            if(word.charAt(i)>= 97 && word.charAt(i)< 97+26){
                capitalFound = false;
            }

        }

        if(smallFound || capitalFound || fChar && smallFound){
            return true;
        }
        return false;
    }
}
