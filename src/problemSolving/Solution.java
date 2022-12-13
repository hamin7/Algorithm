package problemSolving;


public class Solution {
    public int solution(String s) {
        int answer = 0, sameCnt = 0, diffCnt = 0;
        char firstLetter = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (firstLetter == s.charAt(i))
                sameCnt++;
            else
                diffCnt++;
            if (i == s.length() - 1) {
                answer++;
                break;
            }
            if (sameCnt == diffCnt) {
                answer++;
                firstLetter = s.charAt(i+1);
                sameCnt = 0;
                diffCnt = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        String s = "banana";
        int ret1 = sol.solution(s);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}