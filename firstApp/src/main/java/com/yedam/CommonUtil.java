package com.yedam;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
	public static void printParameter(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String[] value = map.get(key);
			System.out.print(key + ":");
			if (value != null) {
				for (String h : value) {
					System.out.print(h + ",");
				}
			}
			System.out.println();
		}
	}
}
