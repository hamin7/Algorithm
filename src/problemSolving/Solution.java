package problemSolving;

public class Solution {
    public String solution(int[] food) {
        String answer = "";
        String half = "";

        for (int i = 1; i < food.length; i++) {
            int cnt = food[i];
            if (cnt % 2 != 0) {
                cnt--;
            }
            cnt /= 2;
            while (cnt > 0) {
                half += Integer.toString(i);
                cnt--;
            }
        }

        answer = half.concat("0").concat(reverse(half));
        return answer;
    }

    public String reverse(String half) {
        String reversed = "";
        for (int i = 0; i < half.length(); i++) {
            reversed += half.charAt(half.length()-i-1);
        }
        return reversed;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr = {1, 3, 4, 6};
        String ret1 = sol.solution(arr);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}