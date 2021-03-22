import java.util.Random;

public class SkipListTester {
	public static void main(String[] args) {
		SkipList<Integer> list = new SkipList<Integer>(0.5);
		Random rand = new Random(4);

        for(int i = 0; i < 20; i++) {
        	if(rand.nextInt(10) < 5){
				int toBeAdded = rand.nextInt(10);
        		list.add(toBeAdded);
				System.out.println(toBeAdded + " has been added");
        	}
        	else {
				int removed = rand.nextInt(10);
        		list.remove(removed);
				System.out.println(removed + " has been removed");
        	}
            list.print();
            System.out.println();
        }
        
        System.out.println("yo sup");
    }

}