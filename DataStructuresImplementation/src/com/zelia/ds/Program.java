package com.zelia.ds;

import com.zelia.ds.map.CustomMap;

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

	}
}
