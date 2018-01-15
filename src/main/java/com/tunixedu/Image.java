package main.java.com.tunixedu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends JPanel {

    // Frame to hold a panel and display an image
    JFrame frame;
    // Central pixel of the image and origin of the (o,i,j) coordinate system
    Pixel o;
    // Any pixel of the image (to be used to hold coordinate conversion computations)
    Pixel p;
    // Container to hold a png or a jpg file
    BufferedImage image;
    // Border width
    final int BORDER = 10;

    /**
     * Parametrized constructor.
     *
     * @param path  from the home directory to the image file.
     */
    public Image(String path) {

        // load an image from resource files
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println("Failed to load images");
        }

        // Get dimensions of the image to display...
        int width  = image.getWidth();
        int height = image.getHeight();
        // ... and use them to calculate the coordinates of the central pixel.
        o = new Pixel();
        o.c = width  / 2;
        o.r = height / 2;

        // Create the pixel object.
        p = new Pixel();

        // Add the border...
        width += 2*BORDER;
        height += 2*BORDER;
        // ... and use them to resize the frame.
        this.setPreferredSize(new Dimension(width, height));

        // Create the "window" that would include this panel and display the image.
        frame = new JFrame();
        // Add this panel to the created frame.
        frame.add(this);

        // Shrink the window to the appropriate size.
        frame.pack();
        // Make the window not resizable.
        frame.setResizable(false);
        // Close the application when the window is closed.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Show the window
        frame.setVisible(true);
    }

    /**
     * Parametrized constructor for an empty image window.
     *
     * @param width   of the image-reserved area.
     * @param height  of the image-reserved area.
     */
    public Image(int width, int height) {

        // Create an empty image.
        image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);

        // Create the central pixel object and calculate its coordinates.
        o = new Pixel();
        o.c = width  / 2;
        o.r = height / 2;

        // Create the pixel object.
        p = new Pixel();

        // Resize the frame according the dimensions of the image to display.
        this.setPreferredSize(new Dimension((width+2*BORDER), (height+2*BORDER)));

        // Create the "window" that would include this panel and display the image.
        frame = new JFrame();
        // Add this panel to the created frame.
        frame.add(this);

        // Shrink the window to the appropriate size.
        frame.pack();
        // Make the window not resizable.
        frame.setResizable(false);
        // Close the application when the window is closed.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Show the window
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //draw everything as normal ..
        super.paint(g);
        // .. plus the grid lines ..
        g.drawImage(image, BORDER, BORDER, null);
    }

    public int getImageWidth() {
        return this.image.getWidth();
    }

    public int getImageHeight() {
        return this.image.getHeight();
    }

    public int getPixelRGB(int column, int row) {
        return this.image.getRGB(column, row);
    }

    public void setPixelRGB(int column, int row, int rgb) {
        this.image.setRGB(column, row, rgb);
    }

}
