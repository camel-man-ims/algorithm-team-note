package 자료구조;

import java.util.*;

public class HashTest {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);

        Set<Integer> set = map.keySet();
        for(int a : set){
            System.out.println(a);
        }
    }
}
