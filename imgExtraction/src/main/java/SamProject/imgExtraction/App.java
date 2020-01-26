package SamProject.imgExtraction;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Extracting Image Data :" );
        System.out.println();
      
        String inputFilePath="F:/Screenshot3.png";
        Tesseract tsi=new Tesseract();
        tsi.setDatapath("F:/ExtractDataFromImage-Java/imgExtraction/Tesseract");
        try {
			
        	String dataFromImage=tsi.doOCR(new File(inputFilePath)).toLowerCase();
        	System.out.println(dataFromImage);
        	System.out.println();
        	
        	System.out.println("ReplaceAll method");
        	String d=dataFromImage.replaceAll("[!-.:-@{-}a-zA-Z]", "");
        	System.out.println(d);
        	
        	d.trim();
        	
        	System.out.println("split method");
        	String[] oneMore=d.split(" ");
        	
        	System.out.println("For Each loop");
        	List<String> li=new ArrayList<String>();
        	for (String string : oneMore) {
        		System.out.println(string);
				if(string.contains("/"))
					li.add(string);
			}
        	System.out.println(li);
        	
        	
        	
//        	String demo="01878/21548Hello hay this 01/10/1997 a format of date..1245 sjdbhagdca hsbahhs shb c ma hay thisncfnjhj dnjbcjsadbkd 01/10/1548";
//        	System.out.println(demo);
//        	
//        	String myData=demo.replaceAll("[!-.:-@{-}a-zA-Z]", "");
//        	myData.trim();
//
//        	String[] oneMore=myData.split(" ");
//        	
//        	List<String> li=new ArrayList<String>();
//        	for (String string : oneMore) {
//				if(string.contains("/"))
//					li.add(string);
//			}
//        	System.out.println(li);
        	
        	
        	
        	//demo=demo.replaceAll("^[0-9]","");
        	//System.out.println(demo.replaceAll("[0-9/]",""));
        	
        	
//        	char a[]=demo.toCharArray();
//        	StringBuffer m=new StringBuffer();
//        	for(char c:a)
//        		if(c==48||c==49||c==50||c==51|c==52||c==53||c==54||c==55||c==56||c==57||c==47)
//        			m.append(c);
//        	System.out.println(m);
        	
        	
		} catch (TesseractException e) {
			e.printStackTrace();
		}
    }
}
