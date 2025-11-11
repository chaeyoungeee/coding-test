class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxH = health;
        int prevT = 0;
        
        for (int[] attack : attacks) {
            int r = attack[0]-prevT-1;
            int p = r * bandage[1] + ((int) r / bandage[0]) * bandage[2];
            health = Math.min(health + p, maxH) - attack[1];
            
            if (health <= 0) return -1;
            
            prevT = attack[0];
        }
        
        return health;
    }
}