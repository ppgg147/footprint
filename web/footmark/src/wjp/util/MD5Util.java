package wjp.util;

import java.security.MessageDigest;

public class MD5Util {
	 private static final String encryModel="MD5";  
	    /** 
	     * 32λmd5. 
	     * 32位小写md5加密 
	     * @param str 
	     * @return 
	     */  
	    public  static String md5(String str) {  
	        return encrypt(encryModel, str);  
	    }  
	    public static String encrypt(String algorithm, String str) {  
	        try {  
	            MessageDigest md = MessageDigest.getInstance(algorithm);  
	            md.update(str.getBytes());  
	            StringBuffer sb = new StringBuffer();  
	            byte[] bytes = md.digest();  
	            for (int i = 0; i < bytes.length; i++) {  
	                int b = bytes[i] & 0xFF;  
	                if (b < 0x10) {  
	                    sb.append('0');  
	                }  
	                sb.append(Integer.toHexString(b));  
	            }  
	            return sb.toString();  
	        } catch (Exception e) {  
	            return "";  
	        }  
	    }  
	    
	    /**
	     * Md5加密
	     * @param s
	     * @return
	     */
	    public final static String MD5(String s) {     
	    	  char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',     
	    	    'a', 'b', 'c', 'd', 'e', 'f' };     
	    	  try {     
	    	   byte[] strTemp = s.getBytes();     
	    	   MessageDigest mdTemp = MessageDigest.getInstance("MD5");     
	    	   mdTemp.update(strTemp);     
	    	   byte[] md = mdTemp.digest();     
	    	   int j = md.length;     
	    	   char str[] = new char[j * 2];     
	    	   int k = 0;     
	    	   for (int i = 0; i < j; i++) {     
	    	    byte byte0 = md[i];     
	    	    str[k++] = hexDigits[byte0 >>> 4 & 0xf];     
	    	    str[k++] = hexDigits[byte0 & 0xf];     
	    	   }     
	    	   return new String(str);     
	    	  } catch (Exception e) {     
	    	   return null;     
	    	  }     
	    	 }     
}
