package problemSolving;

import java.io.*;
import java.util.*;

public class Main {

    static int numOfNodes, kennyLocation, strength, moveCnt;
    static ArrayList<Integer>[] edgeList;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/BaekjoonOnlineJudge/src/problemSolving/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numOfNodes = Integer.parseInt(st.nextToken());
        kennyLocation = Integer.parseInt(st.nextToken());
        strength = Integer.parseInt(st.nextToken());

        depth = new int[numOfNodes + 1];
        edgeList = new ArrayList[numOfNodes + 1];

        for (int i = 1; i < numOfNodes + 1; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < numOfNodes - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edgeList[node1].add(node2);
            edgeList[node2].add(node1);
        }

        dfs(kennyLocation, -1);
        System.out.println(moveCnt*2);
    }

    static int dfs(int idx, int parent) {
        for (int nxt : edgeList[idx]) {
            if (nxt != parent) {
                depth[idx] = Math.max(depth[idx], dfs(nxt, idx) + 1);
            }
        }

        if (idx != kennyLocation && depth[idx] >= strength) {
            moveCnt++;
        }
        return depth[idx];
    }
}