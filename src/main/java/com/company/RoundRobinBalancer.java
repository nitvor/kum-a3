package com.company;

/**
 * Created by dokole on 12/7/17.
 */
public class RoundRobinBalancer extends AbstractBalancer {
    private int counter = 0;
    @Override
    public HW select(VM vm) {
        if(hws.isEmpty())
            return null;
        if(this.counter == hws.size())
            this.counter = 0;
        HW res = hws.get(counter);
        counter++;
        return  res;
    }
}
