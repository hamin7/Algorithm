package problemSolving;

import java.util.*;

public class Solution {

    static long leftTotal;
    static long rightTotal;

    public int solution(int n, long l, long r) {
        leftTotal = l;
        rightTotal = r;
        long lengthTotal = (long) Math.pow(5, n);

        return find(1L, lengthTotal);
    }
    static int find(long left, long right) {
        if(right < leftTotal || left > rightTotal) return 0;
        if(left == right) return 1;
        int result = 0;
        long interval = (right - left + 1L) / 5;
        result += find(left, left + interval * 1 - 1);
        result += find(left + interval * 1, left + interval * 2 - 1);
        result += find(left + interval * 3, left + interval * 4 - 1);
        result += find(left + interval * 4, right);
        return result;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int n = 2;
        int l = 4;
        int r = 17;
        int ret1 = sol.solution(n, l, r);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}