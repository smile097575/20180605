import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MFrame extends JFrame {
    Container cp;
    private Timer t1;
    private ImageIcon icon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled\\src\\f_18273492_1.png");
    private ImageIcon icon1 = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled\\src\\jn.png");
    private ImageIcon icon2 = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled\\src\\b.png");
    private JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();

    public MFrame() {
        Ex1();
    }

    private void Ex1() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 700, 700);
        cp = getContentPane();
        cp.setLayout(null);

        Image img = icon.getImage();
        Image img2 = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        icon.setImage(img2);

        jlb.setBounds(400, 450, 100, 100);
        jlb.setIcon(icon);
        cp.add(jlb);

        img = icon2.getImage();
        img2 = img.getScaledInstance(30, 60, Image.SCALE_SMOOTH);
        icon2.setImage(img2);
        jlb2.setIcon(icon2);

        t1 = new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb2.setLocation(jlb2.getX() - 5, jlb2.getY());
                if (jlb2.getY() < 0) {
                    t1.stop();
                }
            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()) {
                    case 37:
                        jlb.setLocation(jlb.getX() - 5, jlb.getY());
                    case 39:
                        jlb.setLocation(jlb.getX() + 5, jlb.getY());
                    case 32:
                        jlb2.setBounds(jlb.getX() + 50, jlb.getY(), 60, 60);
                        cp.add(jlb2);
                        t1.start();
                }
            }
        });


    }
}
