package com.zelia.ds;

import com.zelia.ds.map.CustomMap;
import com.zelia.ds.stack.CustomStack;

public class Program {
	public static void main(String[] args) {
		/* CUSTOM MAP */
		CustomMap<String, String> cmap = new CustomMap<>();
		cmap.put("Test1", "Value2");
		cmap.put("Test1", "Value1");
		cmap.put("Test2", "Value2");
		cmap.put("Test3", "Value3");
		cmap.put("Test4", "Value4");
		cmap.remove("Test4");
		System.out.println("Map : " + cmap);
		System.out.println(cmap.get("Test2"));
		System.out.println(cmap.keySet().size() + " keys (keyset)" + cmap.size() + " elements (size) "
				+ (cmap.isEmpty() ? "Empty" : "Not empty"));

		System.out.println("\nClearing the map\n");
		cmap.Clear();
		System.out.println("Map : " + cmap);
		System.out.println(cmap.get("Test2"));
		System.out.println(cmap.keySet().size() + " keys (keyset)" + cmap.size() + " elements (size) "
				+ (cmap.isEmpty() ? "Empty" : "Not empty"));

		System.out.println();
		/* CUSTOM STACK */
		CustomStack<String> cstack = new CustomStack<>();
		for(int i = 0; i < 20; ++i)
			cstack.push("#" + i);
		
		System.out.println(cstack.getSize() + " elements");
		
		for(int i = cstack.getSize(); i != 0; --i){
			System.out.print(cstack.pop()); 
		}
		System.out.println();
	}
}
