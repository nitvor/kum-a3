package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dokole on 11/9/17.
 */
public class HW {

    public List<VM> vms = new ArrayList<>();

    public String name;
    public int cpu;
    public int memmory;
    public int netz;
    public double nl;

    public HW(String input){
        String[] inputs = input.split(",");
        this.name = inputs[0];
        this.cpu = Integer.parseInt(inputs[1]);
        this.memmory = Integer.parseInt(inputs[2]);
        this.netz = Integer.parseInt(inputs[3]);
    }

    public void setNl(int cpuMax,int memmoryMax, int netMax){
        this.nl = (this.cpu/cpuMax+this.memmory/memmoryMax+this.netz/netMax)/3.0;
    }

    public void clear(){
        this.vms = new ArrayList<>();
    }

    public int vmsCPU(){
        int result = 0;
        for( VM vm: vms){
            result += vm.cpu;
        }
        return result;
    }

    public boolean isCPUOver(){
        return this.vmsCPU() > this.cpu;
    }

    public int vmsMemmory(){
        int result = 0;
        for( VM vm: vms){
            result += vm.memmory;
        }
        return result;
    }

    public double getVMSNL(){
        double result = 0;
        for( VM vm: vms){
            result += vm.nl;
        }
        return result;
    }

    public boolean isMemmoryOver(){
        return this.vmsMemmory()> this.memmory;
    }

    public int vmsNetz(){
        int result = 0;
        for( VM vm: vms){
            result += vm.netz;
        }
        return result;
    }

    public boolean isNetzOver(){
        return this.vmsNetz() > this.netz;
    }

}
