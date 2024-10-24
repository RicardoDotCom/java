package br.com.tarefas.minhas_tarefas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ds_tarefa", nullable = false, length = 150)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TarefaStatus status;

    private LocalDate dataEntrega;

    private boolean visivel;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TarefaCategoria categoria;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public TarefaStatus getStatus() {
        return status;
    }
    
    public void setStatus(TarefaStatus status) {
        this.status = status;
    }

    public LocalDate getdataEntrega() {
        return dataEntrega;
    }

    public void setdataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public boolean isVisivel() {
        return visivel;
    }
    
    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
        
    public TarefaCategoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(TarefaCategoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
