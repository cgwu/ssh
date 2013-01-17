/*    */ package org.framework.core.util;
/*    */ 
/*    */ public abstract class Permutations
/*    */ {
/*    */   public static int permutation(int n, int r)
/*    */   {
/* 33 */     if ((n == 0) || (r == 0) || (r > n)) return 0;
/* 34 */     int count = n;
/* 35 */     for (int i = 1; i < r; i++) {
/* 36 */       count *= (n - i);
/*    */     }
/* 38 */     return count;
/*    */   }
/*    */ 
/*    */   public static int combination(int n, int r)
/*    */   {
/* 49 */     if ((n == 0) || (r == 0) || (r > n)) return 0;
/* 50 */     int p = permutation(n, r);
/* 51 */     int divide = factorial(r);
/* 52 */     return p / divide;
/*    */   }
/*    */ 
/*    */   public static int factorial(int n)
/*    */   {
/* 62 */     int f = 1;
/* 63 */     for (int i = 2; i <= n; i++) {
/* 64 */       f *= i;
/*    */     }
/* 66 */     return f;
/*    */   }
/*    */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.Permutations
 * JD-Core Version:    0.6.0
 */