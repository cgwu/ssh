/*     */ package org.framework.core.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ public abstract class Hex
/*     */ {
/*  27 */   private static final char[] DIGITS = { 
/*  28 */     '0', '1', '2', '3', '4', '5', '6', '7', 
/*  29 */     '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */   public static int toHexDigit(char ch)
/*     */   {
/*  38 */     if ((ch <= '9') && (ch >= '0')) {
/*  39 */       return ch - '0';
/*     */     }
/*  41 */     if ((ch >= 'a') && (ch <= 'f')) {
/*  42 */       return ch - 'a' + 10;
/*     */     }
/*  44 */     if ((ch < 'A') || (ch > 'F')) {
/*  45 */       throw new IllegalArgumentException("Illegal hexadecimal charcter + " + ch);
/*     */     }
/*  47 */     return ch - 'A' + 10;
/*     */   }
/*     */ 
/*     */   public static byte[] toHex(int i) {
/*  51 */     byte[] bytes = new byte[8];
/*  52 */     for (int j = 7; j >= 0; j--) {
/*  53 */       bytes[j] = toHex((byte)(i & 0xF));
/*  54 */       i >>= 4;
/*     */     }
/*  56 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] toHex(long l) {
/*  60 */     byte[] bytes = new byte[16];
/*  61 */     for (int i = 15; i >= 0; i--) {
/*  62 */       bytes[i] = toHex((byte)(int)(l & 0xF));
/*  63 */       l >>= 4;
/*     */     }
/*     */ 
/*  66 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte[] toHex(short value) {
/*  70 */     byte[] bytes = new byte[4];
/*  71 */     for (int i = 3; i >= 0; i--) {
/*  72 */       bytes[i] = toHex((byte)(value & 0xF));
/*  73 */       value = (short)(value >> 4);
/*     */     }
/*     */ 
/*  76 */     return bytes;
/*     */   }
/*     */ 
/*     */   public static byte toHex(byte b) {
/*  80 */     b = (byte)(b & 0xF);
/*  81 */     return (byte)(b >= 10 ? b - 10 + 65 : b + 48);
/*     */   }
/*     */ 
/*     */   public static char hexDigit(int num)
/*     */   {
/*  90 */     return num < 10 ? (char)(num + 48) : (char)(num + 55);
/*     */   }
/*     */ 
/*     */   public static byte[] decodeHexString(String hexString)
/*     */   {
/*  99 */     if (hexString == null) {
/* 100 */       throw new IllegalArgumentException("hexString must not be null!");
/*     */     }
/*     */ 
/* 103 */     boolean flag = false;
/* 104 */     int num = 0;
/* 105 */     int length = hexString.length();
/* 106 */     if ((length % 2 != 0) && (length % 3 != 2)) {
/* 107 */       throw new IllegalArgumentException("hexString length is invalid!");
/*     */     }
/* 109 */     if ((length >= 2) && (hexString.charAt(0) == '0') && ((hexString.charAt(1) == 'x') || (hexString.charAt(1) == 'X'))) {
/* 110 */       length = hexString.length() - 2;
/* 111 */       num = 2;
/*     */     }
/*     */     byte[] buffer;
/* 113 */     if ((length >= 3) && (hexString.charAt(num + 2) == ' ')) {
/* 114 */       flag = true;
/* 115 */       buffer = new byte[length / 3 + 1];
/*     */     } else {
/* 117 */       buffer = new byte[length / 2];
/*     */     }
/* 119 */     for (int i = 0; num < length; i++) {
/* 120 */       int num4 = toHexDigit(hexString.charAt(num));
/* 121 */       int num3 = toHexDigit(hexString.charAt(num + 1));
/* 122 */       buffer[i] = (byte)(num3 | num4 << 4);
/* 123 */       if (flag) {
/* 124 */         num++;
/*     */       }
/* 126 */       num += 2;
/*     */     }
/* 128 */     return buffer;
/*     */   }
/*     */ 
/*     */   public static byte[] decodeHex(char[] data)
/*     */   {
/* 137 */     int len = data.length;
/*     */ 
/* 139 */     if ((len & 0x1) != 0) {
/* 140 */       throw new IllegalArgumentException("Odd number of characters.");
/*     */     }
/* 142 */     byte[] out = new byte[len >> 1];
/*     */ 
/* 145 */     int i = 0; for (int j = 0; j < len; i++) {
/* 146 */       int f = toHexDigit(data[j]) << 4;
/* 147 */       j++;
/* 148 */       f |= toHexDigit(data[j]);
/* 149 */       j++;
/* 150 */       out[i] = (byte)(f & 0xFF);
/*     */     }
/*     */ 
/* 153 */     return out;
/*     */   }
/*     */ 
/*     */   public static String encodeHexString(byte[] sArray)
/*     */   {
/* 162 */     String str = null;
/* 163 */     if (sArray == null) {
/* 164 */       return str;
/*     */     }
/* 166 */     int length = sArray.length;
/* 167 */     char[] chArray = new char[length * 2];
/* 168 */     int index = 0;
/* 169 */     int num3 = 0;
/* 170 */     while (index < length) {
/* 171 */       int num = (sArray[index] & 0xF0) >> 4;
/* 172 */       chArray[(num3++)] = hexDigit(num);
/* 173 */       num = sArray[index] & 0xF;
/* 174 */       chArray[(num3++)] = hexDigit(num);
/* 175 */       index++;
/*     */     }
/* 177 */     return new String(chArray);
/*     */   }
/*     */ 
/*     */   public static char[] encodeHex(byte[] data)
/*     */   {
/* 186 */     int l = data.length;
/* 187 */     char[] out = new char[l << 1];
/*     */ 
/* 190 */     int i = 0; for (int j = 0; i < l; i++) {
/* 191 */       out[(j++)] = DIGITS[((0xF0 & data[i]) >>> 4)];
/* 192 */       out[(j++)] = DIGITS[(0xF & data[i])];
/*     */     }
/* 194 */     return out;
/*     */   }
/*     */ 
/*     */   public static long parseLong(CharSequence s)
/*     */   {
/* 204 */     long out = 0L;
/* 205 */     byte shifts = 0;
/*     */ 
/* 207 */     for (int i = 0; (i < s.length()) && (shifts < 16); i++) {
/* 208 */       char c = s.charAt(i);
/* 209 */       if ((c > '/') && (c < ':')) {
/* 210 */         shifts = (byte)(shifts + 1);
/* 211 */         out <<= 4;
/* 212 */         out |= c - '0';
/*     */       }
/* 214 */       else if ((c > '@') && (c < 'G')) {
/* 215 */         shifts = (byte)(shifts + 1);
/* 216 */         out <<= 4;
/* 217 */         out |= c - '7';
/*     */       }
/* 219 */       else if ((c > '`') && (c < 'g')) {
/* 220 */         shifts = (byte)(shifts + 1);
/* 221 */         out <<= 4;
/* 222 */         out |= c - 'W';
/*     */       }
/*     */     }
/* 225 */     return out;
/*     */   }
/*     */ 
/*     */   public static short parseShort(String s)
/*     */   {
/* 235 */     short out = 0;
/* 236 */     byte shifts = 0;
/*     */ 
/* 238 */     for (int i = 0; (i < s.length()) && (shifts < 4); i++) {
/* 239 */       char c = s.charAt(i);
/* 240 */       if ((c > '/') && (c < ':')) {
/* 241 */         shifts = (byte)(shifts + 1);
/* 242 */         out = (short)(out << 4);
/* 243 */         out = (short)(out | c - '0');
/*     */       }
/* 245 */       else if ((c > '@') && (c < 'G')) {
/* 246 */         shifts = (byte)(shifts + 1);
/* 247 */         out = (short)(out << 4);
/* 248 */         out = (short)(out | c - '7');
/*     */       }
/* 250 */       else if ((c > '`') && (c < 'g')) {
/* 251 */         shifts = (byte)(shifts + 1);
/* 252 */         out = (short)(out << 4);
/* 253 */         out = (short)(out | c - 'W');
/*     */       }
/*     */     }
/* 256 */     return out;
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, int in)
/*     */   {
/* 267 */     return append(a, in, 8);
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, int in, int length)
/*     */   {
/* 279 */     int b = in;
/* 280 */     int l = length;
/* 281 */     char[] out = new char[l--];
/* 282 */     for (int i = l; i > -1; i--) {
/* 283 */       out[i] = DIGITS[(byte)(b & 0xF)];
/* 284 */       b >>= 4;
/*     */     }
/*     */     try {
/* 287 */       for (int i = 0; i < out.length; i++)
/* 288 */         a.append(out[i]);
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/* 293 */     return a;
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, long in)
/*     */   {
/* 304 */     return append(a, in, 16);
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, long in, int length)
/*     */   {
/* 316 */     long b = in;
/* 317 */     int l = length;
/* 318 */     char[] out = new char[l--];
/* 319 */     for (int i = l; i > -1; i--) {
/* 320 */       out[i] = DIGITS[(byte)(int)(b & 0xF)];
/* 321 */       b >>= 4;
/*     */     }
/*     */     try {
/* 324 */       for (int i = 0; i < out.length; i++) {
/* 325 */         a.append(out[i]);
/*     */       }
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/* 331 */     return a;
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, short in)
/*     */   {
/* 342 */     return append(a, in, 4);
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, short in, int length)
/*     */   {
/* 354 */     short b = in;
/* 355 */     int l = length;
/* 356 */     char[] out = new char[l--];
/* 357 */     for (int i = l; i > -1; i--) {
/* 358 */       out[i] = DIGITS[(byte)(b & 0xF)];
/* 359 */       b = (short)(b >> 4);
/*     */     }
/*     */     try {
/* 362 */       for (int i = 0; i < out.length; i++) {
/* 363 */         a.append(out[i]);
/*     */       }
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/* 369 */     return a;
/*     */   }
/*     */ 
/*     */   public static Appendable append(Appendable a, byte[] b)
/*     */   {
/* 380 */     int len = b.length << 1;
/* 381 */     char[] out = new char[len--];
/* 382 */     for (int i = b.length - 1; i > -1; i--) {
/* 383 */       out[(len--)] = DIGITS[(byte)(b[i] & 0xF)];
/* 384 */       out[(len--)] = DIGITS[(byte)((b[i] & 0xF0) >> 4)];
/*     */     }
/*     */     try {
/* 387 */       for (int i = 0; i < out.length; i++)
/* 388 */         a.append(out[i]);
/*     */     }
/*     */     catch (IOException localIOException)
/*     */     {
/*     */     }
/* 393 */     return a;
/*     */   }
/*     */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.Hex
 * JD-Core Version:    0.6.0
 */