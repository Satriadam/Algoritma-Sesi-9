public class DoubleLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    Node head = null;
    Node tail = null;
    
    
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    
    public void deleteNode(int key) {
        Node temp = head;
        
        if (temp != null && temp.data == key) {
            head = temp.next;
            if (head != null) head.prev = null;
            return;
        }
        
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        
        if (temp == null) return;
        
        if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
            return;
        }
        
        temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }
    
    
    public void displayList() {
        Node current = head;
        if (head == null) {
            System.out.println("List kosong");
            return;
        }
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtFront(0);
        
        System.out.println("Setelah insert:");
        list.displayList();
        
        list.deleteNode(2);
        System.out.println("Setelah delete node 2:");
        list.displayList();
    }
}