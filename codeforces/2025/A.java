import java.util.*;
 
public class Asolution {
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		s.nextLine();
		while(t-->0) {
			String s1=s.nextLine();
			String s2=s.nextLine();
			int i=0;
			while(i<s1.length() && i<s2.length() && s1.charAt(i)==s2.charAt(i))i++;
			if(i!=0)i--;
			System.out.println(s1.length()+s2.length()-i);
		}
	}
}
