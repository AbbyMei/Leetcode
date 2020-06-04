package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    List<Integer> list = new ArrayList<>();
    private List<Integer> preOrder1(TreeNode root){
        if(root == null){
            return null;
        }
        list.add(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
        return list;
    }

    private List<Integer> preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            if(tmp.right != null) {
                stack.add(tmp.right);
            }
            if(tmp.left != null){
                stack.add(tmp.left);
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
        List<Integer>  list = new ArrayList<>();
        list = preOrder2(root);
        System.out.println(list.toString());
    }
}
