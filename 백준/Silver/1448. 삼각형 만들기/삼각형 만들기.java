import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < n; i++) data.add(Integer.parseInt(br.readLine()));
        Collections.sort(data, Comparator.reverseOrder());

        for (int i = 0; i < n - 2; i++) {
            int a = data.get(i), b = data.get(i+1), c = data.get(i+2);
            if (a < b + c) {
                System.out.println(a+b+c);
                return;
            }
        }
        System.out.println(-1);
    } 
}