package problemSolving;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(int K, String[] words) {
        int line = 0;
        int space = 0;
        int idx = 0;
        while (idx < words.length) {
            if (space + words[idx].length() + 1 < K) {
                space += words[idx].length();
                idx++;
            } else {
                line++;
                space = 0;
            }
        }

        return line;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};
        int ret = sol.solution(K, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}