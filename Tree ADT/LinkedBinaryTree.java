package hw5_19000311;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int numChildren(T p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    @Override
    public T parent(T p) {
        Node node = validate(p);
        return (T) node.getParent();
    }

    @Override
    public T left(T p) {
        Node node = validate(p);
        return (T) node.getLeft();
    }

    @Override
    public T right(T p) {
        Node node = validate(p);
        return (T) node.getRight();
    }

    @Override
    public T sibling(T p) {
        if (parent(p) == null) {
            return null;
        }
        if (p == left(parent(p))) {
            return right(parent(p));
        } else {
            return left(parent(p));
        }
    }

    protected Node validate(T p) {
        Node node = (Node) p;
        if (node.parent == node) {
            return null;
        }
        return node;
    }

    public static class Node<E> {
        public E element; // an element stored at this node
        public Node<E> parent; // a reference to the parent node (if any)
        public Node<E> left; // a reference to the left child
        public Node<E> right;// a reference to the right child

        // Constructs a node with the given element and neighbors. ∗/
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            // Sinh viên hoàn thiện phương thức
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
    }

    protected Node creatNode(E e, Node parent, Node left, Node right) {
        return new Node(e, parent, left, right);
    }

    //update methods
    public Node<E> addRoot(E element) {
// Add element to root of an empty tree
        if (!isEmpty()) {
            return null;
        }
        root = creatNode(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node p, E element) {
// Add element to left child node of p if empty
        Node parent = p;
        if (parent.getLeft() != null) {
            return null;
        }
        Node child = creatNode(element, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Node<E> addRight(Node p, E element) {
// Add element to right child node of p if empty
        Node parent = p;
        if (parent.getRight() != null) {
            return null;
        }
        Node child = creatNode(element, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public void set(Node p, E element) {
// set element to nnode p
        Node node = p;
        E temp = (E) node.getElement();
        node.setElement(element);
    }

    public static class ExpressionTree<E> extends LinkedBinaryTree{
        public void preorderPrint(Node<E> p) {
        //pre-order traversal of tree with root p
            if (p == null){
                return;
            } else {
                System.out.print(p.element + " ");
                preorderPrint(p.left);
                preorderPrint(p.right);
            }
        }

        String s = "";
        public String postorderPrint(Node<E> p) {
            //post-order traversal of tree with root p

            if (p == null) {
                return null;
            } else {

                postorderPrint(p.left);
                postorderPrint(p.right);
                s = s + p.element + " ";

            }
            return s;
        }

        public void inorderPrint(Node<E> p) {
            if (p == null){
                return;
            } else {
                inorderPrint(p.left);
                System.out.print(p.element + " ");
                inorderPrint(p.right);
            }
        }
    }


}