package coin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class coin {
	static PrintWriter pw;
	static int arr[][][][]=new int[104][104][104][3];
	static int n1,n2,n3;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStream in = new FileInputStream("coin.inp");
		Scanner sc = new Scanner(in);
		FileWriter fw = new FileWriter("coin.out");
		pw = new PrintWriter(fw);
		
		int c = sc.nextInt();
		init();
		for(int i=0;i<c;i++)
		{
			n1=sc.nextInt();
			n2=sc.nextInt();
			n3=sc.nextInt();
			pw.print("("+n1+" "+n2+" "+n3+") : ");
			if(arr[n1+3][n2+3][n3+3][0]==0||
					arr[n1+3][n2+3][n3+3][1]==0||
					arr[n1+3][n2+3][n3+3][2]==0)
				pw.println(1);
			else
				pw.println(-1);	
		}
		pw.close();
	}
	private static void init()
	{
		for (int i = 3; i < 104; i++) {
		      for (int j = 3; j < 104; j++) {
		         for (int k = 3; k < 104; k++) {
		            if (j == 3 && i == 3 && k == 3)continue;
		            for (int l = 0; l < 3; l++) {
		               if (l == 0) {
		                  n1 = (arr[i - (l + 1)][j][k][1] == 1 && arr[i - (l + 1)][j][k][2] == 1) ? 0 : 1;
		                  if(n1 == 0)continue;
		                  n2 = (arr[i][j - (l + 1)][k][1] == 1 && arr[i][j - (l + 1)][k][2] == 1) ? 0 : 1;
		                  if(n2 == 0)continue;
		                  n3 = (arr[i][j][k - (l + 1)][1] == 1 && arr[i][j][k - (l + 1)][2] == 1) ? 0 : 1;
		                  if(n3 == 0)continue;
		               }
		               else if (l == 1) {
		                  n1 = (arr[i - (l + 1)][j][k][0] == 1 && arr[i - (l + 1)][j][k][2] == 1) ? 0 : 1;
		                  if(n1 == 0)continue;
		                  n2 = (arr[i][j - (l + 1)][k][0] == 1 && arr[i][j - (l + 1)][k][2] == 1) ? 0 : 1;
		                  if(n2 == 0)continue;
		                  n3 = (arr[i][j][k - (l + 1)][0] == 1 && arr[i][j][k - (l + 1)][2] == 1) ? 0 : 1;
		                  if(n3 == 0)continue;
		               }
		               else {
		            	  n1 = (arr[i - (l + 1)][j][k][0] == 1 && arr[i - (l + 1)][j][k][1] == 1) ? 0 : 1;
		                  if(n1 == 0)continue;
		                  n2 = (arr[i][j - (l + 1)][k][0] == 1 && arr[i][j - (l + 1)][k][1] == 1) ? 0 : 1;
		                  if(n2 == 0)continue;
		                  n3 = (arr[i][j][k - (l + 1)][0] == 1 && arr[i][j][k - (l + 1)][1] == 1) ? 0 : 1;
		                  if(n3 == 0)continue;
		               }
		               if (n1 == 1 && n2 == 1 && n3 == 1)arr[i][j][k][l] = 1;
		            }
		         }
		      }
		   }
	}

}
