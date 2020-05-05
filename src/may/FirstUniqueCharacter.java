package may;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int arr[] = new int[26];

        for(char c: s.toCharArray()){
            arr[c-'a']+=1;
        }

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(arr[c-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
