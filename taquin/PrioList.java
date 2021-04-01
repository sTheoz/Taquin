package taquin;

import java.util.LinkedList;

public class PrioList {

    private LinkedList<Couple> queue;

    public PrioList(){
        this.queue = new LinkedList<>();
    }

    public void addElement(Board b, int val, int depth, String path){
        int index = 0;
        for(Couple c: this.queue){
            if(val < c.getValue()){
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
