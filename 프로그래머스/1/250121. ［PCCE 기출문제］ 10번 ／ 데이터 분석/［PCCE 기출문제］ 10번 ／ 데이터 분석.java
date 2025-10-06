import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> exts = Map.of(
            "code", 0,
            "date", 1,
            "maximum", 2,
            "remain", 3
        );

        int extIdx = exts.get(ext);
        int sortIdx = exts.get(sort_by);

        return Arrays.stream(data)
            .filter(row -> row[extIdx] < val_ext)
            .sorted(Comparator.comparingInt(row->row[sortIdx]))
            .toArray(int[][]::new);
    }
}