import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, next_i, next_j;
    static int[] move_i = {-1, 1, 0, 0};
    static int[] move_j = {0, 0, -1, 1};
    static int[][] Map;
    static boolean[][] isVisit;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        getInput();
        bfs();

        Collections.sort(answer);
        bw.write(String.valueOf(answer.size()) + "\n");
        for(Integer i : answer) bw.write(String.valueOf(i) + "\n");
        
        bw.flush();
        return;
    }

    static void bfs() {
        answer = new ArrayList<>();
        ArrayDeque<House> queue;
        House house;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(!isVisit[i][j] && Map[i][j] == 1) {
                    queue = new ArrayDeque<>();
                    isVisit[i][j] = true;
                    int cnt = 0;
                    queue.add(new House(i, j));
                    while(!queue.isEmpty()) {
                        house = queue.poll();
                        cnt++;
                        for(int k=0; k<4; k++) {
                            next_i = house.i + move_i[k];
                            next_j = house.j + move_j[k];
            
                            if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= N) continue;
            
                            if(Map[next_i][next_j] == 1 && !isVisit[next_i][next_j]) {
                                queue.add(new House(next_i, next_j));
                                isVisit[next_i][next_j] = true;
                            }
                        }
                    }
                    answer.add(cnt);
                }

            }
        }

    }

    static void getInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        String input;
        isVisit = new boolean[N][N];
        Map = new int[N][N];
        for(int i=0; i<N; i++) {
            input = br.readLine();
            for(int j=0; j<N; j++) {
                Map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }
    }

    static class House {
        int i, j;
        public House(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}