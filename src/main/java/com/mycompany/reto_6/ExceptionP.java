/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto_6;

import java.util.ArrayList;

public class ExceptionP extends Exception {
    
    public ExceptionP(String mensaje){
         super(mensaje);
     }
    
    public static boolean IsInteger(String text){
        long v;
        try{
            v = Long.parseLong(text);
            return true;
        }catch (NumberFormatException ex){
            System.out.println("Error..Ingrese solo Números!!");
            return false;
        }
    }
    
    public static boolean validarCuenta(long i, ArrayList<Cuenta> listaCuentas){
        boolean encontrado = false;
        for ( int j = 0; j < listaCuentas.size(); j++){
            if( i == listaCuentas.get(j).getNumCuenta()){
                encontrado = true;
            }
        }
        if(encontrado == false){
            System.out.println("El número de cuenta "+ i + " no existe!!");
            return false;

        }else{
            
            return true;
        } 
    }
    
    
    
}
