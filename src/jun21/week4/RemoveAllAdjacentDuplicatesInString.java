package jun21.week4;

public class RemoveAllAdjacentDuplicatesInString
{
    public String removeDuplicates(String s) {

        char[] cArr = s.toCharArray();

        Stack<Character> st = new Stack();
        int n = cArr.length;
        st.add(cArr[0]);
        for(int i =1; i<n; i++){
            if(!st.isEmpty()){
                if(cArr[i] != st.peek()){
                    st.add(cArr[i]);
                } else{
                    st.pop();
                }
            } else{
                st.add(cArr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }
}
