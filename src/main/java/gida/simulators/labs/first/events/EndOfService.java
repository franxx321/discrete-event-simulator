package gida.simulators.labs.first.events;

import java.util.List;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Server;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, EndOfServiceBehavior behavior) {
        super(clock,entity,behavior,0);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        if(/*TOASK como veo en que servidor esta la entidad para ver si este tiene cola?*/){
            //Aca iria la linea que marcaria el servidor actual como desocupado, SI TAN SOLO SUPIERA MI SERVIDOR
        }
        else{
            /*TOASK tengo que saber de manera magica cual es la entidad a la que le genero el EoS o genero una nueva? si
            *   genero una nueva, no se me va a la mierda la lista de eventos de la entidad?*/
        }
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "end of service - entity id: " + this.getEntity().getId() + " - clock: "
                + this.getClock();
        return ret;
    }
}
