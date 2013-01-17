 package org.framework.core.util;
 
 import java.io.IOException;
 
 public abstract class Hex
 {
   private static final char[] DIGITS = { 
     '0', '1', '2', '3', '4', '5', '6', '7', 
     '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
 
   public static int toHexDigit(char ch)
   {
     if ((ch <= '9') && (ch >= '0')) {
       return ch - '0';
     }
     if ((ch >= 'a') && (ch <= 'f')) {
       return ch - 'a' + 10;
     }
     if ((ch < 'A') || (ch > 'F')) {
       throw new IllegalArgumentException("Illegal hexadecimal charcter + " + ch);
     }
     return ch - 'A' + 10;
   }
 
   public static byte[] toHex(int i) {
     byte[] bytes = new byte[8];
     for (int j = 7; j >= 0; j--) {
       bytes[j] = toHex((byte)(i & 0xF));
       i >>= 4;
     }
     return bytes;
   }
 
   public static byte[] toHex(long l) {
     byte[] bytes = new byte[16];
     for (int i = 15; i >= 0; i--) {
       bytes[i] = toHex((byte)(int)(l & 0xF));
       l >>= 4;
     }
 
     return bytes;
   }
 
   public static byte[] toHex(short value) {
     byte[] bytes = new byte[4];
     for (int i = 3; i >= 0; i--) {
       bytes[i] = toHex((byte)(value & 0xF));
       value = (short)(value >> 4);
     }
 
     return bytes;
   }
 
   public static byte toHex(byte b) {
     b = (byte)(b & 0xF);
     return (byte)(b >= 10 ? b - 10 + 65 : b + 48);
   }
 
   public static char hexDigit(int num)
   {
     return num < 10 ? (char)(num + 48) : (char)(num + 55);
   }
 
   public static byte[] decodeHexString(String hexString)
   {
     if (hexString == null) {
       throw new IllegalArgumentException("hexString must not be null!");
     }
 
     boolean flag = false;
     int num = 0;
     int length = hexString.length();
     if ((length % 2 != 0) && (length % 3 != 2)) {
       throw new IllegalArgumentException("hexString length is invalid!");
     }
     if ((length >= 2) && (hexString.charAt(0) == '0') && ((hexString.charAt(1) == 'x') || (hexString.charAt(1) == 'X'))) {
       length = hexString.length() - 2;
       num = 2;
     }
     byte[] buffer;
     if ((length >= 3) && (hexString.charAt(num + 2) == ' ')) {
       flag = true;
       buffer = new byte[length / 3 + 1];
     } else {
       buffer = new byte[length / 2];
     }
     for (int i = 0; num < length; i++) {
       int num4 = toHexDigit(hexString.charAt(num));
       int num3 = toHexDigit(hexString.charAt(num + 1));
       buffer[i] = (byte)(num3 | num4 << 4);
       if (flag) {
         num++;
       }
       num += 2;
     }
     return buffer;
   }
 
   public static byte[] decodeHex(char[] data)
   {
     int len = data.length;
 
     if ((len & 0x1) != 0) {
       throw new IllegalArgumentException("Odd number of characters.");
     }
     byte[] out = new byte[len >> 1];
 
     int i = 0; for (int j = 0; j < len; i++) {
       int f = toHexDigit(data[j]) << 4;
       j++;
       f |= toHexDigit(data[j]);
       j++;
       out[i] = (byte)(f & 0xFF);
     }
 
     return out;
   }
 
   public static String encodeHexString(byte[] sArray)
   {
     String str = null;
     if (sArray == null) {
       return str;
     }
     int length = sArray.length;
     char[] chArray = new char[length * 2];
     int index = 0;
     int num3 = 0;
     while (index < length) {
       int num = (sArray[index] & 0xF0) >> 4;
       chArray[(num3++)] = hexDigit(num);
       num = sArray[index] & 0xF;
       chArray[(num3++)] = hexDigit(num);
       index++;
     }
     return new String(chArray);
   }
 
   public static char[] encodeHex(byte[] data)
   {
     int l = data.length;
     char[] out = new char[l << 1];
 
     int i = 0; for (int j = 0; i < l; i++) {
       out[(j++)] = DIGITS[((0xF0 & data[i]) >>> 4)];
       out[(j++)] = DIGITS[(0xF & data[i])];
     }
     return out;
   }
 
   public static long parseLong(CharSequence s)
   {
     long out = 0L;
     byte shifts = 0;
 
     for (int i = 0; (i < s.length()) && (shifts < 16); i++) {
       char c = s.charAt(i);
       if ((c > '/') && (c < ':')) {
         shifts = (byte)(shifts + 1);
         out <<= 4;
         out |= c - '0';
       }
       else if ((c > '@') && (c < 'G')) {
         shifts = (byte)(shifts + 1);
         out <<= 4;
         out |= c - '7';
       }
       else if ((c > '`') && (c < 'g')) {
         shifts = (byte)(shifts + 1);
         out <<= 4;
         out |= c - 'W';
       }
     }
     return out;
   }
 
   public static short parseShort(String s)
   {
     short out = 0;
     byte shifts = 0;
 
     for (int i = 0; (i < s.length()) && (shifts < 4); i++) {
       char c = s.charAt(i);
       if ((c > '/') && (c < ':')) {
         shifts = (byte)(shifts + 1);
         out = (short)(out << 4);
         out = (short)(out | c - '0');
       }
       else if ((c > '@') && (c < 'G')) {
         shifts = (byte)(shifts + 1);
         out = (short)(out << 4);
         out = (short)(out | c - '7');
       }
       else if ((c > '`') && (c < 'g')) {
         shifts = (byte)(shifts + 1);
         out = (short)(out << 4);
         out = (short)(out | c - 'W');
       }
     }
     return out;
   }
 
   public static Appendable append(Appendable a, int in)
   {
     return append(a, in, 8);
   }
 
   public static Appendable append(Appendable a, int in, int length)
   {
     int b = in;
     int l = length;
     char[] out = new char[l--];
     for (int i = l; i > -1; i--) {
       out[i] = DIGITS[(byte)(b & 0xF)];
       b >>= 4;
     }
     try {
       for (int i = 0; i < out.length; i++)
         a.append(out[i]);
     }
     catch (IOException localIOException)
     {
     }
     return a;
   }
 
   public static Appendable append(Appendable a, long in)
   {
     return append(a, in, 16);
   }
 
   public static Appendable append(Appendable a, long in, int length)
   {
     long b = in;
     int l = length;
     char[] out = new char[l--];
     for (int i = l; i > -1; i--) {
       out[i] = DIGITS[(byte)(int)(b & 0xF)];
       b >>= 4;
     }
     try {
       for (int i = 0; i < out.length; i++) {
         a.append(out[i]);
       }
     }
     catch (IOException localIOException)
     {
     }
     return a;
   }
 
   public static Appendable append(Appendable a, short in)
   {
     return append(a, in, 4);
   }
 
   public static Appendable append(Appendable a, short in, int length)
   {
     short b = in;
     int l = length;
     char[] out = new char[l--];
     for (int i = l; i > -1; i--) {
       out[i] = DIGITS[(byte)(b & 0xF)];
       b = (short)(b >> 4);
     }
     try {
       for (int i = 0; i < out.length; i++) {
         a.append(out[i]);
       }
     }
     catch (IOException localIOException)
     {
     }
     return a;
   }
 
   public static Appendable append(Appendable a, byte[] b)
   {
     int len = b.length << 1;
     char[] out = new char[len--];
     for (int i = b.length - 1; i > -1; i--) {
       out[(len--)] = DIGITS[(byte)(b[i] & 0xF)];
       out[(len--)] = DIGITS[(byte)((b[i] & 0xF0) >> 4)];
     }
     try {
       for (int i = 0; i < out.length; i++)
         a.append(out[i]);
     }
     catch (IOException localIOException)
     {
     }
     return a;
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.Hex
 * JD-Core Version:    0.6.0
 */