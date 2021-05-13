public class UnionFind {

    int count = 0;

    public void makeset(Cell c) {
        // if cell doesn't have a set, make new linkedlist and set cell as head
        if(find(c) == null) {
            count++;
            LLAddOnly newList = new LLAddOnly();
            newList.add(c);
        }
    }

    public LLAddOnly find(Cell c) {
        // if cell has a header, return it. otherwise, return null
        if(c.head == null) {
            return null;
        }

        return c.head;
    }

    public boolean union(Cell c1, Cell c2) {

        // for each cell in c1, if its header is already set to c2's header,
        // add c1 to c2's header and change c1's head to be c2's head
        if(!find(c1).equals(find(c2))) {
            Cell curCell = c2.head.first;
            while(curCell != null) {
                Cell nextCell = curCell.next;
                c1.head.add(curCell);
                curCell = nextCell;
            }
            count--;
            return true;
        } else {
            return false;
        }
    }

}