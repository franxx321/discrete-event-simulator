package gida.simulators.labs.first.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.utils.Order;

public class FutureEventList {

    private ArrayList<Event> fel;

    private final Order order;


    //TODO cambiar la implementacion de la fel por un arraylist
    public FutureEventList(){
            this.fel=new ArrayList<>();
            order= new Order();
     }



    public void insert(Event event) {
        this.fel.add(event);
        this.fel.sort(order);
    }

    public Event getImminent() {
        Event ret = fel.remove(0);
        return ret;

    }

    public boolean hasNext(){
        return this.fel.isEmpty();
    }

    @Override
    public String toString() {
        String ret =
                "============================================================== F E L ==============================================================\n";

        Iterator<Event> it = this.fel.iterator();

        while (it.hasNext()) {
            ret += it.next().toString() + "\n";
        }

        ret += "***********************************************************************************************************************************\n\n";

        return ret;
    }
}
