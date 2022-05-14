package TreeADT;

import java.util.Arrays;
import java.util.Stack;

public class Exercise2 {

    public static int calculator(String s){
        Stack <Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                stack.push(c - '0');
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (c){
                    case '+':
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();
        LinkedBinaryTree.Node n0 = new LinkedBinaryTree.Node("*");
        LinkedBinaryTree.Node n1 = new LinkedBinaryTree.Node("+");
        LinkedBinaryTree.Node n2 = new LinkedBinaryTree.Node("-");
        LinkedBinaryTree.Node n3 = new LinkedBinaryTree.Node("/");
        LinkedBinaryTree.Node n4 = new LinkedBinaryTree.Node(2);
        LinkedBinaryTree.Node n5 = new LinkedBinaryTree.Node(6);
        LinkedBinaryTree.Node n6 = new LinkedBinaryTree.Node(3);
        LinkedBinaryTree.Node n7 = new LinkedBinaryTree.Node(7);
        LinkedBinaryTree.Node n8 = new LinkedBinaryTree.Node(4);

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n5;
        n3.right = n6;
        n2.left = n7;
        n2.right = n8;
/* Cây có dạng:
                *
           +        -
        /     2   7    4
    6     3
*/
        LinkedBinaryTree.ExpressionTree test = new LinkedBinaryTree.ExpressionTree();

        System.out.print("Biểu diễn dưới dạng biểu thức tiền tố: ");
        test.preorderPrint(n0);
        System.out.println();

        System.out.print("Biểu diễn dưới dạng biểu thức trung tố: ");
        test.inorderPrint(n0);
        System.out.println();

        System.out.print("Biểu diễn dưới dạng biểu thức hậu tố: ");
        System.out.println(test.postorderPrint(n0));

        String sMath = test.postorderPrint(n0);
        sMath = sMath.trim();
        sMath = sMath.replaceAll("\\s", "");

        System.out.print("Giá trị biểu thức là: ");
        System.out.println(calculator(sMath));

    }
}
