package com.tipwheal.visual;

import com.tipwheal.dog.*;
import com.tipwheal.dog.Action;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorModel;

/**
 * Created by Administrator on 2016/6/10.
 */
public class MainFrame extends JFrame {
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
    private JLabel warmLabel;

    public MainFrame(Dog dog) {
        Action action = new Action();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Feed My Dog 1.0");

        JPanel buttonPanel = new JPanel(new GridLayout(12, 1));
        JLabel boxLabel = new JLabel("Select:");
        buttonPanel.add(boxLabel);
        name = new JButton();
        name.setText("name");
        name.setBackground(Color.lightGray);
        name.addMouseListener(new MyMouseListener());
        name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NameRefactor(dog, mainFrame);
            }
        });
        play = new JButton();
        play.setText("play");
        play.setBackground(Color.lightGray);
        play.addMouseListener(new MyMouseListener());
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText(dog.play());
//                new PlayFrame(mainFrame,"What To Play",true);
            }
        });
        wash = new JButton();
        wash.setText("wash");
        wash.setBackground(Color.lightGray);
        wash.addMouseListener(new MyMouseListener());
        wash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText(dog.wash());
            }
        });
        exercise = new JButton();
        exercise.setText("exercise");
        exercise.setBackground(Color.lightGray);
        exercise.addMouseListener(new MyMouseListener());
        exercise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText("Your dog exercise and be stronger.");
                dog.exercise();
            }
        });
        feed = new JButton();
        feed.setText("feed");
        feed.setBackground(Color.lightGray);
        feed.addMouseListener(new MyMouseListener());
        feed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText("You feed your dog.");
                dog.feed();
            }
        });
        show = new JButton();
        show.setText("show");
        show.setBackground(Color.lightGray);
        show.addMouseListener(new MyMouseListener());
        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText(action.show("-a", dog));
            }
        });
        random = new JButton();
        random.setText("random");
        random.setBackground(Color.lightGray);
        random.addMouseListener(new MyMouseListener());
        random.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText(action.randomShow(dog));
            }
        });
        help = new JButton();
        help.setText("help");
        help.setBackground(Color.lightGray);
        help.addMouseListener(new MyMouseListener());
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText(action.getAllCommands());
            }
        });
        setting = new JButton();
        setting.setText("setting");
        setting.setBackground(Color.lightGray);
        setting.addMouseListener(new MyMouseListener());
        setting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(name);
        buttonPanel.add(play);
        buttonPanel.add(wash);
        buttonPanel.add(exercise);
        buttonPanel.add(feed);
        buttonPanel.add(show);
        buttonPanel.add(random);
        buttonPanel.add(help);
        buttonPanel.add(setting);
        buttonPanel.setBorder(new MatteBorder(0, 1, 0, 0, SystemColor.activeCaption));
        this.getContentPane().add(buttonPanel, BorderLayout.EAST);

        mainText = new JTextArea();
        mainText.setLineWrap(true);
        mainText.setWrapStyleWord(true);
        mainText.setEditable(false);
        JScrollPane mainTextPane = new JScrollPane(mainText);
        mainTextPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().add(mainText, BorderLayout.CENTER);

        warmLabel = new JLabel();
        warmLabel.setBorder(new MatteBorder(1, 0, 0, 0, SystemColor.activeCaption));
        warmLabel.setText("Feed My Dog 1.0");
        this.getContentPane().add(warmLabel, BorderLayout.SOUTH);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((dimension.width - 600) / 2, (dimension.height - 400) / 2, 600, 400);
        this.setVisible(true);
    }

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
}
