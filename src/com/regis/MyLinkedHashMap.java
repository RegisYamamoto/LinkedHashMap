package com.regis;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	private static final int MAX_ENTRIES = 5;
	
	public MyLinkedHashMap() {
	}
	 
    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }
 
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
    
    @Test
    public void givenLinkedHashMap_whenRemovesEldestEntry_thenCorrect() {
        LinkedHashMap<Integer, String> map
          = new MyLinkedHashMap<>(16, .75f, true);
        map.put(1, null);
        System.out.println("# map 1: " + map); // teste
        System.out.println(""); // teste
        
        map.put(2, null);
        System.out.println("# map 2: " + map); // teste
        System.out.println(""); // teste
        
        map.put(3, null);
        System.out.println("# map 3: " + map); // teste
        System.out.println(""); // teste
        
        map.put(4, null);
        System.out.println("# map 4: " + map); // teste
        System.out.println(""); // teste
        
        map.put(5, null);
        System.out.println("# map 5: " + map); // teste
        System.out.println(""); // teste
        
        Set<Integer> keys = map.keySet();
        System.out.println("# keys: " + keys); // teste
        System.out.println(""); // teste
        
        assertEquals("[1, 2, 3, 4, 5]", keys.toString());
        System.out.println("# keys: " + keys); // teste
        System.out.println(""); // teste
      
        map.put(6, null);
        assertEquals("[2, 3, 4, 5, 6]", keys.toString());
        System.out.println("# map 6: " + map); // teste
        System.out.println("# keys 6: " + keys); // teste
        System.out.println(""); // teste
      
        map.put(7, null);
        assertEquals("[3, 4, 5, 6, 7]", keys.toString());
        System.out.println("# map 7: " + map); // teste
        System.out.println("# keys 7: " + keys); // teste
        System.out.println(""); // teste
      
        map.put(8, null);
        assertEquals("[4, 5, 6, 7, 8]", keys.toString());
        System.out.println("# map 8: " + map); // teste
        System.out.println("# keys 8: " + keys); // teste
        System.out.println(""); // teste
        
    }
	
}