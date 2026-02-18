import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            try {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                String t = st.nextToken();
                int i = 0, j = 0;
                while (j < t.length() && i < s.length()) {
                    if (s.charAt(i) == t.charAt(j)) {
                        i++;
                    }
                    j++;
                }

                // System.out.printf("%d %d %d %d", s.length(), t.length(), i, j);

                if (i == s.length()) {
                    bw.write("Yes");
                } else {
                    bw.write("No");
                }
                bw.newLine();
                bw.flush();
            } catch (NullPointerException e) {
                break;
            }
        }
        
        bw.close();
    }
}