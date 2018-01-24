package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dokole on 11/9/17.
 */
public abstract class AbstractBalancer {
    public List<HW> hws = new ArrayList<>();
    public List<VM> vms = new ArrayList<>();
    public int maxCPU = 0;
    public int maxMemmory = 0;
    public int maxNetz = 0;

    public String name;

    public void addHW(String hwString){
        HW hw = new HW(hwString);
        boolean refresh = false;
        if(maxCPU < hw.cpu){
            maxCPU = hw.cpu;
            refresh = true;
        }
        if(maxMemmory < hw.memmory){
            maxMemmory = hw.memmory;
            refresh = true;
        }
        if(maxNetz < hw.netz){
            maxNetz = hw.netz;
            refresh = true;
        }
        if(refresh){
            for (HW a : hws)
                a.setNl(maxCPU,maxMemmory,maxNetz);
        }
        hws.add(hw);
        hw.setNl(maxCPU,maxMemmory,maxNetz);
    }

    public void clearVMS(){
        for(HW h : hws)
            h.clear();
        this.vms = new ArrayList<>();
    }

    public void clearHW(){
        this.hws = new ArrayList<>();
        this.vms = new ArrayList<>();
    }

    public void balance(){
        for (VM vm: vms) {
            HW hw = this.select(vm);
            hw.vms.add(vm);
        }
    }

    public abstract  HW select(VM vm);

    public void addVM(String vmString){
        VM vm = new VM(vmString);
        vms.add(vm);
        vm.setNl(maxCPU,maxMemmory,maxNetz);
    }

}
