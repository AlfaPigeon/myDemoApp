package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.*;


public class AppTest {

    public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        assertTrue(new App().search(array, 4));
    }
    public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 5));
    }
    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertFalse(new App().search(array, 1));
    }
    public void testNull() {
        assertFalse(new App().search(null, 1));
    }


    public void testOne() {
        int[] x = {1};
        int[] y = {3};
        String s1 = "+1x";
        String s2 = "+2x";
        assertTrue(new App().myMethod(x,y,s1,s2));
    }

    public void testTwo() {
        int[] x = {1,2,3,4,5,6};
        int[] y = {1,2,6};
        String s1 = "+4x";
        String s2 = "+2x";
        assertTrue(new App().myMethod(x,y,s1,s2));
    }
    public void testThree() {
        int[] x = {1,2};
        int[] y = {52};
        String s1 = "+50x";
        String s2 = "+2x";
        assertTrue(new App().myMethod(x,y,s1,s2));
    }
    public void testFour() {
        int[] x = {1};
        int[] y = {1,2,3,4,5,6,7,8,9,10};
        String s1 = "+50x";
        String s2 = "-2x";
        assertFalse(new App().myMethod(x,y,s1,s2));
    }
    public void testFive() {
        int[] x = {1,2,3,4,5,6,7,8,9};
        int[] y = {50};
        String s1 = "+100x";
        String s2 = "-50x";
        assertTrue(new App().myMethod(x,y,s1,s2));
    }
}
