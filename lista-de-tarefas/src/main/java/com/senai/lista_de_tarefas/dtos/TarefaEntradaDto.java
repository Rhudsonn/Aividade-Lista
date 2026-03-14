package com.senai.lista_de_tarefas.dtos;


public class TarefaEntradaDto {

    private int codigo;
    private String titulo;
    private String descricao;
    private StatusEnum status;

    public TarefaEntradaDto() {}

    public TarefaEntradaDto(int codigo, String titulo, String descricao, StatusEnum status) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
