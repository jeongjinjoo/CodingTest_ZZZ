import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



//        HashMap이랑 HashSet의 차이점?
//        HashMap : Key-Value 쌍으로 데이터를 저장, Key는 고유하지만, Value은 중복 가능
//        HashSet : 오직 고유한 값만 저장, 중복 불가

//        HashSet<String> set = new HashSet<>();
    while(true) {
        String game = br.readLine(); // 게임 입력

        if(game.equals("end")) {
            break;
        } else{
            boolean check = true; // 조건을 만족하지 못하면 실패로 false임.
            int one = 0; // 모음 a,e,i,o,u 포함하기
            int two = 0; // 모음 3개 연속 체크
            int two2 = 0; // 자음 3개 연속 체크
            char three = 0; // 같은 글자가 연속적을 두번은 안됨. ee와 oo만 됨.

            for(char c : game.toCharArray()){
//                문자열을 문자 배열로 바꿨을 때
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    one++;
                    two++;
                    two2 = 0;
                } else {
                    two = 0; // 모음이 아닌 변수가 나오면 two 리셋
                    two2++;
                }

                // 연속된 문자가 있을 때
                if(three == c && !(c == 'e' || c == 'o')){
                    check = false;
                }
                three = c;

//                모음이나 자음이 3개 연속이라면
                if(two >= 3 || two2 >= 3){
                    check = false; // 실패
                }
            }

            if(check && one > 0){
                System.out.println("<" + game + "> is acceptable.");
            } else {
                System.out.println("<" + game + "> is not acceptable.");
            }
        }
    }
    }
}