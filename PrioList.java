import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

public class PrioList {

    private LinkedList<Couple> queue;

    public PrioList(){
        this.queue = new LinkedList<Couple>();
    }

    public void addElement(Board b, int val, int depth, String path){
        Iterator<Couple> it = this.queue.iterator();
        Couple current;
        int index = 0;
        while(it.hasNext()){
            current = it.next();
            if(current.getValue() < val)this.queue.add(index, new Couple(b, val, depth, path));
            index++;
        }
        this.queue.addLast(new Couple(b, val, depth, path));
    }

    public Couple getFirst(){
        return this.queue.removeFirst();
    }

    public boolean isEmpty(){
        return this.queue.isEmpty();
    }
}
