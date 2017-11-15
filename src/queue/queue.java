package queue;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class queue {

	static int[] heap=new int[1000000];
	static int size;
	static PrintWriter pw;
	
  public static void main(String[] args) throws IOException {
	      
	      InputStream in = new FileInputStream("queue.inp");
	      Scanner sc = new Scanner(in);
	      FileWriter fw = new FileWriter("queue.out");
	      pw= new PrintWriter(fw);
	      String s;
	      int a;
	      //s=sc.nextLine();
	      //System.out.println(s);
	    
	     while(true) {
		      s=sc.nextLine();
		      if(s.equals("r"))
		      {
		    	  print();
		      }
		      else if(s.equals("d"))
		      {
		    	del();  
		      }
		      else if(s.equals("q"))
		      {
		    	  break;
		      }
		      else
		      {
		    	  a=Integer.parseInt(s);
		    	  insert(a);
		      }
	     }
	    // System.out.println("exit");
	     pw.close();
	     sc.close();
	     }
  
  
  static void insert(int element)
    {
      
        heap[size] = element;
        int now = size;
        size++;
        //System.out.println(size);
        while(heap[now] > heap[parent(now)])
        {
            swap(now,parent(now));
            now = parent(now);
        }	
    }
  	
  	static int parent(int pos)
  	{
  		return ((pos-1)/2);
  	}
  	
  	static boolean leaf(int pos)
  	{
  		if(pos >=(size/2)&&pos<=size)
  		{
  			return true;
  		}
  		return false;
  	}
  	static int tmp;
    static void swap(int fpos, int spos)
  	{
  		tmp=heap[fpos];
  		heap[fpos]=heap[spos];
  		heap[spos]=tmp;
  	}
    
    static void maxheap(int pos)
    {
    	if(!leaf(pos))
    	{
    		if(heap[pos]<heap[(2*pos)+1]||heap[pos]<heap[ (2*pos)+2])
    		{
    			if(heap[(2*pos)+1]>heap[(2*pos)+2])
    			{
    				swap(pos,(2*pos)+1);
    				maxheap((2*pos)+1);
    			}
    			else
    			{
    				swap(pos,(2*pos)+2);
    				maxheap((2*pos)+2);
    			}
    		}
    	}
    }
    
    static void print()
    {
    	pw.print(heap[0]);
    	int i=0,q=0;
    	while(true) {
    		i=i+(int)Math.pow(2,q);
    		if(i>size)
    			break;
    		pw.print(" " + heap[i]);
    		q++;
    	}
        pw.println();
    }
    
    static void del()
    {
    	
    	size--;
    	heap[0]=heap[size];
    	maxheap(0);
    }

}
