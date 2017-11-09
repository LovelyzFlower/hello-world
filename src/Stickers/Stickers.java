package Stickers;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stickers {
	
	static int arr[][]=new int[2][10001];
	static int arr2[][]=new int[2][10001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stubInputStream in = new FileInputStream("coin.inp");
		InputStream in = new FileInputStream("stickers.inp");
		Scanner sc = new Scanner(in);
		FileWriter fw = new FileWriter("stickers.out");
		PrintWriter pw = new PrintWriter(fw);
		
		int c=sc.nextInt();
		int s;
		int ans;
		for(int k=0;k<c;k++)
		{
			s=sc.nextInt();
			for(int i=0;i<2;i++)
			{
				for(int j=1;j<=s;j++)
				{
					arr[i][j]=sc.nextInt();
					arr2[i][j]=arr[i][j];
				}
			}
			
		
			for(int i=2;i<=s;i++)
			{
				arr2[1][i]=Math.max(arr2[0][i-1], arr2[0][i-2])+arr[1][i];
				arr2[0][i]=Math.max(arr2[1][i-1], arr2[1][i-2])+arr[0][i];
			}
			ans =Math.max(arr2[0][s],arr2[1][s]);
			pw.println(ans);
			
		}
		pw.close();
		sc.close();

	}

}
