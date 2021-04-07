/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author Javi
 */
public class BotonCustom extends JButton {

    private Color backgroundColor;
    private String text;

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(new GradientPaint(new Point(0, 0), Color.WHITE, new Point(0, getHeight()), Color.PINK.darker()));
        g2d.setPaint(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2d.setPaint(Color.BLACK);
        g2d.drawString(text, 30, 12);
        g2d.dispose();
    }

}
