import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class SmallImagePanel extends JPanel{
    private BufferedImage image;
    private boolean isFocused;

    public SmallImagePanel(BufferedImage image) {
        this.image = image;
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, false));
        isFocused = false;
        this.setPreferredSize(new Dimension(150, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage bi = new
                BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics gl = bi.getGraphics();
        gl.drawImage(image, 0, 0, null);

        double sx = 0.25f;
        double sy = 0.25f;
        AffineTransform transform = new AffineTransform();
        transform.setToScale(sx, sy);
        AffineTransformOp top = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
        //BufferedImage compImage = top.createCompatibleDestImage(bi, null);

        //Graphics2D gtmp = compImage.createGraphics();
        //gtmp.drawImage(bi, top, 0,0);


        if (isFocused) {
            //g2.setBackground(Color.BLUE);
            this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3, false));
        }
        g2.drawImage(bi, top, 5, 5);
        g2.dispose();

        //g2.drawImage(compImage, 5, 5, null);
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setFocused(boolean focused) {
        isFocused = focused;
    }
}
