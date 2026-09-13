import java.util.Scanner;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("=====Analisador de frase=====");
		System.out.println("Escreva uma frase: ");
		
		String frase = scanner.nextLine();
		
		analisaCaracter(frase);
		
		analisadorPalavras(frase);
		
		System.out.println("Digite a letra para contar sua frequência: ");
		char letra = scanner.next().charAt(0);
		
		contarLetra(frase, letra);
		
		verificarPalindromo(frase);
		
		scanner.close();
	}
	
	public static void analisaCaracter(String frase)
	{
	    int total = frase.length();
	    int letra = 0;
	    int vogal = 0;
	    int consoante = 0;
	    int digitos = 0;
	    int espaco = 0;
	    int outrosCaracters = 0;
	    
	    String fraseMinuscula = frase.toLowerCase();
	    
	    for (int i = 0; i < frase.length(); i++)
	    {
	        char c = frase.charAt(i);
	        char cMin = fraseMinuscula.charAt(i);
	        
	        if (Character.isLetter(c))
	        {
	            letra++;
	            if (cMin == 'a' || cMin == 'e' || cMin == 'i' || cMin == 'o' || cMin == 'u')
                {
                    vogal++;
                }
                else
                {
                    consoante++;
                }
	        }
	        
	        else if (Character.isDigit(c))
            {
                digitos++;
            }
            
            else if (Character.isWhitespace(c))
            {
                espaco++;
            }
            else
            {
                outrosCaracters++;
            }
	    }
	    
	    System.out.println("Total de caracteres: " + total);
        System.out.println("Quantidade de letras: " + letra);
        System.out.println("Quantidade de vogais: " + vogal);
        System.out.println("Quantidade de consoantes: " + consoante);
        System.out.println("Quantidade de algarismos: " + digitos);
        System.out.println("Quantidade de espaços: " + espaco);
        System.out.println("Quantidade de outros caracteres: " + outrosCaracters);

	}
	
	public static void analisadorPalavras(String frase)
	{
	    String[] palavras = frase.trim().split("\\s+");
	    
	    int totalPalavras = palavras.length;
	    
	    String maiorPalavra = "";
	    
	    for (int i = 0; i < palavras.length; i++)
	    {
	        String palavraAtual = palavras[i];
	        
	        if(palavraAtual.length() > maiorPalavra.length())
	        {
	            maiorPalavra = palavraAtual;
	        }
	    }
	    
	    System.out.println("Quantidade de palavras: " + totalPalavras);
	    System.out.println("Maior palavra: " + maiorPalavra);
	}
	
	public static void contarLetra( String frase, char letraProcurada)
	{
	    int quantidade = 0;
	    
	    char letraMinuscula = Character.toLowerCase(letraProcurada);
	    
	    for (int i = 0; i < frase.length(); i++)
	    {
	        if(Character.toLowerCase(frase.charAt(i)) == letraMinuscula)
	        {
	            quantidade++;
	        }
	    }
	    
	    System.out.println("Frequência da letra '" + letraProcurada + "': " + quantidade);
	}
	
	public static void verificarPalindromo(String frase)
	{
	    String textoLimpo = "";
	    
	    for (int i = 0; i < frase.length(); i++)
	    {
	        char c = frase.charAt(i);
	        
	        if(Character.isLetterOrDigit(c))
	        {
	            textoLimpo += Character.toLowerCase(c);
	        }
	    }
	    
	    int inicio = 0;
	    
	    int fim = textoLimpo.length() - 1;
	    
	    boolean ehPalindromo = true;
	    
	    while (inicio < fim)
	    {
	        if (textoLimpo.charAt(inicio) != textoLimpo.charAt(fim))
	        {
	            ehPalindromo = false;
	            break;
	        }
	        
	        inicio++;
	        fim--;
	    }
	    
	    if (ehPalindromo)
	    {
	        System.out.println("A frase é um palíndromo.!");
	    }
	    else
	    {
	        System.out.println("A frase não é um palíndromo!");
	    }
	}
}
