package problemSolving;

import java.util.*;

public class Solution {

    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l; i <= r ; i++){
            int flag = 1;
            if (i % 5 == 3){
                continue;
            }
            long temp = i;
            long result;
            while (true){
                if (temp % 5 == 0){
                    temp = temp / 5;
                }
                else {
                    temp = (temp / 5) + 1;
                }

                if (temp % 5 == 3){
                    flag = 0;
                    break;
                }
                else if (temp <= 5){
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) answer++;
        }
        return answer;
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