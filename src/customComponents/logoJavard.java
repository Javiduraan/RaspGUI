/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customComponents;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author AngeloCU
 */
public class logoJavard extends JPanel{
    private URL url = getClass().getResource("/img/logo_javard_2.png");
    Image image = new ImageIcon(url).getImage();

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(),getHeight(),this);
        super.paint(g);
    }
    
    
}
