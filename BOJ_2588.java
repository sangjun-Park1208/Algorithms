import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2588 {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> resultArray = new ArrayList<>();
        int operand1 = 0;
        int operand2 = 0;
        int result = 0;
        int count = 1;

        arrayList = new BOJ_2588().getInputfunc(arrayList);
        operand1 = arrayList.get(0);
        operand2 = arrayList.get(1);
        for(int i=0; i<3; i++){
            resultArray.add(new BOJ_2588().multFunc(operand1, operand2 % 10));
            result += (resultArray.get(i) * count);
            operand2 /= 10;
            count *= 10;
        }
        resultArray.add(result);
        new BOJ_2588().printfunc(resultArray);



    }

    ArrayList<Integer> getInputfunc(ArrayList<Integer> arrayList) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<2; i++){
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        return arrayList;
    }

    int multFunc(int a, int b){
        return a * b;
    }

    void printfunc(ArrayList<Integer> arrayList) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<4; i++){
            bw.write(String.valueOf(arrayList.get(i)));
            bw.newLine();
        }
        bw.flush();
    }
}
