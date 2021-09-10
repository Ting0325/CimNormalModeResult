import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(new File("dmac_glb_result.txt"));
		//Scanner sc = new Scanner(new File("READ_DMAC_WT_results_long.txt"));
		//Scanner sc = new Scanner(new File("dmac_weights_bank0_v4.txt"));
		Scanner scIn = new Scanner(System.in);
		//System.out.println("num");
		//int n = scIn.nextInt();
		//Scanner sc = new Scanner(new File("./consecutive_10_tests/c12_9.txt"));
		Scanner sc = new Scanner(new File("dump_CIM_c12_0910_count_5e7_5e7.txt"));
		String dummy;
		List<String> patternList = new ArrayList();
		List<String> globalEntries = new ArrayList();
		dummy = sc.nextLine();
		dummy = sc.nextLine();
		/*
		String pattern0 = "";
		for(int i = 0; i < 32;i ++) {
			pattern0 = sc.next()+pattern0;
		}
		
		System.out.println(pattern0);
		*/
		
		while(sc.hasNext()) {
			String pattern = "";
			for(int i = 0; i < 32;i ++) {
				if(sc.next().length() != 1) {
					pattern = sc.next() + pattern;
				}
			}
			patternList.add(pattern);
		}
		/*
		for(int i = 22; i < 700; i+=8) {
			String word = "";
			word = patternList.get(i);
			word = patternList.get(i+2)+word;
			word = patternList.get(i+4)+word;
			word = patternList.get(i+6)+word;
			globalEntries.add(word);
		}
		*/
		//printList(patternList);
		System.out.println("length:" + patternList.size());
		//System.out.println(getVal("10000100011000000111011101101001"));
		//System.out.println(powOf2(31));
		//File file0 = new File("CIM_word_"+n+".txt");
		//FileWriter writer = new FileWriter("CIM_word_"+n+".txt");
		File file0 = new File("CIM_word.txt");
		FileWriter writer = new FileWriter("CIM_word.txt");
		int row = 1;
		int ans = 0;
		int wrong = 0;
		for(int i =0; i < 17400 ; i++) {
		//for(int i =168; i < 4000 ; i++) {
			//if(i%2 ==0) {
				//System.out.println(row-1 + ": "+ addUbderScore(8,patternList.get(i)));
				
				if((i-4)%4==0) {
					if(bin2Dec(patternList.get(i))==ans) {
						System.out.println(row + ": "+ patternList.get(i)+" \\\\" + bin2Dec(patternList.get(i)));
						writer.write(patternList.get(i) +" \\\\" + bin2Dec(patternList.get(i))+"\n");
					}else {
						System.out.println(row + ": "+ patternList.get(i)+" \\\\" + bin2Dec(patternList.get(i)));
						writer.write(patternList.get(i) +" \\\\"+ bin2Dec(patternList.get(i))+" wrong!!"+ans+"\n");
						wrong ++;
					}
				
					if(i>29) {
						ans++;
					}
				}
				
			/*
				System.out.println(row + ": "+ patternList.get(i)+" \\\\" + bin2Dec(patternList.get(i)));
				writer.write(patternList.get(i) +" \\\\" + bin2Dec(patternList.get(i))+"\n");
			*/ 
				row++;
			//}
			//if((i-21) %8== 0)
				
		}
		writer.close();
		System.out.println("wrong: "+wrong);
		}
	
	/*
	File file1 = new File("acquired_global_weights.txt");
	FileWriter writer0 = new FileWriter("acquired_global_weights.txt");
	for(int i = 0; i < globalEntries.size();i ++) {
		System.out.println(i+301+": "+addUbderScore(8,globalEntries.get(i)));
		writer0.write(addUbderScore(8,globalEntries.get(i)) +"\n");
	}
	writer0.close();
	
	}*/
	static void printList(List<String> list) {
		for(int i =0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
	}
	
	static int getVal(String str) {
		double val = 0;
		int e = 0;
		for(int i = str.length() -1; i >=0 ; i--) {
			if(str.charAt(i) == '1') {
				val =  (val + Math.pow(2, e));
				System.out.println(e+" "+Math.pow(2, e));
				System.out.println("here"+val);
			}	
			System.out.println(val);
			e++;
		}
		System.out.println();
		Double dVal = new Double(val);
		return dVal.intValue();
	}
	
	static int powOf2(int e) {
		int val = 1;
		for(int i = 0 ; i < e; i ++) {
			val *=2;
		}
		return val;
	}
	
	static String addUbderScore(int every,String str) {
		String strNew = "";	
		for(int i =0 ; i < str.length();i ++) {
			if(i % every == 0 && i !=0)
				strNew = strNew+"_"+str.charAt(i);
			else
				strNew = strNew+str.charAt(i);
		}
		return strNew;
	} 
	
	static int bin2Dec(String bin) {
		int dec = 0; 
		for(int i = 0; i < bin.length(); i++) {
			if(bin.charAt(bin.length()-1-i)=='1')
				dec += powOf2(i);
		}
		return dec;
	}
	
}












