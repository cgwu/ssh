 package org.framework.core.util;
 
 public abstract class Permutations
 {
   public static int permutation(int n, int r)
   {
     if ((n == 0) || (r == 0) || (r > n)) return 0;
     int count = n;
     for (int i = 1; i < r; i++) {
       count *= (n - i);
     }
     return count;
   }
 
   public static int combination(int n, int r)
   {
     if ((n == 0) || (r == 0) || (r > n)) return 0;
     int p = permutation(n, r);
     int divide = factorial(r);
     return p / divide;
   }
 
   public static int factorial(int n)
   {
     int f = 1;
     for (int i = 2; i <= n; i++) {
       f *= i;
     }
     return f;
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.Permutations
 * JD-Core Version:    0.6.0
 */