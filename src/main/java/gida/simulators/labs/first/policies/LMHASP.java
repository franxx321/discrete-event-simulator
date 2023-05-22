package gida.simulators.labs.first.policies;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.entities.HeavyAircraft;
import gida.simulators.labs.first.entities.MaintenanceCrew;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.HFA;
import gida.simulators.labs.first.resources.Server;

import java.util.ArrayList;
import java.util.List;

public class LMHASP implements ServerSelectionPolicy {
    /*CDESC Light Medium Heavy Aircraft Selection Policy, implements ServerSelectionPolicy
     * returns the server that needs to be operated on*/
    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        if (entity instanceof MaintenanceCrew){
            Airstrip ret= (Airstrip)servers.get(0);
            for (Server server: servers) {
                Airstrip airstrip=(Airstrip)server;
                if((airstrip.getDurability()/airstrip.getMaxDurability())<(ret.getDurability()/ret.getMaxDurability())){
                    ret=airstrip;
                }
            }
            return ret;
            //TODO terminar la politica
        } else if (entity instanceof HeavyAircraft) {
            List<Server> heavyAirstrips =new ArrayList<>();
            for (Server server:servers) {
                if (server instanceof HFA){
                    heavyAirstrips.add(server);
                }
                Server ret =heavyAirstrips.get(0);
                for (Server heavyAirstip: heavyAirstrips) {
                }



            }


        }

        return null;
    }

}
