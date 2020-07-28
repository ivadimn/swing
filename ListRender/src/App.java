import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });

        /*try {
            PDDocument doc = Render.loadDocument(new File("homework08.pdf"));
            BufferedImage img = ImageIO.read(new File("image-1.jpg"));
            doc = Render.insertImage(doc, img, 1);
            Render.savePdf(doc, new File("gen1.pdf"));
            System.out.println("File created and saved");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
