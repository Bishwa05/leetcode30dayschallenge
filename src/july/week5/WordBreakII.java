package july.week5;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII
{

    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }
    }


    public List<String> wordBreak(String s, List<String> wordDict){
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<>();
                            list.add(sub);
                            pos[j]=list;
                        } else {
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<>();
        }else{
            ArrayList<String> result = new ArrayList<>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }


    public static void main(String arg[]){

        List<String> x = new ArrayList<>();
        x.add("cat");
        x.add("cats");
        x.add("and");
        x.add("sand");
        x.add("dog");
        String s = "catsanddog";
        WordBreakII wb2 = new WordBreakII();

        wb2.wordBreak( s, x).forEach(e -> System.out.println(e));



    }
}
