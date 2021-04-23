package com.mycompany.reto_6;

import java.util.ArrayList;
import java.util.Scanner;

public class Cuenta {
    private long numCuenta;
    private String paisLinea;
    private String tipoDocumento;
    private int idenTitular;
    private String nombreTitular;
    private float saldoDisponible;
    private static final float montoMaximo = 50000000;
    private static final int maxTransaccionesDia = 4;
    
   
    Scanner lector = new Scanner(System.in);
    
    public Cuenta( String iniciar){
    }
    
    public Cuenta() {
        
        String num = "9999999999";
        do {
        if(num.length() != 10){
            System.out.println("La cuenta debe tener 10 digitos");
        }
        System.out.println("Número de Cuenta: ");
        num = lector.next(); 
       }while(!ExceptionP.IsInteger(num) || num.length() != 10);
         
        this.numCuenta = Long.parseLong(num);
        lector.nextLine();
        System.out.println("País de la linea Movil:");
        this.paisLinea = lector.nextLine();
        System.out.println("Tipo de documento del titular:");
        this.tipoDocumento = lector.nextLine();
        
        do {

            System.out.println("Identificación del titular de la cuenta:");       
            num = lector.nextLine(); 
       
       }while(!ExceptionP.IsInteger(num));

        this.idenTitular = Integer.parseInt(num);
        System.out.println("Nombre completo del titular de la cuenta: ");
        this.nombreTitular = lector.nextLine();
        this.saldoDisponible = 0;
    }
    
    
    public void agregarCuenta(ArrayList<Cuenta> listaCuentas) {
        listaCuentas.add(new Cuenta());
        System.out.println("Cuenta creada exitosamente!!");
        
        
    }    
     public void consultarCuenta(long i, ArrayList<Cuenta> listaCuentas) {
        boolean encontrado = false;
        for ( int j = 0; j < listaCuentas.size(); j++){
            if( i == listaCuentas.get(j).getNumCuenta()){
                System.out.println("Numero de Cuenta:");
                System.out.println(listaCuentas.get(j).getNumCuenta());
                System.out.println("País de la Linea:");
                System.out.println(listaCuentas.get(j).getPaisLinea());
                System.out.println("Tipo de Documento del Titular de la Cuenta:");
                System.out.println(listaCuentas.get(j).getTipoDocumento());
                System.out.println("Identificación del Titular de la Cuenta:");
                System.out.println(listaCuentas.get(j).getIdenTitular());
                System.out.println("Nombre del Titular de la Cuenta:");
                System.out.println(listaCuentas.get(j).getNombreTitular());
                System.out.println("Saldo Disponible:");
                System.out.println(listaCuentas.get(j).getSaldoDisponible());
                encontrado = true;
            }
        }
        
        if(encontrado == false){
            System.out.println("El número de cuenta "+ i + " no existe!!");
            
        } 
    }
     
    public void eliminarCuenta(long i, ArrayList<Cuenta> listaCuentas) {
        
        boolean encontrado = false;
        for ( int j = 0; j < listaCuentas.size(); j++){
            if( i == listaCuentas.get(j).getNumCuenta()){
                listaCuentas.remove(j);
                encontrado = true;
                System.out.println("La cuenta " + i + " fue eliminada exitosamente!!");
            }
        }
        if(encontrado == false){
            System.out.println("El número de cuenta " + i + " no se pudo eliminar porque no existe!!");
        } 
    }
  
    public void depositar(float i) {
        this.saldoDisponible = this.saldoDisponible + i;
    }
    
    public void retirar(float i){
        this.saldoDisponible = this.saldoDisponible - i;
    }
     
    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta() {
        System.out.println("Ingrese el número de la cuenta:");
        this.numCuenta = lector.nextInt();
    }
  
    public String getPaisLinea() {
        return paisLinea;
    }

    public void setPaisLinea() {
        System.out.println("Digite el país de la linea movil:");
        this.paisLinea = lector.nextLine();
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento() {
        System.out.println("Ingrese el tipo de documento del titular:");
        this.tipoDocumento = lector.nextLine();
    }

    public int getIdenTitular() {
        return idenTitular;
    }

    public void setIdenTitular() {
        System.out.println("Ingrese el número de documento del titular:");
        this.idenTitular = lector.nextInt();
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular() {
        System.out.println("Ingrese el nombre del titular de la cuenta:");
        this.nombreTitular = lector.nextLine();
    }

    public float getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible() {
        System.out.println("Digite el saldo disponible:");
        this.saldoDisponible = lector.nextFloat();
    }
    
    public float montoMaximo() {
        return montoMaximo;
    }
    
    public int getMaximoTransaccionDia() {
        return maxTransaccionesDia;
    }
}
