/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.Color;

/**
 *
 * @author Javi
 */
public class StringUtils {
    
    /**
 * Este metodo recibe un objeto Color y lo convierte a un string de la forma "250,250,250"
 * @param color el color que se quiere convertir
 * @return un string de la forma "250,250,250"
 */
  static String ColorToStringRGB(Color color){
        return color.getRed()+","+color.getGreen()+","+color.getBlue();
    }
}
