package com.ta.johan.background;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Luwax
 */
public class JDesktopPaneGambarHome extends JDesktopPane {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g.create();

//        Image img = new ImageIcon(getClass().getResource("/Image/388012.jpg")).getImage();
        Image img = new ImageIcon(getClass().getResource("/image/wallpaperflare.com_wallpaper.jpg")).getImage();

        graphics.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        graphics.dispose();
    }
}
