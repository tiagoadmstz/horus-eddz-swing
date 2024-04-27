/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperstandard.util;

import com.cooperstandard.views.extrusao.ViewExtrusao;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author hugov
 */
public class FundoTela extends JDesktopPane {
    private Image imagem;

public FundoTela(String imagem)   {
    this.imagem = new ImageIcon(ViewExtrusao.class.getResource(imagem)).getImage();
} 

@Override
public void paintComponent(Graphics g){
    g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
}
    
}
