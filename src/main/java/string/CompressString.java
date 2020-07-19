package string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CompressString {
    public String compressString(String S) {
        //TODO 优化代码，写的实在是太丑了
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int originLen = S.length();
        int count = 0;
        for(int i = 0; i < originLen; i++){
            if(queue.isEmpty() || S.charAt(i) == queue.peek()){
                queue.add(S.charAt(i));
                count++;
            }else{
                sb.append(queue.peek());
                while(!queue.isEmpty()){
                    queue.poll();
                }
                sb.append(count);
                count = 1;
                queue.add(S.charAt(i));
            }
        }
        while(!queue.isEmpty()){
            sb.append(queue.peek());
            while(!queue.isEmpty()){
                queue.poll();
            }
            sb.append(count);
        }
        String compressString = sb.toString();
        if(originLen > compressString.length()){
            return compressString;
        }else{
            return S;
        }
    }

    public String compressString2(String S){
        int len = S.length();
        if(S == null || len == 0){
            return S;
        }
        StringBuilder sb  = new StringBuilder();
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < len && j < len){
            while( j < len && S.charAt(j) == S.charAt(i)){
                j++;
                count++;
            }
            sb.append(S.charAt(i));
            sb.append(count);
            count = 0;
            i = j;
        }
        String compressString = sb.toString();
        if(len > compressString.length()){
            return compressString;
        }else{
            return S;
        }
    }

    @Test
    public void testCompressString(){
        String s = "aab";
        System.out.println(compressString(s));
    }
}
