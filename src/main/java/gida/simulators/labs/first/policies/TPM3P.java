package gida.simulators.labs.first.policies;

import gida.simulators.labs.first.entities.*;
import gida.simulators.labs.first.resources.*;

import java.util.ArrayList;
import java.util.List;

public class TPM3P implements ServerSelectionPolicy {
    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        Server ret = null;
        if (entity instanceof MaintenanceCrew) {
            Airstrip airRet = (Airstrip) servers.get(0);
            for (Server server : servers) {
                Airstrip airstrip = (Airstrip) server;
                if ((airstrip.getDurability() / airstrip.getMaxDurability()) < (airRet.getDurability() / airRet.getMaxDurability())) {
                    airRet = airstrip;
                }
            }
            ret = airRet;
            return ret;
        } else {
            List<Server> correctTypeAirstrip = new ArrayList<>();
            if (entity instanceof HeavyAircraft) {
                for (Server server : servers) {
                    if (server instanceof HFA) {
                        correctTypeAirstrip.add(server);
                    }
                }
            } else if (entity instanceof MediumAircraft) {
                for (Server server : servers) {
                    if (server instanceof MFA) {
                        correctTypeAirstrip.add(server);
                    }
                }
            } else if (entity instanceof LightAircraft) {
                for (Server server : servers) {
                    if (server instanceof LFA) {
                        correctTypeAirstrip.add(server);
                    }
                }
            }
            ret = getServer(ret, correctTypeAirstrip);
        }
        if (ret == null) {
            for (Server server : servers) {
                if (!this.expectingMaintenance(server)) {
                    ret = server;
                    return ret;
                }

            }
        }
        return ret;

    }

    public boolean expectingMaintenance(Server server) {
        boolean ret=false;
        try{
            if(server.getCurrentEntity() instanceof MaintenanceCrew){
                ret=true;
            }
            else {
                for (Queue queue:server.getQueues()) {
                    if (queue.checkLast() instanceof MaintenanceCrew){
                        ret= true;
                    }
                }
            }
        }
        catch (NullPointerException nullPointerException){
            ret=false;
        }
        finally {
            return ret;
        }
    }

    private Server getServer(Server ret, List<Server> heavyAirstrips) {
        int a=0,b=0;
        for (int i = 0; i < heavyAirstrips.size(); i++) {
            if (!expectingMaintenance(heavyAirstrips.get(i))) {
                try{
                    if (heavyAirstrips.get(i).isBusy()){
                        a=heavyAirstrips.get(i).getLastQueue().getSize()+1;
                    }
                    else {
                        a=heavyAirstrips.get(i).getLastQueue().getSize();
                    }
                    if (ret.isBusy()){
                        b=ret.getLastQueue().getSize()+1;
                    }
                    else {
                        b=ret.getLastQueue().getSize();
                    }
                    if(a<b){
                        ret=heavyAirstrips.get(i);
                    }
                }
                catch (NullPointerException nullPointerException){
                    ret=heavyAirstrips.get(i);
                }

            }
        }
        return ret;

    }
}
