class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        while (!(Math.abs(a-b) == 1 && a % 2 == 1)) {
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);
            round += 1;
        }
        
        return round;
    }
}