import java.util.*;

class Solution {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    static int n;
    static String number;
    static Set<Integer> set = new HashSet<>();
    
    static void perm(int r, int depth, String result, boolean[] visited) {
        if (r == depth) {
            set.add(Integer.parseInt(result));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (depth == 0 && number.charAt(i) == '0') continue;
            if (!visited[i]) {
                visited[i] = true;
                perm(r, depth+1, result + number.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        n = numbers.length();
        number = numbers;
        
        for (int i = 1; i < n+1; i++) {
            perm(i, 0, "", new boolean[n]);   
        }
        
        int answer = 0;
        for (int s : set) {
            boolean p = isPrime(s);
            if (p) answer +=1;
        }
        return answer;
    }
}