package eg.edu.alexu.csd.datastructure.linkedList;

public class DoublyLinkedList implements ILinkedList {
	
	class DLNode{
		Object value;
		DLNode next;
		DLNode prev;
		DLNode(Object value){
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}
	
	DLNode head;

	public void add(int index, Object element) {
		if(this.size() > index + 1) {
			DLNode temp = head;
			for(int i=0; i<index-1; i++) {
				temp = temp.next;
			}
			DLNode newNode = new DLNode(element);
			temp.next.prev = newNode;
			newNode.next = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
		}
	}

	public void add(Object element) {
		
		
	}

	public Object get(int index) {
		
		return null;
	}

	public void set(int index, Object element) {
		
		
	}

	public void clear() {
		head = null;
	}

	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}

	public void remove(int index) {
		
		
	}

	public int size() {
		DLNode temp = head;
		if(head == null)
			return 0;
		int size = 1;
		while(temp.next != null) {
			size++;
			temp = temp.next;
		}			
		return size;
	}

	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		return null;
	}

	public boolean contains(Object o) {
		
		return false;
	}

}
