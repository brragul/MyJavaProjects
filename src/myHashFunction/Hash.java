package myHashFunction;

import java.util.LinkedList;
import java.util.Scanner;

public class Hash {
	static int h,rem;
	
	public static void main(String[] args) {
		LinkedList<Integer>[] hash = new LinkedList[17];
		int i=0;
		while(i<15){
			
		Scanner sc = new Scanner(System.in);
		h=sc.nextInt();
		rem = h%17;
		if(hash[rem]==null){
			hash[rem]= new LinkedList<Integer>();
		}
		hash[rem].add(h);
		i++;
		}
		for(int j=0;j<hash.length;j++){
			System.out.println("Index of "+j+":"+ hash[j]);
		}
	}
}
