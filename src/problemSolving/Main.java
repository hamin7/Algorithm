package problemSolving;

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
        ArrayList<ArrayList<Path>> townLink = mkTownLink(N, road);
        int[] visit = mkMaxVisitArray(N);
        Queue<Path> linkFromStart = mkLinkFromStart(townLink);
        visit = bfs(linkFromStart, visit, townLink);
        return cntAvailableTwn(visit, K);
    }

    public ArrayList<ArrayList<Path>> mkTownLink(int N, int[][] road) {
        ArrayList<ArrayList<Path>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).add(new Path(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Path(road[i][1], road[i][0], road[i][2]));
        }

        return list;
    }

    public int[] mkMaxVisitArray(int N) {
        int[] visit = new int[N+1];
        for (int i = 2; i < visit.length; i++) {
            visit[i] = Integer.MAX_VALUE;       // 방문 배열을 모두 max 값으로 갱신.
        }
        return visit;
    }

    public Queue<Path> mkLinkFromStart(ArrayList<ArrayList<Path>> townLink) {
        Queue<Path> linkFromStart = new LinkedList<>();
        linkFromStart.addAll(townLink.get(1));      // 1번 마을에서 갈수있는 마을 정보 모두 큐에 담음.
        return linkFromStart;
    }

    public int[] bfs(Queue<Path> linkFromStart, int[] visit, ArrayList<ArrayList<Path>> townLink) {
        while(!linkFromStart.isEmpty()) {
            // bfs
            Path path = linkFromStart.poll();
            if (visit[path.end] <= visit[path.start] + path.time)
                continue;
            visit[path.end] = visit[path.start] + path.time;
            linkFromStart.addAll(townLink.get(path.end));
        }
        return visit;
    }

    public int cntAvailableTwn(int[] visit, int K) {
        int answer = 1;     // 1번마을 무조건 갈 수 있음.
        for (int i = 2; i < visit.length; i++) {
            if (visit[i] <= K)
                answer++;
        }
        return answer;
    }

    static class Path {
        int start, end, time;
        Path(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}