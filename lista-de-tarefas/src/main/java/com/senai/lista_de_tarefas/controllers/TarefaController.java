
package com.senai.lista_de_tarefas.controllers;

import com.senai.lista_de_tarefas.dtos.TarefaEntradaDto;
import com.senai.lista_de_tarefas.services.TarefaService;
import com.senai.lista_de_tarefas.util.ConsoleUtils;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
public class TarefaController implements CommandLineRunner {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public void run(String @NonNull ... args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {
            try {
                ConsoleUtils.exibirMenu();
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> tarefaService.cadastrarTarefa(new TarefaEntradaDto());
                    case 2 -> tarefaService.listaTarefa();
                    case 3 -> tarefaService.concluirTarefa();
                    case 4 -> tarefaService.removerTarefa();
                    case 5 -> tarefaService.finalizarSistema();
                    default -> System.out.println("Opção inválida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                sc.nextLine();
                opcao = 0;

            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

        } while (opcao != 5);

        sc.close();
    }
}
