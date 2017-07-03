/**
 * Created by Nikita on 03.07.2017.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.List;
import java.util.ArrayList;

import static java.lang.System.in;

class MainPanel extends JPanel {
    private File file;
    private boolean started, gameOver;
    private Player player;
    private ArrayList<ArrayList<Cell>> cells;
    private Image freecell,wall, playerposition, path, destination, deathwall,success;


    MainPanel() throws IOException {

        file = new File("C:\\Users\\Nikita\\IdeaProjects\\Gui\\lewel.txt");
        java.util.List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Nikita\\IdeaProjects\\Gui\\lewel.txt"), StandardCharsets.UTF_8);
        int j = 0;
        for(String line: lines){
            int i = 0;
            ArrayList<Cell> adder = new ArrayList<>();
            Cell cell = new Cell();
            while(i < (line.length()-1)){
                cell.setX(i+1);
                cell.setY(j+1);
                cell.setStatus(line.charAt(i));
                if (cell.getStatus() == 2){
                    player.setCell(cell);
                }
                adder.add(cell);
                i += 1;
            }
            cells.add(adder);
            j += 1;
        }
        try {
            freecell = ImageIO.read(new File("C:\\Users\\Nikita\\IdeaProjects\\Gui\\sprites\\freecell.png"));
            wall = ImageIO.read(new File("C:\\Users\\Nikita\\IdeaProjects\\Gui\\sprites\\wall.png"));
            playerposition = ImageIO.read(new File("C:\\Users\\Nikita\\IdeaProjects\\Gui\\sprites\\player.png"));
            path = ImageIO.read(new File("C:\\Users\\Nikita\\Gui\\sprites\\path.png"));
            destination = ImageIO.read(new File("C:\\Users\\Nikita\\Gui\\sprites\\destination.png"));
            deathwall = ImageIO.read(new File("C:\\Users\\Nikita\\Gui\\sprites\\deathwall.png"));
            success = ImageIO.read(new File("C:\\Users\\Nikita\\IdeaProjects\\Gui\\sprites\\success.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        setFocusable(true);


        /**/
        setBackground(Color.white);
        /**/

        KeyListener  keyListener = new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!gameOver) {
                    if (e.getKeyCode() == KeyEvent.VK_W) {
                        try {
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                            player.up();
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_A) {
                        try {
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                            player.left();
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        try {
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                            player.down();
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    if (e.getKeyCode() == KeyEvent.VK_D) {
                        try {
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                            player.right();
                            cells.get(player.getX()).get(player.getY()).changeStatus();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        };

        addKeyListener(keyListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        int i = 0;
        int j = 0;
        while (i < 16) {
            while (j < 16) {
                switch (cells.get(i).get(j).getStatus()) {
                    case 0:
                        g2D.drawImage(freecell, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                    case 1:
                        g2D.drawImage(wall, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                    case 2:
                        g2D.drawImage(playerposition, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                    case 3:
                        g2D.drawImage(path, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                    case 4:
                        g2D.drawImage(destination, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                    case 5:
                        g2D.drawImage(success, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                    case 6:
                        g2D.drawImage(deathwall, cells.get(i).get(j).getX() * Frame.DEFAULT_WIDTH / 16, cells.get(i).get(j).getX() * Frame.DEFAULT_HEIGHT / 16, null);
                        break;
                }
                i += 1;
            }
            j += 1;
        }
    }

}
