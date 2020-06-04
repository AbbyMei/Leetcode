package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    List<Integer> list = new ArrayList<>();
    private List<Integer> inOrder1(TreeNode root){
        if(root == null){
            return null;
        }
        inOrder1(root.left);
        list.add(root.val);
        inOrder1(root.right);
        return list;
    }

    private List<Integer> inOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;

    }


    @Test
    public void testPreOrder(){
        TreeNode root  = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        List<Integer> list = new ArrayList<>();
        list = inOrder2(root);
        System.out.println(list.toString());
    }
}
