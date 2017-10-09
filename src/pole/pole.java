package pole;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class pole {
	static long d[][][]=new long[21][21][21];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStream in = new FileInputStream("pole.inp");
		Scanner sc = new Scanner(in);
		FileWriter fw = new FileWriter("pole.out");
		PrintWriter pw = new PrintWriter(fw);
		
		int c;
		int temp;
		int n,l,r;
		c=sc.nextInt();
		for(int run=0;run<c;run++)
		{
			n=sc.nextInt();
			l=sc.nextInt();
			r=sc.nextInt();
			d[1][1][1]=1L;
			for (int i=2; i<=20; i++) {
				for (int j=1; j<=20; j++) {
			        for (int k=1; k<=20; k++) {
			                d[i][j][k] = d[i-1][j-1][k] + d[i-1][j][k-1] + d[i-1][j][k] * (i-2);
			            }
			        }
			    }
			pw.println(d[n][l][r]);
			   
		}
		pw.close();
		in.close();
	}

}
