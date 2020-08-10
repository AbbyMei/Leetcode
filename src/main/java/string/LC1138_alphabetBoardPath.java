package string;

/*
*
* 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。

在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。



我们可以按下面的指令规则行动：

如果方格存在，'U' 意味着将我们的位置上移一行；
如果方格存在，'D' 意味着将我们的位置下移一行；
如果方格存在，'L' 意味着将我们的位置左移一列；
如果方格存在，'R' 意味着将我们的位置右移一列；
'!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
（注意，字母板上只存在有字母的位置。）

返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 

示例 1：

输入：target = "leet"
输出："DDR!UURRR!!DDD!"
示例 2：

输入：target = "code"
输出："RR!DDRR!UUL!R!"
 

提示：

1 <= target.length <= 100
target 仅含有小写英文字母。

* */

import org.junit.Test;

public class LC1138_alphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder("");
        char targetChar[] = target.toCharArray();
        int startX = 0;
        int startY = 0;
        for(char c : targetChar){
            int size = c - 97;
            int targetX = size % 5;
            int targetY = size / 5;
            int XLength = targetX - startX;
            int YLength = targetY - startY;
            if(startY == 5){
                for(; YLength < 0; YLength++){
                    sb.append("U");
                }
                for(; XLength > 0; XLength--){
                    sb.append("R");
                }
            }else{
                if(XLength > 0){
                    for(; XLength > 0; XLength--){
                        sb.append("R");
                    }
                }else if(XLength < 0){
                    for(; XLength < 0; XLength++){
                        sb.append("L");
                    }
                }
                if(YLength > 0){
                    for(; YLength > 0; YLength--){
                        sb.append("D");
                    }
                }else if(YLength < 0){
                    for(; YLength < 0; YLength++){
                        sb.append("U");
                    }
                }
            }
            sb.append("!");
            startX = targetX;
            startY = targetY;
        }
        return sb.toString();
    }

    @Test
    public void testAlphabetBoardPath(){
        System.out.println(alphabetBoardPath("zb"));
    }
}
