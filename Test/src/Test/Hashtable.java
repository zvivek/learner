package Test;

import java.util.HashMap;

public class Hashtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		Integer[] arr={1,10,5,3,1,5,7,9};
		
		for(int i = 0; i < arr.length; i++){
			if(hash.get(arr[i])==null)
				hash.put(arr[i], 1);
			else
				hash.put(arr[i], hash.get(arr[i])+1);
		}
System.out.println(hash.entrySet());
	}

}
