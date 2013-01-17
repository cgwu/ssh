 package org.framework.core.util;
 
 import java.math.BigDecimal;
 import java.math.MathContext;
 import java.math.RoundingMode;
 import java.text.DecimalFormat;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
 public abstract class BigDecimalUtils
 {
   public static int SYSTEM_SCALE = 6;
   public static int PAGE_SCALE = 2;
 
   public static final DecimalFormat NumberFormat = new DecimalFormat("#,###.##");
 
   public static final BigDecimal SYSTEM_ZERO = BigDecimal.valueOf(0L, SYSTEM_SCALE);
   public static final BigDecimal ONE_HUNDRAD = BigDecimal.valueOf(100L);
   public static final BigDecimal NEGATIVE_ONE = BigDecimal.valueOf(-1L);
 
   public static final Pattern BigDecimalRegex = Pattern.compile("[\\+-]?\\d+(\\.\\d+)?");
 
   private static final BigDecimal[] zeroThrough24 = { 
     BigDecimal.valueOf(0L), 
     BigDecimal.valueOf(1L), 
     BigDecimal.valueOf(2L), 
     BigDecimal.valueOf(3L), 
     BigDecimal.valueOf(4L), 
     BigDecimal.valueOf(5L), 
     BigDecimal.valueOf(6L), 
     BigDecimal.valueOf(7L), 
     BigDecimal.valueOf(8L), 
     BigDecimal.valueOf(9L), 
     BigDecimal.valueOf(10L), 
     BigDecimal.valueOf(11L), 
     BigDecimal.valueOf(12L), 
     BigDecimal.valueOf(13L), 
     BigDecimal.valueOf(14L), 
     BigDecimal.valueOf(15L), 
     BigDecimal.valueOf(16L), 
     BigDecimal.valueOf(17L), 
     BigDecimal.valueOf(18L), 
     BigDecimal.valueOf(19L), 
     BigDecimal.valueOf(20L), 
     BigDecimal.valueOf(21L), 
     BigDecimal.valueOf(22L), 
     BigDecimal.valueOf(23L), 
     BigDecimal.valueOf(24L) };
 
   private static final BigDecimal[] zeroScaled6 = { 
     BigDecimal.valueOf(0L, 0), 
     BigDecimal.valueOf(0L, 1), 
     BigDecimal.valueOf(0L, 2), 
     BigDecimal.valueOf(0L, 3), 
     BigDecimal.valueOf(0L, 4), 
     BigDecimal.valueOf(0L, 5), 
     BigDecimal.valueOf(0L, 6) };
 
   public static BigDecimal systemScale(BigDecimal val)
   {
     return val.setScale(SYSTEM_SCALE, RoundingMode.HALF_UP);
   }
 
   public static BigDecimal pageScale(BigDecimal val) {
     return val.setScale(PAGE_SCALE, RoundingMode.DOWN);
   }
 
   public static boolean notZero(BigDecimal val)
   {
     if ((val == null) || (BigDecimal.ZERO == val)) {
       return false;
     }
     int scale = val.scale();
     if (scale <= SYSTEM_SCALE) {
       BigDecimal zero = zeroScaled6[scale];
       return val.compareTo(zero) > 0;
     }
     BigDecimal valScaled = systemScale(val);
     return valScaled.compareTo(SYSTEM_ZERO) > 0;
   }
 
   public static boolean isNegative(BigDecimal val)
   {
     if ((val == null) || (BigDecimal.ZERO == val)) {
       return false;
     }
     int scale = val.scale();
     if (scale <= SYSTEM_SCALE) {
       BigDecimal zero = zeroScaled6[scale];
       return val.compareTo(zero) < 0;
     }
     BigDecimal valScaled = systemScale(val);
     return valScaled.compareTo(SYSTEM_ZERO) < 0;
   }
 
   public static boolean isZero(BigDecimal val)
   {
     if ((val == null) || (BigDecimal.ZERO == val)) {
       return true;
     }
     int scale = val.scale();
     if (scale <= SYSTEM_SCALE) {
       BigDecimal zero = zeroScaled6[scale];
       return (val == zero) || (val.compareTo(zero) == 0);
     }
     BigDecimal valScaled = systemScale(val);
     return (valScaled == SYSTEM_ZERO) || (valScaled.compareTo(SYSTEM_ZERO) == 0);
   }
 
   public static BigDecimal defaultZero(BigDecimal val)
   {
     return isZero(val) ? SYSTEM_ZERO : val;
   }
 
   public static boolean equals(BigDecimal val1, BigDecimal val2)
   {
     if ((val1 == val2) || ((val1 == null) && (val2 == null))) {
       return true;
     }
     if ((val1 != null) && (val2 != null)) {
       if (val1.scale() == val2.scale()) {
         return val1.equals(val2);
       }
       BigDecimal diff = val1.subtract(val2).abs();
       return isZero(diff);
     }
 
     return false;
   }
 
   public static boolean greater(BigDecimal val1, BigDecimal val2)
   {
     if ((val1 == val2) || (val1 == null) || (val2 == null)) {
       return false;
     }
     if ((val1 != null) && (val2 != null)) {
       if (val1.scale() == val2.scale()) {
         return val1.compareTo(val2) > 0;
       }
       BigDecimal diff = val1.subtract(val2);
       return notZero(diff);
     }
 
     return false;
   }
 
   public static boolean less(BigDecimal val1, BigDecimal val2)
   {
     return greater(val2, val1);
   }
 
   public static BigDecimal max(BigDecimal val1, BigDecimal val2) {
     return greater(val1, val2) ? val1 : val2;
   }
 
   public static BigDecimal min(BigDecimal val1, BigDecimal val2) {
     return greater(val1, val2) ? val2 : val1;
   }
 
   public static BigDecimal add(BigDecimal val1, BigDecimal val2) {
     if (isZero(val1)) return defaultZero(val2);
     if (isZero(val2)) return defaultZero(val1);
     return val1.add(val2);
   }
 
   public static BigDecimal subtract(BigDecimal val1, BigDecimal val2) {
     if (isZero(val1)) return defaultZero(val2).negate();
     if (isZero(val2)) return defaultZero(val1);
     return val1.subtract(val2);
   }
 
   public static BigDecimal divide(BigDecimal amount, BigDecimal divisor) {
     if (isZero(amount)) return amount;
 
     if (notZero(divisor)) {
       if (BigDecimal.ONE.equals(divisor)) {
         return amount;
       }
       return amount.divide(divisor, SYSTEM_SCALE, RoundingMode.HALF_UP);
     }
     return BigDecimal.ZERO;
   }
 
   public static BigDecimal divide(BigDecimal amount, int divisor) {
     if (divisor > 0) {
       if (divisor == 1) {
         return amount;
       }
       return divide(amount, valueOf(divisor));
     }
     return BigDecimal.ZERO;
   }
 
   public static BigDecimal multiply(BigDecimal amount, int multiplicand) {
     if (multiplicand > 0) {
       if (multiplicand == 1) {
         return amount;
       }
       return multiply(amount, valueOf(multiplicand));
     }
     return BigDecimal.ZERO;
   }
 
   public static BigDecimal multiply(BigDecimal amount, BigDecimal multiplicand) {
     if (isZero(amount)) return BigDecimal.ZERO;
     if (notZero(multiplicand)) {
       if (BigDecimal.ONE.equals(multiplicand)) {
         return amount;
       }
       BigDecimal ret = amount.multiply(multiplicand);
       return ret.setScale(SYSTEM_SCALE, RoundingMode.HALF_UP);
     }
     return BigDecimal.ZERO;
   }
 
   public static BigDecimal percentOf(BigDecimal val, BigDecimal percentage) {
     if (notZero(percentage)) {
       return divide(multiply(val, percentage), 100);
     }
     return BigDecimal.ZERO;
   }
 
   public static BigDecimal discountOf(BigDecimal val, BigDecimal discount) {
     if (notZero(discount)) {
       BigDecimal multiplicand = valueOf(1).subtract(divide(discount, 100));
       return multiply(val, multiplicand);
     }
     return val;
   }
 
   public static String format(BigDecimal val) {
     if (val == null) return "0";
     return NumberFormat.format(val);
   }
 
   public static BigDecimal valueOf(double val) {
     return new BigDecimal(val, MathContext.DECIMAL32);
   }
 
   public static BigDecimal valueOf(int val) {
     if ((val >= 0) && (val <= 24)) {
       return zeroThrough24[val];
     }
     if (val == 100) {
       return ONE_HUNDRAD;
     }
     return BigDecimal.valueOf(val);
   }
 
   public static BigDecimal valueOf(String input)
   {
     if (StringUtils.isEmpty(input)) {
       return BigDecimal.ZERO;
     }
 
     String s = input.indexOf(',') > 0 ? input.replace("", "") : input;
     if (BigDecimalRegex.matcher(s).matches())
       try {
         return new BigDecimal(s);
       } catch (Exception localException) {
       }
     return BigDecimal.ZERO;
   }
 }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.BigDecimalUtils
 * JD-Core Version:    0.6.0
 */