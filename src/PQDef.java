/*
 * Mounceph Morssaoui
 * 40097557
 * 
 */

/*
 * This program is used to implement an adaptable and flexible priority queue ADT
 * offering many methods
 * 
 */
public class PQDef<T> {

	//Constructors
	//Note, if not precised, a tree will by default be a min heap
	private boolean isMax; 
	Node[] pq;
	private int size = 0;


	public PQDef () {
		isMax = false;
		pq = new Node[10];
	}

	public PQDef (int size) {
		isMax = false;
		pq = new Node[size];
	}

	public PQDef (boolean type) {
		isMax = type;
		pq = new Node[10];
	}

	public PQDef (boolean type, int size) {
		isMax = type;
		pq = new Node[size];
	}

	
	//Sets heap order of a Node
	private void Heapify(int i) {

		int parent = parent(i);
		if (parent==-1) {
			return;
		}
		
		if(!isMax) {
		if (pq[i].key < pq[parent].key) {
			swap(i,parent);
		}
		}else if (pq[i].key > pq[parent].key) {
			swap(i,parent);
		}
		Heapify(parent);
			

	}
	
	//Restores heap order
	public void rearange() {
		for (int i = 0; i<size;i++ ) {
			Heapify(i);
		}
	}
	
	//Changes heap order to what it was, so if it was a min heap, changes to a max heap tree and vice versa
	private void changeType() {
		
		isMax = !isMax;
		
		for (int i = 0; i<size;i++ ) {
			Heapify(i);
		}
		
		
	}

	//Swaps content of two items in priority queue
	public void swap(int i, int min) {
		
		Node temp = pq[i];
		pq[i]=pq[min];
		pq[min]=temp;

	}
	
	//Removes the root of the tree and returns the node removed, restores heap order afterward
	public Node removeTop() {

		Node top = pq[0];
		
		remove(pq[0]);
		
		return top;
	}

	//Insert a key and value pair to PQueue and assures heap order
	public void insert(int key, T value) {

		if (size !=pq.length && pq[size]==null) {
			pq[size]= new Node(key,value);
			
		}
		else {
			if (pq.length != size) {
				pq[size+1]=new Node(key,value);
				
			}else {
				
				Node[] temp = new Node[pq.length*2];

				for (int j = 0; j<pq.length;j++) {
					temp[j]=pq[j];
				}
				pq=temp;
				temp=null;

				pq[size]=new Node(key,value);
					
			}
		}
		
		
		Heapify(size);
		size++;	

	}

	//returns root of tree
	public Node top() {
		return pq[0];
	}

	//removes node inputed and fixes heap and restores order
	public Node remove(Node entry) {
		
		Node[] temp = new Node[pq.length];
		int tracker = 0;
		boolean found = false;
		Node hold = null;
		
		
		for (int i =0; i<size;i++) {
			
			if (pq[i].key==entry.key&&pq[i].value==entry.value) {
				found = true;
				tracker = i;
				hold = pq[i];
				break;
			}
			
		}
			if (found==false) {
				System.out.println("The key was not found, return null");
				return null;
			}else {
			
			//swap(tracker,size);
			
			pq[size]=null;
			size--;
			swap(tracker,size);
					
			}
		
			rearange();
			
		return hold;
			
	}
	
	public String toString() {
		String s = "| ";
		
		for (int i = 0;i<size;i++) {
			s+= pq[i].key + " | ";
		}
		return s;
	}

	//Replaces node's key to inputed key
	public int replaceKey(Node entry, int k) {
		
		int temp = entry.key;
		entry.key = k;
		
		return temp;
	}

	//Replaces node's value to entered value
	public T replaceValue(Node entry, T val) {
		
		
		T temp = (T) entry.value;
		entry.value = val;
		
		return temp;
		
		
	}

	//Changes min tree to max and vice versa
	public void toggle() {

		changeType();

	}

	//Displays the state of the tree, whether is min or max heap
	public void state() {
		if (isMax)
			System.out.println("The priority queue is a MAX heap");
		else
			System.out.println("The priority queue is a MIN heap");
	}

	//return size
	public int size() {
		return size;
	}
	//return true if PQ is empty
	public boolean isEmpty() {
		return (size==0);
	}

	//returns index of parents
	private int parent(int index) {
		if(index == 0) {
			return -1;
		}else
		{
			 if (index%2==1) {
				return ((int) Math.floor(index/2.0));
			}else
			return (int) Math.floor(index/2.0) -1;
		}
	}
	 
	//Object to store key and value pair
	class Node<S>{		
		private int key;
		private S value;

		//Constructor
		public Node(int key, S value) {
			this.key = key;
			this.value = value;
		}

		//Displays node info
		public String toString() {
			return "key: "+ key + " and value: " + value;
		}
		
	}


}
