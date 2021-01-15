package util;

import java.lang.reflect.Array;
import java.util.*; // something missing here?
import java.lang.Math;

/**
 * Mathematical functions for arrays.
 * have 5 method
 *
 * @author NoBoomTa, Puvana Swatvanith, SKE17 Student, Student-ID: 6210545734
 */
public class ArrayMath {

    /**
     * Compute and return the dot product
     *
     * @param x,y array of double values. May have length 0.
     * @return the dotProduct by check the with the lower length of them to be the measure of,
     * how many of them would be multiply and return sum of them
     */
    public static double dotProduct(double[] x, double[] y) {
        double sumDot = 0.0;
        if (x.length >= y.length) {
            for (int i = 0; i < y.length; i++) {
                sumDot += x[i] * y[i];
            }
        } else if (x.length <= y.length) {
            for (int i = 0; i < x.length; i++) {
                sumDot += x[i] * y[i];
            }
        }
        return sumDot;
    }

    /**
     * Compute and return the average of an array of values.
     *
     * @param x array of double values. May have length 0.
     * @return the average of values in x. If array has
     * length 0 then the average is 0.0.
     */
    public static double average(double[] x) {
        if (x.length == 0) return 0.0;
        else {
            double len = 0;
            len = x.length;
            double sum = 0;
            for (int i = 0; i < len; i++) {
                sum += x[i];
            }
            sum = sum / len;
            return sum;
        }
    }

    /**
     * Compute and return size of vector
     *
     * @param x array of double values. May have length 0.
     * @return calculate the square root of sum of all (ingredient)square
     */
    public static double norm(double[] x) {
        return Math.sqrt(dotProduct(x, x));
    }

    /**
     * Compute and return max value of all ingredient in Arrays.
     *
     * @param x array of double values. May have length 0.
     * @return the max value of the Array by sort and return the last ingredient.
     */
    public static double max(double[] x) {
        if (x.length == 0) {
            return Double.NEGATIVE_INFINITY;
        } else {
            double ans = x[0];
            for (int i = 1; i < x.length; i++) {
                if (x[i] > ans) {
                    ans = x[i];
                }
            }
            return ans;
        }
    }

    /**
     * Compute and return the polynomial value.
     *
     * @param a,x array of double values. May have length 0. and the coefficient.
     * @return calculate the Value of Polynomial by calculate the sum, start with a[0]*(x^(len of a)) to a[len of a]*(x^0).
     */
    public static double polyval(double x, double[] a) {
        double k = a.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i] * (Math.pow(x, i));
        }
        return sum;
    }
}
