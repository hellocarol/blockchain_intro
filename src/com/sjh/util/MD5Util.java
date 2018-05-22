package com.sjh.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5Util {

 /**
  * 将源字符串使用MD5加密为字节数�?
  * @param source
  * @return
  */
 public static byte[] encode2bytes(String source) {
  byte[] result = null;
  try {
   MessageDigest md = MessageDigest.getInstance("MD5");
   md.reset();
   md.update(source.getBytes("UTF-8"));
   result = md.digest();
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  } catch (UnsupportedEncodingException e) {
   e.printStackTrace();
  }

  return result;
 }

 /**
  * 将源字符串使用MD5加密�?2�?6进制�?
  * @param source
  * @return
  */
 public static String encode2hex(String source) {
  byte[] data = encode2bytes(source);
  StringBuffer hexString = new StringBuffer();
  for (int i = 0; i < data.length; i++) {
   String hex = Integer.toHexString(0xff & data[i]);

   if (hex.length() == 1) {
    hexString.append('0');
   }

   hexString.append(hex);
  }

  return hexString.toString();
 }

 /**
  * 验证字符串是否匹�?
  * @param unknown 待验证的字符�?
  * @param okHex 使用MD5加密过的16进制字符�?
  * @return 匹配返回true，不匹配返回false
  */
 public static boolean validate(String unknown , String okHex) {
  return okHex.equals(encode2hex(unknown));
 }

}