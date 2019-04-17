package eg.edu.alexu.csd.datastructure.linkedList;

public class Main {

    public static void main(String[] args) {
    	DoublyLinkedList test = new DoublyLinkedList();
    	test.add(5);
    	test.add(0);
    	test.add(5555);
    	test.add(4, 90);
    	DoublyLinkedList.DLNode temp;
    	temp = test.head;
    	while(temp!=null) {
    		System.out.println(temp.value);
    		temp=temp.next;
    	}
    }

    /*SinglyLinkedList.SLNode temp;
        temp=test.head;
        while (temp!=null) {
            System.out.println(temp.val);
            temp=temp.next;
        }
       /*DoublyLinkedList.DLNode temp;

        temp=test.head;
        while (temp!=null) {
            System.out.println(temp.value);
            temp=temp.next;
        }*/
}
