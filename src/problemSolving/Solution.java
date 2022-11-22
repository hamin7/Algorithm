package problemSolving;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> divisorsA = getDivisors(arrayA);
        List<Integer> divisorsB = getDivisors(arrayB);

        int targetA = getMaxNonDivisor(arrayB, divisorsA);
        int targetB = getMaxNonDivisor(arrayA, divisorsB);

        return Math.max(targetA, targetB);
    }

    public List<Integer> getDivisors(int[] arrays) {
        List<Integer> list = new ArrayList<>();
        int length = arrays.length;
        int min = arrays[0];
        for (int i = 2; i <= min; i++) {
            boolean isDivide = true;
            for (int j = 0; j < length; j++) {
                if (arrays[j] % i != 0) {
                    isDivide = false;
                    break;
                }
            }
            if (isDivide) {
                list.add(i);
            }
        }
        return list;
    }

    public int getMaxNonDivisor(int[] arrays, List<Integer> divisors) {
        int target = 0;
        for (int divisor : divisors) {
            boolean isNoDivide = true;
            for (int number : arrays) {
                if (number % divisor == 0) {
                    isNoDivide = false;
                    break;
                }
            }
            if (isNoDivide) {
                target = Math.max(target, divisor);
            }
        }
        return target;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arrA[] = {10, 17};
        int arrB[] = {5, 20};

        int ret1 = sol.solution(arrA, arrB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
    }
}