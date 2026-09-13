import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("=====Leitor de números=====");
		System.out.println("Digite um número inteiro (0 para encerrar): ");
		int numero = scanner.nextInt();
		
		if (numero == 0)
		{
		    System.out.println("Nenhum número válido foi informado!");
		}
		else
		{
		    int quantidade = 0;
		    int soma = 0;
		    int maior = numero;
		    int menor = numero;
		    int positivos = 0;
		    int negativos = 0;
		    int pares = 0;
		    int impares = 0;
		    int multiplosDeTres = 0;
		    
		    while (numero != 0)
		    {
		        quantidade++;
		        
		        soma += numero;
		        
		        if (numero > maior)
		        {
		            maior = numero;
		        }
		        
		        if (numero < menor)
		        {
		            menor = numero;
		        }
		        
		        if (ehPositivo(numero))
		        {
		            positivos++;
		        }
		        else
		        {
		            negativos++;
		        }
		        
		        if (ehPar(numero))
		        {
		            pares++;
		        }
		        else 
		        {
		            impares++;
		        }
		        
		        if (ehMultiploTres(numero))
		        {
		            multiplosDeTres++;
		        }
		        
		        numero = scanner.nextInt();
		    }
		    
		    double media = (double) soma / quantidade;
		    
		    System.out.println("Quantidade de números digitados: " + quantidade);
		    System.out.println("Soma dos valores digitados: " + soma);
		    System.out.println("Média geral: " + media);
		    System.out.println("Maior valor digitado: " + maior);
		    System.out.println("Menor valor digitado: " + menor);
		    System.out.println("Quantidade de números positivos: " + positivos);
		    System.out.println("Quantidade de números negativos: " + negativos);
		    System.out.println("Quantidade de números pares: " + pares);
		    System.out.println("Quantidade de números impares: " + impares);
		    System.out.println("Quantidade de números múltiplos de três: " + multiplosDeTres);
		}
		
		scanner.close();
	}
	
	public static boolean ehPar(int numero)
	{
	    return numero % 2 == 0;
	}
	
	public static boolean ehPositivo(int numero)
	{
	    return numero > 0;
	}
	
	public static boolean ehMultiploTres(int numero)
	{
	    return numero % 3 == 0;
	}
}
