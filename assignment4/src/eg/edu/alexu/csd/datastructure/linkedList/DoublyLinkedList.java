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
		try{
		if(index>size())
			throw new IndexOutOfBoundsException("Index Out Of Boundaries");
		DLNode newNode = new DLNode(element);
		if(this.size() > index) {
			DLNode temp = head;
			if(index==0)
			{
				newNode.next=head;
				head.prev=newNode;
				head=newNode;
				return;
			}
			for(int i=0; i<index-1; i++) {
				temp = temp.next;
			}
			temp.next.prev = newNode;
			newNode.next = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
		}
		if(size()==index)
		{
			DLNode temp=head;
			while (temp.next!=null)
			{
				temp=temp.next;
			}
			newNode.prev=temp;
			temp.next=newNode;
		}
		}
		catch (IndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}

	public void add(Object element) {
		DLNode temp = head;
		DLNode newNode = new DLNode(element);
		if(head == null) {
			head = newNode;
			return;
		}
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;
	}

	public Object get(int index) {
		Object val;
		if(head == null || index >= this.size())
			return null;
		DLNode temp = head;
		for(int i=0; i<index; i++) {
			temp = temp.next;
		}
		val = temp.value;
		return val;
	}

	public void set(int index, Object element) {
		try {
			if (index > size() - 1 || index < 0)
				throw new IndexOutOfBoundsException("Index Out Of Boundaries");
			if (head != null && index < this.size()) {
				DLNode temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				temp.value = element;
			}
		}
		catch (IndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
			System.exit(1);
		}
	}

	public void clear() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void remove(int index) {
        try {
            if (index > size() - 1 || index < 0)
                throw new IndexOutOfBoundsException("Index Out Of Boundaries");
            if (head == null) return;
            if (index == 0) {
                head = head.next;
                head.prev=null;
                return;
            }
            if (index < this.size()) {
                DLNode temp = head;
                if(index==size()-1)
                {
                    while (temp.next.next!=null)
                    {
                        temp=temp.next;
                    }
                    temp.next=null;
                }
                else{
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }}
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
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

	public DoublyLinkedList sublist(int fromIndex, int toIndex) {

		return null;
	}

	public boolean contains(Object o) {
		DLNode temp = head;
		while(temp != null) {
			if(temp.value == o)
				return true;
			temp=temp.next;
		}
		return false;
	}

}
