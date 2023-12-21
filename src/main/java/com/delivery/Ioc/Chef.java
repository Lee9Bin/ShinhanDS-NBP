package com.delivery.Ioc;

public class Chef {
    public String cook(String menu) {
//        Pork p = new Pork("한돈 안심 ");
        Beef beef = new Beef("한우 꽃등심 ");
        return beef.getName() + menu;
    }
}
