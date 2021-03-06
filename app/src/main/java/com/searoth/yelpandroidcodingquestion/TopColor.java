package com.searoth.yelpandroidcodingquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TopColor {
    public static final String GREEN = "green";
    public static final String YELL = "yellow";
    public static final String  RED = "red";
    public static final String  BLUE = "blue";
    public static final String  ORANGE = "orange";
    public static final String  PURPLE = "purple";
    /**
     * @param args
     *
     * Given a List of Lists, find the color(s) that occurs the most and return an alphabetized list
     * of the most frequent color(s)     *
     *
     */
    public static void main(String args[]) {
        List<List<String>> mainList = new ArrayList<List<String>>();

        List<String> one = new ArrayList<>();
        one.add(GREEN);
        one.add(YELL);
        one.add(RED);
        one.add(BLUE);
        one.add(ORANGE);
        one.add(PURPLE);

        List<String> two = new ArrayList<>();
        two.add(GREEN);
        two.add(YELL);
        two.add(RED);
        two.add(BLUE);
        two.add(ORANGE);
        two.add(PURPLE);

        List<String> three = new ArrayList<>();
        three.add(GREEN);
        three.add(YELL);
        three.add(RED);
        three.add(BLUE);
        three.add(ORANGE);
        three.add(PURPLE);

        mainList.add(one);
        mainList.add(two);
        mainList.add(three);

        System.out.println(topColor(mainList));
    }

    /**
     *
     * @param image List of Lists of Strings
     * @return alphabetized list of the most frequent colors found in all lists
     */
    public static List<String> topColor(List<List<String>> image) {
        List<String> ret;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int max = 1;

        for(List<String> inner : image){
            for(String color : inner){
                if(map.containsKey(color)) {//does color already exist?
                    int count = map.get(color)+1;
                    max = count > max ? count : max;
                    map.put(color, count);
                }else if (isValidColor(color))map.put(color,1);
            }
        }
        ret = buildMostSeenColorList(map, max);//build unsorted list
        if(map.size() > 1) {
            ret = ret.size() > 1 ? sortListString(ret) : ret; //sort if size > 1
        }
        return ret;
    }

    /**
     *
     * @param map colors and their frequency
     * @param key frequency of color to find and add to ArrayList<String>
     * @return unsorted list of colors
     */
    private static List<String> buildMostSeenColorList(HashMap<String, Integer> map, int key){
        List<String> ret = new ArrayList<>();
        Set<String> set = map.keySet();
        for(String s : set){
            if(map.get(s) == key)
                ret.add(s);
        }
        return ret;
    }

    /**
     *
     * @param arr unsorted list
     * @return sorted list using BubbleSort
     */
    private static List<String> sortListString(List<String> arr){
        String temp;

        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.size(); j++){
                if(j+1 < arr.size()) {
                    int isBigger = arr.get(j).compareTo(arr.get(j + 1));
                    if (isBigger > 0) {
                        temp = arr.get(j + 1);
                        arr.set(j + 1, arr.get(j));
                        arr.set(j, temp);
                    }
                }
            }
        }
        return arr;
    }

    /**
     *
     * @param name color to validate
     * @return whether it's one of our colors
     */
    private static boolean isValidColor(String name){
        switch (name) {
            case GREEN:
                return true;
            case BLUE:
                return true;
            case YELL:
                return true;
            case RED:
                return true;
            case PURPLE:
                return true;
            case ORANGE:
                return true;
            default:
                return false;
        }
    }
}

