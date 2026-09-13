import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
		System.out.println("=======Calculadora======");
		
		int opcao = 0;
		
		double num1 = 0;
		double num2 = 0;
		
		while (opcao != 7)
		{
		    System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Potenciação");
            System.out.println("6. Resto da Divisão");
            System.out.println("7. Encerrar");
    
            System.out.println("Escolha uma opção: ");
    
    
            opcao = scanner.nextInt();
            scanner.nextLine();
    
            System.out.println("Você escolheu a opção: " + opcao);
            
            if(opcao >= 1 && opcao <= 6)
            {
                System.out.println("Digite o primeiro número: ");
                num1 = scanner.nextDouble();
                scanner.nextLine();
            
                System.out.println("Digite o segundo número: ");
                num2 = scanner.nextDouble();
                scanner.nextLine();
            }
		
		    switch (opcao)
		    {
		        case 1:
		            System.out.println("Resultado da Soma foi de: " + somar(num1, num2));
		            break;
		        
                case 2:
		            System.out.println("Resultado da Subtração foi de: " + subtrair(num1, num2));
		            break;
		        
                case 3:
		            System.out.println("Resultado da Multiplicação foi de: " + multiplicar(num1, num2));
		            break;
		        
                case 4:
		            System.out.println("Resultado da Divisão foi de: " + dividir(num1, num2));
		            break;		
		        
                case 5:
		            System.out.println("Resultado da Potenciação foi de: " + potencia(num1, num2));
		            break;	
	        
                case 6:
		            System.out.println("O Resto de Divisão foi de: " + resto(num1, num2));
		            break;	        

                case 7:
		            System.out.println("Obrigado por utilizar a calculadora!");
		            break;
		       
                default:
                    System.out.println("Opção inválida.");
                    break;
		    }
	   }
		
		scanner.close();
	}
	
	public static double somar(double num1, double num2)
	{
	    return num1 + num2;
	}
	
	public static double subtrair(double num1, double num2)
	{
	    return num1 - num2;
	}
	
	public static double multiplicar(double num1, double num2)
	{
	    return num1 * num2;
	}
	
	public static double dividir(double num1, double num2)
	{
	    if(num2 ==0)
	    {
	        System.out.println("Erro divisão por zero.");
	        return 0;
	    }
	    return num1 / num2;
	}
	
	public static double potencia(double num1, double num2)
	{
	    return Math.pow(num1, num2);
	}
	
	public static double resto(double num1, double num2)
	{
	    if(num2 ==0)
	    {
	        System.out.println("Erro divisão por zero.");
	        return 0;
	    }
	    return num1 % num2;
	}
}
