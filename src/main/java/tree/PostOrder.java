package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    List<Integer> list = new ArrayList<>();
    private List<Integer> postOrder1(TreeNode root){
        if(root == null){
            return null;
        }
        postOrder1(root.left);
        postOrder1(root.right);
        list.add(root.val);
        return list;
    }

    private List<Integer> postOrder2(TreeNode root){
        if(root == null){
            return null;
        }
        //先序遍历后，中左右->中右左，然后将中右左的顺序存入另一个栈中，再取出，即实现了后续遍历
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode curNode = null;
        while(!stack1.isEmpty()){
            curNode = stack1.pop();
            //辅助栈
            stack2.push(curNode);
            if(curNode.left != null){
                stack1.push(curNode.left);
            }
            if(curNode.right != null){
                stack1.push(curNode.right);
            }
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
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
        List<Integer>  list1 = new ArrayList<>();
        list1 = postOrder2(root);
        System.out.println(list1.toString());
    }
}
