/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author NobleTalal
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String answer;
        //secondNum = Double.parseDouble(jTxtDisplay.getText());
        //String txt = jTxtDisplay.getText();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter you equation: ");
        String eq = keyboard.nextLine();
        double result;
        
        char [] check = eq.toCharArray();
        int lp = 0, rp = 0;
        for (int i=0; i < check.length; i++)
        {
            if (check[i] == '(')
            {
                lp++;
            }
            if (check[i] == ')')
            {
                rp++;
            }
        }
        
        if (lp != rp)
        {
            //jTxtDisplay.setText("Syntax Error");
            //return;
        }
        else
        {
            Stack<String> opstack = new Stack<String>();
            ArrayList<String> output = new ArrayList<String>();
           
            
            for(int i=0; i < check.length; i++)
            {
                boolean operator;
                if (check[i] == '+' || check[i] == '-' || check[i] == '*' || check[i] == '/' || check[i] == '%' || check[i] == '^')
                    operator = true;
                else
                    operator = false;
               
                
                if (check[i] != '+' && check[i] != '-' && check[i] != '*' && check[i] != '/' && check[i] != '%' && check[i] != '^'  && check[i] != ')' && check[i] != '(')
                {
                    output.add(output.size(), "" + check[i]);
                    /*
                    int index = i;
                    while (check[index] != '+' && check[index] != '-' && check[index] != '*' && check[index] != '/' && check[index] != '%' && check[i] != ')' && check[i] != '(')
                    {
                        
                        index++;
                        if (index >= check.length)
                            break;
                    }
*/
                    //output.add(output.size(), "" + check[i]);
                }
                else if (check[i] == '(')
                {
                    if (check[i-1] != '+' && check[i-1] != '-' && check[i-1] != '*' && check[i-1] != '/' && check[i-1] != '%' && check[i-1] != '^' )
                        opstack.push("*");
                    opstack.push("" + check[i]);
                    
                }
                
                else if (check[i] == ')')
                   {
                      // int index = i;
                       while (!opstack.peek().equals("("))
                       {
                           if (check[i] != '(')
                                output.add(output.size(), opstack.peek());
                           opstack.pop();
                       }
                   }
                else if (check[i] == '+' || check[i] == '-' || check[i] == '*' || check[i] == '/' || check[i] == '%' || check[i] == '^' )
                {
                    if (check[i] == '*' || check[i] == '/')
                    {
                        if (opstack.isEmpty())
                            opstack.push("" + check[i]);
                            
                        else if (opstack.peek().equals('^'))
                        {
                            output.add(output.size(), opstack.peek());
                            opstack.pop();
                            
                        }
                        else
                            opstack.push("" + check[i]);
                            
                        
                    }
                    else if (check[i] == '+' || check[i] == '-')
                    {
                        if (opstack.isEmpty())
                            opstack.push("" + check[i]);
                        
                        else if (opstack.peek().equals('*') || opstack.peek().equals('/') || opstack.peek().equals('^'))
                        {
                            output.add(output.size(), opstack.peek());
                            opstack.pop();
                        }
                        else
                            opstack.push("" + check[i]);
                        }
                    }
                   
                   }
            
                   /*
                    else
                       opstack.push("" + check[i]);
*/
                      for (int i=0; i < output.size(); i++)
                          System.out.println(output.get(i));
               
            
            
            while (!opstack.isEmpty())
            {
                if (!opstack.peek().equals("("))
                output.add(output.size(), opstack.peek());
                opstack.pop();
            }
            /////////////////////
            
            boolean digit = false;
            Stack<String> operandStack = new Stack<String>();
            for (int i=0; i < output.size(); i++)
            {
                System.out.println("output array at: " + i + " is " + output.get(i));
                for (int j=0; j < output.get(i).length(); j++)
                {
                    if (Character.isDigit(output.get(i).charAt(j)))
                        digit = true;
                    else
                        digit = false;
                }
               // System.out.println("state of digit is " + digit);
                
                if (digit == true)
                {
                    operandStack.push(output.get(i));
                    
                }
                else
                {
                    
                    String operation = output.get(i);
                    double num2 = Double.parseDouble(operandStack.peek());
                    operandStack.pop();
                    double num1 = Double.parseDouble(operandStack.peek());
                    operandStack.pop();
                    
                   // System.out.println("num1 is " + num1 + "num2 is " + num2);
                    
                    if (operation.equals("+"))
                    {
                        result = num1 + num2;
                        answer = String.format("%.0f", result);
                        //jTxtDisplay.setText(answer);
                        operandStack.push(answer);
                        
                        //System.out.println("DONE");
                    }
                    else if (operation.equals("-"))
                    {
                        result = num1 - num2;
                        answer = String.format("%.0f", result);
                        operandStack.push(answer);
                    }
                    else if (operation.equals("*"))
                    {
                        result = num1 * num2;
                        answer = String.format("%.0f", result);
                        operandStack.push(answer);
                    }
                    else if (operation.equals("/"))
                    {
                        if (num2 == 0)
                        {
                            //jTxtDisplay.setText("Undefined");

                        }
                        else
                        {
                            result = num1 / num2;
                            answer = String.format("%.0f", result);
                            operandStack.push(answer);
                        }
                    }
                    else if (operation.equals("^"))
                    {
                        result = java.lang.Math.pow(num1, num2);
                        answer = String.format("%.0f", result);
                        operandStack.push(answer);
                        
                    }
                }
                
                
                
                
                    
            }
            String bla = operandStack.peek();
            System.out.println(bla);
            
        }
    }
    
}
