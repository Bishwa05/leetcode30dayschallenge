package may;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] intArr = new int[26];

        for(char c : magazine.toCharArray()){
            intArr[c-'a']+=1;
        }

        for(char c : ransomNote.toCharArray()){
            intArr[c-'a']-=1;
        }

        for(int x: intArr){
            if(x<0){
                return false;
            }
        }
        return true;

    }
}
