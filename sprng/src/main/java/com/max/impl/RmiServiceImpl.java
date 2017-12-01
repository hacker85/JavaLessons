package com.max.impl;

import com.max.interfaces.RmiService;

public class RmiServiceImpl implements RmiService {
    @Override
    public void printMessage(String s) {
        System.out.println(s);
    }
}
