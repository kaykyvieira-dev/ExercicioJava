import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Olá, digite seu nome: ");
        String nome = sc.nextLine();
        
        System.out.println("Olá" + nome + ", digite a nota 1 (0 a 10): ");
        double nota1 = sc.nextDouble();
        
        System.out.println("Digite a nota 2 (0 a 10): ");
        double nota2 = sc.nextDouble();
        
        System.out.println("Digite a nota 3 (0 a 10): ");
        double nota3 = sc.nextDouble();
        
        System.out.print("Digite seu percentual de frequência (0 a 100): ");
        double frequencia = sc.nextDouble();
        
        double media = calcularMedia(nota1, nota2, nota3);
        
        String aprovacao = aprovar(media, frequencia);
        
        System.out.println("Estudante: " + nome);
        System.out.printf("Média: %.2f\n", media);
        System.out.printf("Frequência: %.1f%%\n", frequencia);
        System.out.println("Situação: " + aprovacao);
        
        sc.close();
    }
    
    public static double calcularMedia(double nota1, double nota2, double nota3) 
    {
        return (nota1 + nota2 + nota3) / 3;
    }
    
    public static String aprovar(double media, double frequencia)
    {
        if(frequencia < 75)
        {
            return("Reprovado por frequência.");
        }
        else if (media >= 7)
        {
            return("Aprovado");
        }
        else if (media >= 5 && media <= 6.99) 
        {
            return("Recuperação.");
        }
        else
        {
            return("Reprovado por nota.");
        }
    }
}
