import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String code = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            s.add(a);
            l.add(a.length());
        }


        int an = 'z'-'a'+1;
        StringBuilder sb = new StringBuilder();

        first:
        for (int i = 1; i < an; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < code.length(); j++) {
                int k = 0;
                if (code.charAt(j) < 97) {
                    k = (code.charAt(j) + i - 1 - 'A') % an + 'A';
                } else {
                    k = (code.charAt(j) + i - 1 - 'a') % an + 'a';
                }
                sb.append((char) k);
            }


            for (int o : l) {
                for (int p = 0; p <= code.length() - o; p++) {
                    if (s.contains(sb.toString().substring(p, p+o))) break first;
                }
            }
        }
        
        System.out.println(sb);
    }
}