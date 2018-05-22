package com.sjh.util;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtilsBean;

import net.sf.json.JSONObject;

public class ParserToMap {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map stringToMap(String s){  
	    Map map=new HashMap();
	    
	    if(s != null){
	    	JSONObject json=JSONObject.fromObject(s);
		    Iterator keys=json.keys();  
		    while(keys.hasNext()){  
		        String key=(String) keys.next();  
		        String value=json.get(key).toString();  
		        if(value.startsWith("{")&&value.endsWith("}")){  
		            map.put(key, stringToMap(value));  
		        }else{  
		            map.put(key, value);  
		        }  
		    }  
	    }
	    return map;  
	}  

	
	public static Map<String, Object> entityToMap(Object obj) { 
        Map<String, Object> params = new HashMap<String, Object>(0); 
        try { 
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) { 
                String name = descriptors[i].getName(); 
                if (!"class".equals(name)) { 
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name)); 
                } 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return params; 
	}
}
