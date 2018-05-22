package com.sjh.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;


/**
 * @author aned
 * @since 2014-5-16
 */
public class JSONUtil {

	/**
	 * 把对象转换成json字符串写到客户端
	 * 
	 * @author aned
	 * @since 2014-5-16
	 * @param response
	 *            Http应答
	 * @param obj
	 *            �?��写到客户端的数据对象
	 * @param clazz
	 *            �?��记录的日志class
	 */
	public static void writeJSONString(HttpServletResponse response, Object obj) {
		PrintWriter out = null;
		try {
			JsonConfig config = new JsonConfig();
			config.setJsonPropertyFilter(new PropertyFilter() {
				@Override
				public boolean apply(Object arg0, String name, Object arg2) {
					/*
					 * 由于JSONObject插件内部会无限拆解你传入的对象，直到没有可拆解为�?
					 * 那么拥有外键的实体就会互相引用，陷入死循�?name是实体的属�?�?过滤掉的字段返回为true
					 */
					if (name.equals("packingLot") || name.equals("record")
							|| name.equals("puser") || name.equals("ruser")
							|| name.equals("mountMessage")
							|| name.equals("reserveMessages")
							|| name.equals("releaseRecords")
							|| name.equals("records") || name.equals("payRecords")) {
						return true;
					} else {
						return false;
					}
				}
			});
			JSONObject jsonObject = JSONObject.fromObject(obj, config);
			// JSONObject jsonObject = JSONObject.fromObject(obj);
			response.setCharacterEncoding("gbk");
			out = response.getWriter();
			String str = jsonObject.toString();
			out.write(str);
		} catch (IOException e) {

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public static void writeJSONArrayString(HttpServletResponse response,
			Object obj) {

		PrintWriter out = null;
		try {
			// JSONObject jsonObject = JSONObject.fromObject(obj);
			JSONArray jsonArray = JSONArray.fromObject(obj);
			response.setCharacterEncoding("gbk");
			out = response.getWriter();
			String str = jsonArray.toString();
			out.write(str);
		} catch (IOException e) {
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Object> codeErrorMap() {
		Map<String, Object> codeMap = new HashMap<String, Object>();

		codeMap.put("data", Constants.EMPTY);
		codeMap.put("code", "2");
		return codeMap;
	}

	public static void sendError(HttpServletResponse response) {
		try {
			response.sendError(500);
		} catch (IOException e) {
		}
	}
}
