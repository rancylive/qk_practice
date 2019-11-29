package com.practice.whiteboard.rough;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class Rough {

	static String approverEmailIds = "balaji.pathar@quikr.com,  ranjan.choudhury@quikr.com, prity.s@quikr.com, manukiran.jogi@quikr.com";
	static int[] fibo = new int[10];
	public static void main(String[] args) {
		 //new Rough().fibo(10);
		 for(int nn:fibo) {
			 //System.out.println(nn);
		 }
		 
		int n = 6;
		int[] arr = new int[n + 1];
		for(int i = 0; i < n; i++) {
			arr[i] = -1;
		}
		//fibo(13);
 		for(int i = 0; i< n; i++) {
 			System.out.println(arr[i]);
 		}
 		System.out.println("Array duplicate");
 		duplicateInArray();
 		String adId = "293119|50-QEBHZ_160817-01";
 		test(adId);
 		test("1");
 		test(null);
 		Date dt = new Date("2019/10/15");
 		System.out.println(getCurrentDate().equals(dt));
 		getLongTime();
 		System.out.println("Valid email "+ isValidAdminEmail("prity.s@quikr.com"));
 		System.out.println("Approver email "+ getApproverEmail(md5Hash("prity.s@quikr.com")));
	}
	
	
	public static String fun() {
		String result = "Hello";
		
		return result;
	}
	
	public static void fibo(int n) {
		recufibo(1, n);
	}
	public static int recufibo(int i,int n) {
		if(i<n) {
			fibo[i] = recufibo(i+1,n)+recufibo(i+2,n);
			return fibo[i];
		} else {
			return 1;
		}
	}
	
	public static void duplicateInArray() {
		int[] input = new int[]{1, 2, 3, 7, 7, 8, 9, 9, 9, 10};
		int current = input[0];
		boolean found = false;

		for (int i = 0; i < input.length; i++) {
		    if (current == input[i] && !found) {
		        found = true;
		    } else if (current != input[i]) {
		        System.out.print(" " + current);
		        current = input[i];
		        found = false;
		    }
		}
		System.out.print(" " + current);
	}
	
	public static void test(String adId) {
		if(StringUtils.isNotEmpty(adId)) {
			String[] tokens = StringUtils.split(adId, "|");
			System.out.println(tokens[0]);
		}
	}
	

    public static Date getCurrentDate(){
        //default time zone
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate date = LocalDate.now();
        Date toDayDate = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
        return toDayDate;
    }
    
    public static void getLongTime() {
    	String pattern = "yyyy-MM-dd";
    	String commissionExpiryTimeStr = "2019-10-18";
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	long dateLong = 0;
		try {
			dateLong = sdf.parse(commissionExpiryTimeStr).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(dateLong);
    }
    

    public static boolean isValidAdminEmail(String approverEmailId) {
        //String[] adminEmails = StringUtils.split(approverEmailIds, ",\\s+");
    	String[] adminEmails = approverEmailIds.split(",\\s+");
        for(String email : adminEmails) {
        	if(StringUtils.equals(StringUtils.trim(email), approverEmailId)) {
        		return true;
        	}
        }
        return false;
    }

    public static String getApproverEmail(String approverSecretKey) {
    	if(StringUtils.isEmpty(approverEmailIds)) {
            return null;
        }
        String[] adminEmails = approverEmailIds.split(",\\s+");
        for(String email : adminEmails) {
            if(StringUtils.equals(approverSecretKey, md5Hash(StringUtils.trim(email)))) {
                return StringUtils.trim(email);
            }
        }
        return null;
    }
    
    public static String md5Hash(String str) {
    	String hashtext = "";
    	String plaintext = str;
    	MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
    	m.reset();
    	m.update(plaintext.getBytes());
    	byte[] digest = m.digest();
    	BigInteger bigInt = new BigInteger(1,digest);
    	hashtext = bigInt.toString(16);
    	// Now we need to zero pad it if you actually want the full 32 chars.
    	while(hashtext.length() < 32 ){
    	  hashtext = "0"+hashtext;
    	}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashtext;
    }
	 
}