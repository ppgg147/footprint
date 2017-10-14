package wjp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SecurityUtil {
	/**
	 *  @Description    : �����֤tokenֵ�㷨�� 
     *                              �㷨�ǣ����ض���ĳ��������һmap�����ݽṹ���룬 
     *                              �����ֵ��������Ժ����md5����,32λСд���ܣ� 
     *  @Method_Name    : authentication 
     *  @param token        ���󴫹�����token 
     *  @param srcData   Լ����������token�Ĳ��� 
     *  @return  
     */  
    public static String authentication(Map<String , Object > srcData){  
        //���򣬸���keyde �ֵ�������  
        if(null == srcData){  
            return "-1";  
        }  
        List<Map.Entry<String,Object>> list = new ArrayList<Map.Entry<String,Object>>(srcData.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Object>>(){  
            //��������  
            public int compare(Entry<String,Object> o1, Entry<String,Object> o2){  
                return o1.getKey().compareTo(o2.getKey());  
            }  
        });  
          
        StringBuffer srcSb = new StringBuffer();  
        for(Map.Entry<String , Object>srcAtom : list){  
            srcSb.append(String.valueOf(srcAtom.getValue()));  
        }  
        System.out.println("�����֤����ǰ�ַ�����"+srcSb.toString());  
        //����token  
        String token = MD5Util.md5(srcSb.toString());  
//      System.out.println(cToken);//for test  
        return token;  
    } 
}
