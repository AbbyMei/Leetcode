package string;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CompressString {
    public String compressString(String S) {
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

    @Test
    public void testCompressString(){
        String s = "aab";
        System.out.println(compressString(s));
    }
}
