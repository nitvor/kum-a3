package com.company;

/**
 * Created by dokole on 12/7/17.
 */
public class MinCpuBalancer extends AbstractBalancer {
    @Override
    public HW select(VM vm) {
        if(hws.isEmpty())
            return null;
        HW result = null;
        for(HW h: hws){
            if(result == null || (result.vmsCPU() > h.vmsCPU() && vm.cpu <= h.cpu - h.vmsCPU()))
                result = h;
        }
        return result;
    }
}
