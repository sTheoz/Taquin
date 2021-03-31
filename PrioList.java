import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;

public class PrioList {

    private LinkedList<Couple> queue;

    public PrioList(){
        this.queue = new LinkedList<Couple>();
    }

    public void addElement(Board b, int val, int depth, String path){
        int index = 0;
        for(Couple c: this.queue){
            if(c.getValue() > val){
                this.queue.add(index, new Couple(b, val, depth, path));
                return;
            }
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

    public int size(){
        return this.queue.size();
    }
}
