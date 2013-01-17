 package org.framework.core.util;
 
 import java.util.Locale;
 
 public abstract class LocaleParser
 {
   private static final char HYPHEN = '-';
   private static final char UNDERSCORE = '_';
 
   public static Locale parse(String locale, String variant)
   {
     String language = locale;
     String country = null;
     int index = -1;
 
     if (((index = locale.indexOf('_')) > -1) || ((index = locale.indexOf('-')) > -1)) {
       language = locale.substring(0, index);
       country = locale.substring(index + 1);
     }
 
     if (StringUtils.isEmpty(language)) {
       return null;
     }
 
     if (StringUtils.isEmpty(country)) {
       country = "";
     }
     if (variant != null) {
       return new Locale(language, country, variant);
     }
     return new Locale(language, country);
   }
 
   public static String language(Locale locale) {
     return locale.getLanguage();
   }
 
   public static String language(String locale) {
     String language = locale;
     int index = -1;
     if (((index = locale.indexOf('_')) > -1) || ((index = locale.indexOf('-')) > -1)) {
       language = locale.substring(0, index);
     }
     return language.toLowerCase();
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.LocaleParser
 * JD-Core Version:    0.6.0
 */