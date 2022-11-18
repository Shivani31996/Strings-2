// Time Complexity:O(length of string s)
// Space Complexity: O(1) because HashMap will have a maximum of 26 entries which is constant
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * 1 - The idea is to have a HashMap of string p so that search will be O(1) when we iterate over string s
 * 2 - Now, We have a sliding window has two pointers. i is the fast pointer and the slow pointer is calculated.
 * 3 - Instead of checking each substring, we are checking only 2 characters i.e. incoming and outgoing in every substring.
 * 4 - After every loop, we check if the map size is equal to the match variable and we add this to the result List 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        if(p.length() > s.length())
        {
            return result;
        }
        
        for(int i=0; i < p.length(); i++)
        {
            char c = p.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        
        int match = 0;
        for(int i = 0; i < s.length(); i++)
        {
            //incoming character
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                if(count == 0)
                {
                    match++;
                }
                map.put(in,count);
            }
            
            //outgoing character
            if(i >= p.length())
            {
                char out = s.charAt(i - p.length());
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    count++;
                    if(count == 1)
                    {
                        match--;
                    }
                    map.put(out,count);
                }
            }
            if(match == map.size())
                result.add(i - p.length() + 1);
        }
        return result;
    }
}
