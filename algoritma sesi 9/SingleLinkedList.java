public class SingleLinkedList {
    // Node class
    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node head = null;
    
    
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    
    public void deleteNode(int key) {
        Node temp = head, prev = null;
        
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        
        if (temp == null) return;
        prev.next = temp.next;
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
        SingleLinkedList list = new SingleLinkedList();
        
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