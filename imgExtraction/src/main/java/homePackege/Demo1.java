package homePackege;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
    	String demo="original result\r\n" + 
    			"\r\n" + 
    			"29/02/16 i 2/29/2016!\r\n" + 
    			"15/01/16 1/15/2016\r\n" + 
    			"23/03/17 3/23/2017\r\n" + 
    			"17/07/17 7/17/2017\r\n" + 
    			"21/11/17 11/21/2017\r\n" + 
    			"13/12/17 12/13/201701878/21548Hello hay this 01/10/2020 a format 01/10//2220 of date..1245 sjdbhagdca hsbahhs shb c ma hay thisncfnjhj dnjbcjsadbkd 01/10/4800";   
    	System.out.println(demo);
    	
    	System.out.println("--------------------------------------------------------------------------");
    	char a[]=demo.toCharArray();
    	StringBuffer m=new StringBuffer();
    	for(char c:a)
    		if(c>=47&&c<=57)
    			m.append(c);
    	StringBuffer dd=new StringBuffer();
    	List<String> list=new ArrayList<String>();
    	char []z=new String(m).toCharArray();
    	for(int i=0;i<z.length;i++)
    	{
    		if(z[0]!=47||z[1]!=47||z[z.length-1]!=47||z[z.length-2]!=47)
    			if(z[i]==47)
    				if(z[i+3]==47)
    					{dd.append(z[i-2]).append(z[i-1]).append(z[i]).append(z[i+1]).append(z[i+2]).append(z[i+3]).append(z[i+4]).append(z[i+5]).append(z[i+6]).append(z[i+7]).append(" ");
    					i=i+7;
    					}				
    	}
    	String lis[]=new String(dd).split(" ");
    	for(String ll:lis)
    	{
    		int count=0;
    		char c[]=ll.toCharArray();
    		for(char p:c)
    			if(p==47)
    				count++;
    		if(count==2)
    			list.add(ll);
    		
    	}
    	for(String abcv:list)
    		System.out.println(abcv);
	}

}
