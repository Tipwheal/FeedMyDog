package com.tipwheal.visual;

import com.tipwheal.dog.Dog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * Created by Administrator on 2016/6/10.
 */
public class NameRefactor extends JDialog {
    public NameRefactor nf = this;

    public NameRefactor(Dog dog) {
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

        this.setBounds(550, 250, 200, 100);
        this.setResizable(false);
        this.setVisible(true);
    }

}
