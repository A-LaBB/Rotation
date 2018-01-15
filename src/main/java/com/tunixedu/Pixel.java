package main.java.com.tunixedu;

/**
 * Class representing a pixel in the image.
 */

public class Pixel {

    // PPI (Pixels Per Inch) also said DPI (Dots Per Inch)
    private final static int PIXEL_PER_INCH = 96;
    // Inch to centimeter conversion factor
    private final static double CM_PER_INCH = 2.54;

    // Discrete value of the horizontal coordinate relative to pixel(0,0)
    int c;
    // Discrete value of the vertical coordinate relative to pixel(0,0)
    int r;
    // Discrete value of the horizontal coordinate relative to pixel(w/2,h/2)
    int i;
    // Discrete value of the vertical coordinate relative to pixel(w/2,h/2)
    int j;
    // Continuous value of the horizontal coordinate relative to pixel(w/2,h/2)
    double x;
    // Continuous value of the vertical coordinate relative to pixel(w/2,h/2)
    double y;
}
