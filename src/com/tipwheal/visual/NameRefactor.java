package com.tipwheal.visual;

import com.tipwheal.dog.Dog;
import javafx.scene.text.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
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
        super(mainFrame,"Name Your Dog",true);
        this.mainFrame = mainFrame;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("new name:");
        JTextField name = new JTextField();
        name.setColumns(10);
        JButton ok = new JButton("ok");
        ok.setBackground(Color.lightGray);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((dimension.width - 200) / 2, (dimension.height - 100) / 2, 200, 100);
        this.setResizable(false);
        this.setVisible(true);

        ok.requestFocus();

    }

}
