
class SLL {

    class Node {

        private int item;
        private Node next;

        // get & Setter
        // public Node() {
        //     this.item = 0;
        //     this.next = null;
        // }
        public Node(int item) {
            this.item = item;
            this.next = null;
        }

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

        public void setItem(int data) {
            this.item = data;
        }

        public int getItem() {
            return this.item;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

    }

    // properties
    private Node start;

    // list is empty or not
    public boolean isEmptyList() {
        return this.start == null;
    }

    // insert new node at begining of list
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = start;
        this.start = newNode;
    }

    // insert new node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node temp = this.start;
        if (temp == null) {
            temp = newNode;
        } else {

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }

    // search a node of given item value
    // insert a new node after a given node
    // delete first node of the list
    public void deleteAtBegin() {
        Node temp = this.start;
        if (temp != null) {
            this.start = this.start.next;
        }
    }

    // delete last node of the list
    public void deleteAtEnd() {
        if (this.start == null) {
            return; // Empty list
        }
    
        if (this.start.next == null) {
            // List has only one node
            this.start = null;
            return;
        }
    
        Node temp = this.start;
        while (temp.next.next != null) {
            temp = temp.next;
        }
    
        // temp now points to second-last node
        temp.next = null;
    }
    

    // delete a node with given item value , if multiple found then delete first occurence
    // display list
    public void display() {
        Node temp = this.start;
        System.out.println("\n----------List Start----------");
        while (temp != null) {
            System.out.print(temp.item + ", ");
            temp = temp.next;
        }
        System.out.println("\n----------List End------------");

    }

}

public class SinglyLinkedList {

    public static void main(String[] args) {
        SLL slist = new SLL();

        slist.insertAtBegin(10);
        slist.insertAtBegin(20);
        slist.insertAtBegin(30);
        slist.insertAtBegin(40);
        slist.insertAtBegin(50);
        slist.insertAtBegin(60);
        slist.display();
        slist.insertAtEnd(99);
        slist.insertAtEnd(98);
        slist.insertAtEnd(97);
        slist.insertAtEnd(96);
        slist.insertAtEnd(95);
        slist.insertAtEnd(94);
        slist.display();
        slist.deleteAtBegin();
        slist.display();
        slist.deleteAtBegin();
        slist.display();
        slist.deleteAtBegin();
        slist.display();
        slist.deleteAtBegin();
        slist.display();
        slist.deleteAtBegin();
        slist.display();
        slist.deleteAtEnd();
        slist.display();
        slist.deleteAtEnd();
        slist.display();
        slist.deleteAtEnd();
        slist.display();

    }

}
