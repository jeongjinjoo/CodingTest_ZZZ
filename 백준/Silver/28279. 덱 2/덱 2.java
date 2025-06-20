import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st;

        //명령어의 수
        int N = Integer.parseInt(br.readLine()); 

        while(N --> 0) {
            //입력
            st = new StringTokenizer(br.readLine());
            
            int order = Integer.parseInt(st.nextToken());

            switch (order){
                case 1 : // 앞에 넣는다
                    frontPush(Integer.parseInt(st.nextToken()));
                    break;
                case 2 : //뒤에 넣는다
                    backPush(Integer.parseInt(st.nextToken()));
                    break;
                case 3 : //덱의 맨 앞의 정수를 빼서 출력한다.(없다면 -1)
                    frontPop();
                    break;
                case 4 : //덱의 맨 뒤의 정수를 빼서 출력한다.(없다면 -1)
                    backPop();
                    break;
                case 5 : //덱에 들어있는 정수의 개수 출력
                    dequeSize();
                    break;
                case 6 : //덱이 비어있으면 1 출력 비어있지 않으면 0
                    dequeEmpty();
                    break;
                case 7 : //덱에 정수가 있다면 맨 앞의 정수를 출력(없다면 -1)
                    getFront();
                    break;
                case 8 : //덱에 정수가 있다면 맨 뒤의 정수를 출력(없다면 -1)
                    getBack();
                    break;
            }
        }
        
        br.close();
        
        System.out.println(sb);
        
    }
    
    static void frontPush(int element){ //명령어 1 X
        deque.addFirst(element);
    }
    
    static void backPush(int element){ //명령어 2 X
        deque.addLast(element);
    }
    
    static void frontPop(){ //명령어 3
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
            return;
        }
        
        sb.append(deque.pollFirst()).append("\n");
    }
    
    static void backPop(){ //명령어 4
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
            return;
        }
        sb.append(deque.pollLast()).append("\n");
    }
    
    static void dequeSize(){ //명령어 5
        sb.append(deque.size()).append("\n");
    }
    
    static void dequeEmpty(){ //명령어 6
        sb.append(deque.isEmpty()? 1 : 0).append("\n");
    }
    
    static void getFront(){ //명령어 7
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
            return;
        }
        sb.append(deque.peekFirst()).append("\n");
    }
    
    static void getBack(){ //명령어 8
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
            return;
        }
        sb.append(deque.peekLast()).append("\n");
    }
}