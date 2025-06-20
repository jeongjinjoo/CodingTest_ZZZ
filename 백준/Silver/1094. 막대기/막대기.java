import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
       
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int X = Integer.parseInt(br.readLine());
       
        //length : 막대기 길이 합, cur : 가장 짧은 막대기 길이, answer : 막대기 개수
        int length = 64, cur = 64, answer = 1;
        
        //X가 64일 때
        if(X == 64)
            bw.write("1");	//초기 막대기만 사용!
        else{		//X != 64
            //막대기 자르고 붙이는 과정 진행!
            while(true){
                cur /= 2;	//막대기 절반으로 자르기
                length -= cur;	//절반으로 자른 1개 막대기 버렸다고 가정!
                if(length < X){	//막대기의 합 < X
                    answer++;	//막대기 버리지 않기
                    length += cur;
                }else if(length == X)	//막대기의 합 == X
                    break;
            }
          
            //막대기의 개수 BufferedWriter 저장
            bw.write(answer + "");	
        }
       
        //결과 출력
        bw.flush();
        bw.close();
        br.close();
    }
}