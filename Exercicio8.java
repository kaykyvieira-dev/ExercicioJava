import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();
        
        int opcao = 0;
        
        while (opcao != 9)
        {
            System.out.println("\n===== Gerenciador de Lista de Compras =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Alterar quantidade");
            System.out.println("3. Alterar preço");
            System.out.println("4. Remover produto");
            System.out.println("5. Pesquisar produto por nome");
            System.out.println("6. Listar todos os produtos");
            System.out.println("7. Calcular valor total da compra");
            System.out.println("8. Identificar produto com maior subtotal");
            System.out.println("9. Encerrar");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao)
            {
                case 1:
                    adicionarProduto(nomes, quantidades, precos, scanner);
                    break;
                    
                case 2:
                    alterarQuantidade(nomes, quantidades, scanner);
                    break;
                    
                case 3:
                    alterarPreco(nomes, precos, scanner);
                    break;
                    
                case 4:
                    removerProduto(nomes, quantidades, precos, scanner);
                    break;
                    
                case 5:
                    pesquisarProduto(nomes, quantidades, precos, scanner);
                    break;
                    
                case 6:
                    listarProdutos(nomes, quantidades, precos);
                    break;
                    
                case 7:
                    calcularTotal(nomes, quantidades, precos);
                    break;
                    
                case 8:
                    maiorSubtotal(nomes, quantidades, precos);
                    break;
                    
                case 9:
                    System.out.println("Programa encerrado com sucesso!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    
        scanner.close();
    }
    
    public static void adicionarProduto(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos, Scanner scanner)
    {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        
        int indiceExistente = buscarIndice(nomes, nome);
        
        if (indiceExistente != -1)
        {
            System.out.print("Produto já cadastrado! Deseja adicionar mais unidades? (1-Sim / 2-Não): ");
            int resp = scanner.nextInt();
            scanner.nextLine();
            
            if (resp == 1)
            {
                System.out.print("Digite a quantidade a ser somada: ");
                int qtdAdicional = scanner.nextInt();
                scanner.nextLine();
                
                if (qtdAdicional > 0)
                {
                    int novaQtd = quantidades.get(indiceExistente) + qtdAdicional;
                    quantidades.set(indiceExistente, novaQtd);
                    System.out.println("Quantidade atualizada com sucesso!");
                }
                else
                {
                    System.out.println("Quantidade inválida!");
                }
            }
        }
        else 
        {
            System.out.print("Digite a quantidade: ");
            int qtd = scanner.nextInt();
            System.out.print("Digite o preço unitário: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();
            
            if (qtd > 0 && preco > 0)
            {
                nomes.add(nome);
                quantidades.add(qtd);
                precos.add(preco);
                System.out.println("Produto adicionado com sucesso!");
            }
            else
            {
                System.out.println("Quantidade e preço devem ser maiores que zero!");
            }
        }
    }
    
    public static void alterarQuantidade(ArrayList<String> nomes, ArrayList<Integer> quantidades, Scanner scanner)
    {
        System.out.print("Digite o nome do produto para alterar a quantidade: ");
        String nome = scanner.nextLine();
        int idx = buscarIndice(nomes, nome);
        
        if (idx != -1)
        {
            System.out.print("Digite a nova quantidade: ");
            int novaQtd = scanner.nextInt();
            scanner.nextLine();
            
            if (novaQtd > 0)
            {
                quantidades.set(idx, novaQtd);
                System.out.println("Quantidade alterada com sucesso!");
            }
            else
            {
                System.out.println("A quantidade deve ser maior que zero!");
            }
        }
        else
        {
            System.out.println("Produto não encontrado!");
        }
    }
    
    public static void alterarPreco(ArrayList<String> nomes, ArrayList<Double> precos, Scanner scanner)
    {
        System.out.print("Digite o nome do produto para alterar o preço: ");
        String nome = scanner.nextLine();
        int idx = buscarIndice(nomes, nome);
        
        if (idx != -1)
        {
            System.out.print("Digite o novo preço unitário: ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine();
            
            if (novoPreco > 0)
            {
                precos.set(idx, novoPreco);
                System.out.println("Preço alterado com sucesso!");
            }
            else
            {
                System.out.println("O preço deve ser maior que zero!");
            }
        }
        else
        {
            System.out.println("Produto não encontrado!");
        }
    }
    
    public static void removerProduto(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos, Scanner scanner)
    {
        System.out.print("Digite o nome do produto a remover: ");
        String nome = scanner.nextLine();
        int idx = buscarIndice(nomes, nome);
        
        if (idx != -1)
        {
            nomes.remove(idx);
            quantidades.remove(idx);
            precos.remove(idx);
            System.out.println("Produto removido com sucesso!");
        }
        else
        {
            System.out.println("Produto não encontrado!");
        }
    }
    
    public static void pesquisarProduto(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos, Scanner scanner)
    {
        System.out.print("Digite o nome ou parte do nome do produto: ");
        String termo = scanner.nextLine().toLowerCase();
        boolean encontrou = false;
        
        for (int i = 0; i < nomes.size(); i++)
        {
            if (nomes.get(i).toLowerCase().contains(termo))
            {
                encontrou = true;
                double subtotal = quantidades.get(i) * precos.get(i);
                System.out.println("Produto: " + nomes.get(i) + " | Qtd: " + quantidades.get(i) + " | Preço: R$" + precos.get(i) + " | Subtotal: R$" + subtotal);
            }
        }
        
        if (!encontrou)
        {
            System.out.println("Nenhum produto encontrado com o termo informado!");
        }
    }
    
    public static void listarProdutos(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos)
    {
        if (nomes.isEmpty())
        {
            System.out.println("A lista de compras está vazia!");
        }
        else
        {
            System.out.println("\n--- LISTA DE PRODUTOS ---");
            for (int i = 0; i < nomes.size(); i++)
            {
                double subtotal = quantidades.get(i) * precos.get(i);
                System.out.println((i + 1) + ". " + nomes.get(i) + " - Qtd: " + quantidades.get(i) + " - Preço: R$" + precos.get(i) + " - Subtotal: R$" + subtotal);
            }
        }
    }
    
    public static void calcularTotal(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos)
    {
        double total = 0;
        for (int i = 0; i < nomes.size(); i++)
        {
            total += quantidades.get(i) * precos.get(i);
        }
        System.out.println("Valor total da compra: R$" + total);
    }
    
    public static void maiorSubtotal(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos)
    {
        if (nomes.isEmpty())
        {
            System.out.println("A lista de compras está vazia!");
        }
        else
        {
            int idxMaior = 0;
            double maiorSub = quantidades.get(0) * precos.get(0);
            
            for (int i = 1; i < nomes.size(); i++)
            {
                double sub = quantidades.get(i) * precos.get(i);
                if (sub > maiorSub)
                {
                    maiorSub = sub;
                    idxMaior = i;
                }
            }
            
            System.out.println("Produto com maior subtotal: " + nomes.get(idxMaior) + " (Subtotal: R$" + maiorSub + ")");
        }
    }
    
    public static int buscarIndice(ArrayList<String> nomes, String nome)
    {
        for (int i = 0; i < nomes.size(); i++)
        {
            if (nomes.get(i).equalsIgnoreCase(nome))
            {
                return i;
            }
        }
        return -1;
    }
}
