import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (a, b) -> {
                    if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                    return Integer.compare(a[0], b[0]);
                });

        int answer = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (end <= info[i][0]) {
                answer++;
                end = info[i][1];
            }
        }

        System.out.println(answer);
    }
}