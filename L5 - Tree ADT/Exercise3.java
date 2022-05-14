package hw5_19000311;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Node {
    char value;
    Node left, right;

    Node(char item) {
        value = item;
        left = right = null;
    }
}

class Exercise3 {

    public static int priority(char c){
        if (c == '+' || c == '-'){
            return 1;
        }
        else if (c == '*' || c == '/'){
            return 2;
        }
        else return 0;
    }

    public static String postFix(String[] s){
        Stack <String> stack = new Stack<String>();
        String s1 = "";

        for (int i = 0 ; i < s.length; i++){
            char c = s[i].charAt(0);
            if (!isOperator(c)){
                s1 = s1 + " " + s[i];
            }
            else {
                if (c == '('){
                    stack.push(s[i]);
                } else {
                    if (c == ')'){
                        char c1;
                        do {
                            c1 = stack.peek().charAt(0);
                            if (c1 != '('){
                                s1 = s1 + " " + stack.peek();
                            }
                            stack.pop();
                        } while (c1 != '(');
                    } else {
                        while (!stack.isEmpty() && priority(stack.peek().charAt(0)) >= priority(c)){
                            s1 = s1 + " " + stack.peek();
                            stack.pop();
                        }
                        stack.push(s[i]);
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            s1 = s1 + " " + stack.peek();
            stack.pop();
        }
        s1 = s1.replaceAll("\\s", "");

        return s1;
    }


    public static String[] process(String s){
        String s1 = "";
        String[] result = null;
        s = s.trim();
        s = s.replaceAll("\\s", "");

        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (!isOperator(c)){
                s1 = s1 + c;
            } else {
                s1 = s1 + " " + c + " ";
            }
        }

        s1 = s1.trim();
        s1 = s1.replaceAll("\\s", "");
        result = s1.split("");
        return result;
    }

    public static boolean isOperator(char c){
        char [] operator = {'+' , '-' , '*' , '/' , '(' , ')'};
        Arrays.sort(operator);
        if (Arrays.binarySearch(operator, c) > -1){
            return true;
        }
        else {
            return false;
        }
    }

    Node constructTree(char postfix[]) {
        Stack<Node> st = new Stack<Node>();
        Node t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                st.push(t);
            } else
            {
                t = new Node(postfix[i]);
                t1 = st.pop();
                t2 = st.pop();

                t.right = t1;
                t.left = t2;

                st.push(t);
            }
        }

        t = st.peek();
        st.pop();

        return t;
    }

    static final int COUNT = 10;
    static void printTree(Node root, int space)
    {
        if (root == null)
            return;

        space += COUNT;

        printTree(root.right, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        printTree(root.left, space);
    }

    static void printTree1(Node root)
    {
        printTree(root, 0);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Exercise3 et = new Exercise3();
        System.out.println("Nhập biểu thức: ");
        String postfix = sc.nextLine();
        String s = postFix(process(postfix));
        char[] charArray = s.toCharArray();
        Node root = et.constructTree(charArray);

        System.out.println("Cây nhị phân xây dựng từ biểu thức trên là: ");
        printTree1(root);

    }
}



