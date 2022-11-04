
package lab4p1_tatianagarcia;
import java.util.Scanner;
/**
 *
 * @author tatig
 */
public class Lab4P1_TatianaGarcia {
    static Scanner leer = new Scanner (System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        
        do 
        {
            System.out.println();
            System.out.println("--> Menu <--");
            System.out.println("1 -> Sumador Binario");
            System.out.println("2 -> Contains");
            System.out.println("3 -> Alpha");
            System.out.println("4 -> Salir");
            System.out.println();
            System.out.println(">> Ingrese una opcion: ");
            opcion = leer.nextInt();
            
            switch (opcion)
            {
                case 1: {
                    
                    System.out.println();
                    System.out.println("-- Sumador Binario --");
                    System.out.println();
                    System.out.println(">> Ingrese una cadena: ");
                    String num = leer.next();
                    System.out.println(">> Ingrese otra cadena: ");
                    String num2 = leer.next();
                    System.out.println();
                    SumadorBinario(num, num2);
                    break;
                }
                   
                    
                case 2: {
                    
                    System.out.println();
                    System.out.println("-- Contains --");
                    System.out.println();
                    System.out.println(">> Ingrese una cadena: ");
                    String contenedor = leer.next();
                    System.out.println(">> Ingrese otra cadena: ");
                    String contenida = leer.next();
                    System.out.println();
                    Contains(contenedor, contenida);
                    break;
                    
                }
                   
                    
                case 3: {
                    
                    System.out.println();
                    System.out.println("-- Alpha --");
                    System.out.println();
                    System.out.println(">> Ingrese una cadena: ");
                    String cadena = leer.next();
                    
                    System.out.println();
                    Alpha(cadena);
                    break;
                }
                     
                
                default: {
                    System.out.println();
                    System.out.println(">> Salida...");
                    break; 
                }
      
            }//Fin del switch 
            
            
        }while (opcion < 4);
        
        
    }//Fin del main
    
    public static void SumadorBinario(String num, String num2)
    {
        int valid = 0;
        int valid2 = 0;
        
        //Validar primer cadena
        for (int i=0; i < num.length(); i++)
        {
            char c = num.charAt(i);
            if (c != '1'&& c!= '0')
            {
                System.out.println(">> El primer número contiene caracteres distintos de '0' y '1'.");
                valid = 0;
                break;
            }
            else 
            {
                valid = 0;
                valid++;
            }
        }
        
        //Validar segunda cadena
        for (int i=0; i < num2.length(); i++)
        {
            char c = num2.charAt(i);
            if (c != '1'&& c!= '0')
            {
                System.out.println(">> El segundo número contiene caracteres distintos de '0' y '1'.");
                valid2= 0;
                break;
            }
            else 
            {
                valid2 = 0;
                valid2++;
            }
        }
        
        //Programa
        String digit = "", resultado = "", uno = "";
        int suma = 0;
        
        
        if (valid>0 && valid2>0)
        {
            System.out.println(">> Bien");
            
            for (int i = num.length()-1; i >= 0; i--)
            {
                char c = num.charAt(i);
                
                /*for (int j = num2.length()-1; j >= i; j--)
                {*/
                    char d = num2.charAt(i);
                    
                    if (c == '0'&& d == '0')
                    {
                        
                        if (suma == 1)
                        {
                            digit = "1";
                            resultado += digit;
                            suma = 0;
                        }
                        else 
                        {
                           digit = "0";
                           resultado += digit; 
                        }
                    }
                    else if ((c == '1' && d == '0')||(c == '0' && d == '1'))
                    {
                        if (suma == 1)
                        {
                            digit = "0";
                            resultado += digit;
                        }
                        else 
                        {
                            digit = "1";
                            resultado += digit;
                        }
                        
                    }
                    else if (c == '1'&& d == '1')
                    {
                        if (suma == 1)
                        {
                            digit = "1";
                            resultado += digit;
                        }
                        else 
                        {
                            digit = "0";
                            resultado += digit;
                            suma = 1;
                        }
                        
                        
                    }
                    else if (i == num2.length()-1)//con las suma
                    {
                        if (suma == 1)
                        {
                            digit = "1";
                            resultado += digit;
                        }
                        else {
                            break;
                        }
                         
                    }
                //}
            }//For 
            if (suma ==1)
            {
                digit = "1";
                resultado += digit;
            }
        }
        else{}
        
        String inversa = "";
                    
        for (int i = resultado.length()-1; i>= 0; i--)
        {
            inversa += resultado.charAt(i);
        }
        System.out.println(inversa);
        
        
        
    }
    
    public static void Contains(String contenedor, String contenida)
    {
        String acum_c = "";
        if (contenedor.length() < contenida.length())
        {
            System.out.println(">> El tamaño de la segunda cadena no puede ser mayor que el de la primera");
        }
        else 
        {
            for (int i = 0; i < contenedor.length()-1; i++)
            {
                char c = contenedor.charAt(i);
                char e = contenedor.charAt(i+1);
                
                for (int j = i; j < contenida.length()-1; j++)
                {
                    char d = contenida.charAt(j);
                    char f = contenida.charAt(i+1);
                    if ( d == c && e == f)
                    {
                        acum_c += d;
                    }
                    else if (j == contenida.length())
                    {
                        if (d == c)
                        {
                            acum_c += d;
                        }
                    }
                }
                
                
            }
        }
        if (acum_c == contenida)
        {
            System.out.println(">> La cadena "+contenedor+" contiene a la cadena "+contenida);
        }
        else 
        {
            System.out.println(">> La cadena "+contenedor+" no contiene a la cadena "+contenida);
        }
        
    }
    public static void Alpha(String cadena)
    {
        int ASCII=0;
        boolean valid= true; 

        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);
            ASCII = (int) c;
            
            if (ASCII <= 97 || ASCII >= 122)
            {
                System.out.println(">> La cadena contiene caracteres que no son letras");
                valid = false; 
            }
            
        }
        
        if (valid)
        {
            System.out.println(">> La cadena solo contiene letras");
        }
        else 
        {
            
        }
          
    }//Fin del metodo
    
}//Fin de la clase
