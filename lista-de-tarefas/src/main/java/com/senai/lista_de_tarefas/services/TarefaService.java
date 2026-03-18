package com.senai.lista_de_tarefas.services;

import com.senai.lista_de_tarefas.dtos.StatusEnum;
import com.senai.lista_de_tarefas.dtos.TarefaEntradaDto;

import com.senai.lista_de_tarefas.util.ConsoleUtils;
import jakarta.validation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

@Service
public class TarefaService {


    private int contadorCodigo = 1; //Iniciando o contador em ordem cresente.

    // Aqui adicionei este Scanner para evitar duplica scanner para todas as vezes que precisar ler algo.
    private final Scanner sc = new Scanner(System.in);

    ArrayList<TarefaEntradaDto> tarefa = new ArrayList<>();

    // Iniciando o validador que vai me ajudar a não ficar validando muita coisa manualmente.
    private final Validator validator;
    public TarefaService() {
        ValidatorFactory valida = Validation.buildDefaultValidatorFactory();
        this.validator = valida.getValidator();
    }



    // Adicionar uma tarefa
    public void cadastrarTarefa(TarefaEntradaDto entradaDto){

        TarefaEntradaDto entrada = ConsoleUtils.criarTarefaDto(sc);

        Set<ConstraintViolation<TarefaEntradaDto>> erros = validator.validate(entrada); // chamando o médoto validador.

        if (!erros.isEmpty()) {
            for (ConstraintViolation<TarefaEntradaDto> erro : erros) {
                System.out.println(erro.getMessage());
            }
            return;
        }

        entrada.setCodigo(contadorCodigo++);
        entrada.setStatus(StatusEnum.PENDENTE);

        tarefa.add(entrada);

        System.out.println("Tarefa cadastrada com sucesso!\n");
    }

    // Visualizar todas as tarefas
    public void listaTarefa(){
        if (tarefa.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.\n");
            return;
        }
        for (TarefaEntradaDto e : tarefa) {
            ConsoleUtils.imprimirTarefa(e);
        }
    }

    // Marcar uma tarefa como concluída
    public void concluirTarefa(){
        if (tarefa.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.\n");
            return;
        }
        System.out.println("Digite o codigo da tarefa:");
        int codigo = sc.nextInt();

        for (TarefaEntradaDto e: tarefa) {
            if (e.getCodigo() == codigo) {
                e.setStatus(StatusEnum.CONCLUIDO);
                System.out.println( "Tarefa concluida com sucesso!\n");
                return;
            }
        }
        System.out.println("Tarefa não encontrada!\n");
    }

    // Remover uma tarefa
    public void removerTarefa(){
        if (tarefa.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.\n");
            return;
        }
        System.out.println("Digite o codigo da tarefa:");
        int codigo = sc.nextInt();

        for (TarefaEntradaDto e: tarefa) {
            if (e.getCodigo() == codigo) {
                tarefa.remove(e);
                System.out.println("Tarefa removida com sucesso!\n");
                return;
            }
        }
        System.out.println("Tarefa não encontrada!\n");
    }

    public void finalizarSistema(){
        System.out.printf("Sistema finalizado!");
    }






}
