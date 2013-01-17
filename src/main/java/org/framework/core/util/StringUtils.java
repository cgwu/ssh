/*     */ package org.framework.core.util;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ public abstract class StringUtils
/*     */ {
/*     */   public static final String EMPTY_STRING = "";
/*     */   public static final int INDEX_NOT_FOUND = -1;
/*     */   public static final char DEFAULT_SEPARATOR = ',';
/*     */   public static final String DEFAULT_SEPARATOR_STRING = ",";
/*     */   public static final char MAP_KEY_SEPARATOR = ':';
/*     */   public static final char MAP_KEY_SEPARATOR2 = '=';
/*     */   public static final String MAP_KEY_SEPARATOR_STRING = ":";
/*     */   public static final char ARRAY_BOUND_START = '[';
/*     */   public static final char ARRAY_BOUND_END = ']';
/*     */   public static final char MAP_BOUND_START = '{';
/*     */   public static final char MAP_BOUND_END = '}';
/*     */ 
/*     */   public static boolean isEmpty(String s)
/*     */   {
/*  58 */     return length(s) == 0;
/*     */   }
/*     */ 
/*     */   public static boolean notEmpty(String s)
/*     */   {
/*  65 */     return length(s) > 0;
/*     */   }
/*     */ 
/*     */   public static int length(String s) {
/*  69 */     return s != null ? s.length() : 0;
/*     */   }
/*     */ 
/*     */   public static boolean hasText(String s)
/*     */   {
/*  78 */     if (isEmpty(s)) {
/*  79 */       return false;
/*     */     }
/*  81 */     int i = s.length();
/*  82 */     while (i > 0) {
/*  83 */       i--; if (s.charAt(i) > ' ') {
/*  84 */         return true;
/*     */       }
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isHexPrefix(String s, int index)
/*     */   {
/*  97 */     return (s.charAt(index) == '0') && (s.charAt(index + 1) == 'x');
/*     */   }
/*     */ 
/*     */   public static boolean isNumeric(String s)
/*     */   {
/* 111 */     int sz = length(s);
/* 112 */     if (sz == 0) {
/* 113 */       return false;
/*     */     }
/* 115 */     for (int i = 0; i < sz; i++) {
/* 116 */       if (!Character.isDigit(s.charAt(i))) {
/* 117 */         return false;
/*     */       }
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   public static String trim(String s)
/*     */   {
/* 131 */     return isEmpty(s) ? s : s.trim();
/*     */   }
/*     */ 
/*     */   public static String deleteWhitespace(String s)
/*     */   {
/* 143 */     if (isEmpty(s)) {
/* 144 */       return s;
/*     */     }
/* 146 */     int length = s.length();
/* 147 */     char[] chs = new char[length];
/* 148 */     int count = 0;
/* 149 */     for (int i = 0; i < length; i++) {
/* 150 */       char ch = s.charAt(i);
/* 151 */       if (!Character.isWhitespace(ch)) {
/* 152 */         chs[(count++)] = ch;
/*     */       }
/*     */     }
/* 155 */     if (count == length) {
/* 156 */       return s;
/*     */     }
/* 158 */     return new String(chs, 0, count);
/*     */   }
/*     */ 
/*     */   public static String deleteCharacter(String s, char ch)
/*     */   {
/* 170 */     int length = length(s);
/* 171 */     if (length == 0) {
/* 172 */       return s;
/*     */     }
/* 174 */     char[] chs = new char[length];
/* 175 */     int count = 0;
/* 176 */     for (int i = 0; i < length; i++) {
/* 177 */       char c = s.charAt(i);
/* 178 */       if (c != ch) {
/* 179 */         chs[(count++)] = c;
/*     */       }
/*     */     }
/* 182 */     if (count == length) {
/* 183 */       return s;
/*     */     }
/* 185 */     return new String(chs, 0, count);
/*     */   }
/*     */ 
/*     */   public static String capitalFirstLetter(String s)
/*     */   {
/* 195 */     int len = length(s);
/* 196 */     if (len == 0) {
/* 197 */       return s;
/*     */     }
/* 199 */     if (len == 1) {
/* 200 */       return String.valueOf(Character.toUpperCase(s.charAt(0)));
/*     */     }
/* 202 */     return Character.toUpperCase(s.charAt(0)) + s.substring(1);
/*     */   }
/*     */ 
/*     */   public static String leftPad(String s, int size)
/*     */   {
/* 216 */     return leftPad(s, size, ' ');
/*     */   }
/*     */ 
/*     */   public static String rightPad(String s, int size)
/*     */   {
/* 230 */     return rightPad(s, size, ' ');
/*     */   }
/*     */ 
/*     */   public static String leftPad(String s, int size, char padChar)
/*     */   {
/* 245 */     int length = length(s);
/* 246 */     if (length == 0) {
/* 247 */       return s;
/*     */     }
/* 249 */     int pads = size - length;
/* 250 */     if (pads <= 0) {
/* 251 */       return s;
/*     */     }
/* 253 */     return padding(pads, padChar).concat(s);
/*     */   }
/*     */ 
/*     */   public static String rightPad(String s, int size, char padChar)
/*     */   {
/* 268 */     int length = length(s);
/* 269 */     if (length == 0) {
/* 270 */       return s;
/*     */     }
/* 272 */     int pads = size - length;
/* 273 */     if (pads <= 0) {
/* 274 */       return s;
/*     */     }
/* 276 */     return s.concat(padding(pads, padChar));
/*     */   }
/*     */ 
/*     */   public static String abbr(String s, int len)
/*     */   {
/* 290 */     int length = length(s);
/* 291 */     if (length <= len) {
/* 292 */       return s;
/*     */     }
/* 294 */     return s.substring(0, len - 3) + "...";
/*     */   }
/*     */ 
/*     */   private static String padding(int repeat, char padChar) {
/* 298 */     if (repeat < 0) {
/* 299 */       throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
/*     */     }
/* 301 */     char[] buf = new char[repeat];
/* 302 */     for (int i = 0; i < buf.length; i++) {
/* 303 */       buf[i] = padChar;
/*     */     }
/* 305 */     return new String(buf);
/*     */   }
/*     */ 
/*     */   public static String left(String s, int len)
/*     */   {
/* 322 */     int length = length(s);
/* 323 */     if (length <= len) {
/* 324 */       return s;
/*     */     }
/* 326 */     return s.substring(0, len);
/*     */   }
/*     */ 
/*     */   public static String right(String s, int len)
/*     */   {
/* 341 */     int length = length(s);
/* 342 */     if (length <= len) {
/* 343 */       return s;
/*     */     }
/* 345 */     return s.substring(length - len);
/*     */   }
/*     */ 
/*     */   public static String mid(String s, int startIndex, int len)
/*     */   {
/* 360 */     int length = length(s);
/* 361 */     if ((length == 0) || (len < 0) || (startIndex > length)) {
/* 362 */       return s;
/*     */     }
/* 364 */     if (startIndex < 0) {
/* 365 */       startIndex = 0;
/*     */     }
/* 367 */     if (s.length() <= startIndex + len) {
/* 368 */       return s.substring(startIndex);
/*     */     }
/* 370 */     return s.substring(startIndex, startIndex + len);
/*     */   }
/*     */ 
/*     */   public static String substringBetween(String s, String open, String close)
/*     */   {
/* 387 */     if ((s == null) || (open == null) || (close == null)) {
/* 388 */       return null;
/*     */     }
/* 390 */     int start = s.indexOf(open);
/* 391 */     if (start != -1) {
/* 392 */       int end = s.indexOf(close, start + open.length());
/* 393 */       if (end != -1) {
/* 394 */         return s.substring(start + open.length(), end);
/*     */       }
/*     */     }
/* 397 */     return null;
/*     */   }
/*     */ 
/*     */   public static String[] toArray(String commaDelim)
/*     */   {
/* 411 */     if (isEmpty(commaDelim)) {
/* 412 */       return new String[0];
/*     */     }
/* 414 */     List list = toList(commaDelim);
/* 415 */     return (String[])list.toArray(new String[list.size()]);
/*     */   }
/*     */ 
/*     */   public static String[] toArray(String commaDelim, String separator)
/*     */   {
/* 427 */     if (isEmpty(commaDelim)) {
/* 428 */       return new String[0];
/*     */     }
/* 430 */     List list = toList(commaDelim, separator);
/* 431 */     return (String[])list.toArray(new String[list.size()]);
/*     */   }
/*     */ 
/*     */   public static String[] toArray(String commaDelim, char separator)
/*     */   {
/* 443 */     if (isEmpty(commaDelim)) {
/* 444 */       return new String[0];
/*     */     }
/* 446 */     List list = toList(commaDelim, separator);
/* 447 */     return (String[])list.toArray(new String[list.size()]);
/*     */   }
/*     */ 
/*     */   public static List<String> toList(String commaDelim)
/*     */   {
/* 457 */     return toList(commaDelim, ',');
/*     */   }
/*     */ 
/*     */   public static List<String> toList(String commaDelim, String separator)
/*     */   {
/* 465 */     int len = length(commaDelim);
/* 466 */     if (len == 0) {
/* 467 */       return Collections.emptyList();
/*     */     }
/* 469 */     List list = new ArrayList();
/* 470 */     parseCollection(list, commaDelim, separator);
/* 471 */     return list;
/*     */   }
/*     */ 
/*     */   public static List<String> toList(String commaDelim, char separator)
/*     */   {
/* 479 */     int len = length(commaDelim);
/* 480 */     if (len == 0) {
/* 481 */       return Collections.emptyList();
/*     */     }
/* 483 */     List list = new ArrayList();
/* 484 */     parseCollection(list, commaDelim, separator);
/* 485 */     return list;
/*     */   }
/*     */ 
/*     */   public static Set<String> toSet(String commaDelim)
/*     */   {
/* 495 */     return toSet(commaDelim, ',');
/*     */   }
/*     */ 
/*     */   public static Set<String> toSet(String commaDelim, String separator)
/*     */   {
/* 506 */     int len = length(commaDelim);
/* 507 */     if (len == 0) {
/* 508 */       return Collections.emptySet();
/*     */     }
/* 510 */     Set set = new LinkedHashSet();
/* 511 */     parseCollection(set, commaDelim, separator);
/* 512 */     return set;
/*     */   }
/*     */ 
/*     */   public static Set<String> toSet(String commaDelim, char separator)
/*     */   {
/* 522 */     int len = length(commaDelim);
/* 523 */     if (len == 0) {
/* 524 */       return Collections.emptySet();
/*     */     }
/* 526 */     Set set = new LinkedHashSet();
/* 527 */     parseCollection(set, commaDelim, separator);
/* 528 */     return set;
/*     */   }
/*     */ 
/*     */   private static void parseCollection(Collection<String> collection, String commaDelim, String separator) {
/* 532 */     int len = length(commaDelim);
/* 533 */     if (len == 0) return;
/* 534 */     String s = null;
/* 535 */     if ((commaDelim.charAt(0) == '[') && (commaDelim.charAt(len - 1) == ']'))
/* 536 */       s = commaDelim.substring(1, len - 1);
/*     */     else {
/* 538 */       s = commaDelim;
/*     */     }
/* 540 */     StringTokenizer token = new StringTokenizer(s, separator);
/* 541 */     while (token.hasMoreTokens()) {
/* 542 */       String item = token.nextToken();
/* 543 */       String trimmed = item.trim();
/* 544 */       collection.add(trimmed);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void parseCollection(Collection<String> collection, String commaDelim, char separator) {
/* 549 */     int len = length(commaDelim);
/* 550 */     if (len == 0) return;
/* 551 */     String s = null;
/* 552 */     if ((commaDelim.charAt(0) == '[') && (commaDelim.charAt(len - 1) == ']')) {
/* 553 */       s = commaDelim.substring(1, len - 1);
/* 554 */       len = s.length();
/*     */     } else {
/* 556 */       s = commaDelim;
/*     */     }
/* 558 */     int index = 0; int start = 0;
/* 559 */     while (index < len) {
/* 560 */       char ch = s.charAt(index);
/* 561 */       if (ch == separator) {
/* 562 */         String block = s.substring(start, index);
/* 563 */         start = index + 1;
/* 564 */         collection.add(block.trim());
/*     */       }
/* 566 */       index++;
/*     */     }
/*     */ 
/* 569 */     if (start < index) {
/* 570 */       String block = s.substring(start, index);
/* 571 */       collection.add(block.trim());
/* 572 */     } else if (start == index) {
/* 573 */       collection.add("");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static Map<String, String> toMap(String commaDelim)
/*     */   {
/* 586 */     if ((commaDelim == null) || (commaDelim.trim().length() == 0)) {
/* 587 */       return Collections.emptyMap();
/*     */     }
/* 589 */     String s = null;
/* 590 */     int len = commaDelim.length();
/* 591 */     if ((commaDelim.charAt(0) == '{') && (commaDelim.charAt(len - 1) == '}'))
/* 592 */       s = commaDelim.substring(1, len - 1);
/*     */     else {
/* 594 */       s = commaDelim;
/*     */     }
/* 596 */     Map map = new LinkedHashMap();
/* 597 */     StringTokenizer token = new StringTokenizer(s, ",");
/* 598 */     while (token.hasMoreTokens()) {
/* 599 */       String item = token.nextToken();
/* 600 */       int index = item.indexOf(':');
/* 601 */       if (index <= 0) {
/* 602 */         index = item.indexOf('=');
/*     */       }
/* 604 */       if (index <= 0) {
/*     */         continue;
/*     */       }
/* 607 */       String key = item.substring(0, index).trim();
/* 608 */       String val = item.substring(index + 1).trim();
/* 609 */       map.put(key, val);
/*     */     }
/* 611 */     return map;
/*     */   }
/*     */ 
/*     */   public static String toString(Object[] array)
/*     */   {
/* 623 */     return toString(array, true);
/*     */   }
/*     */ 
/*     */   public static String toString(Object[] array, boolean includeBound) {
/* 627 */     return toString(array, ",", 0, CollectionUtils.length(array), includeBound);
/*     */   }
/*     */ 
/*     */   public static String toString(Object[] array, String separator, int startIndex, int endIndex, boolean includeBound)
/*     */   {
/* 639 */     int length = CollectionUtils.length(array);
/* 640 */     if (length == 0) {
/* 641 */       return "";
/*     */     }
/* 643 */     int start = startIndex >= 0 ? Math.min(startIndex, length - 1) : 0;
/* 644 */     int end = endIndex >= 0 ? Math.min(endIndex, length) : 0;
/*     */ 
/* 646 */     int bufferSize = end - start;
/* 647 */     bufferSize *= ((array[start] == null ? 16 : array[start].toString().length()) + separator.length());
/* 648 */     StringBuilder sb = new StringBuilder(bufferSize + 2);
/* 649 */     if (includeBound) sb.append('[');
/* 650 */     for (int i = start; i < end; i++) {
/* 651 */       if (i != start) {
/* 652 */         sb.append(separator);
/*     */       }
/* 654 */       sb.append(array[i]);
/*     */     }
/* 656 */     if (includeBound) sb.append(']');
/* 657 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String toString(Collection collection)
/*     */   {
/* 666 */     return toString(collection, ",", true);
/*     */   }
/*     */ 
/*     */   public static String toString(Collection collection, boolean includeBound)
/*     */   {
/* 675 */     return toString(collection, ",", includeBound);
/*     */   }
/*     */ 
/*     */   public static String toString(Collection collection, String separator, boolean includeBound)
/*     */   {
/* 685 */     int length = CollectionUtils.length(collection);
/* 686 */     if (length == 0) {
/* 687 */       return "";
/*     */     }
/* 689 */     int bufferSize = length * (16 + separator.length());
/* 690 */     StringBuilder sb = new StringBuilder(bufferSize + 2);
/* 691 */     if (includeBound) sb.append('[');
/* 692 */     Iterator iter = collection.iterator();
/* 693 */     for (boolean hasNext = iter.hasNext(); hasNext; ) {
/* 694 */       Object element = iter.next();
/* 695 */       sb.append(element);
/* 696 */       hasNext = iter.hasNext();
/* 697 */       if (hasNext) {
/* 698 */         sb.append(separator);
/*     */       }
/*     */     }
/* 701 */     if (includeBound) sb.append(']');
/* 702 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String toString(Map map)
/*     */   {
/* 711 */     return toString(map, ",", ":", true);
/*     */   }
/*     */ 
/*     */   public static String toString(Map map, boolean includeBound) {
/* 715 */     return toString(map, ",", ":", includeBound);
/*     */   }
/*     */ 
/*     */   public static String toString(Map map, String separator, String equalSymbol, boolean includeBound)
/*     */   {
/* 726 */     int length = CollectionUtils.length(map);
/* 727 */     if (length == 0) {
/* 728 */       return "";
/*     */     }
/* 730 */     int bufferSize = length * (16 + separator.length() + equalSymbol.length());
/* 731 */     StringBuffer sb = new StringBuffer(bufferSize + 2);
/* 732 */     if (includeBound) sb.append('{');
/* 733 */     Iterator iter = map.entrySet().iterator();
/* 734 */     for (boolean hasNext = iter.hasNext(); hasNext; ) {
/* 735 */       Map.Entry entry = (Map.Entry)iter.next();
/* 736 */       sb.append(entry.getKey()).append(equalSymbol).append(toString(entry.getValue()));
/* 737 */       hasNext = iter.hasNext();
/* 738 */       if (hasNext) {
/* 739 */         sb.append(separator);
/*     */       }
/*     */     }
/* 742 */     if (includeBound) sb.append('}');
/* 743 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String toString(Object obj) {
/* 747 */     if (obj == null) {
/* 748 */       return "null";
/*     */     }
/* 750 */     if ((obj instanceof Date)) {
/* 751 */       SimpleDateFormat rfc3399 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
/* 752 */       return rfc3399.format((Date)obj);
/*     */     }
/* 754 */     if ((obj.getClass().isPrimitive()) || (obj.getClass().getName().startsWith("java"))) {
/* 755 */       return String.valueOf(obj);
/*     */     }
/* 757 */     if ((obj instanceof Collection)) {
/* 758 */       return toString((Collection)obj);
/*     */     }
/* 760 */     if ((obj instanceof Object[])) {
/* 761 */       return toString((Object[])obj);
/*     */     }
/* 763 */     if ((obj instanceof Map)) {
/* 764 */       return toString((Map)obj);
/*     */     }
/*     */ 
/* 767 */     return obj.toString();
/*     */   }
/*     */ 
/*     */   public static String toObjectString(Object obj)
/*     */   {
/* 777 */     return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
/*     */   }
/*     */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.StringUtils
 * JD-Core Version:    0.6.0
 */