/*    */ package org.framework.core.util;
/*    */ 
/*    */ import java.util.Locale;
/*    */ 
/*    */ public abstract class LocaleParser
/*    */ {
/*    */   private static final char HYPHEN = '-';
/*    */   private static final char UNDERSCORE = '_';
/*    */ 
/*    */   public static Locale parse(String locale, String variant)
/*    */   {
/* 30 */     String language = locale;
/* 31 */     String country = null;
/* 32 */     int index = -1;
/*    */ 
/* 34 */     if (((index = locale.indexOf('_')) > -1) || ((index = locale.indexOf('-')) > -1)) {
/* 35 */       language = locale.substring(0, index);
/* 36 */       country = locale.substring(index + 1);
/*    */     }
/*    */ 
/* 39 */     if (StringUtils.isEmpty(language)) {
/* 40 */       return null;
/*    */     }
/*    */ 
/* 43 */     if (StringUtils.isEmpty(country)) {
/* 44 */       country = "";
/*    */     }
/* 46 */     if (variant != null) {
/* 47 */       return new Locale(language, country, variant);
/*    */     }
/* 49 */     return new Locale(language, country);
/*    */   }
/*    */ 
/*    */   public static String language(Locale locale) {
/* 53 */     return locale.getLanguage();
/*    */   }
/*    */ 
/*    */   public static String language(String locale) {
/* 57 */     String language = locale;
/* 58 */     int index = -1;
/* 59 */     if (((index = locale.indexOf('_')) > -1) || ((index = locale.indexOf('-')) > -1)) {
/* 60 */       language = locale.substring(0, index);
/*    */     }
/* 62 */     return language.toLowerCase();
/*    */   }
/*    */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.LocaleParser
 * JD-Core Version:    0.6.0
 */