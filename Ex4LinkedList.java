class Ex4LinkedList{
	// constructor for list stating how many elements are in the list 
	Ex4LinkedList(){
		numElements=0;
	}
	// Node object in the list, pointer to next Node, previous node and String with data in node
	private class Node {
		String data; Node next; Node prev;
	// creates new Node 
	Node(String data, Node next, Node prev) {
		this.data = data; this.next = next; this.prev = prev;
		}
	}
	// Head node, tail node and number of elements
	private Node head; private Node tail; private int numElements;
	// sets head and tail equal to null and num elements equal to 0 
	void initializeList(){
		head = null; tail = null; numElements = 0;
	}
	// Clears the list essentially by doing the same thing as initalizing the list
	void clearList(){
		head = null; tail = null; numElements = 0;
	}
	// For debugging and viewing purposes 
	void printList(){
		System.out.println();
		System.out.println("List size: " + numElements);
		Node print = head;
		for(int i = 1; i<=numElements; i++){
				System.out.println("Memory address of node " + i + ": " + print); 
				System.out.println("String contained in node " + i + ": " + print.data);
				print=print.next;
			}
		System.out.println();
	}
	// Used during debugging process
	// checks if the list contains elements.
	boolean hasElements(){
		boolean containsElements = false;
		if(numElements==0){
			containsElements=false;
		}
		else if (numElements>=1){
			containsElements = true;
		}
		return containsElements;
	}
	// Inserts a node at the end of the list as the tail.
	void insertAtEnd(String data){
	Node tempNode = head;
	Node newNode = new Node(data, null, null);
	if(head == null){
		head = newNode;
		head.prev = null;
		numElements = 1;
		return;
	}
	while(tempNode.next!=null){
		tempNode = tempNode.next;
	}
	tempNode.next=newNode;
	newNode.prev=tempNode;
	newNode.next=null;
	tail = newNode;
	numElements++;
	}
	// Inserts a node at the front of the list as the head.
	void insertAtFront(String data){
		Node tempNode = head;
		Node newNode = new Node(data,null,null);
		if(head == null){
		head = newNode;
		head.prev = null;
		numElements = 1;
		return;
		}
		tempNode.prev=newNode;
		newNode.next=tempNode;
		newNode.prev=null;
		head=newNode;
		numElements++;
	}
	// Returns the number of elements in the list.
	int getNumElements(){
		return numElements;
	}
	// Deletes nodes in the list.
	Node delete(String data){
		 Node x4 = head;
		 while(x4.data.equals(data)!=true){
		 	x4 = x4.next;
		 		if(x4==null){
		 		return null;
		 		}
		 	}

		 if(x4==head){
		 	head = x4.next;
		 }
		 else{
		 	x4.prev.next = x4.next;
		 }
		 if(x4==tail){
		 	tail=x4.prev;
		 }
		 else{
		 	x4.next.prev = x4.prev;
		 }
		 return x4;
	}

	// Gets the position of a node with the inputted data.
	int getPosition(String data){
		Node search = new Node(data,null,null); 
		Node temp = head;
		int position = 1; boolean check = false;
		String a = data; String b = "";
		while(temp!=null){
			b = temp.data; check = a.equals(b);
			if(check==false){
				position++;
			}
			else if(check==true){
				break;
			}
			temp = temp.next;
		}
			if(check==false){
				position = -1;
			}
			return position;
		}
	// Returns the node at the specified position in the list.
	Node getNode(int position){
			Node temp = head;
			for(int i=1; i<position; i++){
				if(temp.next!=null){
				temp = temp.next;
				}
			}
			return temp;
		}


	
	// Utilizes the getPosition, getNode and moveTowardsFront method
	// Returns the value obtained from the getPosition method 
	// Moves nodes accordingly using getNode and moveTowardsToward
	int findPositionAndMove(String data, int moveDistance){
		int position = getPosition(data);
		if((position!=-1)&&(position!=1)){
		Node temp = getNode(position);
		while(moveDistance!=0){
			if (temp.prev==null){
				break;
			}
			Node p = temp.prev;
			Node pp = p.prev;
			Node n = temp.next;
			if(pp!=null){
				pp.next = temp;
			}
			temp.prev = pp;
			temp.next = p;
			p.prev = temp;
			p.next = n;
			if(n!=null){
				n.prev = p;
			}
			moveDistance--;
	
		}
		}
		return position;
	}
	

}