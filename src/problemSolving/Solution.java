package problemSolving;

import java.util.*;

public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] solution(String s) {
        HashMap<Character, Integer> alpha = new HashMap<>();
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (!alpha.containsKey(s.charAt(i))) result[i] = -1;
            else result[i] = i - alpha.get(s.charAt(i));
            alpha.put(s.charAt(i), i);
        }
        return result;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        String s = "banana";
        int[] ret1 = sol.solution(s);

        System.out.println("solution 메소드의 반환 값은 \"" + Arrays.toString(ret1) + "\" 입니다.");
    }
}