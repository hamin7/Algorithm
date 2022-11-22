package problemSolving;

import java.util.Arrays;

class Solution {

    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int[] tScore = new int[score.length];
        int[] reversedArr = reverseArray(tScore, score);

        return packaging(reversedArr, m);
    }

    public int[] reverseArray(int[] arr, int[] score) {
        for (int i = 0; i < score.length; i++) {
            arr[i] = score[score.length - 1 - i];
        }
        return arr;
    }

    public int packaging(int[] reversedArr, int m) {
        int maxIncome = 0;
        int index = 0;
        while (true) {
            if (index >= reversedArr.length || index + m > reversedArr.length) {
                break;
            }
            maxIncome += reversedArr[index + m - 1] * m;
            index += m;
        }
        return maxIncome;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();

        int k1 = 3, m1 = 4;
        int score1[] = {1, 2, 3, 1, 2, 3, 1};
        int ret1 = sol.solution(k1, m1, score1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int k2 = 4, m2 = 3;
        int score2[] = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int ret2 = sol.solution(k2, m2, score2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}