package problemSolving;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        System.out.println(s.solution(N, road, K));
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;     // 1번마을 무조건 갈 수 있음.
        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
        }

        Queue<Node> q = new LinkedList<>();
        int[] visit = new int[N+1];

        for (int i = 2; i < visit.length; i++) {
            visit[i] = Integer.MAX_VALUE;       // 방문 배열을 모두 max 값으로 갱신.
        }
        q.addAll(list.get(1));      // 1번 마을에서 갈수있는 마을 정보 모두 큐에 담음.

        while(!q.isEmpty()) {
            // bfs
            Node n = q.poll();
            if (visit[n.y] <= visit[n.x] + n.time)
                continue;
            visit[n.y] = visit[n.x] + n.time;
            q.addAll(list.get(n.y));
        }

        for (int i = 2; i < visit.length; i++) {
            if (visit[i] <= K)
                answer++;
        }

        return answer;
    }

    static class Node {
        int x, y, time;
        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}