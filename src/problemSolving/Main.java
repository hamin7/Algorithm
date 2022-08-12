package problemSolving;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static ArrayList<Character> policyList = new ArrayList<>();
    static ArrayList<Character> result = new ArrayList<>();
    static int m = 6;
    static boolean[] visit = new boolean[6];
    static int[] alpha = new int[4];
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        countAlpha();
        dfs();
        System.out.println("중복 제거 전 순열 갯수 : " + ans);
        removeDuplication();
        System.out.println("중복 제거 후 순열 갯수 : " + ans);
    }

    static void input() throws IOException {
        System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/BaekjoonOnlineJudge/src/problemSolving/input.txt"));
        policyList.add('a');
        policyList.add('a');
        policyList.add('b');
        policyList.add('b');
        policyList.add('c');
        policyList.add('c');
    }

    static void countAlpha() {
        for (int i = 0; i < policyList.size(); i++) {
            alpha[policyList.get(i) - 'a']++;
        }
    }

    static void dfs() {
        if (result.size() == m) {
            ans++;
            return;
        }
        for (int i = 0; i < policyList.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                result.add(policyList.get(i));
                dfs();
                result.remove(result.size() - 1);
                visit[i] = false;
            }
        }
    }

    static void removeDuplication() {
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > 1) {
                // 중복되는 원소라면
                ans = ans / fact(alpha[i]);
            }
        }
    }

    static int fact(int n) {
        int res = 1;
        while (n > 0) {
            res = res * n;
            n--;
        }
        return res;
    }
}