package gida.simulators.labs.first.utils;
import gida.simulators.labs.first.events.Event;
import java.util.Comparator;

public class Order implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        int ret = 0;
        if (e1.getClock() < e2.getClock()) {
            ret = -1;
        } else if (e1.getClock() > e2.getClock()) {
            ret = 1;
        } else if (e1.getOrder() < e2.getOrder()) {
            ret = -1;
        } else if (e1.getOrder() > e2.getOrder()) {
            ret = 1;
        }
        return ret;
    }
}
