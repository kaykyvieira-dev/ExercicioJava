import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        int fileiras = 5;
        int poltronas = 10;
        boolean[][] sala = new boolean[fileiras][poltronas];
        
        int opcao = 0;
        
        while (opcao != 7)
        {
            System.out.println("===== SISTEMA DE RESERVAS DE CINEMA =====");
            System.out.println("1. Exibir mapa de assentos");
            System.out.println("2. Reservar um assento");
            System.out.println("3. Cancelar uma reserva");
            System.out.println("4. Informar ocupação (quantidade e %)");
            System.out.println("5. Identificar fileira com maior ocupação");
            System.out.println("6. Procurar assentos consecutivos");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao)
            {
                case 1:
                    exibirMapa(sala);
                    break;
                case 2:
                    reservarAssento(sala, scanner);
                    break;
                case 3:
                    cancelarReserva(sala, scanner);
                    break;
                case 4:
                    relatorioOcupacao(sala);
                    break;
                case 5:
                    fileiraMaiorOcupacao(sala);
                    break;
                case 6:
                    procurarConsecutivos(sala, scanner);
                    break;
                case 7:
                    System.out.println("Programa encerrado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    public static void exibirMapa(boolean[][] sala)
    {
        System.out.println("\n===== MAPA DE ASSENTOS (0 = Livre, X = Ocupado) =====");
        System.out.print("          ");
        for (int j = 0; j < sala.length; j++)
        {
            System.out.print("P" + j + " ");
        }
        System.out.println();
        
        for (int i = 0; i < sala.length; i++)
        {
            System.out.print("Fileira " + i + ": ");
            for (int j = 0; j < sala[i].length; j++)
            {
                if (sala[i][j])
                {
                    System.out.print(" X  ");
                }
                else
                {
                    System.out.print(" 0  ");
                }
            }
            System.out.println();
        }
    }
    
    public static void reservarAssento(boolean[][] sala, Scanner scanner)
    {
        System.out.print("Digite o número da fileira (0 a " + (sala.length - 1) + "): ");
        int f = scanner.nextInt();
        System.out.print("Digite o número da poltrona (0 a " + (sala.length - 1) + "): ");
        int p = scanner.nextInt();
        scanner.nextLine();
        
        if (f < 0 || f >= sala.length || p < 0 || p >= sala.length)
        {
            System.out.println("Erro: Posição fora dos limites da sala!");
        }
        else if (sala[f][p])
        {
            System.out.println("Erro: O assento na Fileira " + f + ", Poltrona " + p + " já está ocupado!");
        }
        else
        {
            sala[f][p] = true;
            System.out.println("Assento reservado com sucesso!");
        }
    }
    
    public static void cancelarReserva(boolean[][] sala, Scanner scanner)
    {
        System.out.print("Digite o número da fileira (0 a " + (sala.length - 1) + "): ");
        int f = scanner.nextInt();
        System.out.print("Digite o número da poltrona (0 a " + (sala.length - 1) + "): ");
        int p = scanner.nextInt();
        scanner.nextLine();
        
        if (f < 0 || f >= sala.length || p < 0 || p >= sala.length)
        {
            System.out.println("Erro: Posição fora dos limites da sala!");
        }
        else if (!sala[f][p])
        {
            System.out.println("Erro: O assento na Fileira " + f + ", Poltrona " + p + " já está livre!");
        }
        else
        {
            sala[f][p] = false;
            System.out.println("Reserva cancelada com sucesso!");
        }
    }
    
    public static void relatorioOcupacao(boolean[][] sala)
    {
        int totalAssentos = sala.length * sala.length;
        int ocupados = 0;
        
        for (int i = 0; i < sala.length; i++)
        {
            for (int j = 0; j < sala[i].length; j++)
            {
                if (sala[i][j])
                {
                    ocupados++;
                }
            }
        }
        
        double percentual = (double) ocupados / totalAssentos * 100;
        
        System.out.println("\n===== RELATÓRIO DE OCUPAÇÃO =====");
        System.out.println("Assentos ocupados: " + ocupados + " de " + totalAssentos);
        System.out.println("Percentual de ocupação: " + percentual + "%");
    }
    
    public static void fileiraMaiorOcupacao(boolean[][] sala)
    {
        int fileiraMaior = 0;
        int maxOcupados = -1;
        
        for (int i = 0; i < sala.length; i++)
        {
            int ocupadosFileira = 0;
            for (int j = 0; j < sala[i].length; j++)
            {
                if (sala[i][j])
                {
                    ocupadosFileira++;
                }
            }
            if (ocupadosFileira > maxOcupados)
            {
                maxOcupados = ocupadosFileira;
                fileiraMaior = i;
            }
        }
        
        System.out.println("\nFileira com maior ocupação: Fileira " + fileiraMaior + " (" + maxOcupados + " assentos ocupados)");
    }
    
    public static void procurarConsecutivos(boolean[][] sala, Scanner scanner)
    {
        System.out.print("Digite a quantidade de assentos consecutivos desejada: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        
        if (x <= 0 || x > sala.length)
        {
            System.out.println("Quantidade inválida para uma única fileira!");
            return;
        }
        
        boolean encontrou = false;
        
        for (int i = 0; i < sala.length; i++)
        {
            int consecutivos = 0;
            int inicioPoltrona = -1;
            
            for (int j = 0; j < sala[i].length; j++)
            {
                if (!sala[i][j])
                {
                    if (consecutivos == 0)
                    {
                        inicioPoltrona = j;
                    }
                    consecutivos++;
                    
                    if (consecutivos == x)
                    {
                        System.out.println("\nConjunto de " + x + " assentos consecutivos encontrado!");
                        System.out.println("Fileira: " + i);
                        System.out.println("Poltronas: de P" + inicioPoltrona + " até P" + j);
                        encontrou = true;
                        break;
                    }
                }
                else
                {
                    consecutivos = 0;
                    inicioPoltrona = -1;
                }
            }
            
            if (encontrou)
            {
                break;
            }
        }
        
        if (!encontrou)
        {
            System.out.println("Nenhum conjunto de " + x + " assentos consecutivos disponível em uma mesma fileira.");
        }
    }
}
