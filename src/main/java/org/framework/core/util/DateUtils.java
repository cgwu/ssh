/*     */ package org.framework.core.util;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ 
/*     */ public abstract class DateUtils
/*     */ {
/*     */   public static final String ISO_DATE_FORMAT = "yyyyMMdd";
/*     */   public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
/*     */   public static final String ISO_TIME_FORMAT = "HHmmssSSSzzz";
/*     */   public static final String ISO_EXPANDED_TIME_FORMAT = "HH:mm:ss,SSSzzz";
/*     */   public static final String ISO_DATE_TIME_FORMAT = "yyyyMMdd'T'HHmmssSSSzzz";
/*     */   public static final String ISO_EXPANDED_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss,SSSzzz";
/*     */   public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
/*     */   public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
/*     */   public static final long ONE_SECOND = 1000L;
/*     */   public static final long ONE_MINUTE = 60000L;
/*     */   public static final long ONE_HOUR = 3600000L;
/*     */   public static final long ONE_DAY = 86400000L;
/*     */   public static final long ONE_WEEK = 604800000L;
/*     */   public static final long ONE_YEAR = 31536000000L;
/*     */ 
/*     */   public static Date afterMilliseconds(long time, long milliseconds)
/*     */   {
/* 114 */     return new Date(time + milliseconds);
/*     */   }
/*     */ 
/*     */   public static Date afterSeconds(long time, long seconds) {
/* 118 */     return new Date(time + 1000L * seconds);
/*     */   }
/*     */ 
/*     */   public static Date afterSeconds(long seconds) {
/* 122 */     return new Date(System.currentTimeMillis() + 1000L * seconds);
/*     */   }
/*     */ 
/*     */   public static Date afterMinutes(long time, long minutes) {
/* 126 */     return new Date(time + 60000L * minutes);
/*     */   }
/*     */ 
/*     */   public static Date afterMinutes(long minutes) {
/* 130 */     return new Date(System.currentTimeMillis() + 60000L * minutes);
/*     */   }
/*     */ 
/*     */   public static Date afterHours(long time, long hours) {
/* 134 */     return new Date(time + 3600000L * hours);
/*     */   }
/*     */ 
/*     */   public static Date afterHours(long hours) {
/* 138 */     return new Date(System.currentTimeMillis() + 3600000L * hours);
/*     */   }
/*     */ 
/*     */   public static Date afterDays(long time, long days) {
/* 142 */     return new Date(time + 86400000L * days);
/*     */   }
/*     */ 
/*     */   public static Date afterDays(long days) {
/* 146 */     return new Date(System.currentTimeMillis() + 86400000L * days);
/*     */   }
/*     */ 
/*     */   public static Date afterYears(long time, long years) {
/* 150 */     return new Date(time + 31536000000L * years);
/*     */   }
/*     */ 
/*     */   public static Date afterYears(long years) {
/* 154 */     return new Date(System.currentTimeMillis() + 31536000000L * years);
/*     */   }
/*     */ 
/*     */   public static Date parseDate(String text) {
/* 158 */     return parseDate(text, new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" });
/*     */   }
/*     */ 
/*     */   public static Date parseDate(String text, String[] dateFormatPatterns) {
/* 162 */     if (dateFormatPatterns != null)
/*     */     {
/* 163 */       String[] arrayOfString;
/* 163 */       int j = (arrayOfString = dateFormatPatterns).length; for (int i = 0; i < j; ) { String pattern = arrayOfString[i];
/*     */         try {
/* 165 */           SimpleDateFormat parser = new SimpleDateFormat(pattern);
/* 166 */           return parser.parse(text);
/*     */         }
/*     */         catch (Exception localException)
/*     */         {
/* 163 */           i++;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 170 */     throw new RuntimeException("Unparseable date: " + text);
/*     */   }
/*     */ 
/*     */   public static String formatDate(Date date)
/*     */   {
/* 175 */     return formatDate(date, "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String formatDate(Date date, String dateFormatPattern) {
/* 179 */     DateFormat dateFormat = null;
/*     */     try {
/* 181 */       dateFormat = new SimpleDateFormat(dateFormatPattern);
/*     */     } catch (Exception ignore) {
/* 183 */       dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */     }
/* 185 */     return formatDate(date, dateFormat);
/*     */   }
/*     */ 
/*     */   public static String formatDate(Date date, DateFormat dateFormat)
/*     */   {
/* 190 */     if (date == null) {
/* 191 */       throw new IllegalArgumentException("date can not be null");
/*     */     }
/* 193 */     if (dateFormat == null) {
/* 194 */       throw new IllegalArgumentException("dateFormat can not be null");
/*     */     }
/* 196 */     return dateFormat.format(date);
/*     */   }
/*     */ 
/*     */   public static Timestamp[] oneDay(Date date)
/*     */   {
/* 205 */     Calendar calendar = new GregorianCalendar();
/* 206 */     calendar.setTime(date != null ? date : new Date());
/* 207 */     calendar.set(11, 0);
/* 208 */     calendar.set(12, 0);
/* 209 */     calendar.set(13, 0);
/* 210 */     calendar.set(14, 0);
/*     */ 
/* 212 */     Timestamp[] array = new Timestamp[2];
/* 213 */     array[0] = new Timestamp(calendar.getTimeInMillis());
/*     */ 
/* 215 */     calendar.add(5, 1);
/* 216 */     calendar.add(14, -1);
/* 217 */     array[1] = new Timestamp(calendar.getTimeInMillis());
/*     */ 
/* 219 */     return array;
/*     */   }
/*     */ 
/*     */   public static Date onlyDate(Date time)
/*     */   {
/* 228 */     Calendar calendar = new GregorianCalendar();
/* 229 */     calendar.setTime(time);
/* 230 */     calendar.set(11, 0);
/* 231 */     calendar.set(12, 0);
/* 232 */     calendar.set(13, 0);
/* 233 */     calendar.set(14, 0);
/* 234 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   public static int getDayOfWeek(Date date)
/*     */   {
/* 243 */     Calendar calendar = new GregorianCalendar();
/* 244 */     calendar.setTime(date);
/* 245 */     return calendar.get(7);
/*     */   }
/*     */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.DateUtils
 * JD-Core Version:    0.6.0
 */