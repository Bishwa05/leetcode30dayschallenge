package may21.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given a list paths of directory info, including the directory path, and all the files with contents in this directory, return all the duplicate files in the file system in terms of their paths. You may return the answer in any order.
 *
 * A group of duplicate files consists of at least two files that have the same content.
 *
 * A single directory info string in the input list has the following format:
 *
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 *
 * The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:
 *
 * "directory_path/file_name.txt"
 *
 */

public class FindDuplicateFileInSystem
{
    public void addToMap(Map<String, List<String>> root, String key, String dir, String a){

        if(root.containsKey(key)){
            List<String> l = root.get(key);
            l.add(dir+"/"+ a.substring(0, a.indexOf("(")));
        } else{
            List<String> l = new ArrayList<>();
            l.add(dir+"/"+ a.substring(0, a.indexOf("(")));
            root.put(key, l);
        }

    }
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> root = new HashMap<>();

        for(String path : paths){
            String [] arr = path.split(" ");



            if(arr.length ==2){
                String a = arr[1];
                String key = a.substring(a.indexOf("("), a.indexOf(")"));
                addToMap(root, key, arr[0], a);
            } else{
                for(int i =1; i<arr.length; i++){
                    String a = arr[i];
                    String key = a.substring(a.indexOf("("), a.indexOf(")"));
                    addToMap(root, key, arr[0], a);
                }

            }


        }

        List<List<String>> res = new ArrayList<>();
        for(List<String>d : root.values()){
            System.out.println(d);
            if(d.size()>1)
                res.add(d);
        }
        return res;

    }
}
