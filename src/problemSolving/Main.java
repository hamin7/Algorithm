package problemSolving;

import java.io.*;
import java.util.Arrays;

public class Main {
    static String scroll, devil, angel;
    static int[][][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        input();
        bw.write(crossingBridge(0, 0, 2) + "\n");
        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        System.setIn(new FileInputStream("/Users/leehamin/Algorithm/src/input.txt"));
        scroll = br.readLine();
        devil = br.readLine();
        angel = br.readLine();
        fillDpArray();
        br.close();
    }

    static void fillDpArray() {
        dp = new int[scroll.length() + 1][devil.length() + 1][3];
        for (int i = 0; i < scroll.length() + 1; i++) {
            for (int j = 0; j < devil.length() + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }

    static int crossingBridge(int cnt, int idx, int prev) {
        if (cnt == scroll.length()) return 1;
        if (cnt >= devil.length()) return 0;
        if (dp[cnt][idx][prev] != -1) return dp[cnt][idx][prev];

        dp[cnt][idx][prev] = calculateDp(cnt, idx, prev);
        return dp[cnt][idx][prev];
    }

    static int calculateDp(int cnt, int idx, int prev) {
        int ret = 0;
        if (prev != 0) ret = useDevilBridge(cnt, idx, ret);
        if (prev != 1) ret = useAngelBridge(cnt, idx, ret);
        return ret;
    }

    static int useDevilBridge(int cnt, int idx, int ret) {
        for (int i = idx; i < devil.length(); i++) {
            if (scroll.charAt(cnt) == devil.charAt(i))
                ret += crossingBridge(cnt + 1, i + 1, 0);
        }
        return ret;
    }

    static int useAngelBridge(int cnt, int idx, int ret) {
        for (int i = idx; i < angel.length(); i++) {
            if (scroll.charAt(cnt) == angel.charAt(i)) ret += crossingBridge(cnt + 1, i + 1, 1);
        }
        return ret;
    }
}