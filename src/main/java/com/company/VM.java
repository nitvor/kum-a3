package com.company;

/**
 * Created by dokole on 11/9/17.
 */
public class VM {

    public String name;
    public int cpu;
    public int memmory;
    public int netz;
    public double nl;

    public VM(String input){
        String[] inputs = input.split(",");
        this.name = inputs[0];
        this.cpu = Integer.parseInt(inputs[1]);
        this.memmory = Integer.parseInt(inputs[2]);
        this.netz = Integer.parseInt(inputs[3]);
    }

    public void setNl(int cpuMax,int memmoryMax, int netMax){
        this.nl = (this.cpu/cpuMax+this.memmory/memmoryMax+this.netz/netMax)/3.0;
    }
}
