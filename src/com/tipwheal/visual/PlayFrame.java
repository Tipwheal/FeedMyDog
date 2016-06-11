package com.tipwheal.visual;

import com.tipwheal.dog.Room;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;

/**
 *
 */
public class PlayFrame extends JDialog {
    private PlayFrame pf = this;
    private MainFrame mf;

    public PlayFrame(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Hello");
        JList<String> list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton ok = new JButton("OK");
        ok.setBackground(Color.lightGray);
        JButton cancel = new JButton("cancel");
        cancel.setBackground(Color.lightGray);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ok);
        buttonPanel.add(cancel);

        this.getContentPane().add(scrollPane);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        int width = 150;
        int height = 250;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        this.setResizable(false);
        this.setVisible(true);
    }
}
