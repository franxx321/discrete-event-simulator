package gida.simulators.labs.first.policies;

import gida.simulators.labs.first.entities.*;
import gida.simulators.labs.first.resources.*;

import java.util.ArrayList;
import java.util.List;

public class LMHASP implements ServerSelectionPolicy {
    /*CDESC Light Medium Heavy Aircraft Selection Policy, implements ServerSelectionPolicy
     * returns the server that needs to be operated on*/



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
                    if (!((Airstrip)server).expectingMaintenance()) {
                        ret = server;
                        return ret;
                    }

                }
            }
            return ret;

    }

    private Server getServer(Server ret, List<Server> heavyAirstrips) {
        int a=0,b=0;
        for (int i = 0; i < heavyAirstrips.size(); i++) {
            if (!((Airstrip)heavyAirstrips.get(i)).expectingMaintenance()) {
                try{
                    if (heavyAirstrips.get(i).isBusy()){
                        a=heavyAirstrips.get(i).getQueue().getSize() +1;
                    }
                    else {
                        a=heavyAirstrips.get(i).getQueue().getSize();
                    }
                    if (ret.isBusy()){
                        b=ret.getQueue().getSize()+1;
                    }
                    else {
                        b=ret.getQueue().getSize();
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
        if(ret.getId()==heavyAirstrips.get(0).getId()&& ((Airstrip)ret).expectingMaintenance()){
            ret=null;
        }
        return ret;

    }

}
