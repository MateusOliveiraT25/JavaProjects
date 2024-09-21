package com.exemplo;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercicios {
    Scanner sc = new Scanner(System.in);

    public void mediaAluno() {
        double notas[] = new double[4];

        System.out.println("Digite 4 Notas do aluno:");
        for (int i = 0; i < 4; i++) {
            notas[i] = sc.nextDouble();
        }

        System.out.println("Notas do aluno:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + "ª Nota: " + notas[i]);
        }

        double media = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;

        // Verifica se todas as notas são maiores que 9
        boolean elegivelBonus = true;
        for (double nota : notas) {
            if (nota <= 9) {
                elegivelBonus = false;
                break;
            }
        }


        // Aplica o bônus se elegível
        if (elegivelBonus) {
            double novaMedia = media + media * 0.10; // Calcula a nova média com bônus
            if (novaMedia > 10) {
                media = 10; // Garante que a média não exceda 10
            } else {
                media = novaMedia; // Aplica a nova média se não exceder 10
            }
            System.out.println("Bônus aplicado! Nova média: " + media);
        }

        // Avaliação do aluno
        if (media >= 7) {
            System.out.println( "A media é " + media + ". Aluno está Aprovado");
        } else if (media >= 5 && media < 7) {
            System.out.println( "A media é " + media +". Aluno está de Recuperação");
        } else {
            System.out.println( "A media é " + media +". Aluno está Reprovado");
        }
    }

    public void cadastroFuncionario() {


    }
   
   
    
        public void calculadoraAvancada() {
            Scanner sc = new Scanner(System.in);
            boolean continuar = true;
            double num1, num2 = 0, resultado = 0;
            while (continuar) {
                try {
                    System.out.println("Escolha a operação aritmética:");
                    System.out.println("(1) Soma");
                    System.out.println("(2) Subtração");
                    System.out.println("(3) Divisão");
                    System.out.println("(4) Multiplicação");
                    System.out.println("(5) Raiz Quadrada");
                    System.out.println("(0) Sair");
    
                    int opA = sc.nextInt();
    
                    if (opA == 0) {
                        continuar = false;
                        System.out.println("Encerrando a calculadora.");
                        break;
                    }
    
                 
    
                    // Solicitar o primeiro número para todas as operações
                    System.out.println("Informe o primeiro número:");
                    num1 = sc.nextDouble();
    
                    // Apenas para as operações de soma, subtração, divisão e multiplicação, pedir o segundo número
                    if (opA >= 1 && opA <= 4) {
                        System.out.println("Informe o segundo número:");
                        num2 = sc.nextDouble();
                    }
    
                    switch (opA) {
                        case 1: // Soma
                            resultado = num1 + num2;
                            System.out.println("Resultado: " + resultado);
                            break;
    
                        case 2: // Subtração
                            resultado = num1 - num2;
                            System.out.println("Resultado: " + resultado);
                            break;
    
                        case 3: // Divisão
                            if (num2 == 0) {
                                throw new ArithmeticException("Erro: Divisão por zero!");
                            }
                            resultado = num1 / num2;
                            System.out.println("Resultado: " + resultado);
                            break;
    
                        case 4: // Multiplicação
                            resultado = num1 * num2;
                            System.out.println("Resultado: " + resultado);
                            break;
    
                        case 5: // Raiz Quadrada
                            if (num1 < 0) {
                                throw new ArithmeticException("Erro: Raiz quadrada de número negativo!");
                            }
                            resultado = Math.sqrt(num1);
                            System.out.println("Resultado (Raiz Quadrada): " + resultado);
                            break;
    
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                    sc.next(); // Limpa a entrada inválida
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
    
                System.out.println(); // Linha em branco para separar as execuções
            }
    
            sc.close();
        }

    }
    


    
