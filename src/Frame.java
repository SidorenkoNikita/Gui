/**
 * Created by Nikita on 02.07.2017.
 */
import javax.swing.*;
import java.io.IOException;

public class Frame extends JFrame {
    static final int DEFAULT_WIDTH = 640;
    static final int DEFAULT_HEIGHT = 640;

    private Frame(String title) throws IOException {
        super(title);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(new MainPanel());
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Frame("Dungeon");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}