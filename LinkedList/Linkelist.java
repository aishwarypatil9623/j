public class Linkelist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data) {     
        // step1 = create new node
        Node newNode = new Node(data);
        size++;

        // step2 - newNode next = Head
        newNode.next = head;   // link

        // step3 - head = newNode
        head = newNode;
        if (tail == null) {
            tail = head; // Update tail if it is null
        }
    }

    public void addlast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("LL is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int idx, int data){
        if(idx == 0) {
            addfirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        // i = idx -1;  temp  -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println();
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val =head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }
    

    public static void main(String[] args) {
        Linkelist ll = new Linkelist();

        ll.print();
        ll.addfirst(2);
        ll.print();
        ll.addfirst(1);
        ll.print();
        ll.addlast(3);
        ll.print();
        ll.addlast(4);
        ll.print();
        ll.add(2, 9); //index,data

        ll.print();
        //System.out.println(ll.size);

        ll.removeFirst();
        ll.print();

    }
}
