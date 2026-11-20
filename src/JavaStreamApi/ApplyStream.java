package JavaStreamApi;

import java.util.ArrayList;
import java.util.List;

public class ApplyStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = new ArrayList<>();
		
		names.add("Aman");
		names.add("Rohit");
		names.add("kunal");
		names.add("sachin");
		names.add("prince");
		names.add("Av9");
		
		Long c =names.stream().filter(s -> s.startsWith("A")).count();
		
		System.out.println(c);
		  

	}

}
