package com.senai.lista_de_tarefas.controllers;

import com.senai.lista_de_tarefas.dtos.TarefaEntradaDto;
import com.senai.lista_de_tarefas.services.TarefaService;
import com.senai.lista_de_tarefas.util.ConsoleUtils;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;


@Controller
public class TarefaController implements CommandLineRunner {

    final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public void run(String @NonNull ... args){
        Scanner sc = new Scanner(System.in);

        int opcao;


            do {
                ConsoleUtils.exibirMenu();
                opcao = sc.nextInt();

            try{
                switch (opcao){
                    case 1 -> tarefaService.cadastrarTarefa(new TarefaEntradaDto());
                    case 2 -> tarefaService.listaTarefa();
                    case 3 -> tarefaService.concluirTarefa();
                    case 4 -> tarefaService.removerTarefa();
                    case 5 -> System.out.println("Saindo da aplicação...");

                    default -> {
                        System.out.println("Opção invalida \n");
                        ConsoleUtils.exibirMenu();
                        opcao = sc.nextInt();
                    }
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            }while (opcao != 0);

        sc.close();
    }






}
