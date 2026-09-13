import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("=====Calendário=====");
	    
		System.out.println("Digite o dia do mês: ");
		int dia = scanner.nextInt();
        scanner.nextLine();
        
		System.out.println("Digite o mês: ");
		int mes = scanner.nextInt();
        scanner.nextLine();
        
		System.out.println("Digite o ano: ");
		int ano = scanner.nextInt();
        scanner.nextLine();
        
        boolean bissexto = verificarAno(ano);
        System.out.println("O ano é bissexto? " + bissexto);
        
        obterDiasDoMês(ano, mes);
        
        if (validarData(dia, mes, ano))
        {
            System.out.println("A data inserida é válida!");
            
            int trimestre = obterTrimestre(mes);
            System.out.println("Este mês pertence ao " + trimestre + "° trimestre do ano.");
            
            int posicao = calcularPosicao(dia, mes, ano);
            System.out.println("A posição deste dia no ano é: " + posicao + "° dia");
        }
        else
        {
            System.out.println("Data inserida é inválida!");
        }
        
        scanner.close();
	}
	
	public static boolean verificarAno(int ano)
    {
        if((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0))
        {
            return true; //é bissexto
        }
        else
        {
            return false; //ñ é bissexto
        }
    }
    
    public static int obterDiasDoMês(int ano, int mes)
    {
        if(mes == 2)
        {
            if(verificarAno(ano))
            {
                return 29;
            }
            
            return 28;
        }
        
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
        {
            return 30;
        }
        
        return 31;
    }
    
    public static boolean validarData(int dia, int mes, int ano)
    {
        if(ano <= 0)
        {
            return false;
        }
        
        if(mes <1 || mes > 12)
        {
            return false;
        }
        
        int limiteDias = obterDiasDoMês(ano, mes);
        
        if(dia < 1 || dia > limiteDias)
        {
            return false;
        }
        
        return true;
    }
    
    public static int obterTrimestre(int mes)
    {
        if(mes <= 3)
        {
            return 1;
        }
        
        if(mes <= 6)
        {
            return 2;
        }
        
        if(mes <= 9)
        {
            return 3;
        }
        
        return 4;
    }
    
    public static int calcularPosicao(int dia, int mes, int ano)
    {
        int somaDias = dia;
        
        for(int i = 1; i < mes; i++)
        {
            somaDias += obterDiasDoMês(ano, i);
        }
        
        return somaDias;
    }
    
}
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("=====Calendário=====");
	    
		System.out.println("Digite o dia do mês: ");
		int dia = scanner.nextInt();
        scanner.nextLine();
        
		System.out.println("Digite o mês: ");
		int mes = scanner.nextInt();
        scanner.nextLine();
        
		System.out.println("Digite o ano: ");
		int ano = scanner.nextInt();
        scanner.nextLine();
        
        boolean bissexto = verificarAno(ano);
        System.out.println("O ano é bissexto? " + bissexto);
        
        obterDiasDoMês(ano, mes);
        
        if (validarData(dia, mes, ano))
        {
            System.out.println("A data inserida é válida!");
            
            int trimestre = obterTrimestre(mes);
            System.out.println("Este mês pertence ao " + trimestre + "° trimestre do ano.");
            
            int posicao = calcularPosicao(dia, mes, ano);
            System.out.println("A posição deste dia no ano é: " + posicao + "° dia");
        }
        else
        {
            System.out.println("Data inserida é inválida!");
        }
        
        scanner.close();
	}
	
	public static boolean verificarAno(int ano)
    {
        if((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0))
        {
            return true; //é bissexto
        }
        else
        {
            return false; //ñ é bissexto
        }
    }
    
    public static int obterDiasDoMês(int ano, int mes)
    {
        if(mes == 2)
        {
            if(verificarAno(ano))
            {
                return 29;
            }
            
            return 28;
        }
        
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11)
        {
            return 30;
        }
        
        return 31;
    }
    
    public static boolean validarData(int dia, int mes, int ano)
    {
        if(ano <= 0)
        {
            return false;
        }
        
        if(mes <1 || mes > 12)
        {
            return false;
        }
        
        int limiteDias = obterDiasDoMês(ano, mes);
        
        if(dia < 1 || dia > limiteDias)
        {
            return false;
        }
        
        return true;
    }
    
    public static int obterTrimestre(int mes)
    {
        if(mes <= 3)
        {
            return 1;
        }
        
        if(mes <= 6)
        {
            return 2;
        }
        
        if(mes <= 9)
        {
            return 3;
        }
        
        return 4;
    }
    
    public static int calcularPosicao(int dia, int mes, int ano)
    {
        int somaDias = dia;
        
        for(int i = 1; i < mes; i++)
        {
            somaDias += obterDiasDoMês(ano, i);
        }
        
        return somaDias;
    }
    
}
