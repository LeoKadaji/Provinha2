import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map;

public class App {


    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner sc = new Scanner(System.in);
        List<Produto> ListaProduto = new ArrayList<>();
        List<Vendas> ListaVendas = new ArrayList<>();
    
        do{
            System.out.println("****MENU****\n");
            System.out.println("1 - Incluir produto ");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produto");
            System.out.println("4 - Vendas por produto");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair\n");

            System.out.println("Opção: ");
            opcao = sc.nextInt();
            sc.next();
        

            if(opcao==1){
                System.out.println("Digite o nome do produto: ");
                String nome = sc.next();
                System.out.println("Digite o codigo do produto: ");
                String codigo = sc.next();
                System.out.println("Digite o valor do produto ");
                Double valor = sc.nextDouble();
                int qnt=0;
            
                ListaProduto.add(new Produto(nome, codigo, valor, qnt));
                System.out.println("Produto inserido");

            } else if(opcao==2){
               System.out.println("Insira o codigo do produto");
               String codigoIn = sc.next();

               List<Produto> ListaP = ListaProduto.stream()
               .filter(p -> p.getCodigo().contains(codigoIn)).collect(Collectors.toList());;
               if(ListaP.isEmpty()){
                System.out.println("Não existe produtos no seu carrinho");
               } else{
                for (Produto produto : ListaP) {
                    System.out.println(produto);
                }
               }


            } else if(opcao==3){
                System.out.println("Produtos no seu carrinho");
                for (Produto produto : ListaProduto) {
                    System.out.println(produto);
                }

                DoubleSummaryStatistics resumo = ListaProduto.stream()
                .collect(Collectors.summarizingDouble(Produto::getValor));
                System.out.println("O valor maximo do seu produto é: " + resumo.getMax());
                System.out.println("\n O valor medio dos seus produtos são: " + resumo.getAverage());
                System.out.println("\nO valor minimo do seu produto é: " + resumo.getMin());
            
                

            } else if(opcao==4){
                Map<Integer, List<Vendas>> vendasPorProduto = ListaVendas.stream().collect(Collectors.groupingBy(Vendas::getQtdv));
                vendasPorProduto.entrySet().forEach(v -> System.out.printf("Produto: %s - Venda: %s", v.getKey(), v.getValue()));

            
            }else if(opcao==5){
                System.out.println("Digite o codigo do produto: ");
                String produtoVendido = sc.next();
                List<Produto> ListaP = ListaProduto.stream()
                .filter(pro -> pro.getCodigo().equals(produtoVendido)).collect(Collectors.toList());
                if(ListaP.isEmpty()){
                    System.out.println("Produto não encontrado");
                } else {
                    for(Produto pro: ListaProduto){
                        System.out.println("Digite sua quantidade de produtos");
                        int quantidadevendida = sc.nextInt();
                        int quantidadeEs = pro.getQtdVendida()-quantidadevendida;
                        double valortotal=pro.getValor()*quantidadevendida;
                        pro.setQtdVendida(quantidadeEs);
                        if(quantidadeEs<0){
                            System.out.println("Venda não finalizada! existem apenas: " + quantidadeEs + "disponivel!");
                         } else{
                                LocalDate date = LocalDate.now();
                                Vendas ven = new Vendas(date,produtoVendido,quantidadevendida,valortotal);
                                ListaVendas.add(ven);
                                System.out.println(valortotal);
                                System.out.println("Venda realizada!");
                            }
                        }
                    }

                }
                
        }while(opcao!=0);
    }
}
