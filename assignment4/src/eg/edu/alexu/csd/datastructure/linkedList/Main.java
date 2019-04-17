package eg.edu.alexu.csd.datastructure.linkedList;

public class Main {

    public static void main(String[] args) {
	DoublyLinkedList test=new DoublyLinkedList();
	//SinglyLinkedList test=new SinglyLinkedList();
	test.add(5);
	test.add(0);
	test.add(5555);
	test.add(3,90);


    /*SinglyLinkedList.SLNode temp;
        temp=test.head;
        while (temp!=null) {
            System.out.println(temp.val);
            temp=temp.next;
        }*/
       DoublyLinkedList.DLNode temp;

        temp=test.head;
        while (temp!=null) {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
}
