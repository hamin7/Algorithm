package problemSolving;

import java.util.*;

class Main {
    static boolean[][] map = new boolean[8][8];
    public int solution(String[] bishops) {
        for (int i = 0; i < bishops.length; i++) {
            int x = bishops[i].charAt(0) - 'A';
            int y = bishops[i].charAt(1) - '1';
            moveBishop(x, y);
        }
        int answer = cntFalse();
        return answer;
    }

    public void moveBishop(int x, int y) {
        map[x][y] = true;
        moveDir(x, y, 1, 1);
        moveDir(x, y, 1, -1);
        moveDir(x, y, -1, 1);
        moveDir(x, y, -1, -1);
    }

    public void moveDir(int x, int y, int dx, int dy) {
        while(x>=0 && x<8 && y>=0 && y<8) {
            map[x][y] = true;
            x += dx;
            y += dy;
        }
    }

    public int cntFalse() {
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == false)
                    cnt++;
            }
        }
        return cnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}