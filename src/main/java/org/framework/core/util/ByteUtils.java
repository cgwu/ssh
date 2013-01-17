/*     */ package org.framework.core.util;
/*     */ 
/*     */ public abstract class ByteUtils
/*     */ {
/*     */   public static boolean toBoolean(byte[] b)
/*     */   {
/*  26 */     return toBoolean(b, 0);
/*     */   }
/*     */ 
/*     */   public static boolean toBoolean(byte[] b, int off) {
/*  30 */     return b[off] != 0;
/*     */   }
/*     */ 
/*     */   public static char toChar(byte[] b) {
/*  34 */     return toChar(b, 0);
/*     */   }
/*     */ 
/*     */   public static char toChar(byte[] b, int off) {
/*  38 */     return (char)(((b[(off + 1)] & 0xFF) << 0) + (
/*  39 */       (b[(off + 0)] & 0xFF) << 8));
/*     */   }
/*     */ 
/*     */   public static short toShort(byte[] b) {
/*  43 */     return toShort(b, 0);
/*     */   }
/*     */ 
/*     */   public static short toShort(byte[] b, int off) {
/*  47 */     return (short)(((b[(off + 1)] & 0xFF) << 0) + (
/*  48 */       (b[(off + 0)] & 0xFF) << 8));
/*     */   }
/*     */ 
/*     */   public static int toInt(byte[] b) {
/*  52 */     return toInt(b, 0);
/*     */   }
/*     */ 
/*     */   public static int toInt(byte[] b, int off) {
/*  56 */     return ((b[(off + 3)] & 0xFF) << 0) + (
/*  57 */       (b[(off + 2)] & 0xFF) << 8) + (
/*  58 */       (b[(off + 1)] & 0xFF) << 16) + (
/*  59 */       (b[(off + 0)] & 0xFF) << 24);
/*     */   }
/*     */ 
/*     */   public static float toFloat(byte[] b) {
/*  63 */     return toFloat(b, 0);
/*     */   }
/*     */ 
/*     */   public static float toFloat(byte[] b, int off) {
/*  67 */     int i = ((b[(off + 3)] & 0xFF) << 0) + (
/*  68 */       (b[(off + 2)] & 0xFF) << 8) + (
/*  69 */       (b[(off + 1)] & 0xFF) << 16) + (
/*  70 */       (b[(off + 0)] & 0xFF) << 24);
/*  71 */     return Float.intBitsToFloat(i);
/*     */   }
/*     */ 
/*     */   public static long toLong(byte[] b) {
/*  75 */     return toLong(b, 0);
/*     */   }
/*     */ 
/*     */   public static long toLong(byte[] b, int off) {
/*  79 */     return ((b[(off + 7)] & 0xFF) << 0) + (
/*  80 */       (b[(off + 6)] & 0xFF) << 8) + (
/*  81 */       (b[(off + 5)] & 0xFF) << 16) + (
/*  82 */       (b[(off + 4)] & 0xFF) << 24) + (
/*  83 */       (b[(off + 3)] & 0xFF) << 32) + (
/*  84 */       (b[(off + 2)] & 0xFF) << 40) + (
/*  85 */       (b[(off + 1)] & 0xFF) << 48) + (
/*  86 */       (b[(off + 0)] & 0xFF) << 56);
/*     */   }
/*     */ 
/*     */   public static double toDouble(byte[] b) {
/*  90 */     return toDouble(b, 0);
/*     */   }
/*     */ 
/*     */   public static double toDouble(byte[] b, int off) {
/*  94 */     long j = ((b[(off + 7)] & 0xFF) << 0) + (
/*  95 */       (b[(off + 6)] & 0xFF) << 8) + (
/*  96 */       (b[(off + 5)] & 0xFF) << 16) + (
/*  97 */       (b[(off + 4)] & 0xFF) << 24) + (
/*  98 */       (b[(off + 3)] & 0xFF) << 32) + (
/*  99 */       (b[(off + 2)] & 0xFF) << 40) + (
/* 100 */       (b[(off + 1)] & 0xFF) << 48) + (
/* 101 */       (b[(off + 0)] & 0xFF) << 56);
/* 102 */     return Double.longBitsToDouble(j);
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(boolean val) {
/* 106 */     byte[] b = new byte[1];
/* 107 */     b[0] = (byte)(val ? 1 : 0);
/* 108 */     return b;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(char val) {
/* 112 */     byte[] b = new byte[2];
/* 113 */     b[1] = (byte)(val >>> '\000');
/* 114 */     b[0] = (byte)(val >>> '\b');
/* 115 */     return b;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(short val) {
/* 119 */     byte[] b = new byte[2];
/* 120 */     b[1] = (byte)(val >>> 0);
/* 121 */     b[0] = (byte)(val >>> 8);
/* 122 */     return b;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(int val) {
/* 126 */     byte[] b = new byte[4];
/* 127 */     b[3] = (byte)(val >>> 0);
/* 128 */     b[2] = (byte)(val >>> 8);
/* 129 */     b[1] = (byte)(val >>> 16);
/* 130 */     b[0] = (byte)(val >>> 24);
/* 131 */     return b;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(float val) {
/* 135 */     int i = Float.floatToIntBits(val);
/* 136 */     byte[] b = new byte[4];
/* 137 */     b[3] = (byte)(i >>> 0);
/* 138 */     b[2] = (byte)(i >>> 8);
/* 139 */     b[1] = (byte)(i >>> 16);
/* 140 */     b[0] = (byte)(i >>> 24);
/* 141 */     return b;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(long val) {
/* 145 */     byte[] b = new byte[8];
/* 146 */     b[7] = (byte)(int)(val >>> 0);
/* 147 */     b[6] = (byte)(int)(val >>> 8);
/* 148 */     b[5] = (byte)(int)(val >>> 16);
/* 149 */     b[4] = (byte)(int)(val >>> 24);
/* 150 */     b[3] = (byte)(int)(val >>> 32);
/* 151 */     b[2] = (byte)(int)(val >>> 40);
/* 152 */     b[1] = (byte)(int)(val >>> 48);
/* 153 */     b[0] = (byte)(int)(val >>> 56);
/* 154 */     return b;
/*     */   }
/*     */ 
/*     */   public static byte[] getBytes(double val) {
/* 158 */     long j = Double.doubleToLongBits(val);
/* 159 */     byte[] b = new byte[8];
/* 160 */     b[7] = (byte)(int)(j >>> 0);
/* 161 */     b[6] = (byte)(int)(j >>> 8);
/* 162 */     b[5] = (byte)(int)(j >>> 16);
/* 163 */     b[4] = (byte)(int)(j >>> 24);
/* 164 */     b[3] = (byte)(int)(j >>> 32);
/* 165 */     b[2] = (byte)(int)(j >>> 40);
/* 166 */     b[1] = (byte)(int)(j >>> 48);
/* 167 */     b[0] = (byte)(int)(j >>> 56);
/* 168 */     return b;
/*     */   }
/*     */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.ByteUtils
 * JD-Core Version:    0.6.0
 */