import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== CAÇA-PALAVRAS MULTIDIRECIONAL =====");
        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = scanner.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = scanner.nextInt();
        scanner.nextLine();
        
        char[][] matriz = new char[linhas][colunas];
        
        System.out.println("\nDigite os caracteres da matriz (posição por posição):");
        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                String entrada = scanner.next();
                matriz[i][j] = Character.toUpperCase(entrada.charAt(0));
            }
        }
        
        System.out.print("\nDigite a quantidade de palavras a buscar: ");
        int qtdPalavras = scanner.nextInt();
        scanner.nextLine();
        
        String[] palavras = new String[qtdPalavras];
        for (int k = 0; k < qtdPalavras; k++)
        {
            System.out.print("Digite a palavra " + (k + 1) + ": ");
            palavras[k] = scanner.nextLine().trim().toUpperCase();
        }
        
        System.out.println("\n===== RESULTADOS DA BUSCA =====");
        for (int k = 0; k < qtdPalavras; k++)
        {
            buscarPalavra(matriz, palavras[k]);
        }
        
        scanner.close();
    }
    
    public static void buscarPalavra(char[][] matriz, String palavra)
    {
        int linhas = matriz.length;
        int colunas = matriz.length;
        
        int[] df = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] dp = {1, -1, 0, 0, 1, -1, -1, 1};
        
        String[] nomeDirecao = {
            "Horizontal da esquerda para a direita",
            "Horizontal da direita para a esquerda",
            "Vertical de cima para baixo",
            "Vertical de baixo para cima",
            "Diagonal superior esquerda para inferior direita",
            "Diagonal inferior direita para superior esquerda",
            "Diagonal superior direita para inferior esquerda",
            "Diagonal inferior esquerda para superior direita"
        };
        
        boolean encontrada = false;
        
        for (int i = 0; i < linhas && !encontrada; i++)
        {
            for (int j = 0; j < colunas && !encontrada; j++)
            {
                for (int d = 0; d < 8; d++)
                {
                    if (verificarDirecao(matriz, palavra, i, j, df[d], dp[d]))
                    {
                        encontrada = true;
                        int fimLinha = i + (palavra.length() - 1) * df[d];
                        int fimColuna = j + (palavra.length() - 1) * dp[d];
                        
                        System.out.println("Palavra '" + palavra + "' ENCONTRADA!");
                        System.out.println(" - Posição inicial: [" + i + "][" + j + "]");
                        System.out.println(" - Posição final: [" + fimLinha + "][" + fimColuna + "]");
                        System.out.println(" - Direção: " + nomeDirecao[d]);
                        System.out.println("================================");
                        break;
                    }
                }
            }
        }
        
        if (!encontrada)
        {
            System.out.println("Palavra '" + palavra + "' NÃO foi encontrada no caça-palavras.");
            System.out.println("==============================");
        }
    }
    
    public static boolean verificarDirecao(char[][] matriz, String palavra, int r, int c, int dr, int dc)
    {
        int linhas = matriz.length;
        int colunas = matriz.length;
        int len = palavra.length();
        
        int fimR = r + (len - 1) * dr;
        int fimC = c + (len - 1) * dc;
        
        if (fimR < 0 || fimR >= linhas || fimC < 0 || fimC >= colunas)
        {
            return false;
        }
        
        for (int k = 0; k < len; k++)
        {
            if (matriz[r + k * dr][c + k * dc] != palavra.charAt(k))
            {
                return false;
            }
        }
        
        return true;
    }
}
