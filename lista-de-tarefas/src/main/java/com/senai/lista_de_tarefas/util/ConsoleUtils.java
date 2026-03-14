package com.senai.lista_de_tarefas.util;

import com.senai.lista_de_tarefas.dtos.TarefaEntradaDto;

import java.util.Scanner;

public class ConsoleUtils {

    // Exibe o menu no terminal
    public static void exibirMenu() {
        System.out.println("\n Escolha uma opção: \n");

        System.out.println("1 - Adicionar uma tarefa.");
        System.out.println("2 - Visualizar todas as tarefas.");
        System.out.println("3 - Marcar uma tarefa como concluída");
        System.out.println("4 - Remover tarefa.");
        System.out.println("5 - Encerrar o programa.");
    }

    // Coloquei este metodo para Ler Strings e evitar duplicar varias vezes elas no codigo.
    public static String lerString(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        return sc.nextLine().trim();
    }

    // Metodo auxiliar para Imprimir Tarefas asim evita duplicar elas no controller.
    public static void imprimirTarefa(TarefaEntradaDto entradaDto) {
        System.out.println("------------------------------------");
        System.out.println("Código: " + entradaDto.getCodigo());
        System.out.println("Titulo: " + entradaDto.getTitulo());
        System.out.println("Descricao: " + entradaDto.getDescricao());
        System.out.println("Status: " + entradaDto.getStatus()+"\n");
    }

    // Metodo que vai me auxiliar  Criar TarefaDto evitando duplicadas.
    public static TarefaEntradaDto criarTarefaDto(Scanner sc) {
        TarefaEntradaDto entradaDto = new TarefaEntradaDto();
        System.out.println("------------------------------");
        entradaDto.setTitulo(lerString(sc,"Titulo:"));
        entradaDto.setDescricao(lerString(sc,"Descricao:"));
        return entradaDto;
    }





}
