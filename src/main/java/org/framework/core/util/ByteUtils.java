 package org.framework.core.util;
 
 public abstract class ByteUtils
 {
   public static boolean toBoolean(byte[] b)
   {
     return toBoolean(b, 0);
   }
 
   public static boolean toBoolean(byte[] b, int off) {
     return b[off] != 0;
   }
 
   public static char toChar(byte[] b) {
     return toChar(b, 0);
   }
 
   public static char toChar(byte[] b, int off) {
     return (char)(((b[(off + 1)] & 0xFF) << 0) + (
       (b[(off + 0)] & 0xFF) << 8));
   }
 
   public static short toShort(byte[] b) {
     return toShort(b, 0);
   }
 
   public static short toShort(byte[] b, int off) {
     return (short)(((b[(off + 1)] & 0xFF) << 0) + (
       (b[(off + 0)] & 0xFF) << 8));
   }
 
   public static int toInt(byte[] b) {
     return toInt(b, 0);
   }
 
   public static int toInt(byte[] b, int off) {
     return ((b[(off + 3)] & 0xFF) << 0) + (
       (b[(off + 2)] & 0xFF) << 8) + (
       (b[(off + 1)] & 0xFF) << 16) + (
       (b[(off + 0)] & 0xFF) << 24);
   }
 
   public static float toFloat(byte[] b) {
     return toFloat(b, 0);
   }
 
   public static float toFloat(byte[] b, int off) {
     int i = ((b[(off + 3)] & 0xFF) << 0) + (
       (b[(off + 2)] & 0xFF) << 8) + (
       (b[(off + 1)] & 0xFF) << 16) + (
       (b[(off + 0)] & 0xFF) << 24);
     return Float.intBitsToFloat(i);
   }
 
   public static long toLong(byte[] b) {
     return toLong(b, 0);
   }
 
   public static long toLong(byte[] b, int off) {
     return ((b[(off + 7)] & 0xFF) << 0) + (
       (b[(off + 6)] & 0xFF) << 8) + (
       (b[(off + 5)] & 0xFF) << 16) + (
       (b[(off + 4)] & 0xFF) << 24) + (
       (b[(off + 3)] & 0xFF) << 32) + (
       (b[(off + 2)] & 0xFF) << 40) + (
       (b[(off + 1)] & 0xFF) << 48) + (
       (b[(off + 0)] & 0xFF) << 56);
   }
 
   public static double toDouble(byte[] b) {
     return toDouble(b, 0);
   }
 
   public static double toDouble(byte[] b, int off) {
     long j = ((b[(off + 7)] & 0xFF) << 0) + (
       (b[(off + 6)] & 0xFF) << 8) + (
       (b[(off + 5)] & 0xFF) << 16) + (
       (b[(off + 4)] & 0xFF) << 24) + (
       (b[(off + 3)] & 0xFF) << 32) + (
       (b[(off + 2)] & 0xFF) << 40) + (
       (b[(off + 1)] & 0xFF) << 48) + (
       (b[(off + 0)] & 0xFF) << 56);
     return Double.longBitsToDouble(j);
   }
 
   public static byte[] getBytes(boolean val) {
     byte[] b = new byte[1];
     b[0] = (byte)(val ? 1 : 0);
     return b;
   }
 
   public static byte[] getBytes(char val) {
     byte[] b = new byte[2];
     b[1] = (byte)(val >>> '\000');
     b[0] = (byte)(val >>> '\b');
     return b;
   }
 
   public static byte[] getBytes(short val) {
     byte[] b = new byte[2];
     b[1] = (byte)(val >>> 0);
     b[0] = (byte)(val >>> 8);
     return b;
   }
 
   public static byte[] getBytes(int val) {
     byte[] b = new byte[4];
     b[3] = (byte)(val >>> 0);
     b[2] = (byte)(val >>> 8);
     b[1] = (byte)(val >>> 16);
     b[0] = (byte)(val >>> 24);
     return b;
   }
 
   public static byte[] getBytes(float val) {
     int i = Float.floatToIntBits(val);
     byte[] b = new byte[4];
     b[3] = (byte)(i >>> 0);
     b[2] = (byte)(i >>> 8);
     b[1] = (byte)(i >>> 16);
     b[0] = (byte)(i >>> 24);
     return b;
   }
 
   public static byte[] getBytes(long val) {
     byte[] b = new byte[8];
     b[7] = (byte)(int)(val >>> 0);
     b[6] = (byte)(int)(val >>> 8);
     b[5] = (byte)(int)(val >>> 16);
     b[4] = (byte)(int)(val >>> 24);
     b[3] = (byte)(int)(val >>> 32);
     b[2] = (byte)(int)(val >>> 40);
     b[1] = (byte)(int)(val >>> 48);
     b[0] = (byte)(int)(val >>> 56);
     return b;
   }
 
   public static byte[] getBytes(double val) {
     long j = Double.doubleToLongBits(val);
     byte[] b = new byte[8];
     b[7] = (byte)(int)(j >>> 0);
     b[6] = (byte)(int)(j >>> 8);
     b[5] = (byte)(int)(j >>> 16);
     b[4] = (byte)(int)(j >>> 24);
     b[3] = (byte)(int)(j >>> 32);
     b[2] = (byte)(int)(j >>> 40);
     b[1] = (byte)(int)(j >>> 48);
     b[0] = (byte)(int)(j >>> 56);
     return b;
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.ByteUtils
 * JD-Core Version:    0.6.0
 */