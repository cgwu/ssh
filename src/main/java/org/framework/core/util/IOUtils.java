 package org.framework.core.util;
 
 import java.io.ByteArrayInputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.util.zip.GZIPInputStream;
 import java.util.zip.GZIPOutputStream;
 
 public abstract class IOUtils
 {
   private static final int DEFAULT_BUFFER_SIZE = 4096;
 
   public static byte[] gzip(byte[] bytes)
     throws IOException
   {
     ByteArrayOutputStream out = new ByteArrayOutputStream();
     GZIPOutputStream gzip = new GZIPOutputStream(out);
     gzip.write(bytes);
     gzip.finish();
     gzip.close();
 
     return out.toByteArray();
   }
 
   public static void ungzip(InputStream in, OutputStream out) throws IOException {
     GZIPOutputStream gzip = new GZIPOutputStream(out);
     copy(in, gzip);
   }
 
   public static byte[] decompress(byte[] bytes) throws IOException {
     GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(bytes));
 
     ByteArrayOutputStream out = new ByteArrayOutputStream();
     copy(gzip, out);
     gzip.close();
     out.close();
 
     return out.toByteArray();
   }
 
   public static void decompress(InputStream in, OutputStream out) throws IOException {
     GZIPInputStream gzip = new GZIPInputStream(in);
     copy(gzip, out);
   }
 
   public static long copy(InputStream input, OutputStream output) throws IOException {
     byte[] buffer = new byte[4096];
     long count = 0L;
     int n = 0;
     while (-1 != (n = input.read(buffer))) {
       output.write(buffer, 0, n);
       count += n;
     }
     return count;
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.IOUtils
 * JD-Core Version:    0.6.0
 */