package path;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class path {
	static final int MAX = 502;
	static final int INF = 99999999;
	
	static int s[][]=new int[MAX][MAX];
	static int r[][]=new int[MAX][MAX];
	static int p[][]=new int[MAX][MAX];
	
	static int path_save[][]=new int[2500][3];
	static int one_index;
	static int two_index;
	
	static int one[] = new int[1000];
	static int two[] = new int[1000];
	
	static int rr[]=new int[2500];

	static int c,n,one_path,two_path;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		

		InputStream in = new FileInputStream("path.inp");
		Scanner sc = new Scanner(in);
		FileWriter fw = new FileWriter("path.out");
		pw = new PrintWriter(fw);
		
		n=sc.nextInt();
		c=sc.nextInt();
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==j)
					s[i][j]=0;
				else
					s[i][j]=INF;
				p[i][j]=-1;
					
			}
		}
	
		for(int i=0;i<2500;i++)
		{
			rr[i]=-1;
		}
		for(int i=0;i<1000;i++)
		{
			one[i]=-1;
			two[i]=-1;
		}
		int b,e,k;
		for(int i=0;i<c;i++)
		{
			b=sc.nextInt();
			e=sc.nextInt();
			k=sc.nextInt();
			s[b][e]=k;
		}
		int x;
		for(x=0;;x++)
		{
			b=sc.nextInt();
			e=sc.nextInt();
			k=sc.nextInt();
			if(b==-1||e==-1||k==-1)
				break;
			path_save[x][0]=b;
			path_save[x][1]=e;
			path_save[x][2]=k;
			
		}
		for(int i=0;i<x;i++)
		{
			for(int t=0;t<=n;t++)
			{
				for(int y=0;y<=n;y++)
				{
				//	System.out.print(s[t][y]+" ");
					r[t][y]=s[t][y];
					p[t][y]=-1;
				}
			//	System.out.println();
			}
			
			for(int a=0;a<one_index;a++)
				one[a]=-1;
			

			one_index=0;
			one_path=0;
			path_cal(path_save[i][2]);
			one[one_index++]=path_save[i][0];
			one_path=path_oneprint(path_save[i][0], path_save[i][1], path_save[i][2]);
			one[one_index++]=path_save[i][1];
			
			for(int q=0;q<=n;q++)
			{
				for(int qq=0; qq<=n;qq++)
				{
					//.args.System.out.print(s[q][qq]+" ");
					r[q][qq]=s[q][qq];
					p[q][qq]=-1;
				}//System.out.println();
			}
			for(int a=0;a<two_index;a++)
				two[a]=-1;
			
			
			two_index=0;
			two_path=0;
			path_cal(path_save[i][0]);
			two[two_index++]=path_save[i][1];
			two_path=path_twoprint(path_save[i][1], path_save[i][2], path_save[i][0]);
			two[two_index++]=path_save[i][2];
			//System.out.println(one_path+" "+two_path);
			if(one_path==-1||two_path==-1)
			{
				pw.println(path_save[i][0]+" "+path_save[i][1]+" "+path_save[i][2]+" (-1)");
			}
			else
			{
				int ans=real_route_cal();
				if(ans==-1)
				{
					pw.println(path_save[i][0]+" "+path_save[i][1]+" "+path_save[i][2]+" (-1)");
					
				}
				else
				{
					pw.println("("+ans+")");
				}
			}

		}
		pw.close();
		sc.close();

	}
	
	static int real_route_cal() {
		   int sum = 0;
		   int index = 0;
		   int i = 0;
		   for (i = 0; i  < one_index; i++) {
		      if (one[i] == one[i + 1]) {
		         continue;
		      }
		      else {
		         rr[index++] = one[i];
		      }
		   }
		   for (i = 1; i <= two_index; i++) {
		      if (two[i] == two[i + 1]) {
		         continue;
		      }
		      else {
		         rr[index++] = two[i];
		      }
		   }
		  // System.out.println(index+" "+one_index+" "+two_index);
		   for (i = 0; i < index - 1; i++) {
		      pw.print(rr[i]+" ");
		      sum += r[rr[i]][rr[i + 1]];
		   }
		   pw.print(rr[index-1]+" ");
		   return sum;
		}
	
	static int path_oneprint(int start, int end, int ban) {
		//System.out.println("1: "+r[start][end]);
		   if (r[start][end] == INF) {
		      return -1;
		   }
		   else {
		      if (p[start][end] != -1) {
		    	  path_oneprint(start, p[start][end], end);
		         one[one_index++] = p[start][end];
		         path_oneprint(p[start][end], end, start);
		      }
		   }
		   return 0;
		}
	static int path_twoprint(int start, int end, int ban) {

			//System.out.println("2: "+r[start][end]);
		   if (r[start][end] == INF) {
		      return -1;
		   }
		   else {
		      if (p[start][end] != -1) {
		    	  path_twoprint(start, p[start][end], end);
		         two[two_index++] = p[start][end];
		         path_twoprint(p[start][end], end, start);
		      }
		   }
		   return 0;
		}

	static void path_cal(int ban) {
		   int i, j, k;
		   for (k = 0; k <= n; k++) {
		      for (i = 0; i <= n; i++) {
		         for (j = 0; j <= n; j++) {
		            if (k == ban) {
		               continue;
		            }
		            if (r[i][k] + r[k][j] < r[i][j]) {
		               p[i][j] = k;
		               r[i][j] = r[i][k] + r[k][j];
		            }
		         }
		      }
		   }
		}

}
