package org.wind.pro.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Circle {


	public static void main(String[] args) {
		
//		List list = new ArrayList();
//		for(int i=0;i<10;i++ ){
//			list.add(i+1);
//			System.out.println(i+1);
//		}
//		int j=0;
//		while(list.size()>1){
//			int n= j%list.size();
//			System.out.println(" remove "+n+":"+list.get(n));
//			list.remove(n);
//			j=j+3;
//		}
//		System.out.println(list.get(0));
		
//		List list = new LinkedList();
//		for(int i=0;i<10;i++ ){
//			list.add(i+1);
//			System.out.println(i+1);
//		}
//		int num = 0;
//		int j = -1;
//		while(list.size()>1){
//			num++; j++;//报数
//			if(num%3 == 0){
//				System.out.println(num+":remove"+list.get(j));
//				list.remove(j);
//				j--;
//			}
//			if(j+1==list.size()){
//				j=-1;  //回到初始位置
//			}
//		}
//		System.out.println("结果是："+list.get(0));
		
		System.out.println("第二部分");
	
		List list2 = new LinkedList();
		
		
		for(int i=0;i<10;i++ ){
			list2.add("p"+(i+1));
			System.out.println("p"+(i+1));
		}
		
		int n=1;
		for (Iterator iterator = list2.iterator(); list2.size()>1;) {
			if(!iterator.hasNext()){
				iterator = list2.iterator();
			}
			String string = String.valueOf(iterator.next());
			if(n%3==0){
				System.out.println(n+" remove "+string);
				iterator.remove();
			}
			n++;
		}
		System.out.println(list2.get(0));

		
		
	}

}
