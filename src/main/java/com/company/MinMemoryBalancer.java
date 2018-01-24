package com.company;

/**
 * Created by dokole on 12/7/17.
 */
public class MinMemoryBalancer extends AbstractBalancer {
    @Override
    public HW select(VM vm) {
        if(hws.isEmpty())
            return null;
        HW result = null;
        for(HW h: hws){
            if(result == null || (result.vmsMemmory() > h.vmsMemmory() && vm.memmory <= h.memmory-h.vmsMemmory()))
                result = h;
        }
        return result;
    }
}
