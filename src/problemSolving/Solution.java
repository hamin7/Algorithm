package problemSolving;

public class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d/k; i++) {
            long x = i * k;
            long y = (long) Math.sqrt((long)Math.pow(d, 2) - (long)Math.pow(x, 2))/k;
            answer += y + 1;
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int k = 2;
        int d = 4;
        long ret1 = sol.solution(k, d);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}