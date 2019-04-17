package eg.edu.alexu.csd.datastructure.linkedList;

public class Main {

    public static void main(String[] args) {
    	DoublyLinkedList test = new DoublyLinkedList();
    	test.add(0);
    	test.add(1);
    	test.add(2);
    	test.add(3);
    	test.add(4);
    	test.add(5);
    	DoublyLinkedList temp = test.sublist(0, 3);
    	DoublyLinkedList.DLNode tempo = temp.head;
    	while(tempo!=null) {
    		System.out.println(tempo.value);
    		tempo=tempo.next;
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
