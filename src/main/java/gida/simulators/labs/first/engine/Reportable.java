package gida.simulators.labs.first.engine;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.resources.Queue;
import gida.simulators.labs.first.resources.Server;

import java.util.ArrayList;
import java.util.List;

public interface Reportable {

    void generateReport();
    void calculateQueueTime(Event event, Entity entity);
    void calculateTransitTime(Event event);
    void calculateIdleTime(Server server, Event event);
    void calculateQueueLength(Queue queue, Server server);
    void addEntityAmount(Entity entity);
    void calculateEndAtributes(List<Server> servers);

}
