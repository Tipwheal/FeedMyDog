package com.tipwheal.visual;

import com.tipwheal.dog.Dog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 2016/6/10.
 */
public class NameRefactor extends JDialog {
    public MainFrame mainFrame;
    public NameRefactor nf = this;

    /**
     * constructor.
     *
     * @param dog
     * @param mainFrame
     */
    public NameRefactor(Dog dog, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Name Your Dog");

        JLabel label = new JLabel("new name:");
        JTextField name = new JTextField();
        name.setColumns(10);
        JButton ok = new JButton("ok");
        ok.setBackground(Color.lightGray);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!name.getText().equals(""))
                    dog.setName(name.getText());
                nf.dispose();
            }
        });
        JButton cancel = new JButton("cancel");
        cancel.setBackground(Color.lightGray);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nf.dispose();
            }
        });

        this.setLayout(new FlowLayout());
        this.getContentPane().add(label);
        this.getContentPane().add(name);
        this.getContentPane().add(ok);
        this.getContentPane().add(cancel);

        this.setAlwaysOnTop(true);
        this.setBounds(550, 250, 200, 100);
        this.setResizable(false);
        this.setVisible(true);

        ok.requestFocus();

        class MyKeyListener implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\t') {
                    if (e.getSource() == nf) {
                        name.requestFocus();
                    } else if (e.getSource() == name) {
                        ok.requestFocus();
                    } else if (e.getSource() == ok) {
                        cancel.requestFocus();
                    } else if (e.getSource() == cancel) {
                        nf.requestFocus();
                    }
                } else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    if (e.getSource() == cancel) {
                        nf.dispose();
                    } else if (e.getSource() == ok) {
                        if (!name.getText().equals(""))
                            dog.setName(name.getText());
                        nf.dispose();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        }
        MyKeyListener myKeyListener = new MyKeyListener();
        nf.addKeyListener(myKeyListener);
        name.addKeyListener(myKeyListener);
        ok.addKeyListener(myKeyListener);
        cancel.addKeyListener(myKeyListener);

        nf.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setEnabled(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void dispose() {
        mainFrame.setEnabled(true);
        super.dispose();
    }

}
