/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masivian.test.client;

import com.masivian.test.wsdl.Calculator;

/**
 *
 * @author ingru
 */
public class CalculatorClient {
    Calculator c;
    
    public long getOperacion(long a, long b, int operacion){
       long resultado = 0;
       c = new Calculator();
       switch(operacion){
           case 1: resultado = c.getCalculatorSoap().add((int)a, (int)b);
           break;  
               
           case 2: resultado = c.getCalculatorSoap().divide((int)a, (int)b);
           break; 
               
           case 3: resultado = c.getCalculatorSoap().multiply((int)a, (int)b);
           break; 
               
           case 4: resultado = c.getCalculatorSoap().subtract((int)a, (int)b);
           break; 
       }
       return resultado;
    }
    
}
