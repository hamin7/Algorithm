package problemSolving;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public long solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int my = n;
        int muJeokGuan = k;
        for (int i = 0; i < enemy.length; i++) {
            my -= enemy[i];
            pq.add(enemy[i]);

            if (my < 0) {
                if (muJeokGuan > 0 && !pq.isEmpty()) {
                    my += pq.poll();
                    muJeokGuan--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        long ret1 = sol.solution(n, k, enemy);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}