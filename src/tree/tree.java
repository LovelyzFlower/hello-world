package tree;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class tree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStream in = new FileInputStream("tree.inp");
		Scanner sc = new Scanner(in);
		FileWriter fw = new FileWriter("tree.out");
		PrintWriter pw = new PrintWriter(fw);
		
		int c;
		int fn1;
		int fn2;
		c=sc.nextInt();
		for(int i=0;i<2;i++)
		{
			fn1=sc.nextInt();
			for(int a=0;a<c;a++)
			{
				
			}
		}
	}

}
