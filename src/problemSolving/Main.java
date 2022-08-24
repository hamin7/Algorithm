package problemSolving;

import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int N;
    static Boolean[][] gallery;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        inputSize();
        upperSearch();
        bottomSearch();
        leftSearch();
        rightSearch();
        printResult();
    }

    static void inputSize() throws IOException {
        System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/BaekjoonOnlineJudge/src/problemSolving/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);
        gallery = new Boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (line[j].charAt(0) == 'X') {
                    gallery[i][j] = false;
                } else {
                    gallery[i][j] = true;
                }
            }
        }
    }

    static void upperSearch() {
        // 윗벽 탐색
        for (int k = 1; k < M - 1; k++) {
            int cnt = 0;
            for (int l = 1; l < N - 1; l++) {
                if (gallery[k][l] && !gallery[k - 1][l])
                    cnt++;
                else {
                    res += cnt / 2;
                    cnt = 0;
                }
            }
            res += cnt / 2;
        }
    }

    static void bottomSearch() {
        // 아랫벽 탐색
        for (int k = 1; k < M - 1; k++) {
            int cnt = 0;
            for (int l = 1; l < N - 1; l++) {
                if (gallery[k][l] && !gallery[k + 1][l])
                    cnt++;
                else{
                    res += cnt / 2;
                    cnt = 0;
                }
            }
            res += cnt / 2;
        }
    }

    static void leftSearch() {
        // 왼벽 탐색
        for (int k = 1; k < N - 1; k++) {
            int cnt = 0;
            for (int l = 1; l < M - 1; l++) {
                if (gallery[l][k] && !gallery[l][k - 1])
                    cnt++;
                else {
                    res += cnt / 2;
                    cnt = 0;
                }
            }
            res += cnt / 2;
        }
    }

    static void rightSearch() {
        // 오른벽 탐색
        for (int k = 1; k < N - 1; k++) {
            int cnt = 0;
            for (int l = 1; l < M - 1; l++) {
                if (gallery[l][k] && !gallery[l][k + 1])
                    cnt++;
                else{
                    res += cnt / 2;
                    cnt = 0;
                }
            }
            res += cnt / 2;
        }

    }

    static void printResult() {
        System.out.println(res);
    }
}