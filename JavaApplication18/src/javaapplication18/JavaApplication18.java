/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.Stack;
import java.lang.Object;
import java.lang.System;
/**
 *
 * @author NobleTalal
 */
public class JavaApplication18 {

    static int f(int a)
    {
        
        return System.identityHashCode((Object) a);
    }
    
    public static void main(String[] args) 
    {        
       int a = 0; 
       a = System.identityHashCode((Object) a);
       System.out.println("a is " + a);
       
       a = f(a);
       
       System.out.println("now a is " + a);
        
    }
 
}
