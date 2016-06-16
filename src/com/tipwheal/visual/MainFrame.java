package com.tipwheal.visual;

import com.tipwheal.dog.*;
import com.tipwheal.dog.Action;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import static javax.imageio.ImageIO.read;

/**
 * MainFrame.
 */
public class MainFrame extends JFrame implements Runnable {
    private MainFrame mainFrame = this;
    private JTextArea mainText;
    private JButton name;
    private JButton play;
    private JButton wash;
    private JButton exercise;
    private JButton feed;
    private JButton show;
    private JButton random;
    private JButton help;
    private JButton setting;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JMenuItem nameItem;
    private JMenuItem playItem;
    private JMenuItem washItem;
    private JMenuItem exerciseItem;
    private JMenuItem feedItem;
    private JMenuItem showItem;
    private JMenuItem randomItem;
    private JMenuItem helpItem;
    private JMenuItem settingItem;
    private ArrayList<JMenuItem> dogItems = new ArrayList<>();
    private JLabel warmLabel;
    private JPanel statePanel;
    private Dog dog;

    /**
     * constructor.
     *
     * @param dog
     */
    public MainFrame(Dog dog) {
        this.dog = dog;
        Action action = new Action();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Feed My Dog 1.0");

        ActionListener myActionListener = new MyActionListener();
        MouseListener myMouseListener = new MyMouseListener();

        try {
            Image image = ImageIO.read(this.getClass().getResource("/img/newlogo.png"));
            this.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.control);
        menuBar.setBorder(new MatteBorder(0, 0, 1, 0, SystemColor.activeCaption));
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(exit);
        JMenu dogMenu = new JMenu("Dog");
        nameItem = new JMenuItem("Name");
        playItem = new JMenuItem("Play");
        washItem = new JMenuItem("Wash");
        feedItem = new JMenuItem("Feed");
        exerciseItem = new JMenuItem("Exercise");
        showItem = new JMenuItem("Show");
        randomItem = new JMenuItem("Random");
        helpItem = new JMenuItem("Help");
        settingItem = new JMenuItem("Setting");
        dogItems.add(nameItem);
        dogItems.add(playItem);
        dogItems.add(washItem);
        dogItems.add(feedItem);
        dogItems.add(exerciseItem);
        dogItems.add(showItem);
        dogItems.add(randomItem);
        dogItems.add(helpItem);
        dogItems.add(settingItem);
        for (JMenuItem item : dogItems) {
            dogMenu.add(item);
            item.addActionListener(new MyActionListener());
        }
        menuBar.add(file);
        menuBar.add(dogMenu);
        this.setJMenuBar(menuBar);

        JPanel buttonPanel = new JPanel(new GridLayout(12, 1));
        JLabel boxLabel = new JLabel("Select:");
        buttonPanel.add(boxLabel);
        name = new JButton();
        name.setText("name");
        play = new JButton();
        play.setText("play");
        wash = new JButton();
        wash.setText("wash");
        exercise = new JButton();
        exercise.setText("exercise");
        feed = new JButton();
        feed.setText("feed");
        show = new JButton();
        show.setText("show");
        random = new JButton();
        random.setText("random");
        help = new JButton();
        help.setText("help");
        setting = new JButton();
        buttons.add(name);
        buttons.add(play);
        buttons.add(wash);
        buttons.add(exercise);
        buttons.add(feed);
        buttons.add(show);
        buttons.add(random);
        buttons.add(help);
        buttons.add(setting);
        setting.setText("setting");
        buttonPanel.add(new JLabel(""));
        for (JButton button : buttons) {
            buttonPanel.add(button);
            button.addActionListener(myActionListener);
            button.addMouseListener(myMouseListener);
            button.setBackground(Color.lightGray);
        }
        buttonPanel.setBorder(new MatteBorder(0, 1, 0, 0, SystemColor.activeCaption));
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);

        mainText = new JTextArea();
        mainText.setLineWrap(true);
        mainText.setWrapStyleWord(true);
        mainText.setEditable(false);
        JScrollPane mainTextPane = new JScrollPane(mainText);
        mainTextPane.setBorder(null);
        mainTextPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.getContentPane().add(mainTextPane, BorderLayout.CENTER);

        statePanel = new MyDrawPanel();
        statePanel.setLayout(new BoxLayout(statePanel, BoxLayout.Y_AXIS));
        statePanel.add(new JLabel("C:"));
        statePanel.add(new JLabel("S:"));
        statePanel.add(new JLabel("M:"));
        statePanel.add(new JLabel("H:"));
        statePanel.add(new JLabel("                               "));
        statePanel.setBorder(new MatteBorder(0, 0, 0, 1, SystemColor.activeCaption));
        this.getContentPane().add(statePanel, BorderLayout.WEST);

        warmLabel = new JLabel();
        warmLabel.setBorder(new MatteBorder(1, 0, 0, 0, SystemColor.activeCaption));
        warmLabel.setText("Feed My Dog 1.0");
        this.getContentPane().add(warmLabel, BorderLayout.SOUTH);

        Thread repaintThread = new Thread(this);
        repaintThread.start();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((dimension.width - 600) / 2, (dimension.height - 400) / 2, 600, 400);
        this.setVisible(true);
    }

    /**
     * run.
     */
    public void run() {
        while (true) {
            statePanel.repaint();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ActionListener.
     */
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == name || e.getSource() == nameItem) {
                new NameRefactor(dog, mainFrame);
            } else if (e.getSource() == play || e.getSource() == playItem) {
                mainText.setText(dog.play());
            } else if (e.getSource() == wash || e.getSource() == washItem) {
                mainText.setText(dog.wash());
            } else if (e.getSource() == exercise || e.getSource() == exerciseItem) {
                mainText.setText("Your dog exercise and be stronger.");
                dog.exercise();
            } else if (e.getSource() == feed || e.getSource() == feedItem) {
                mainText.setText("You feed your dog.");
                dog.feed();
            } else if (e.getSource() == show || e.getSource() == showItem) {
                mainText.setText(new Action().show("-a", dog));
            } else if (e.getSource() == help || e.getSource() == helpItem) {
                mainText.setText(new Action().getAllCommands());
            } else if (e.getSource() == random || e.getSource() == randomItem) {
                mainText.setText(new Action().randomShow(dog));
            } else if (e.getSource() == setting || e.getSource() == settingItem) {
                new SettingFrame(mainFrame);
            }
        }
    }

    /**
     * MyMouseListener.
     */
    class MyMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == name) {
                warmLabel.setText("To edit your dog's name.");
            } else if (e.getSource() == play) {
                warmLabel.setText("Play with your dog.");
            } else if (e.getSource() == wash) {
                warmLabel.setText("To wash your dog and make it cleaner.");
            } else if (e.getSource() == exercise) {
                warmLabel.setText("Exercise your dog and make it stronger.");
            } else if (e.getSource() == feed) {
                warmLabel.setText("To feed your dog.");
            } else if (e.getSource() == show) {
                warmLabel.setText("Show the state of your dog.");
            } else if (e.getSource() == random) {
                warmLabel.setText("Do random actions.");
            } else if (e.getSource() == help) {
                warmLabel.setText("To see about all things you can do with your dog.");
            } else if (e.getSource() == setting) {
                warmLabel.setText("Settings.");
            }
        }

        public void mouseExited(MouseEvent e) {
            warmLabel.setText("Feed My Dog 1.0");
        }
    }

    /**
     * MyDrawPanel.
     */
    class MyDrawPanel extends JPanel {
        private int clean = (int) Temp.dog.getClean();
        private int strength = (int) Temp.dog.getStrength();
        private int mood = (int) Temp.dog.getMood();
        private int hung = Temp.dog.getHung();

        /**
         * draw lines of numbers.
         *
         * @param g
         */
        public void paint(Graphics g) {
            super.paint(g);
            clean = (int) Temp.dog.getClean();
            strength = (int) Temp.dog.getStrength();
            mood = (int) Temp.dog.getMood();
            hung = Temp.dog.getHung();
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setColor(statePanel.getBackground());
            graphics2D.fillRect(20, 0, 60, 60);
            graphics2D.setColor(Color.orange);
            graphics2D.fillRect(20, 5, clean < 120 ? clean / 2 : 60, 8);
            graphics2D.setColor(Color.PINK);
            graphics2D.fillRect(20, 21, strength < 120 ? strength / 2 : 60, 8);
            graphics2D.setColor(Color.BLUE);
            graphics2D.fillRect(20, 37, mood < 60 ? mood : 60, 8);
            graphics2D.setColor(Color.green);
            graphics2D.fillRect(20, 53, hung < 600 ? hung / 10 : 60, 8);
            graphics2D.setColor(Color.lightGray);
            graphics2D.drawRect(20, 5, 60, 8);
            graphics2D.drawRect(20, 21, 60, 8);
            graphics2D.drawRect(20, 37, 60, 8);
            graphics2D.drawRect(20, 53, 60, 8);
        }
    }
}
