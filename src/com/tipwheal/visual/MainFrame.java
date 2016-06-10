package com.tipwheal.visual;

import com.tipwheal.dog.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2016/6/10.
 */
public class MainFrame extends JFrame {
    private JTextArea mainText;

    public MainFrame(Dog dog) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Feed My Dog 1.0");

        Box box = new Box(BoxLayout.Y_AXIS);
        JLabel boxLabel = new JLabel("please choose:");
        box.add(boxLabel);
        JButton name = new JButton();
        name.setText("name");
        name.setBackground(Color.lightGray);
        name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NameRefactor(dog);
            }
        });
        JButton play = new JButton();
        play.setText("play");
        play.setBackground(Color.lightGray);
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText("You play with your dog.");
                dog.play();
            }
        });
        JButton wash = new JButton();
        wash.setText("wash");
        wash.setBackground(Color.lightGray);
        wash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainText.setText("You wash your dog.");
                dog.wash();
            }
        });
        JButton exercise = new JButton();
        exercise.setText("exercise");
        exercise.setBackground(Color.lightGray);
        exercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainText.setText("Your dog exercise and be stronger.");
                dog.exercise();
            }
        });
        JButton feed = new JButton();
        feed.setText("feed");
        feed.setBackground(Color.lightGray);
        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainText.setText("You feed your dog.");
                dog.feed();
            }
        });
        JButton show = new JButton();
        show.setText("show");
        show.setBackground(Color.lightGray);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainText.setText("name\t" + dog.getName() + "\n");
                mainText.append("hungary:\t" + dog.getHung() + "\n");
                mainText.append("day:\t" + dog.getDay() + "\n");
                mainText.append("hour:\t" + dog.getHour() + "\n");
                mainText.append("min:\t" + dog.getMin() + "\n");
                mainText.append("mood:\t" + dog.getMood() + "\n");
                mainText.append("clean:\t" + dog.getClean() + "\n");
                mainText.append("strength:\t" + dog.getStrength());
            }
        });
        JButton random = new JButton();
        random.setText("random");
        random.setBackground(Color.lightGray);
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainText.setText("nothing happen.");
            }
        });
        JButton help = new JButton();
        help.setText("help");
        help.setBackground(Color.lightGray);
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainText.setText("hello.");
            }
        });
        box.add(name);
        box.add(play);
        box.add(wash);
        box.add(exercise);
        box.add(feed);
        box.add(show);
        box.add(random);
        box.add(help);
        this.getContentPane().add(box, BorderLayout.EAST);

        mainText = new JTextArea();
        mainText.setLineWrap(true);
        mainText.setWrapStyleWord(true);
        mainText.setEnabled(false);
        JScrollPane mainTextPane = new JScrollPane(mainText);
        mainTextPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().add(mainText, BorderLayout.CENTER);

        this.setBounds(400,200,600,400);
        this.setVisible(true);
    }
}
