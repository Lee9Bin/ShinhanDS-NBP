package com.delivery.Ioc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChefTest {
    @Test
    void don(){
        Chef chef = new Chef();
        String menu = "돈까스";

        String food = chef.cook(menu);

        String expected = "한돈 안심 돈까스";

        assertEquals(expected,food);
        System.out.println(food);
    }

    @Test
    void stake(){
        Chef chef = new Chef();
        String menu = "스테이크";

        String food = chef.cook(menu);

        String expected = "한우 꽃등심 스테이크";

        assertEquals(expected,food);
        System.out.println(food);
    }

}