package eg.edu.alexu.csd.datastructure.linkedList;

public class Main {

    public static void main(String[] args) {
	//DoublyLinkedList test=new DoublyLinkedList();
	SinglyLinkedList test=new SinglyLinkedList();
	test.add(5);
	test.add(0);
	test.add(5555);
	test.add(567);
	test.add(123);
	test.add(4,90);
	SinglyLinkedList test_test;
	test_test=test.sublist(0,5);

    SinglyLinkedList.SLNode temp;
        temp=test_test.head;
        while (temp!=null) {
            System.out.println(temp.val);
            temp=temp.next;
        }
        /*
       DoublyLinkedList.DLNode temp;

        temp=test.head;
        while (temp!=null) {
            System.out.println(temp.value);
            temp=temp.next;
        }*/
    }
}
