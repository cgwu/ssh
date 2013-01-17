 package org.framework.core.util;
 
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.Collections;
 import java.util.Date;
 import java.util.Iterator;
 import java.util.LinkedHashMap;
 import java.util.LinkedHashSet;
 import java.util.List;
 import java.util.Map;
 import java.util.Map.Entry;
 import java.util.Set;
 import java.util.StringTokenizer;
 
 public abstract class StringUtils
 {
   public static final String EMPTY_STRING = "";
   public static final int INDEX_NOT_FOUND = -1;
   public static final char DEFAULT_SEPARATOR = ',';
   public static final String DEFAULT_SEPARATOR_STRING = ",";
   public static final char MAP_KEY_SEPARATOR = ':';
   public static final char MAP_KEY_SEPARATOR2 = '=';
   public static final String MAP_KEY_SEPARATOR_STRING = ":";
   public static final char ARRAY_BOUND_START = '[';
   public static final char ARRAY_BOUND_END = ']';
   public static final char MAP_BOUND_START = '{';
   public static final char MAP_BOUND_END = '}';
 
   public static boolean isEmpty(String s)
   {
     return length(s) == 0;
   }
 
   public static boolean notEmpty(String s)
   {
     return length(s) > 0;
   }
 
   public static int length(String s) {
     return s != null ? s.length() : 0;
   }
 
   public static boolean hasText(String s)
   {
     if (isEmpty(s)) {
       return false;
     }
     int i = s.length();
     while (i > 0) {
       i--; if (s.charAt(i) > ' ') {
         return true;
       }
     }
     return false;
   }
 
   public static boolean isHexPrefix(String s, int index)
   {
     return (s.charAt(index) == '0') && (s.charAt(index + 1) == 'x');
   }
 
   public static boolean isNumeric(String s)
   {
     int sz = length(s);
     if (sz == 0) {
       return false;
     }
     for (int i = 0; i < sz; i++) {
       if (!Character.isDigit(s.charAt(i))) {
         return false;
       }
     }
     return true;
   }
 
   public static String trim(String s)
   {
     return isEmpty(s) ? s : s.trim();
   }
 
   public static String deleteWhitespace(String s)
   {
     if (isEmpty(s)) {
       return s;
     }
     int length = s.length();
     char[] chs = new char[length];
     int count = 0;
     for (int i = 0; i < length; i++) {
       char ch = s.charAt(i);
       if (!Character.isWhitespace(ch)) {
         chs[(count++)] = ch;
       }
     }
     if (count == length) {
       return s;
     }
     return new String(chs, 0, count);
   }
 
   public static String deleteCharacter(String s, char ch)
   {
     int length = length(s);
     if (length == 0) {
       return s;
     }
     char[] chs = new char[length];
     int count = 0;
     for (int i = 0; i < length; i++) {
       char c = s.charAt(i);
       if (c != ch) {
         chs[(count++)] = c;
       }
     }
     if (count == length) {
       return s;
     }
     return new String(chs, 0, count);
   }
 
   public static String capitalFirstLetter(String s)
   {
     int len = length(s);
     if (len == 0) {
       return s;
     }
     if (len == 1) {
       return String.valueOf(Character.toUpperCase(s.charAt(0)));
     }
     return Character.toUpperCase(s.charAt(0)) + s.substring(1);
   }
 
   public static String leftPad(String s, int size)
   {
     return leftPad(s, size, ' ');
   }
 
   public static String rightPad(String s, int size)
   {
     return rightPad(s, size, ' ');
   }
 
   public static String leftPad(String s, int size, char padChar)
   {
     int length = length(s);
     if (length == 0) {
       return s;
     }
     int pads = size - length;
     if (pads <= 0) {
       return s;
     }
     return padding(pads, padChar).concat(s);
   }
 
   public static String rightPad(String s, int size, char padChar)
   {
     int length = length(s);
     if (length == 0) {
       return s;
     }
     int pads = size - length;
     if (pads <= 0) {
       return s;
     }
     return s.concat(padding(pads, padChar));
   }
 
   public static String abbr(String s, int len)
   {
     int length = length(s);
     if (length <= len) {
       return s;
     }
     return s.substring(0, len - 3) + "...";
   }
 
   private static String padding(int repeat, char padChar) {
     if (repeat < 0) {
       throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
     }
     char[] buf = new char[repeat];
     for (int i = 0; i < buf.length; i++) {
       buf[i] = padChar;
     }
     return new String(buf);
   }
 
   public static String left(String s, int len)
   {
     int length = length(s);
     if (length <= len) {
       return s;
     }
     return s.substring(0, len);
   }
 
   public static String right(String s, int len)
   {
     int length = length(s);
     if (length <= len) {
       return s;
     }
     return s.substring(length - len);
   }
 
   public static String mid(String s, int startIndex, int len)
   {
     int length = length(s);
     if ((length == 0) || (len < 0) || (startIndex > length)) {
       return s;
     }
     if (startIndex < 0) {
       startIndex = 0;
     }
     if (s.length() <= startIndex + len) {
       return s.substring(startIndex);
     }
     return s.substring(startIndex, startIndex + len);
   }
 
   public static String substringBetween(String s, String open, String close)
   {
     if ((s == null) || (open == null) || (close == null)) {
       return null;
     }
     int start = s.indexOf(open);
     if (start != -1) {
       int end = s.indexOf(close, start + open.length());
       if (end != -1) {
         return s.substring(start + open.length(), end);
       }
     }
     return null;
   }
 
   public static String[] toArray(String commaDelim)
   {
     if (isEmpty(commaDelim)) {
       return new String[0];
     }
     List list = toList(commaDelim);
     return (String[])list.toArray(new String[list.size()]);
   }
 
   public static String[] toArray(String commaDelim, String separator)
   {
     if (isEmpty(commaDelim)) {
       return new String[0];
     }
     List list = toList(commaDelim, separator);
     return (String[])list.toArray(new String[list.size()]);
   }
 
   public static String[] toArray(String commaDelim, char separator)
   {
     if (isEmpty(commaDelim)) {
       return new String[0];
     }
     List list = toList(commaDelim, separator);
     return (String[])list.toArray(new String[list.size()]);
   }
 
   public static List<String> toList(String commaDelim)
   {
     return toList(commaDelim, ',');
   }
 
   public static List<String> toList(String commaDelim, String separator)
   {
     int len = length(commaDelim);
     if (len == 0) {
       return Collections.emptyList();
     }
     List list = new ArrayList();
     parseCollection(list, commaDelim, separator);
     return list;
   }
 
   public static List<String> toList(String commaDelim, char separator)
   {
     int len = length(commaDelim);
     if (len == 0) {
       return Collections.emptyList();
     }
     List list = new ArrayList();
     parseCollection(list, commaDelim, separator);
     return list;
   }
 
   public static Set<String> toSet(String commaDelim)
   {
     return toSet(commaDelim, ',');
   }
 
   public static Set<String> toSet(String commaDelim, String separator)
   {
     int len = length(commaDelim);
     if (len == 0) {
       return Collections.emptySet();
     }
     Set set = new LinkedHashSet();
     parseCollection(set, commaDelim, separator);
     return set;
   }
 
   public static Set<String> toSet(String commaDelim, char separator)
   {
     int len = length(commaDelim);
     if (len == 0) {
       return Collections.emptySet();
     }
     Set set = new LinkedHashSet();
     parseCollection(set, commaDelim, separator);
     return set;
   }
 
   private static void parseCollection(Collection<String> collection, String commaDelim, String separator) {
     int len = length(commaDelim);
     if (len == 0) return;
     String s = null;
     if ((commaDelim.charAt(0) == '[') && (commaDelim.charAt(len - 1) == ']'))
       s = commaDelim.substring(1, len - 1);
     else {
       s = commaDelim;
     }
     StringTokenizer token = new StringTokenizer(s, separator);
     while (token.hasMoreTokens()) {
       String item = token.nextToken();
       String trimmed = item.trim();
       collection.add(trimmed);
     }
   }
 
   private static void parseCollection(Collection<String> collection, String commaDelim, char separator) {
     int len = length(commaDelim);
     if (len == 0) return;
     String s = null;
     if ((commaDelim.charAt(0) == '[') && (commaDelim.charAt(len - 1) == ']')) {
       s = commaDelim.substring(1, len - 1);
       len = s.length();
     } else {
       s = commaDelim;
     }
     int index = 0; int start = 0;
     while (index < len) {
       char ch = s.charAt(index);
       if (ch == separator) {
         String block = s.substring(start, index);
         start = index + 1;
         collection.add(block.trim());
       }
       index++;
     }
 
     if (start < index) {
       String block = s.substring(start, index);
       collection.add(block.trim());
     } else if (start == index) {
       collection.add("");
     }
   }
 
   public static Map<String, String> toMap(String commaDelim)
   {
     if ((commaDelim == null) || (commaDelim.trim().length() == 0)) {
       return Collections.emptyMap();
     }
     String s = null;
     int len = commaDelim.length();
     if ((commaDelim.charAt(0) == '{') && (commaDelim.charAt(len - 1) == '}'))
       s = commaDelim.substring(1, len - 1);
     else {
       s = commaDelim;
     }
     Map map = new LinkedHashMap();
     StringTokenizer token = new StringTokenizer(s, ",");
     while (token.hasMoreTokens()) {
       String item = token.nextToken();
       int index = item.indexOf(':');
       if (index <= 0) {
         index = item.indexOf('=');
       }
       if (index <= 0) {
         continue;
       }
       String key = item.substring(0, index).trim();
       String val = item.substring(index + 1).trim();
       map.put(key, val);
     }
     return map;
   }
   /*
   public static String toString(Object[] array)
   {
     return toString(array, true);
   }
 
   public static String toString(Object[] array, boolean includeBound) {
     return toString(array, ",", 0, CollectionUtils.length(array), includeBound);
   }
 
   public static String toString(Object[] array, String separator, int startIndex, int endIndex, boolean includeBound)
   {
     int length = CollectionUtils.length(array);
     if (length == 0) {
       return "";
     }
     int start = startIndex >= 0 ? Math.min(startIndex, length - 1) : 0;
     int end = endIndex >= 0 ? Math.min(endIndex, length) : 0;
 
     int bufferSize = end - start;
     bufferSize *= ((array[start] == null ? 16 : array[start].toString().length()) + separator.length());
     StringBuilder sb = new StringBuilder(bufferSize + 2);
     if (includeBound) sb.append('[');
     for (int i = start; i < end; i++) {
       if (i != start) {
         sb.append(separator);
       }
       sb.append(array[i]);
     }
     if (includeBound) sb.append(']');
     return sb.toString();
   }
 
   public static String toString(Collection collection)
   {
     return toString(collection, ",", true);
   }
 
   public static String toString(Collection collection, boolean includeBound)
   {
     return toString(collection, ",", includeBound);
   }
 
   public static String toString(Collection collection, String separator, boolean includeBound)
   {
     int length = CollectionUtils.length(collection);
     if (length == 0) {
       return "";
     }
     int bufferSize = length * (16 + separator.length());
     StringBuilder sb = new StringBuilder(bufferSize + 2);
     if (includeBound) sb.append('[');
     Iterator iter = collection.iterator();
     for (boolean hasNext = iter.hasNext(); hasNext; ) {
       Object element = iter.next();
       sb.append(element);
       hasNext = iter.hasNext();
       if (hasNext) {
         sb.append(separator);
       }
     }
     if (includeBound) sb.append(']');
     return sb.toString();
   }
 
   public static String toString(Map map)
   {
     return toString(map, ",", ":", true);
   }
 
   public static String toString(Map map, boolean includeBound) {
     return toString(map, ",", ":", includeBound);
   }
 
   public static String toString(Map map, String separator, String equalSymbol, boolean includeBound)
   {
     int length = CollectionUtils.length(map);
     if (length == 0) {
       return "";
     }
     int bufferSize = length * (16 + separator.length() + equalSymbol.length());
     StringBuffer sb = new StringBuffer(bufferSize + 2);
     if (includeBound) sb.append('{');
     Iterator iter = map.entrySet().iterator();
     for (boolean hasNext = iter.hasNext(); hasNext; ) {
       Map.Entry entry = (Map.Entry)iter.next();
       sb.append(entry.getKey()).append(equalSymbol).append(toString(entry.getValue()));
       hasNext = iter.hasNext();
       if (hasNext) {
         sb.append(separator);
       }
     }
     if (includeBound) sb.append('}');
     return sb.toString();
   }
 */
   public static String toString(Object obj) {
     if (obj == null) {
       return "null";
     }
     if ((obj instanceof Date)) {
       SimpleDateFormat rfc3399 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
       return rfc3399.format((Date)obj);
     }
     if ((obj.getClass().isPrimitive()) || (obj.getClass().getName().startsWith("java"))) {
       return String.valueOf(obj);
     }
     if ((obj instanceof Collection)) {
       return toString((Collection)obj);
     }
     if ((obj instanceof Object[])) {
       return toString((Object[])obj);
     }
     if ((obj instanceof Map)) {
       return toString((Map)obj);
     }
 
     return obj.toString();
   }
 
   public static String toObjectString(Object obj)
   {
     return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.StringUtils
 * JD-Core Version:    0.6.0
 */