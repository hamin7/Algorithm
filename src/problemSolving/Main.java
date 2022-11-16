package problemSolving;

import java.util.*;

class Main {
    public int solution(String s1, String s2) {
        int shortLength = 0;
        boolean s1Short = true;
        if (s1.length() >= s2.length()) {
            shortLength = s2.length();
            s1Short = false;
        } else {
            shortLength = s1.length();
        }

        int sameLength = shortLength;
        if (s1Short) {
            while (true) {
                if (s1.substring(shortLength - sameLength, s1.length()).equals(s2.substring(0, sameLength))) {
                    break;
                }
                sameLength--;
            }
        } else {
            while (true) {
                if (s2.substring(shortLength - sameLength, s1.length()).equals(s2.substring(0, sameLength))) {
                    break;
                }
                sameLength--;
            }
        }

        int answer = s1.length() + s2.length() - sameLength;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String s1 = new String("ababc");
        String s2 = new String("abcdab");
        int ret = sol.solution(s1, s2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}