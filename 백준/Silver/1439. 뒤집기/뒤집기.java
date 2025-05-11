import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 문제

//        0과 1로 된 이진수를 최소횟수로 동일하게 만들기

        // BufferedReader를 사용해 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값을 잘라옴.
        String s = br.readLine();

        int zero = 0;
        int one = 0;

        if(s.charAt(0) == '0'){
            zero++; // 0이라면 카운트
        } else {
            one++;// 아니라면 1이니까 1 카운트
        }

        // 변경될 떄마다 개수 증가
        for(int i =1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                if(s.charAt(i) == '0'){
                    zero++;
                } else {
                    one++;
                }
            }
        }

//        출력
        System.out.println(Math.min(zero, one));
    }
}