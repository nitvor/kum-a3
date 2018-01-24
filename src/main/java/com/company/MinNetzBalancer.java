package com.company;

/**
 * Created by dokole on 12/7/17.
 */
public class MinNetzBalancer extends AbstractBalancer {
    @Override
    public HW select(VM vm) {
        if(hws.isEmpty())
            return null;
        HW result = null;
        for(HW h: hws){
            if(result == null || (result.vmsNetz() > h.vmsNetz() && vm.netz <= h.netz-h.vmsNetz()))
                result = h;
        }
        return result;
    }
}
