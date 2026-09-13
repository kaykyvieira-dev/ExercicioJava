import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
		System.out.println("Digite o tamanho da lista: ");
		int tamanhoLista = scanner.nextInt();
		
		int[] lista = new int[tamanhoLista];
		
		for (int i = 0; i < tamanhoLista; i++)
		{
		    System.out.println("Digite o elemento da posição " + i + ": ");
		    lista[i] = scanner.nextInt();
		}
		
		System.out.println("Digite o valor alvo: ");
		int alvo = scanner.nextInt();
		
		buscarPares(lista, alvo);
		
		scanner.close();
	}
	
	public static void buscarPares(int[] lista, int alvo)
	{
	    int totalPares = 0;
	    
	    for (int i = 0; i < lista.length; i++)
	    {
	        for (int j = i + 1; j < lista.length; j++)
	        {
	            if (lista[i] + lista[j] == alvo)
	            {
	                totalPares++;
	                System.out.println("Par encontrado:");
	                System.out.println(" - Valores: " + lista[i] + " e " + lista[j]);
	                System.out.println(" - Índices: " + i + " e " + j);
	                System.out.println(" - Soma: " + (lista[i] + lista[j]));
	            }
	            
	        }
	    }
	    
	    if (totalPares == 0)
	    {
	        System.out.println("Nenhum par encontrado com a soma igual a " + alvo);
	    }
	    else
	    {
	        System.out.println("Quantidade total de pares encontrados: " + totalPares);
	    }
	}
}
