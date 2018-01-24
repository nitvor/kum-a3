package com.company;

/**
 * Created by dokole on 12/7/17.
 */
public class MinNLBalancer extends AbstractBalancer {
    @Override
    public HW select(VM vm) {
        if(hws.isEmpty())
            return null;
        HW result = null;
        for(HW h: hws){
            if(result == null || (result.getVMSNL() > h.getVMSNL() && vm.nl <= h.nl-h.getVMSNL()))
                result = h;
        }
        return result;
    }
}
