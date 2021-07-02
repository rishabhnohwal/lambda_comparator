package com.stackroute.exercises;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StringSort {

    //write here logic to sort a string List
    public String stringSorter(List<String> stringList, String sortingOrder) {
        if(stringList==null||stringList.isEmpty()||sortingOrder==null||sortingOrder.trim().isEmpty()){
            return "Given stringList or sortingOrder is empty, null or blank space";
        }

        Predicate<String> predicate1 = element->element==null;
        Predicate<String> predicate2 = element->element.trim().isEmpty();

        for (String element:stringList){
            if (predicate1.or(predicate2).test(element)){
                return "The list contains an empty or blank space value";
            }
        }

        if (sortingOrder.toLowerCase().equals("asc")){
            stringList.sort((o1,o2)->o1.compareTo(o2));
        }
        else if (sortingOrder.toLowerCase().equals("desc")){
            stringList.sort((o1,o2)->o2.compareTo(o1));
        }
        else {
            return "No sorting order present for given string '"+sortingOrder+"' , 'asc' for ascending order sort and 'desc' for descending order sort";
        }

        if (stringList.size()==1){
            return "The list contains only one value";
        }

        return stringList.toString();
    }
}
