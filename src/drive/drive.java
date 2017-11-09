import java.util.*;
import java.io.*;
import java.lang.*;

public class drive {
	static int [][][][] d = new int[100][100][201][2];
	static int [][] garo = new int[100][100];
	static int [][] sero = new int[100][100];


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		InputStream in = new FileInputStream("drive.inp");
		Scanner sc = new Scanner(in);
		FileWriter fw = new FileWriter("drive.out");
		PrintWriter pw = new PrintWriter(fw);
		
		int c;
		int temp;
		int n,m,l,g;
		c=sc.nextInt();
		for(int run=0;run<c;run++)
		{
			n=sc.nextInt();
			m=sc.nextInt();
			l=sc.nextInt();
			g=sc.nextInt();
			for (int i = 0; i<n; i++) 
				for (int j = 0; j<m - 1; j++) 
					garo[i][j]=sc.nextInt();
			
			for (int i = 0; i<n - 1; i++) 
				for (int j = 0; j<m; j++) 
					sero[i][j]=sc.nextInt();
			
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<m; j++) {
					for (int k = 0; k <= n + m; k++) {
						d[i][j][k][0] = d[i][j][k][1] = g + 1;
					}
				}
			}
			d[0][0][0][0] = 0;
			d[0][0][0][1] = 0;
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<m; j++) {
					for (int k = 0; k <= n + m; k++) {
						if (i != 0) {
							d[i][j][k][1] = d[i - 1][j][k][1] + sero[i - 1][j];
							if (k > 0) {
								d[i][j][k][1] = Math.min(d[i][j][k][1], d[i - 1][j][k - 1][0] + sero[i - 1][j]);
							}
						}
						if (j != 0) {
							d[i][j][k][0] = d[i][j - 1][k][0] + garo[i][j - 1];
							if (k > 0) {
								d[i][j][k][0] = Math.min(d[i][j][k][0], d[i][j - 1][k - 1][1] + garo[i][j - 1]);
							}
						}
					}
				}
			}
			int ans = -1;
			for (int k = 0; k <= n + m; k++) {
				for (int dir = 0; dir < 2; dir++) {
					if (d[n - 1][m - 1][k][dir] <= g) {
						if (ans == -1 || ans >(n - 1 + m - 1)*l + k) {
							ans = (n - 1 + m - 1)*l + k;
						}
					}
				}
			}
			
			pw.print(ans);
			pw.println();
		}
		
		System.out.println("Hi~");
		in.close();
		pw.close();
	}

}