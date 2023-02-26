package Question4;

//Given a linked list containing an integer value, return the number of steps required to sort an array in
//        ascending order by eliminating elements at each step
//        Note: at each step remove element a[i] where a[i-1]> a[i]

public class LinkedList {
    node head;
    node sorted;
    int totalCount;
    class node {
        int data;
        node next;
        public node(int data) {
            this.data = data;
        }
    }

    void push(int data) {
        node newnode = new node(data);
        newnode.next = head;
        head = newnode;
    }


    void insertionSort(node headref) {
        sorted = null;
        node current = headref;
        while (current != null) {
            node next = current.next;
            sortedInsert(current);
            current = next;
        }

        head = sorted;
//        System.out.println("count is"+count);
    }


    int sortedInsert(node newnode) {
        int count =0;
        // Special case for the head end
        if (sorted == null ||
                sorted.data >= newnode.data) {
            newnode.next = sorted;
            sorted = newnode;

        } else {
            node current = sorted;
            while (current.next != null &&
                    current.next.data < newnode.data) {
                current = current.next;
//                count+=1;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        return count;
    }


    void printlist(node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);
        System.out.println(
                "Linked List before Sorting..");
        list.printlist(list.head);
        list.insertionSort(list.head);
        System.out.println(
                "LinkedList After sorting");
        list.printlist(list.head);
//        System.out.println("count is "+list.totalCount);
    }
}
