package com.tipwheal.visual;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2016/6/11.
 */
public class SettingFrame extends JDialog {
    public SettingFrame(MainFrame mainFrame) {
        super(mainFrame, "Setting", true);

        int width = 300;
        int height = 200;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setResizable(false);
        this.setBounds((dimension.width - width) / 2, (dimension.height) / 2, 300, 200);
        this.setVisible(true);
    }
}
