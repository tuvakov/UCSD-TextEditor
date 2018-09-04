package my.examples;

public class Experiment{

	
	public static void main(String args[]){
	
	String s = "Hello";
	String a = "a";
	
	
	for(int i = 0; i < s.length()+1; i++){
		
		StringBuffer sb = new StringBuffer(s);
		sb.insert(i, a);
		System.out.println(sb.toString());
	}
	
	//System.out.println(sb.toString() + "a");
	
	}
}
