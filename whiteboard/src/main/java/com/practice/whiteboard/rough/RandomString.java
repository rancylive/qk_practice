package com.practice.whiteboard.rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class RandomString {
	static List<String> codeList = Arrays.asList("RB", "BG", "GM", "TR", "SL", "RT", "ZF", "LA", "TL", "KC", "GT", "KR", "EN", "SZ", "KC-", "IM", "ANA", "SM", "RG", "TR-", "AL", "AD", "GH", "MT", "QP", "EM", "ADG");
	public static void main(String[] args) {
		generateInsertQuery();
		Random rnd = new Random(System.currentTimeMillis());
		for(int i=0; i<10;i++) {
			char c1 = (char) (rnd.nextInt(26) + 'A');
			char c2 = (char) (rnd.nextInt(26) + 'A');
			//System.out.println("C: "+c1+c2);
		}
		rightShift();
	}
	
	public static void getBinaryAlphabet() {
		List<String> codes = new ArrayList<String>();
		for(int i=0;i<26; i++) {
			for(int j=0; j<26; j++) {
				char c1 = (char) (i + 'A');
				char c2 = (char) (j + 'A');
				System.out.print(", "+c1+c2);
				codes.add("\""+c1+c2+"\"");
			}
		}
		System.out.println();
		System.out.println(codes.size());
		System.out.println(codes);
		codes.removeAll(codeList);
		System.out.println(codes.size());
		System.out.println(codes);
	}
	
	public static void generateInsertQuery() {
		List<String> codes = new ArrayList<String>();
		for(int i=0;i<26; i++) {
			for(int j=0; j<26; j++) {
				char c1 = (char) (i + 'A');
				char c2 = (char) (j + 'A');
				System.out.print(", "+c1+c2);
				codes.add("\""+c1+c2+"\"");
			}
		}
		List<String> vls = new ArrayList<String>();
		StringBuilder builder=new StringBuilder();
		builder.append("INSERT INTO prestashop_work.aggregator_reserved_seller_code (code, status) VALUES ");
		for(String code:codes) {
			String ss= "("+code+",0)";
			vls.add(ss);
		}
		builder.append(StringUtils.join(vls, ", ")).append(";");
		System.out.println();
		System.out.println(builder.toString());
	}
	
	public static void rightShift() {
		int x = -128;
		System.out.println(x>>1);
	}
}
