import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de participantes: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        
        String[] nomes = new String[quantidade];
        double[] tempos = new double[quantidade];
        
        lerDados(scanner, nomes, tempos);
        
        exibirDados(nomes, tempos);
        
        double media = calcularMedia(tempos);
        System.out.println("=====Média de tempo dos participantes=====");
        System.out.printf("Média: %.2fs%n", media);
        
        analisarDesempenho(tempos, media);
        
        analiseTempo(tempos, nomes);
        
        ranking(nomes, tempos);
        
        double mediana = calcularMediana(tempos);
        System.out.println("=====Mediana=====");
        System.out.printf("A mediana dos tempos é: %.2fs%n", mediana);
        
        double desvioPadrao = calcularDp(tempos, media);
        System.out.println("=====Desvio Padrão=====");
        System.out.printf("O desvio padrão é: %.2fs%n", desvioPadrao);
        
        scanner.close();
    }
    
    public static void lerDados(Scanner scanner, String[] nomes, double[] tempos)
    {
        
        for(int i = 0; i < nomes.length; i++)
        {
            System.out.printf("%nNome da Participante %d: ", i + 1);

            nomes[i] = scanner.nextLine();
        
            System.out.print("Tempo em (segundos): ");
            tempos[i] =  scanner.nextDouble();
            scanner.nextLine();
        }
    }
    
    public static void exibirDados(String[] nomes, double[] tempos)
    {
       for(int i = 0; i < nomes.length; i++)
       {
           System.out.println("=====Lista Participantes=====");
           System.out.printf("Participantes: %d: %s Tempo %.2fs%n", (i + 1), nomes[i], tempos[i]);
       } 
    }
    
    public static double calcularMedia(double[] tempos)
    {
        double soma = 0;
        
        for(int i = 0; i < tempos.length; i++)
        {
            soma += tempos[i];
        }
        
        if (tempos.length == 0)
        {
            return 0.0;
        }
        return soma / tempos.length;
    }
    
    public static void analisarDesempenho(double[] tempos, double media)
    {
        int acima = 0;
        int abaixo = 0;
        
        for(int i = 0; i < tempos.length; i++)
        {
            if(tempos[i] > media)
            {
                acima++;
            }
            else if (tempos[i] < media)
            {
                abaixo++;
            }
        }
        
        System.out.println("=====Acima e abaixo da média=====");
        System.out.println("Participantes acima da média: " + acima);
        System.out.println("Participantes abaixo da média: " + abaixo);
    }
    
    public static void analiseTempo(double[] tempos, String[] nomes)
    {
        if (tempos == null || tempos.length == 0) 
        {
            System.out.println("Sem tempos registrados.");
            return;
        }
        
        double maiorTempo = tempos[0];
        double menorTempo = tempos[0];
        
        String nomeMaior = nomes[0];
        String nomeMenor = nomes[0];
        
        for(int i = 1; i < tempos.length; i++)
        {
            if(tempos[i] > maiorTempo)
            {
                maiorTempo = tempos[i];
                nomeMaior = nomes[i];
            }
            
            if(tempos[i] < menorTempo)
            {
                menorTempo = tempos[i];
                nomeMenor = nomes[i];
            }
        }
        
        System.out.println("=====Maior e menor tempo=====");
        System.out.println(nomeMaior + " fez o maior tempo: " + maiorTempo + "s");
        System.out.println(nomeMenor + " fez o menor tempo: " + menorTempo + "s");
    }
    
    public static void ranking(String[] nomes, double[] tempos)
    {
        System.out.println("=====Ranking=====");
        
        int n = tempos.length;
        
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1 - i; j++) 
            {
                if (tempos[j] > tempos[j+1]) 
                {
                    double tempTempo = tempos[j];
                    tempos[j] = tempos[j+1];
                    tempos[j+1] = tempTempo;
                    
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j+1];
                    nomes[j+1] = tempNome;
                }
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            System.out.printf("%d° lugar: %s - %.2fs%n", (i + 1), nomes[i], tempos[i]);
        }
    }
    
    public static double calcularMediana(double[] tempos)
    {
        int n = tempos.length;
        
        if (n == 0) 
        {
        return 0.0;
        }
        
        if (n % 2 == 0)
        {
            double meiaEsquerda = tempos[(n / 2) - 1];
            double meiaDireita = tempos[n / 2];
            return (meiaEsquerda + meiaDireita) / 2;
        }
        else 
        {
            return tempos[n / 2];
        }
    }
    
    public static double calcularDp(double[] tempos, double media)
    {
        int n = tempos.length;
        double somatorio = 0;
        
        for(int i = 0; i < n; i ++)
        {
            double diferenca = tempos[i] - media;
            somatorio += diferenca * diferenca;
            
        }
        
        double variancia = somatorio / n;
        
        return Math.sqrt(variancia);
    }
}
