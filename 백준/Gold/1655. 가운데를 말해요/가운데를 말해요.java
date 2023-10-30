import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중간값보다 크거나 같은 값들에 대한 최소힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 중간값보다 작은 값들에 대한 최대힙
        int N = Integer.parseInt(br.readLine());
        int cur;
        for(int k=0; k<N; k++) {
            cur = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()) {
                if(maxHeap.isEmpty()) maxHeap.add(cur);
                else if(minHeap.isEmpty()) minHeap.add(cur);
                else if(cur <= maxHeap.peek()) {
                    maxHeap.add(cur);
                }
                else {
                    minHeap.add(cur);
                    maxHeap.add(minHeap.poll());
                }
            }
            
            else if(maxHeap.size() > minHeap.size()) {
                if(minHeap.isEmpty()) {
                    maxHeap.add(cur);
                    minHeap.add(maxHeap.poll());
                } else if(cur <= maxHeap.peek()) {
                    maxHeap.add(cur);
                    minHeap.add(maxHeap.poll());
                } else {
                    minHeap.add(cur);
                }
            }

            else if(maxHeap.size() < minHeap.size()) {
                if(cur <= maxHeap.peek()) {
                    maxHeap.add(cur);
                } else {
                    minHeap.add(cur);
                    maxHeap.add(minHeap.poll());
                }
            }

            bw.write(String.valueOf(maxHeap.peek()) + "\n"); 
        }

        bw.flush();
        return;
    }
    
}