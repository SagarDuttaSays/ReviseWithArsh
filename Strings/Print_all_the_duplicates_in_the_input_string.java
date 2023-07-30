//Print all the duplicates in the input string
//My Code:
import java.util.* ;
import java.io.*; 
import java.util.*;
/****
 * Following is the java Pair class
 * class Pair{
    char alphabet;
    int count;
    Pair(char ch, int x){
        this.alphabet = ch;
        this.count = x;
    }
}
 */


public class Solution {

    public static ArrayList<Pair> duplicate_char(String s, int n) {
        ArrayList<Pair> list = new ArrayList<Pair>();
        char ch[] = s.toCharArray();
        Arrays.sort(ch);
        int c = 1;
        for(int i = 1; i<n; i++){
            if(ch[i-1]==ch[i])
             c++;
            else {
                if(c>1)
                    list.add(new Pair(ch[i-1], c));
                c = 1;
            }
        }
        if(c>1)
         list.add(new Pair(ch[n-1], c));
        return list;
    }
}
