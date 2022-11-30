package problemSolving;

import java.util.ArrayList;

public class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> sequence = new ArrayList<>();

        double index = 0;
        sequence.add((double) k);
        while (k != 1) {
            index++;
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k *= 3;
                k++;
            }
            sequence.add((double) k);
        }

        ArrayList<Double> sizes = new ArrayList<>();
        for (int i = 0; i < sequence.size() - 1; i++) {
            sizes.add((sequence.get(i) + sequence.get(i+1)) / 2);
        }

        for (int i = 0; i < ranges.length; i++) {
            int left = ranges[i][0];
            int right = sequence.size() - 1 + ranges[i][1];

            double area = 0;

            if (left <= right) {
                for (int j = left; j < right; j++) {
                    area += sizes.get(j);
                }
            } else
                area = -1;

            answer[i] = area;
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int k = 5;
        int[][] arr = {{0,0}, {0,-1}, {2,-3}, {3,-3}};
        double[] ret1 = sol.solution(k, arr);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1.toString() + "\" 입니다.");
    }
}