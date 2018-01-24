package com.company;

/**
 * Created by dokole on 12/7/17.
 */
public class RandomBalancer extends AbstractBalancer {
    @Override
    public HW select(VM vm) {
        if(hws.isEmpty())
            return null;
        return hws.get(((int) (Math.random() * hws.size()) + 0));
    }
}
