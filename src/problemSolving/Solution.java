package problemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int INF = 9999999;

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    static ArrayList<int[]> dijkstra(int[][] graph, int startNode) {
        int vertex = graph.length;
        int[] dist = new int[vertex];
        int[] prev = new int[vertex];       // 이전 노드(현재까지의 최단거리 기준)
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, dist[startNode]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curNode = node.index;
            int curDist = node.distance;

            // 새롭게 구한 경로가 현재까지 최단 경로보다 긴 경우.
            if (curDist > dist[curNode])
                continue;

            for (int arbitNode = 0; arbitNode < vertex; arbitNode++) {
                // curNode와 연결되어 있다면
                if (graph[curNode][arbitNode] > 0) {
                    int alt = dist[curNode] + graph[curNode][arbitNode];
                    if (alt < dist[arbitNode]) {
                        dist[arbitNode] = alt;
                        prev[arbitNode] = curNode;
                        pq.offer(new Node(arbitNode, dist[arbitNode]));
                    }
                }
            }
        }

        ArrayList<int[]> result = new ArrayList<>();
        result.add(dist);
        result.add(prev);
        return result;
    }

    public static void printDist(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            System.out.println("dist[" + i + "] = " + dist[i]);
        }
        System.out.println();
    }

    public static void printTrack(int[] prev, int start, int dest) {
        int node = dest;
        ArrayList<Integer> track = new ArrayList<>();
        while (node != start) {
            track.add(node);
            node = prev[node];
        }
        System.out.print("시작 노드 " + start + "에서 도착 노드" + dest + "까지\n" + start + " > ");
        for (int i = track.size() - 1; i >= 0; i--) {
            System.out.print(track.get(i));
            if (i > 0) System.out.print(" > ");
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/leehamin/Algorithm/src/problemSolving/input.txt"));
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] edge = new int[m][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                edge[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<int[]> result = dijkstra(edge, 0);
        printDist(result.get(0));
        printTrack(result.get(1), 0, 5);        // A에서 F까지 가는 경로
    }
}