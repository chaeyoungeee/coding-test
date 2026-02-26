import java.util.*;

class Solution {
    public int[] solution(String[] operations) {        
        TreeMap<Integer, Integer> tree = new TreeMap<>((o1, o2) -> Integer.compare(o1, o2));
        
        for (String op : operations) {
            String[] o = op.split(" ");
            int n = Integer.parseInt(o[1]);
            if (o[0].equals("I")) {
                tree.merge(n, 1, Integer::sum);
            } else {
                if (tree.size() != 0) {
                    int k;
                    if (n == -1) {
                        k = tree.firstKey();
                    } else {
                        k = tree.lastKey();
                    }
                    int v = tree.getOrDefault(k, 0);
                    if (v == 0) continue;
                    else if (v == 1) tree.remove(k);
                    else tree.merge(n, -1, Integer::sum);   
                }
            }
        }
        
        int s = tree.size();
        
        if (s == 0) {
            return new int[] {0, 0};   
        } else if (s == 1) {
            int k = tree.firstKey();
            return new int[] {k, k};
        } else {
            return new int[] {tree.lastKey(), tree.firstKey()};
        }
    }
}