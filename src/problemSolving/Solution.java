package problemSolving;

public class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i <= d; i++) {
            long x = i*k;
            for (int j = 0; j <= d; j++) {
                long y = j*k;
                if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(d, 2)) {
                    answer++;
                }
            }
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