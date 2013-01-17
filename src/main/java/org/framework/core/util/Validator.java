/*     */ package org.framework.core.util;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public abstract class Validator
/*     */ {
/*     */   public static boolean isEmail(String input)
/*     */   {
/*  34 */     String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
/*  35 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isIP(String input)
/*     */   {
/*  44 */     String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
/*  45 */     String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
/*  46 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isUrl(String input)
/*     */   {
/*  55 */     String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
/*  56 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isTelephone(String input)
/*     */   {
/*  65 */     String regex = "^(\\d{3,4}-)?\\d{6,8}$";
/*  66 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isPassword(String input)
/*     */   {
/*  75 */     String regex = "[A-Za-z]+[0-9]";
/*  76 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isPostalcode(String input)
/*     */   {
/*  85 */     String regex = "^\\d{6}$";
/*  86 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isHandset(String input)
/*     */   {
/*  95 */     String regex = "^[1]+[3,5]+\\d{9}$";
/*  96 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isIdNumber(String input)
/*     */   {
/* 105 */     String regex = "(^\\d{18}$)|(^\\d{15}$)";
/* 106 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isDecimal(String input)
/*     */   {
/* 115 */     String regex = "^[0-9]+(.[0-9]{2})?$";
/* 116 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isMonth(String input)
/*     */   {
/* 125 */     String regex = "^(0?[[1-9]|1[0-2])$";
/* 126 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isDay(String input)
/*     */   {
/* 135 */     String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
/* 136 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isDate(String input)
/*     */   {
/* 150 */     String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
/* 151 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isNumber(String input)
/*     */   {
/* 160 */     String regex = "^[0-9]*$";
/* 161 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isIntNumber(String input)
/*     */   {
/* 170 */     String regex = "^\\+?[1-9][0-9]*$";
/* 171 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isUpChar(String input)
/*     */   {
/* 180 */     String regex = "^[A-Z]+$";
/* 181 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isLowChar(String input)
/*     */   {
/* 190 */     String regex = "^[a-z]+$";
/* 191 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isLetter(String input)
/*     */   {
/* 200 */     String regex = "^[A-Za-z]+$";
/* 201 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isChinese(String input)
/*     */   {
/* 210 */     String regex = "^[一-龥],{0,}$";
/* 211 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   public static boolean isLength(String input)
/*     */   {
/* 220 */     String regex = "^.{8,}$";
/* 221 */     return match(regex, input);
/*     */   }
/*     */ 
/*     */   private static boolean match(String regex, String input)
/*     */   {
/* 230 */     Pattern pattern = Pattern.compile(regex);
/* 231 */     Matcher matcher = pattern.matcher(input);
/* 232 */     return matcher.matches();
/*     */   }
/*     */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.Validator
 * JD-Core Version:    0.6.0
 */