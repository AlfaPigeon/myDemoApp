package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App{

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("x");
            String input2 = req.queryParams("y");
            String input3= req.queryParams("s1");
            String input4 = req.queryParams("s2");

            java.util.Scanner x = new java.util.Scanner(input1);
            x.useDelimiter("[;\r\n]+");
            java.util.Scanner y = new java.util.Scanner(input2);
            y.useDelimiter("[;\r\n]+");

            String s1 = input3;
            String s2 = input4;

            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            java.util.ArrayList<Integer> output = new java.util.ArrayList<>();
            while (x.hasNext())
            {
                int value = Integer.parseInt(x.next().replaceAll("\\s",""));
                inputList.add(value);
            }

            while (y.hasNext())
            {
                int value = Integer.parseInt(y.next().replaceAll("\\s",""));
                output.add(value);
            }

            int[] arr1 = new int[inputList.size()];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = inputList.get(i);
            }
            int[] arr2 = new int[output.size()];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = output.get(i);
            }


            boolean result = App.myMethod(arr1,arr2,s1,s2);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;

        for (int elt : array) {
            if (elt == e) return true;
        }
        return false;
    }

    /**
     *
     * solves s1 and s2 polinomşal by values in x
     * and adds them and compares them to values in y,
     * if y has such values returns true
     * +-ax^n, n  can only be 1
     *
     * @param x  an array of inputs
     * @param y an array of outputs
     * @param s1 polinomial 1
     * @param s2 polinomial 2
     * @return returns true if y has every output
     */
    public static boolean myMethod(int[] x, int[] y, String s1, String s2) {

        if(
                x.length == 0
                | y.length == 0
                | s1.length() == 0
                | s2.length() == 0
                | s1.indexOf("x") == -1
                | s2.indexOf("x") == -1
                )return false;

        boolean check = false;


        int kat1 = ((s1.charAt(0) == '-')?-1:1)*Integer.parseInt(s1.substring(1,s1.length()-1));
        int kat2 = ((s2.charAt(0) == '-')?-1:1)*Integer.parseInt(s2.substring(1,s2.length()-1));


        int val = 0;
        for(int i : x){
        val = 0;
        val = val + i*kat1 + i*kat2;


        for(int c : y){
            if(c == val){
                check = true;
                break;
            }
        }



        }



        return check;
    }

}