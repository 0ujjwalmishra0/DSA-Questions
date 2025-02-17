package leetCode.feb2025;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2349 {
    public static void main(String[] args) {

    NumberContainers obj = new NumberContainers();
    obj.change(120,170);
    obj.change(62,170);
    obj.find(170);
    }
}

class NumberContainers {
    HashMap<Integer,Integer> mapOfIndex;
    HashMap<Integer,Integer> mapOfNumbers;

    public NumberContainers() {
        mapOfIndex= new HashMap<>();
        mapOfNumbers= new HashMap<>();
    }

    public void change(int index, int number) {
        mapOfIndex.put(index,number);
        mapOfNumbers.put(number,index);
    }

    public int find(int number) {
        if(mapOfNumbers.getOrDefault(number,-1)==-1){
            return -1;
        }
        Integer min= Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : mapOfIndex.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();


            if(value==number && key<min){
                min= key;
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
