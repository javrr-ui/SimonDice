/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
  
      public static Color getColorXD(String propertyValue) {
        //por si acaso XD
        Color color = new Color(240, 240, 240);
        
            //regex para obtener 3 grupos de valores numericos
            Pattern c = Pattern.compile("^([0-9]+).([0-9]+).([0-9]+)$");
            Matcher m = c.matcher(propertyValue);
            
            if(m.matches()){
                
                try{
                    color = new Color(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
                }catch(Exception e){
                    System.out.println("color not valid: "+e);
                }
                
            }else{
                System.out.println("color not valid");
            }
          
        return color;
    }
}
