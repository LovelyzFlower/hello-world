package color;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class color {

	static PrintWriter pw;

	
  public static void main(String[] args) throws IOException {
	      
	      InputStream in = new FileInputStream("color.inp");
	      Scanner sc = new Scanner(in);
	      FileWriter fw = new FileWriter("color.out");
	      pw= new PrintWriter(fw);
	      int s=sc.nextInt();
	      
	      String s1;
	      String s2;
		
	      for(int ss=0;ss<s;ss++)
	      {
	    	  int dp[][]=new int[5001][5001];
	    	  s1=sc.nextLine();
	    	  s2=sc.nextLine();
	    	  
	    	  for(int i=0;i<=s1.length();i++)
	    	  {
	    		  for(int j=0; j<=s2.length();j++)
	    		  {
	    			  int count=0;
	    			  
	    		  }
	    	  }
	      }
	      
	     
	     
 }

}
