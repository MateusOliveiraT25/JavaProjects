package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Instancia a classe de gerenciamento de vendas
        GerenciamentoVendas gv = new GerenciamentoVendas();
        String operacao;

        do {
            // Exibe o menu de operações
            operacao = JOptionPane.showInputDialog(
                "\n ----Gerenciamento de vendas---\n"
                + "1 - Registra Venda \n"
                + "2 - Listar Vendas do cliente \n"
                + "3 - Listar Vendas acima de valor mínimo \n"
                + "4 - Sair"
            );

            // Realiza a operação selecionada
            switch (operacao) {
                case "1":
                    // Solicita o CPF do cliente
                    String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente:");
                    // Solicita os detalhes do produto (nome e valor, por exemplo)
                    String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto:");
                    double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto:"));
                    
                    // Cria um novo objeto Produto
                    Produto produto = new Produto(nomeProduto, valorProduto);
                    // Registra a venda
                    gv.venda(cpf, produto);
                    JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
                    break;

                case "2":
                    // Solicita o CPF do cliente para listar suas vendas
                    String cpfCliente = JOptionPane.showInputDialog("Informe o CPF do cliente:");
                    gv.consultarVendasPorCliente(cpfCliente);
                    break;

                case "3":
                    // Solicita o CPF e o valor mínimo para listar as vendas
                    String cpfValorMinimo = JOptionPane.showInputDialog("Informe o CPF do cliente:");
                    double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor mínimo:"));
                    gv.consultarClienteAcimaDE(cpfValorMinimo, valorMinimo);
                    break;

                case "4":
                    // Encerra o loop e o programa
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;

                default:
                    // Caso a operação não seja válida
                    JOptionPane.showMessageDialog(null, "Operação inválida. Tente novamente.");
                    break;
            }
        } while (!operacao.equals("4")); // Continua até que o usuário escolha sair
    }
}
