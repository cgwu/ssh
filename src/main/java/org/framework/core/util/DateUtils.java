 package org.framework.core.util;
 
 import java.sql.Timestamp;
 import java.text.DateFormat;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.GregorianCalendar;
 
 public abstract class DateUtils
 {
   public static final String ISO_DATE_FORMAT = "yyyyMMdd";
   public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
   public static final String ISO_TIME_FORMAT = "HHmmssSSSzzz";
   public static final String ISO_EXPANDED_TIME_FORMAT = "HH:mm:ss,SSSzzz";
   public static final String ISO_DATE_TIME_FORMAT = "yyyyMMdd'T'HHmmssSSSzzz";
   public static final String ISO_EXPANDED_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss,SSSzzz";
   public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
   public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
   public static final long ONE_SECOND = 1000L;
   public static final long ONE_MINUTE = 60000L;
   public static final long ONE_HOUR = 3600000L;
   public static final long ONE_DAY = 86400000L;
   public static final long ONE_WEEK = 604800000L;
   public static final long ONE_YEAR = 31536000000L;
 
   public static Date afterMilliseconds(long time, long milliseconds)
   {
     return new Date(time + milliseconds);
   }
 
   public static Date afterSeconds(long time, long seconds) {
     return new Date(time + 1000L * seconds);
   }
 
   public static Date afterSeconds(long seconds) {
     return new Date(System.currentTimeMillis() + 1000L * seconds);
   }
 
   public static Date afterMinutes(long time, long minutes) {
     return new Date(time + 60000L * minutes);
   }
 
   public static Date afterMinutes(long minutes) {
     return new Date(System.currentTimeMillis() + 60000L * minutes);
   }
 
   public static Date afterHours(long time, long hours) {
     return new Date(time + 3600000L * hours);
   }
 
   public static Date afterHours(long hours) {
     return new Date(System.currentTimeMillis() + 3600000L * hours);
   }
 
   public static Date afterDays(long time, long days) {
     return new Date(time + 86400000L * days);
   }
 
   public static Date afterDays(long days) {
     return new Date(System.currentTimeMillis() + 86400000L * days);
   }
 
   public static Date afterYears(long time, long years) {
     return new Date(time + 31536000000L * years);
   }
 
   public static Date afterYears(long years) {
     return new Date(System.currentTimeMillis() + 31536000000L * years);
   }
 
   public static Date parseDate(String text) {
     return parseDate(text, new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" });
   }
 
   public static Date parseDate(String text, String[] dateFormatPatterns) {
     if (dateFormatPatterns != null)
     {
       String[] arrayOfString;
       int j = (arrayOfString = dateFormatPatterns).length; for (int i = 0; i < j; ) { String pattern = arrayOfString[i];
         try {
           SimpleDateFormat parser = new SimpleDateFormat(pattern);
           return parser.parse(text);
         }
         catch (Exception localException)
         {
           i++;
         }
 
       }
 
     }
 
     throw new RuntimeException("Unparseable date: " + text);
   }
 
   public static String formatDate(Date date)
   {
     return formatDate(date, "yyyy-MM-dd HH:mm:ss");
   }
 
   public static String formatDate(Date date, String dateFormatPattern) {
     DateFormat dateFormat = null;
     try {
       dateFormat = new SimpleDateFormat(dateFormatPattern);
     } catch (Exception ignore) {
       dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     }
     return formatDate(date, dateFormat);
   }
 
   public static String formatDate(Date date, DateFormat dateFormat)
   {
     if (date == null) {
       throw new IllegalArgumentException("date can not be null");
     }
     if (dateFormat == null) {
       throw new IllegalArgumentException("dateFormat can not be null");
     }
     return dateFormat.format(date);
   }
 
   public static Timestamp[] oneDay(Date date)
   {
     Calendar calendar = new GregorianCalendar();
     calendar.setTime(date != null ? date : new Date());
     calendar.set(11, 0);
     calendar.set(12, 0);
     calendar.set(13, 0);
     calendar.set(14, 0);
 
     Timestamp[] array = new Timestamp[2];
     array[0] = new Timestamp(calendar.getTimeInMillis());
 
     calendar.add(5, 1);
     calendar.add(14, -1);
     array[1] = new Timestamp(calendar.getTimeInMillis());
 
     return array;
   }
 
   public static Date onlyDate(Date time)
   {
     Calendar calendar = new GregorianCalendar();
     calendar.setTime(time);
     calendar.set(11, 0);
     calendar.set(12, 0);
     calendar.set(13, 0);
     calendar.set(14, 0);
     return calendar.getTime();
   }
 
   public static int getDayOfWeek(Date date)
   {
     Calendar calendar = new GregorianCalendar();
     calendar.setTime(date);
     return calendar.get(7);
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.DateUtils
 * JD-Core Version:    0.6.0
 */