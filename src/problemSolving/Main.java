package problemSolving;

import java.util.*;

class Main {
    public int[] solution(String commands) {
        int[] answer = {0, 0};
        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'L')
                answer[0]--;
            else if (commands.charAt(i) == 'R')
                answer[0]++;
            else if (commands.charAt(i) == 'U')
                answer[1]++;
            else if (commands.charAt(i) == 'D')
                answer[1]--;
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String commands = "URDDL";
        int[] ret = sol.solution(commands);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}