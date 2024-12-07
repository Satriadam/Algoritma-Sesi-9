public class CircularLinkedList {
    class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    Node last = null;
    
    
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }
    
    
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }
    
    
    public void deleteNode(int key) {
        if (last == null) return;
        
        Node current = last.next;
        Node prev = last;
        
        
        if (current == last && current.data == key) {
            last = null;
            return;
        }
        
        do {
            if (current.data == key) {
                if (current == last) {
                    last = prev;
                }
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }
    
    
    public void displayList() {
        if (last == null) {
            System.out.println("List kosong");
            return;
        }
        
        Node current = last.next;
        System.out.print("List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != last.next);
        System.out.println();
    }
    
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
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