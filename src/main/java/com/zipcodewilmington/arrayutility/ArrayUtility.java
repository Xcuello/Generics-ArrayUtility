package com.zipcodewilmington.arrayutility;

import javax.jws.Oneway;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    T[] list;

    public ArrayUtility(T[] list) {

        this.list = list;
    }


    public int getNumberOfOccurrences(T element){

        int count = 0;

        for( T el : list) {

            if(el.equals(element)) {
                count++;
            }
        }
        return count;
    }
    
    public Object[] merge(T[] arr1) {
        
        Object[] mergeArr = new Object[list.length + arr1.length];

      int counter = 0;

      for(T el : list) {

          mergeArr[counter] = el;

          counter++;
      }
      for(T el : arr1) {

          mergeArr[counter] = el;

          counter++;
      }

      return mergeArr;
        
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

       ArrayUtility arrayUtil = new ArrayUtility(merge(arrayToMerge));

        return arrayUtil.getNumberOfOccurrences(valueToEvaluate);
        
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        ArrayUtility arrayUtil = new ArrayUtility(merge(arrayToMerge));

        int tempCount = 0;

        T mostCommonObj = null;

        for(Object el : arrayUtil.list) {

            if(getNumberOfOccurrences((T)el) > tempCount) {

                tempCount = getNumberOfOccurrences((T)el);

                mostCommonObj = (T)el;
            }
        }
        return mostCommonObj;
    }

    public T[] removeValue(T valueToRemove) {

      ArrayList<T> tempArr = new ArrayList<>();

        for(int i = 0; i < list.length; i++){

            if(!list[i].equals(valueToRemove)) {

                tempArr.add(list[i]);


            }
        }
        int newLength = tempArr.size();

        list = (T[]) Array.newInstance(list.getClass().getComponentType(),newLength);

        return tempArr.toArray(list);
    }
}
