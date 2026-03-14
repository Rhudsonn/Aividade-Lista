package com.senai.lista_de_tarefas.services;

import com.senai.lista_de_tarefas.dtos.StatusEnum;
import com.senai.lista_de_tarefas.dtos.TarefaEntradaDto;

import com.senai.lista_de_tarefas.util.ConsoleUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Service
public class TarefaService {


    private int contadorCodigo = 1; //Iniciando o contador em ordem cresente.

    // Aqui adicionei este Scanner para evitar duplica scanner para todas as vezes que precisar ler algo.
    private final Scanner sc = new Scanner(System.in);

    ArrayList<TarefaEntradaDto> tarefa = new ArrayList<>();

    // Adicionar uma tarefa
    public void cadastrarTarefa(TarefaEntradaDto entradaDto){
        TarefaEntradaDto entrada = ConsoleUtils.criarTarefaDto(sc);

        entradaDto.setCodigo(contadorCodigo++); // Aqui estou numerando o código ++ para que não repita numero
        entradaDto.setStatus(StatusEnum.PENDENTE); // Aqui ele sempre inicia em Status PENDENTE.

        entradaDto.setTitulo(entrada.getTitulo());
        entradaDto.setDescricao(entrada.getDescricao());
        System.out.println( "Tarefa cadastrado com sucesso!\n");

        tarefa.add(entradaDto);
    }

    // Visualizar todas as tarefas
    public void listaTarefa(){
        for (TarefaEntradaDto e: tarefa) {
            ConsoleUtils.imprimirTarefa(e);
        }
    }

    // Marcar uma tarefa como concluída
    public void concluirTarefa(){
        System.out.println("Digite o codigo da tarefa:");
        int codigo = sc.nextInt();

        for (TarefaEntradaDto e: tarefa) {
            if (e.getCodigo() == codigo) {
                e.setStatus(StatusEnum.CONCLUIDO);
                System.out.println( "Tarefa concluida com sucesso!\n");
                return;
            }
            System.out.println("Tarefa não encontrada!\n");
        }
    }

    // Remover uma tarefa
    public void removerTarefa(){
        System.out.println("Digite o codigo da tarefa:");
        int codigo = sc.nextInt();

        for (TarefaEntradaDto e: tarefa) {
            if (e.getCodigo() == codigo) {
                tarefa.remove(e);
            }
            System.out.println("Tarefa removido com sucesso!\n");
            return;
        }
    }






}
