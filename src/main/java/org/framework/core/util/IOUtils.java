/*    */ package org.framework.core.util;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.util.zip.GZIPInputStream;
/*    */ import java.util.zip.GZIPOutputStream;
/*    */ 
/*    */ public abstract class IOUtils
/*    */ {
/*    */   private static final int DEFAULT_BUFFER_SIZE = 4096;
/*    */ 
/*    */   public static byte[] gzip(byte[] bytes)
/*    */     throws IOException
/*    */   {
/* 35 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 36 */     GZIPOutputStream gzip = new GZIPOutputStream(out);
/* 37 */     gzip.write(bytes);
/* 38 */     gzip.finish();
/* 39 */     gzip.close();
/*    */ 
/* 41 */     return out.toByteArray();
/*    */   }
/*    */ 
/*    */   public static void ungzip(InputStream in, OutputStream out) throws IOException {
/* 45 */     GZIPOutputStream gzip = new GZIPOutputStream(out);
/* 46 */     copy(in, gzip);
/*    */   }
/*    */ 
/*    */   public static byte[] decompress(byte[] bytes) throws IOException {
/* 50 */     GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(bytes));
/*    */ 
/* 52 */     ByteArrayOutputStream out = new ByteArrayOutputStream();
/* 53 */     copy(gzip, out);
/* 54 */     gzip.close();
/* 55 */     out.close();
/*    */ 
/* 57 */     return out.toByteArray();
/*    */   }
/*    */ 
/*    */   public static void decompress(InputStream in, OutputStream out) throws IOException {
/* 61 */     GZIPInputStream gzip = new GZIPInputStream(in);
/* 62 */     copy(gzip, out);
/*    */   }
/*    */ 
/*    */   public static long copy(InputStream input, OutputStream output) throws IOException {
/* 66 */     byte[] buffer = new byte[4096];
/* 67 */     long count = 0L;
/* 68 */     int n = 0;
/* 69 */     while (-1 != (n = input.read(buffer))) {
/* 70 */       output.write(buffer, 0, n);
/* 71 */       count += n;
/*    */     }
/* 73 */     return count;
/*    */   }
/*    */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.IOUtils
 * JD-Core Version:    0.6.0
 */