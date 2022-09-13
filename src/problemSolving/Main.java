package problemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static ArrayList<ArrayList> inputBirdList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        print(removeOneBird(inputBirdList, 0));
    }

    static void input() throws IOException {
        System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/BaekjoonOnlineJudge/src/problemSolving/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char direction = st.nextToken().charAt(0);
            String tempSing = st.nextToken();
            ArrayList<Integer> birdSing = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if ((tempSing.charAt(j) - '0') == 1) {
                    if (direction == 'L') {
                        birdSing.add(-1);
                    } else {
                        birdSing.add(1);
                    }
                } else {
                    birdSing.add(0);
                }
            }
            inputBirdList.add(birdSing);
        }
    }

    static ArrayList<ArrayList> removeOneBird(ArrayList<ArrayList> birdList, int i) {
        birdList.remove(i);
        return birdList;
    }

    static void print(ArrayList<ArrayList> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}