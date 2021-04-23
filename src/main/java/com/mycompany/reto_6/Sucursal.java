package com.mycompany.reto_6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

    // Andrés David
    // ELiana Puerta 

public class Sucursal {
     public static void main(String[] args){
        ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
        ArrayList<Transaccion> listaTransacciones = new ArrayList<Transaccion>();
        
        Scanner lector = new Scanner(System.in);  

        Cuenta cuenta = new Cuenta("arrancar");
        Transaccion transaccion = new Transaccion("iniciar");
         
         String aux = "";
         int menu = 1;
         int menu2 = 1;
    
    while(menu != 0){
        if(menu < 0 || menu > 4){
            System.out.println("ingrese una opcion entre 0 y 4");
        }
        boolean auxiliar = true;
        do {
        System.out.println("\n Bienvenido a la Sucursal Virtual");
        System.out.println("1. Crear Cuenta de Ahorros ");
        System.out.println("2. Consultar Cuenta de Ahorros ");
        System.out.println("3. Eliminar Cuenta de Ahorros");
        System.out.println("4. Realizar Transacción o consultar saldo ");
        System.out.println("0. Salir del Banco ");
            aux = lector.nextLine();
        
        }while(!ExceptionP.IsInteger(aux) || aux.length() > 1);
        
           menu = Integer.parseInt(aux);
        if(menu == 1){
            cuenta.agregarCuenta(listaCuentas);
        }
        if(menu == 2){
            System.out.println("Digite el número de la cuenta a consultar:");
            cuenta.consultarCuenta(lector.nextLong(), listaCuentas);
        }
        if(menu == 3){
            System.out.println("Digite el número de la cuenta a eliminar:");
            cuenta.eliminarCuenta(lector.nextLong(), listaCuentas);
        }
         if(menu == 4){
            String aux2;
            do{
            System.out.println("Digite el número de la cuenta:");
            aux2 = lector.nextLine();
            
            }while(!ExceptionP.IsInteger(aux2));
             long numCuenta = Long.parseLong(aux2);
                
                    
            if(ExceptionP.validarCuenta(numCuenta, listaCuentas) == true){
                while(menu2 != 0){
                    
                    System.out.println("\n 1. Consultar Saldo ");
                    System.out.println(" 2. Realizar Depósito ");
                    System.out.println(" 3. Realizar Retiro ");
                    System.out.println(" 4. Consultar Transacciones");
                    System.out.println(" 0. Salir. ");
                    menu2 = lector.nextInt();
                   
                    if(menu2 == 1){
                        transaccion.consultarSaldo(numCuenta, listaCuentas);
                    }
                    if(menu2 == 2){
                        System.out.println("Ingrese monto a depositar");
                        float m = lector.nextFloat();
                        transaccion.realizarDeposito(numCuenta,menu2, m, listaCuentas,listaTransacciones);
                    }
                    if(menu2 == 3){
                        System.out.println("Ingrese monto a retirar");
                        float m = lector.nextFloat();
                        transaccion.realizarRetiro(numCuenta,menu2 ,m, listaCuentas, listaTransacciones);
                    }
                    if(menu2 == 4){
                     transaccion.consultarTransaccion(numCuenta,listaTransacciones);
                      //transaccion.fecha(numCuenta,listaTransacciones);
                    }
                }   
                 
            }
        }
    }
}

}
