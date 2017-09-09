package com.example.simples.sm.jdk8;

import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Joiner;

public class Main {

    public static void main(String[] args) {
        //		List<Integer> nums=new ArrayList<>();
        //		Collections.addAll(nums, 1, 2, 6, 3, 5);
        //		Comparator<Integer> c = (Integer n1, Integer n2) -> n1.compareTo(n2);
        //		int result = c.compare(1, 0);
        //		System.out.println(result);
        //		Collections.sort(nums, (Integer n1, Integer n2) -> n1.compareTo(n2));
        //		nums.forEach(n -> System.out.println(n));
        //
        //		List<String> list = Arrays.asList("Hello", "JDK8", "and", "Lambda");
        //		List<String> newList = list.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        //		newList = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        //		newList.forEach(s -> System.out.println(s));
        //		String str = list.stream().map(String::toLowerCase).collect(Collectors.joining(","));
        //		System.out.println(str);
        //		// guava
        //		ArrayList<Integer> list2 = Lists.newArrayList(1, 2, 3);
        //		String str2 = Joiner.on(",").join(list2);
        //		System.out.println(str2);
        JSONArray arr = new JSONArray();
        arr.add("1");
        arr.add("2");
        String str3 = Joiner.on(",").join(arr);
        System.out.println(str3);

    }

}
