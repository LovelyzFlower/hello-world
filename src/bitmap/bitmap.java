package bitmap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class bitmap {


	static int outCount =0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream("bitmap.inp");
		//Scanner sc = new Scanner(in);
		
		FileWriter fw = new FileWriter("bitmap.out");
		PrintWriter pw = new PrintWriter(fw);

		char type;
	    int numRows, numCols;
	    
	    type=(char) in.read();
	    System.out.println(type);
	    in.read();
	    numRows=in.read()-48;
	    System.out.println(numRows);
	    in.read();
	    numCols=in.read()-48;
	    System.out.println(numCols);
	}

}
