package com.example;

public class ContatoController {
    // Atributos
    private Contato[] contatos; 
    private int contadorDeContatos;

    // Construtor
    public ContatoController(int maxContato) {
        contatos = new Contato[maxContato]; // Usa o parâmetro passado
        contadorDeContatos = 0;
    }

    // Métodos - Adicionar Contato
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contadorDeContatos >= contatos.length) {
            throw new AgendaCheiaException("Agenda Cheia"); 
        }
        
        contatos[contadorDeContatos] = contato; // Adiciona o contato
        contadorDeContatos++; // Incrementa o contador
    }

    // Métodos - Listar Todos
    public void listarContato() {
        if (contadorDeContatos == 0) {
            System.out.println("Agenda Vazia");
        } else {
            for (int i = 0; i < contadorDeContatos; i++) {
                System.out.println(contatos[i].toString()); 
            }
        }
    }

    // Métodos - Buscar Contato pelo nome
    public Contato buscarNome(String nome) throws ContatoNaoEncontrado {
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];        
            }
        }
        throw new ContatoNaoEncontrado("Contato Não Encontrado");
    }

    
    // Métodos - Remover Contato pelo nome

    public void removerContato(String nome) throws ContatoNaoEncontrado {
        boolean encontrado = false;
        for (int i = 0; i < contadorDeContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
    
                // Desloca os contatos para remover o contato encontrado
                for (int j = i; j < contadorDeContatos - 1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[contadorDeContatos - 1] = null; // Limpa a última posição
                contadorDeContatos--; // Decrementa o contador
                break; // Sai do loop após encontrar e remover
            }
        }
    
        if (!encontrado) {
            throw new ContatoNaoEncontrado("Contato não encontrado");
        }
    }
}