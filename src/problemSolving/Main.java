package problemSolving;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public String solution(int hour, int minute) {
        double hourAngle = 30 * hour + 0.5 * minute;
        double minuteAngle = 6 * minute;
        double angle = 0;
        if (hourAngle >= minuteAngle) {
            angle = hourAngle - minuteAngle;
        } else {
            angle = minuteAngle - hourAngle;
        }

        String answer = Double.toString(angle);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int hour = 3;
        int minute = 0;
        String ret = sol.solution(hour, minute);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 \"" + ret + "\" 입니다.");
    }
}