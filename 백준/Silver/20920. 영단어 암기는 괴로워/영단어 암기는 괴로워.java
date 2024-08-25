import java.io.*;
import java.util.*;

public class Main {
//    Hash란?
    public static void main(String[] args) throws IOException {
//        효율적인 영단어 암기를 할 수 있도록 단어장 만들기
//        1. 자주 나오는 단어일수록 앞에 배치한다. (빈도수 이용)
//        2. 해당 단어의 길이가 길수록 앞에 배치한다. (단어의 길이 내림차순)
//        3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다. (String 클래스 compareTo()함수 사용


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader를 사용해 입력을 받음.

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 줄 읽어오기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단어의 개수

        int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준


//        HashMap 사용
//        단어와 빈도수를 저장할 HashMap을 생성함.
//        HashMap이란? 키-값 쌍 저장/ 키와 대응하는 값을 하나의 쌍으로 저장
//        해싱 코드를 사용해 내부 배열에서 값이 저장될 위치 결졍 ( 삽입순서와 검색 순서가 다를 수 있음)
        HashMap<String, Integer> map = new HashMap<>();

//        N개의 단어를 입력받음
//        i를 1로 하면 안되는 이유는 횟수는 같지만 배열을 사용할때 0부터 시작하므로 문제임
        for(int i = 0; i < N; i++) {
            String number = br.readLine();
            if (number.length() >= M){ // 단어 길이가 M 이상인 경우에만 저장
//                단어의 빈도수를 HashMap에 저장 (있으면 +1, 없으면 새로 추가
                map.put(number, map.getOrDefault(number, 0) + 1);
//            getOrDefault() : map에 key가 있으면 value리턴, 없으면 defaultValue 리턴

            }
        }

//      HashMap의 키, 즉 단어들을 리스트로 변환
        List<String> keys = new ArrayList<>(map.keySet());
//      리스트를 주어진 기준에 따라 정렬함.
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                빈도수가 다르다면 빈도수를 기준으로 역순 정렬
//                why? 역순 정렬을 하는 이유는 빈도수가 많을수록 우선 순위임
                if (map.get(o1) != map.get(o2)) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
//                그렇다면 빈도수가 같지만 단어 길이가 다르다면? 역순으로 정렬
//                단어 길이가 길수록 우선 순위임.
                if (o1.length() != o2.length()) {
                    return Integer.compare(o2.length(), o1.length());
                }
//                그렇다면 빈도수와 문자열 길이도 같다면? 알파벨 사전순으로 정렬
                return o1.compareTo(o2);
            }
        });
//        정렬된 단어들을 출력
//        전체 키-값 쌍 출력
        for (String key : keys) {
            bw.write(key + "\n");
        }

        bw.flush();
        bw.close();

    }
}
