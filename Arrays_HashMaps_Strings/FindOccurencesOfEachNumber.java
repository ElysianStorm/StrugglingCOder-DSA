package Arrays_HashMaps_Strings;
// https://www.interviewbit.com/problems/occurence-of-each-number/discussion/p/occurrence-of-each-number-java-approach-o-nlogn-time-o-n-space-explanation/502478/2571/

// Easy
// Arrays/HashMap
// Store and Sort
// T: O(N), S: O(N)
// Count -> Sort KEYS -> Return VALUES

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindOccurencesOfEachNumber {
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i=0;i<A.size();i++){
            h.put(A.get(i),h.getOrDefault(A.get(i),0)+1);
        }
       
        ArrayList<Integer> al = new ArrayList<>(h.keySet());
        ArrayList<Integer> bl = new ArrayList<>();
        Collections.sort(al);
        for(int i=0;i<al.size();i++){
            bl.add(h.get(al.get(i)));
        }
        return bl;
    }
}
