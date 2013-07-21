package com.easycms.common;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaServlet extends HttpServlet {
    
    // letter 'l' not there, to avoid confusion with digit '1'
    // letter 'o' not there, to avoid confusion with digit '0'
    private static final String CAPTCHA_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    
    public static final String CAPTCHA_KEY = "CAPTCHA";
    private static Random rand = new Random(System.currentTimeMillis());
    
    /**
     * Returns a String of specified length with random characters.
     */
    public static String getCaptchaString(int length) {
        StringBuffer captcha = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            captcha.append(CAPTCHA_CHARS.charAt(rand.nextInt(CAPTCHA_CHARS.length())));
        }
        return captcha.toString();
    }
    
    public static String generateCaptchaString(HttpServletRequest request, int length) {
        String captchaString = getCaptchaString(length);
        request.getSession(true).setAttribute(CAPTCHA_KEY, captchaString);
        return captchaString;
    }
    
    public static String getStoredCaptchaString(HttpServletRequest request) {
        // requires an http session. create one if not present
        return (String)request.getSession(true).getAttribute(CAPTCHA_KEY);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // no caching
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setDateHeader("Expires", 0); //prevents caching at the proxy server
        
        // default values
        Color background = Color.WHITE;
        Color foreground = new Color(64, 64, 64);
        int length = 5;
        int size = 28;
        int padding = 5;
        int complexity = 5;
        try {
            background = Color.decode(request.getParameter("background"));
        } catch (Exception ignored) {}
        try {
            foreground = Color.decode(request.getParameter("foreground"));
        } catch (Exception ignored) {}
        try {
            length = Integer.parseInt(request.getParameter("length"));
            length = length<1?1:length>16?16:length;
        } catch (Exception ignored) {}
        try {
            size = Integer.parseInt(request.getParameter("size"));
            size = size<18?18:size>48?48:size;
        } catch (Exception ignored) {}
        try {
            complexity = Integer.parseInt(request.getParameter("complexity"));
            complexity = complexity<1?1:complexity>10?10:complexity;
        } catch (Exception ignored) {}

        // the captcha string
        String captchaString = generateCaptchaString(request, length);
        
        // buffered image setup
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = buffer.createGraphics();
        Font font = new Font("Arial", Font.BOLD, size);
        Rectangle2D r = font.getStringBounds(captchaString, g2d.getFontRenderContext());
        buffer = new BufferedImage(
                (int)r.getWidth() + padding * 2,
                (int)r.getHeight() + padding * 2,
                BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D)buffer.getGraphics();
        g2d.setFont(font);
        
        // fill background
        g2d.setColor(background);
        g2d.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
        // text
        g2d.setTransform(AffineTransform.getRotateInstance(0d));
        g2d.setColor(foreground);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2d.drawString(captchaString, (int)(padding/1), buffer.getHeight() - padding * size/15);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
        g2d.drawString(captchaString, (int)(padding/2), buffer.getHeight() - (int)(padding * size/14));
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        g2d.drawString(captchaString, (int)(padding/0.8), buffer.getHeight() - (int)(padding * size/18));
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        g2d.drawString(captchaString, (int)(padding/1.9), buffer.getHeight() - (int)(padding * size/17));

        // copy to buffer2 and use cos/sin to distort
       /* BufferedImage buffer2 = new BufferedImage(
                buffer.getWidth(), 
                buffer.getHeight(), 
                buffer.getType());
        Graphics2D g2d2 = (Graphics2D)buffer2.getGraphics();
        g2d2.drawImage(buffer, 0, 0, null);
        double seed = rand.nextDouble() * 3d + 5d;
        for (int x = 0; x < buffer.getWidth(); x++) {
            for (int y = 0; y < buffer.getHeight(); y++) {
                int xx = x + (int)(Math.cos((double)y/seed) * ((double)complexity/2d));
                int yy = y + (int)(Math.sin((double)x/(seed+1)) * ((double)complexity/2d));
                xx = Math.abs(xx % buffer.getWidth());
                yy = Math.abs(yy % buffer.getHeight());
                buffer.setRGB(x, y, buffer2.getRGB(xx, yy));
            }
        }*/
        
        // draw lines
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setTransform(AffineTransform.getRotateInstance(rand.nextDouble() * 0.3d - 0.15d));
        g2d.setColor(new Color(128, 128, 128, 128));
        for (int x = -100; x < buffer.getWidth() + 100; x=x+(rand.nextInt(9)+6)) {
            g2d.setStroke(new BasicStroke(
                    1, 
                    BasicStroke.CAP_SQUARE, 
                    BasicStroke.CAP_SQUARE, 
                    10, new float[] {rand.nextInt(10)+2, rand.nextInt(4)+2}, 
                    0));
            g2d.drawLine(x, -100, x, buffer.getHeight() + 100);
        }
        g2d.setColor(new Color(188, 188, 128, 64));
        for (int y = -100; y < buffer.getHeight() + 100; y=y+(rand.nextInt(8)+7)) {
            g2d.setStroke(new BasicStroke(
                    1, 
                    BasicStroke.CAP_SQUARE, 
                    BasicStroke.CAP_SQUARE, 
                    10, new float[] {rand.nextInt(10)+2, rand.nextInt(3)+2}, 
                    0));
            g2d.drawLine(-100, y, buffer.getWidth() + 100, y);
        }
        
        // free graphic resources
        g2d.dispose();
        
        // set the mime type of the image
        response.setContentType("image/png");
        
        // write the image as a png
        OutputStream out = response.getOutputStream();
        try {
            ImageIO.write(buffer, "png", out);
        } catch (javax.imageio.IIOException e) {
            // too many requests from same user?
        } finally {
            out.close();
        }
    }
    
}