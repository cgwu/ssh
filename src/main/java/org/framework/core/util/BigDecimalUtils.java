/*     */ package org.framework.core.util;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.MathContext;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public abstract class BigDecimalUtils
/*     */ {
/*  30 */   public static int SYSTEM_SCALE = 6;
/*  31 */   public static int PAGE_SCALE = 2;
/*     */ 
/*  33 */   public static final DecimalFormat NumberFormat = new DecimalFormat("#,###.##");
/*     */ 
/*  35 */   public static final BigDecimal SYSTEM_ZERO = BigDecimal.valueOf(0L, SYSTEM_SCALE);
/*  36 */   public static final BigDecimal ONE_HUNDRAD = BigDecimal.valueOf(100L);
/*  37 */   public static final BigDecimal NEGATIVE_ONE = BigDecimal.valueOf(-1L);
/*     */ 
/* 252 */   public static final Pattern BigDecimalRegex = Pattern.compile("[\\+-]?\\d+(\\.\\d+)?");
/*     */ 
/* 267 */   private static final BigDecimal[] zeroThrough24 = { 
/* 268 */     BigDecimal.valueOf(0L), 
/* 269 */     BigDecimal.valueOf(1L), 
/* 270 */     BigDecimal.valueOf(2L), 
/* 271 */     BigDecimal.valueOf(3L), 
/* 272 */     BigDecimal.valueOf(4L), 
/* 273 */     BigDecimal.valueOf(5L), 
/* 274 */     BigDecimal.valueOf(6L), 
/* 275 */     BigDecimal.valueOf(7L), 
/* 276 */     BigDecimal.valueOf(8L), 
/* 277 */     BigDecimal.valueOf(9L), 
/* 278 */     BigDecimal.valueOf(10L), 
/* 279 */     BigDecimal.valueOf(11L), 
/* 280 */     BigDecimal.valueOf(12L), 
/* 281 */     BigDecimal.valueOf(13L), 
/* 282 */     BigDecimal.valueOf(14L), 
/* 283 */     BigDecimal.valueOf(15L), 
/* 284 */     BigDecimal.valueOf(16L), 
/* 285 */     BigDecimal.valueOf(17L), 
/* 286 */     BigDecimal.valueOf(18L), 
/* 287 */     BigDecimal.valueOf(19L), 
/* 288 */     BigDecimal.valueOf(20L), 
/* 289 */     BigDecimal.valueOf(21L), 
/* 290 */     BigDecimal.valueOf(22L), 
/* 291 */     BigDecimal.valueOf(23L), 
/* 292 */     BigDecimal.valueOf(24L) };
/*     */ 
/* 295 */   private static final BigDecimal[] zeroScaled6 = { 
/* 296 */     BigDecimal.valueOf(0L, 0), 
/* 297 */     BigDecimal.valueOf(0L, 1), 
/* 298 */     BigDecimal.valueOf(0L, 2), 
/* 299 */     BigDecimal.valueOf(0L, 3), 
/* 300 */     BigDecimal.valueOf(0L, 4), 
/* 301 */     BigDecimal.valueOf(0L, 5), 
/* 302 */     BigDecimal.valueOf(0L, 6) };
/*     */ 
/*     */   public static BigDecimal systemScale(BigDecimal val)
/*     */   {
/*  40 */     return val.setScale(SYSTEM_SCALE, RoundingMode.HALF_UP);
/*     */   }
/*     */ 
/*     */   public static BigDecimal pageScale(BigDecimal val) {
/*  44 */     return val.setScale(PAGE_SCALE, RoundingMode.DOWN);
/*     */   }
/*     */ 
/*     */   public static boolean notZero(BigDecimal val)
/*     */   {
/*  51 */     if ((val == null) || (BigDecimal.ZERO == val)) {
/*  52 */       return false;
/*     */     }
/*  54 */     int scale = val.scale();
/*  55 */     if (scale <= SYSTEM_SCALE) {
/*  56 */       BigDecimal zero = zeroScaled6[scale];
/*  57 */       return val.compareTo(zero) > 0;
/*     */     }
/*  59 */     BigDecimal valScaled = systemScale(val);
/*  60 */     return valScaled.compareTo(SYSTEM_ZERO) > 0;
/*     */   }
/*     */ 
/*     */   public static boolean isNegative(BigDecimal val)
/*     */   {
/*  68 */     if ((val == null) || (BigDecimal.ZERO == val)) {
/*  69 */       return false;
/*     */     }
/*  71 */     int scale = val.scale();
/*  72 */     if (scale <= SYSTEM_SCALE) {
/*  73 */       BigDecimal zero = zeroScaled6[scale];
/*  74 */       return val.compareTo(zero) < 0;
/*     */     }
/*  76 */     BigDecimal valScaled = systemScale(val);
/*  77 */     return valScaled.compareTo(SYSTEM_ZERO) < 0;
/*     */   }
/*     */ 
/*     */   public static boolean isZero(BigDecimal val)
/*     */   {
/*  85 */     if ((val == null) || (BigDecimal.ZERO == val)) {
/*  86 */       return true;
/*     */     }
/*  88 */     int scale = val.scale();
/*  89 */     if (scale <= SYSTEM_SCALE) {
/*  90 */       BigDecimal zero = zeroScaled6[scale];
/*  91 */       return (val == zero) || (val.compareTo(zero) == 0);
/*     */     }
/*  93 */     BigDecimal valScaled = systemScale(val);
/*  94 */     return (valScaled == SYSTEM_ZERO) || (valScaled.compareTo(SYSTEM_ZERO) == 0);
/*     */   }
/*     */ 
/*     */   public static BigDecimal defaultZero(BigDecimal val)
/*     */   {
/*  99 */     return isZero(val) ? SYSTEM_ZERO : val;
/*     */   }
/*     */ 
/*     */   public static boolean equals(BigDecimal val1, BigDecimal val2)
/*     */   {
/* 106 */     if ((val1 == val2) || ((val1 == null) && (val2 == null))) {
/* 107 */       return true;
/*     */     }
/* 109 */     if ((val1 != null) && (val2 != null)) {
/* 110 */       if (val1.scale() == val2.scale()) {
/* 111 */         return val1.equals(val2);
/*     */       }
/* 113 */       BigDecimal diff = val1.subtract(val2).abs();
/* 114 */       return isZero(diff);
/*     */     }
/*     */ 
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean greater(BigDecimal val1, BigDecimal val2)
/*     */   {
/* 128 */     if ((val1 == val2) || (val1 == null) || (val2 == null)) {
/* 129 */       return false;
/*     */     }
/* 131 */     if ((val1 != null) && (val2 != null)) {
/* 132 */       if (val1.scale() == val2.scale()) {
/* 133 */         return val1.compareTo(val2) > 0;
/*     */       }
/* 135 */       BigDecimal diff = val1.subtract(val2);
/* 136 */       return notZero(diff);
/*     */     }
/*     */ 
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean less(BigDecimal val1, BigDecimal val2)
/*     */   {
/* 150 */     return greater(val2, val1);
/*     */   }
/*     */ 
/*     */   public static BigDecimal max(BigDecimal val1, BigDecimal val2) {
/* 154 */     return greater(val1, val2) ? val1 : val2;
/*     */   }
/*     */ 
/*     */   public static BigDecimal min(BigDecimal val1, BigDecimal val2) {
/* 158 */     return greater(val1, val2) ? val2 : val1;
/*     */   }
/*     */ 
/*     */   public static BigDecimal add(BigDecimal val1, BigDecimal val2) {
/* 162 */     if (isZero(val1)) return defaultZero(val2);
/* 163 */     if (isZero(val2)) return defaultZero(val1);
/* 164 */     return val1.add(val2);
/*     */   }
/*     */ 
/*     */   public static BigDecimal subtract(BigDecimal val1, BigDecimal val2) {
/* 168 */     if (isZero(val1)) return defaultZero(val2).negate();
/* 169 */     if (isZero(val2)) return defaultZero(val1);
/* 170 */     return val1.subtract(val2);
/*     */   }
/*     */ 
/*     */   public static BigDecimal divide(BigDecimal amount, BigDecimal divisor) {
/* 174 */     if (isZero(amount)) return amount;
/*     */ 
/* 176 */     if (notZero(divisor)) {
/* 177 */       if (BigDecimal.ONE.equals(divisor)) {
/* 178 */         return amount;
/*     */       }
/* 180 */       return amount.divide(divisor, SYSTEM_SCALE, RoundingMode.HALF_UP);
/*     */     }
/* 182 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   public static BigDecimal divide(BigDecimal amount, int divisor) {
/* 186 */     if (divisor > 0) {
/* 187 */       if (divisor == 1) {
/* 188 */         return amount;
/*     */       }
/* 190 */       return divide(amount, valueOf(divisor));
/*     */     }
/* 192 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   public static BigDecimal multiply(BigDecimal amount, int multiplicand) {
/* 196 */     if (multiplicand > 0) {
/* 197 */       if (multiplicand == 1) {
/* 198 */         return amount;
/*     */       }
/* 200 */       return multiply(amount, valueOf(multiplicand));
/*     */     }
/* 202 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   public static BigDecimal multiply(BigDecimal amount, BigDecimal multiplicand) {
/* 206 */     if (isZero(amount)) return BigDecimal.ZERO;
/* 207 */     if (notZero(multiplicand)) {
/* 208 */       if (BigDecimal.ONE.equals(multiplicand)) {
/* 209 */         return amount;
/*     */       }
/* 211 */       BigDecimal ret = amount.multiply(multiplicand);
/* 212 */       return ret.setScale(SYSTEM_SCALE, RoundingMode.HALF_UP);
/*     */     }
/* 214 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   public static BigDecimal percentOf(BigDecimal val, BigDecimal percentage) {
/* 218 */     if (notZero(percentage)) {
/* 219 */       return divide(multiply(val, percentage), 100);
/*     */     }
/* 221 */     return BigDecimal.ZERO;
/*     */   }
/*     */ 
/*     */   public static BigDecimal discountOf(BigDecimal val, BigDecimal discount) {
/* 225 */     if (notZero(discount)) {
/* 226 */       BigDecimal multiplicand = valueOf(1).subtract(divide(discount, 100));
/* 227 */       return multiply(val, multiplicand);
/*     */     }
/* 229 */     return val;
/*     */   }
/*     */ 
/*     */   public static String format(BigDecimal val) {
/* 233 */     if (val == null) return "0";
/* 234 */     return NumberFormat.format(val);
/*     */   }
/*     */ 
/*     */   public static BigDecimal valueOf(double val) {
/* 238 */     return new BigDecimal(val, MathContext.DECIMAL32);
/*     */   }
/*     */ 
/*     */   public static BigDecimal valueOf(int val) {
/* 242 */     if ((val >= 0) && (val <= 24)) {
/* 243 */       return zeroThrough24[val];
/*     */     }
/* 245 */     if (val == 100) {
/* 246 */       return ONE_HUNDRAD;
/*     */     }
/* 248 */     return BigDecimal.valueOf(val);
/*     */   }
/*     */ 
/*     */   public static BigDecimal valueOf(String input)
/*     */   {
/* 254 */     if (StringUtils.isEmpty(input)) {
/* 255 */       return BigDecimal.ZERO;
/*     */     }
/*     */ 
/* 258 */     String s = input.indexOf(',') > 0 ? input.replace("", "") : input;
/* 259 */     if (BigDecimalRegex.matcher(s).matches())
/*     */       try {
/* 261 */         return new BigDecimal(s);
/*     */       } catch (Exception localException) {
/*     */       }
/* 264 */     return BigDecimal.ZERO;
/*     */   }
/*     */ }

/* Location:           X:\Workspace\svn\Spade\java\required-lib\framework-core-2.0.0.jar
 * Qualified Name:     org.framework.core.util.BigDecimalUtils
 * JD-Core Version:    0.6.0
 */