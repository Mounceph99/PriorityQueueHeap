

public class PriorityQueueHeap {
	
	public static void main(String[] args){
		
		//Creating a PQ
		PQDef p = new PQDef();
		
		//Checking if PQ is empty
		System.out.println("The PQ is " + (p.isEmpty()? "empty!!": "not empty!!"));
		
		//Inserting key and value pairs to PQ
		System.out.println("\nCurrently add elements to PQ...\n\n");
		
		p.insert(3, "A+");
		p.insert(9, "A");
		p.insert(17, 100);
		p.insert(65, 'e');
		p.insert(7, 10);
		
		p.insert(1, 100);
		p.insert(12, 11);
		p.insert(16, 100);
		p.insert(8, "B");
		p.insert(2, 9);
		
		//Here the default size is busted, therefore is increase with the 
		//doubling array size strategy
		//O(n)
		p.insert(45,"Mounceph");
		
		//Printing 
		System.out.println("Size of PQ is " + p.size());
		
		System.out.println("Printing PQ keys only\n"+p);
		
		System.out.println("\n\nPrinting PQ key-value pairs");
		for (int i = 0;i<p.size();i++) {
			System.out.println(p.pq[i]);
		}
		System.out.println("\n\n");
		//Printing: changing tree to max heap
		p.state();
		System.out.println("Changing tree to MAX heap");
		p.toggle();
		
		System.out.println("Printing PQ keys only\n"+p);
		
		System.out.println("\n\n");
		//Print top then removing top
		System.out.println("Here is the root of tree");
		System.out.println(p.top());
		System.out.println("Now removing root is the root of tree");
		p.removeTop();
		System.out.println("Printing PQ keys only\n"+p);
		
		System.out.println("\n\n");
		//Remove some nodes 
		System.out.println("About to remove elements of PQ, the following are removed...");
		System.out.println(p.remove(p.pq[2]));
		System.out.println(p.remove(p.pq[6]));
		System.out.println(p.remove(p.pq[2]));
		
		System.out.println("\nUpdated PQ keys only\n"+p);
		
		System.out.println("\n\n");
		//Replace some node's key 
		System.out.println("About to replace elements of PQ, the following are removed...");
		System.out.println(p.replaceKey(p.pq[2],69));
		System.out.println(p.replaceKey(p.pq[6],14));
		System.out.println(p.replaceKey(p.pq[2],6));
		
		System.out.println("\n\nPrinting PQ key-value pairs");
		for (int i = 0;i<p.size();i++) {
			System.out.println(p.pq[i]);
		}
		System.out.println("\n");
	
		//Printing: changing tree to min heap
		p.state();
		System.out.println("Changing tree to MIN heap");
		p.toggle();
		
		System.out.println("Printing PQ keys only\n"+p);
		
		System.out.println("\n");
		//Replace some node's value 
		System.out.println("About to replace elements of PQ, the following are removed...");
		System.out.println(p.replaceValue(p.pq[2],"Replaced1"));
		System.out.println(p.replaceValue(p.pq[6],"Replaced2"));
		System.out.println(p.replaceValue(p.pq[2],"Replaced3"));
		
		System.out.println("\n\nPrinting PQ key-value pairs");
		for (int i = 0;i<p.size();i++) {
			System.out.println(p.pq[i]);
		}
		System.out.println("\n");
		
		
		//Checking if PQ is empty
		System.out.println("The PQ is " + (p.isEmpty()? "empty!!": "not empty!!"));
		
		//Inserting key and value pairs to PQ
		System.out.println("\nCurrently add elements to PQ...\n\n");
		
		//Tested methods
		
		System.out.println("***Thank you***");
		
	}

}

