package br.com.tarefas.minhas_tarefas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tarefas.minhas_tarefas.model.Tarefa;
import br.com.tarefas.minhas_tarefas.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository repositorio;
    
    public List<Tarefa> getTodasTarefas() {
        return repositorio.findAll();       
    }
        
    public List<Tarefa> getTarefaPorDescricao(String descricao) {
        return repositorio.findByDescricaoLike("%" + descricao + "%");
    }

    public Tarefa getTarefaPorId(Integer id){
        return repositorio.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public Tarefa salvaTarefa(Tarefa tarefa){
        return repositorio.save(tarefa);
    }

    public void deleteById(Integer id){
        repositorio.deleteById(id);
    }
}
