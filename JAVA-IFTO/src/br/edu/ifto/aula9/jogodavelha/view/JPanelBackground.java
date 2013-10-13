package br.edu.ifto.aula9.jogodavelha.view;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;



public class JPanelBackground extends JPanel {

    Image bImage;

    public JPanelBackground(String path) {
        this.bImage = Toolkit.getDefaultToolkit().createImage(path);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(bImage, 0, 0, this);
    }
    
}
