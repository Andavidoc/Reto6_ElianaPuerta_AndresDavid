package com.mycompany.reto_6;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Transaccion {
    private String tipoTransaccion;
    private LocalDate fecha = null;
    private float monto;
    private String paisLinea;
    private long numCuenta;
    private static int intentoDiario = 0;
    
    ArrayList<LocalDate> fechas = new ArrayList();
    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    
    
    Cuenta cuenta = new Cuenta("iniciar");
    
    Scanner lector = new Scanner(System.in);

    public Transaccion(String iniciar){}
    
    public Transaccion(long numCuenta, int tipoTransaccion, float monto, ArrayList<Cuenta> listaCuentas, ArrayList<Transaccion> listaTransacciones){
                
        for ( int j = 0; j < listaCuentas.size(); j++ ){
            if( numCuenta == listaCuentas.get(j).getNumCuenta()){
            this.numCuenta = numCuenta;
            this.paisLinea = listaCuentas.get(j).getPaisLinea();
            if(tipoTransaccion == 2){
            this.tipoTransaccion = "Deposito";
            }
            if(tipoTransaccion == 3){
            this.tipoTransaccion = "Retiro";
            }
            System.out.println("Ingrese la fecha en format: dd-MM-yyy");
            String fechaString = lector.nextLine();
            try {       
            this.fecha = LocalDate.parse(fechaString,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }catch (Exception e){System.out.println("invalid format");}
            
            fechas.add(this.fecha);
            if(!fecha(numCuenta,listaTransacciones)){
                this.fecha = null;
            }
            this.monto = monto;
            }
            
        }
    } 
    public boolean fecha(long numCuenta,ArrayList<Transaccion> listaTransacciones){
        int cont = 0;
        for(int i = 0; i < listaTransacciones.size(); i++) {
        if(numCuenta == listaTransacciones.get(i).numCuenta && this.fecha.compareTo(listaTransacciones.get(i).fecha) == 0){
            cont ++;
        }   
        }
        if(cont >= cuenta.getMaximoTransaccionDia()){
            return false;
        }  
        else{
            return true;
        }
        
    }
    public void realizarDeposito(long numCuenta,int tipoTransaccion, float monto, ArrayList<Cuenta> listaCuentas,ArrayList<Transaccion> listaTransacciones)  {
        
        if(monto > cuenta.montoMaximo()){
            System.out.println("El valor a superado el monto máximo!!");   
        }else if(monto < 0 ){
            System.out.println("Error..El monto debe ser positivo!!");
        }
        else{
        boolean encontrado = false;
        for ( int j = 0; j < listaCuentas.size(); j++){
            if( numCuenta == listaCuentas.get(j).getNumCuenta()){
                
                listaTransacciones.add(new Transaccion(numCuenta,tipoTransaccion,monto,listaCuentas,listaTransacciones));
                if(listaTransacciones.get(listaTransacciones.size()-1).fecha == null){
                    listaTransacciones.remove(listaTransacciones.size()-1);
                    System.out.println("Se han realizado el numero maximo de transacciones diarias");
                    return;
                }
                listaCuentas.get(j).depositar(monto);
                encontrado = true;
                System.out.println("Se depositaron " + monto + " Exitosamente a su cuenta!!");
            }
        }
        if(encontrado == false){
            System.out.println("El número de cuenta " + numCuenta + " no existe!!");
        } 
        }
        
        
    }

    public void realizarRetiro(long numCuenta,int tipoTransaccion, float monto,  ArrayList<Cuenta> listaCuentas, ArrayList<Transaccion> listaTransacciones) {
        
        if(monto > cuenta.montoMaximo()){
            System.out.println("El valor ha superado el monto maximo");
        }
       
        else if(monto < 0 ){
            System.out.println("Error..El monto debe ser positivo!!");
        }
        else{
        boolean encontrado = false;
        for ( int j = 0; j < listaCuentas.size(); j++){
            if( monto > listaCuentas.get(j).getSaldoDisponible()){
            System.out.println("Saldo insuficiente en la cuenta!!");
        }
          else  if( numCuenta == listaCuentas.get(j).getNumCuenta()){
                
                listaTransacciones.add(new Transaccion(numCuenta,tipoTransaccion,monto,listaCuentas,listaTransacciones));
                if(listaTransacciones.get(listaTransacciones.size()-1).fecha == null){
                   listaTransacciones.remove(listaTransacciones.size()-1);
                    System.out.println("Se han realizado el numero maximo de transacciones diarias");
                    return;
                    
                }
                listaCuentas.get(j).retirar(monto);
                encontrado = true;
                System.out.println("Se Retiraron " + monto + " Exitosamente de su cuenta");
            }
        }
        if(encontrado == false){
            System.out.println("El número de cuenta " + numCuenta + " no existe!!");
        } 
        }
        
           
    }
    public void consultarSaldo(long numCuenta,  ArrayList<Cuenta> listaCuentas) {
        boolean encontrado = false;
        for ( int j = 0; j < listaCuentas.size(); j++){
            if( numCuenta == listaCuentas.get(j).getNumCuenta()){
                System.out.println("El saldo disponible es:");
                System.out.println(listaCuentas.get(j).getSaldoDisponible());
                encontrado = true;
            }
        }
        
        if(encontrado == false){
            System.out.println("El número de cuenta "+ numCuenta + " no existe!!");
          
        }
    }
    public void consultarTransaccion(long numCuenta, ArrayList<Transaccion> listaTransacciones) {
        boolean encontrado = false;
        
        for ( int j = 0; j < listaTransacciones.size(); j++){
            if( numCuenta == listaTransacciones.get(j).numCuenta){
                System.out.println("Numero de Cuenta:");
                System.out.println(listaTransacciones.get(j).numCuenta);
                System.out.println("País de la Linea:");
                System.out.println(listaTransacciones.get(j).paisLinea);
                System.out.println("Tipo de transacción realizada:");
                System.out.println(listaTransacciones.get(j).tipoTransaccion);
                System.out.println("Monto de la transaccion:");
                System.out.println(listaTransacciones.get(j).monto);
                System.out.println("Fecha de la transaccion:");
                System.out.println(listaTransacciones.get(j).fecha);
        
                encontrado = true;
            }
        }
        
        if(encontrado == false){
            System.out.println("La cuenta "+ numCuenta + " no tiene transacciones realizadas!!");
            
        } 
    }
}