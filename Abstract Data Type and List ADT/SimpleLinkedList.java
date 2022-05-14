package hw3_19000311;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
        Node(T d){
            data = d;
        }
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
    // Thêm phần tử vào đầu danh sách
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void addBot(T data) {
        // Thêm phần tử vào cuối danh sách
        Node newNode = new Node(data);

        if (top == null){
            top = new Node(data);
            return;
        }

        newNode.next = null;
        Node bot = top;
        while (bot.next != null){
            bot = bot.next;
        }
        bot.next = newNode;
        return;
    }
    public T get(int i) {
// Lấy phần tử ở vị trí thứ i
        Node temp = top, result = null;
        int count = 0;
        while (temp != null){
            ++count;
            temp = temp.next;
            if (count == i){
                result.data = temp.data;
                break;
            }
        }
        return result.data;
    }
    public void set(int i, T data){
// Gán giá trị ở vị trí i bằng data
        Node temp = top;
        int count = 0;
        while (temp != null){
            ++count;
            if (count == i){
                temp.data = data;
            }
            temp = temp.next;
        }
    }
    public boolean isContain(T data) {

// Kiểm tra trong danh sách có chứa phần tử data hay không?
        Node current = top;
        while (current != null)
        {
            if (current.data == data)
                return true;    //data found
            current = current.next;
        }

        return false;

    }
    public int size() {
// Trả lại thông tin số phần tử có trong danh sách
        Node temp = top;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;

    }
    public boolean isEmpty() {
        // Kiểm tra danh sách có rỗng hay không?
        if (size() == 0){
            return true;
        }
        return false;

    }
    public T removeTop() {
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        Node temp = top;
        T result = top.data;
        if (temp != null)
        {
            top = temp.next; // Changed head
        }

        return result;
    }
    public T removeBot() {
    // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        Node temp = top, prev = null;
        T result = bot.data;
        while (temp != null && temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        if (temp == null){
            prev.next = temp.next;
        }
        return result;
    }
    public void remove(T data) {

// Xóa tất cả các phần tử có giá trị bằng data
        Node temp = top, prev = null;

        if (temp != null && temp.data == data)
        {
            top = temp.next;
            return;
        }

        while (temp != null && temp.data != data)
        {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }
}
