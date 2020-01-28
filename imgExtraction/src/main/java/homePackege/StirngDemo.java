package homePackege;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class StirngDemo {
	public static void main(String[] args) {
//		String s="01878/21548Hello hay this 01/10/2020 a format 01/10//2220 of date..1245 sjdbhagdca hsbahhs shb c ma hay thisncfnjhj dnjbcjsadbkd 01/10/4800";   
//    	s=s.replaceAll("[^0-9/]", " ");
//    	System.out.println(s);
//    	System.out.println("-----------------------");
//    	StringTokenizer str=new StringTokenizer(s);
//    	List<String> li=new ArrayList<String>();
//    	while(str.hasMoreTokens()) {
//    		String test=str.nextToken();
//    		int count=0;
//    		boolean b=false;
//    		if(test.length()==10) {
//    			for (int i = 0; i < test.length(); i++) {
//    				if(test.charAt(2)=='/' && test.charAt(5)=='/')
//    					b=true;
//    				if(test.charAt(i)=='/')
//    					count++;
//    			}
//    		}
//    		if(count==2 && b==true)
//    			li.add(test);
//    	}
//    	System.out.println(li);
		
		
		String s="01878/21548Hello hay this 01/10/2020 a format 01/10//2220 of date..1245 sjdbhagdca hsbahhs shb c ma hay thisncfnjhj dnjbcjsadbkd 01/10/4800";   
    	System.out.println("------- Complete Data from Image -------");
    	System.out.println(s.trim());
    	System.out.println("----------------------------------------");
    	
    	char[] stringToArray=s.toCharArray();
    	StringBuffer numberAndSlashData=new StringBuffer();
    	for(char c:stringToArray)
    		if(c>=47 && c<=57)
    			numberAndSlashData.append(c);
    	
    //	System.out.println(numberAndSlashData);
    	System.out.println();
    			
    	List<String> datesList=new ArrayList<String>();
    	for (int i = 0; i < numberAndSlashData.length(); i++) {
    		if(i<numberAndSlashData.length()-9)
    			datesList.add(numberAndSlashData.substring(i, i+10));
		}
    	//System.out.println(datesList);
    	
    	System.out.println("\n----------OUTPUT AS---------------");
    	ListIterator<String> itr=datesList.listIterator();
    	List<String> li=new ArrayList<String>();
    	while(itr.hasNext()) {
    		String test=itr.next();
    		char[] c=test.toCharArray();
    		int count=0;
    		boolean b=false;
    		for (int i = 0; i < test.length(); i++) {
    			if(c[2]=='/' && c[5]=='/')
    				b=true;
				if(c[i]=='/')
					count++;
			}
    		if(count==2 && b==true)
    			li.add(test);
    	}
    	if(li.isEmpty())
    		System.out.println("No Date Patterns Found");
    	else
    		System.out.println(li);
	}

}
