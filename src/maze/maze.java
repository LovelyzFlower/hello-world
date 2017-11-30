package maze;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class maze {

	static PrintWriter pw;
	static int nm,n,m;
	static boolean temp;
	static int line[]=new int[600000];
	static boolean chk[]=new boolean[600000];
	static int count;
	static Node[] node = new Node[600000];
	  public static void main(String[] args) throws IOException {
		      
		      InputStream in = new FileInputStream("maze.inp");
		      Scanner sc = new Scanner(in);
		      FileWriter fw = new FileWriter("maze.out");
		      pw= new PrintWriter(fw);
		      n=sc.nextInt();
		      m=sc.nextInt();
		      nm=n*m;
		      int num, val;
		      for(int i=0;i<600000;i++)
		    	  node[i]=new Node();
		      
		      while(true)
		      {
		    	  num=sc.nextInt();
		    	  val=sc.nextInt();
		    	
		    	  if(num==-1)
		    		  break;
		    	  
		    	  node[num].num=num;
		    	  if(val==3) 
		    	  {
		    		  node[num].e=false;
		    		  node[num].s=false;
		    		  node[num+1].w=false;
		    		  node[num+m].n=false;
			      }
		    	  else if(val==2)
		    	  {
		    		  node[num].s=false;
		    		  node[num+m].n=false;
		    	  }
		    	  else if(val==1)
		    	  {
		    		  node[num].e=false;
		    		  node[num+1].w=false;
		    	  }
		    	 
		    	
		      }
		      
		      init(0);
		      if(!temp)
		    	  pw.print("No Solution!");
		      pw.close();
		      sc.close();
		      
		      
	  }
	
	  static void init(int x)
	  {
		  line[count++]=x;
		  if(x==nm-1)
		  {
			  temp=true;
			  if(line[count-1]==nm-1)
			  {
				  for(int i=0; i<count ; i++)
					  pw.println(line[i]);
			  }

		  }
		  
		  if(!node[x].e && !temp)
		  {
			  if(!chk[x+1])
			  {
				  chk[x]=true;
				  init(x+1);
			  }
		  }
		  if(!node[x].s && !temp)
		  {
			  if(!chk[m+x])
			  {
				  chk[x]=true;
				  init(x+m);
			  }
		  }
		  if(!node[x].w && !temp)
		  {
			  if(!chk[x-1])
			  {
				  chk[x]=true;
				  init(x-1);
			  }
		  }
		  if(!node[x].n && !temp)
		  {
			  if(!chk[x-m])
			  {
				  chk[x]=true;
				  init(x-m);
			  }
		  }
		  count--;
	  }
}

class Node
{
	int num;
	boolean n,s,w,e;
	
	public Node() {
		this.n = true;
		this.s = true;
		this.w = true;
		this.e = true;
	}

	
}
