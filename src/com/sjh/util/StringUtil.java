package com.sjh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;


/**
 * 字符串工具类
 */
public class StringUtil {

	/**
	 * ASCII编码字符串转十六进制字符�?
	 * 
	 * @param str
	 *            ASCII编码字符�?
	 * @return 十六进制字符�?
	 */
	public static String stringToHex(String str) {
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();

		for (char c : chars) {
			sb.append(Integer.toHexString((int) c)).append(" ");
		}

		return sb.toString();
	}

	/**
	 * 十六进制字符串转ASCII编码字符�?
	 * 
	 * @param str
	 *            十六进制字符�?
	 * @return ASCII编码字符�?
	 */
	public static String hexToString(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i += 3) {
			sb.append((char) Integer.parseInt(str.substring(i, i + 2), 16));
		}

		return sb.toString();
	}

	/**
	 * 判断字符串是否为�?
	 * 
	 * @param str
	 */
	public static boolean isNotNull(String str) {
		return (null != str && !"".equals(str.trim()) && !"null".equals(str));
	}

	/**
	 * 判断字符串是否为�?
	 * 
	 * @param str
	 */
	public static boolean isNull(String str) {
		return !isNotNull(str);
	}

	/**
	 * 描述: 获取32位UUID, �?null 或�? "" 都能生成无间隔形式的 uuid �?str 就以 str 为分�?
	 */
	public static String getUUID(String str) {
		if (isNotNull(str)) {
			return UUID.randomUUID().toString().replaceAll("-", str);
		} else {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
	}

	/**
	 * 描述�?获取原生态格式的 UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	// 判断输入的是否是数字
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 方法描述�?从str中移除substr 创建人：mazhonghua 创建时间�?014-11-18 下午01:34:36
	 * 
	 * @param str
	 * @param subStr
	 * @return
	 */
	public static String subStr(String str, String oldStr, String newStr) {

		return str.replace(oldStr, newStr);
	}


	public void testString() {
		// String s = "mazhonghua".replace("ma", "liu");
		// System.out.println(s);
		System.out.println(subStr("mazhonghuama", "ma", "liu"));
	}

	// 学生提交答案的字符串解析
	public static Map<String, String> stringToMap(String str) {
		Map<String, String> map = new HashMap<String, String>();
		String[] s = str.split("##");
		for (String itemAnswer : s) {
			String[] item_answer = itemAnswer.split("#");
			map.put(item_answer[0], item_answer[1]);
		}
		return map;
	}

	/**
	 * 方法描述�?�?str 字符串中 截取 两个 subStr 中的字符�?只会得到第一个符合要求的字符�?创建人：mazhonghua
	 * 创建时间�?014-12-25 上午10:27:01
	 * 
	 * @param str
	 * @param subStr
	 * @return
	 */
	public static String parseString(String str, String subStr, int startIndex) {
		int firstIndex = str.indexOf(subStr, startIndex);
		System.out.println(firstIndex);
		int secondIndex = str.indexOf(subStr, firstIndex + subStr.length());
		System.out.println(secondIndex);
		return str.substring(firstIndex + subStr.length(), secondIndex);
	}

	public void testParseString() throws ParseException {
		// System.out.println(parseString("mazhonghuama", "ma",0));
		// System.out.println(parseString("shhhrhmnzghgfhhhtehdhhhfb",
		// "hhh",0));

		System.out.println(DateTime.stringToDate(DateTime.getStringCurrentTime(DateTime.DATE_TIME_FORMAT), DateTime.DATE_TIME_FORMAT));
	}

	/**
	 * 字符串的日期格式的计�?
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 方法描述�?自己实现�?String.split() 方法，缺点是返回了一�?list 而不�?string 数组 创建人：mazhonghua
	 * 创建时间�?014-12-25 上午11:18:18
	 * 
	 * @param str
	 * @param subStr
	 * @param startIndex
	 * @return
	 */
	public static List<String> mySplit(String str, String subStr, int startIndex) {
		List<String> stringList = new ArrayList<String>();
		int firstIndex = str.indexOf(subStr, startIndex);
		if (firstIndex != -1) {
			stringList.add(str.substring(0, firstIndex));
			int secondIndex = str.indexOf(subStr, firstIndex + subStr.length());
			while (secondIndex != -1) {
				String s = str.substring(firstIndex + subStr.length(), secondIndex);
				stringList.add(s);
				firstIndex = secondIndex;
				secondIndex = str.indexOf(subStr, firstIndex + subStr.length());
			}
			stringList.add(str.substring(firstIndex + subStr.length()));
		}
		return stringList;
	}

	public void testParseStringList() {
		// List<String> stringList = mySplit("s#rhmnzghgf#tehd#fb", "#",0);
		// for(String s: stringList){
		// System.out.println(s);
		// }
		String s = "s#rhmn.zghg.f#teh.d#fb";
		// String[] sList = "s#rhmnzghgf#tehd#fb".split("#");
		System.out.println(s.split("\\.")[0]);
		System.out.println(s.substring(0, s.indexOf(".")));
		// for(int i=0;i<sList.length; i++){
		// System.out.println(sList[i]);
		// }

	}

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			java.util.regex.Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static String subStringByByte(String str, int n) {
		StringBuffer sb = new StringBuffer();
		int len = 0, i;
		for (i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			len += (c <= 'z') ? 1 : 2;
			sb.append(c);
			if (len >= n)
				break;
		}
		return sb.toString();
	}

	public static int getByteLen(String str) {
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			len += (str.charAt(i) <= 'z') ? 1 : 2;
		}
		return len;
	}

	public static int getIntNumberFromGroupNumber(String groupNumber) {
		// groupNumber = "�?�?;

		if (StringUtil.isNotNull(groupNumber) && groupNumber.length() >= 3) {
			return Integer.parseInt(groupNumber.substring(1, groupNumber.length() - 1));
		} else {
			return 0;
		}
	}

	public static boolean compareTwoString(String s1, String s2) {
		if (isNull(s1) && isNull(s2)) {
			return true;
		} else if (isNotNull(s1) && isNotNull(s2)) {
			if (s1.equals(s2)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
