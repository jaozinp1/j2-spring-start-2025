package application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Tarefa;
import application.repository.TarefaRepository;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    // private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    @Autowired
    private TarefaRepository tarefaRepository;

    @RequestMapping("/list")
    public String list(Model ui) {
        // tarefas.add(new Tarefa(1, "Aprender Java"));
        // tarefas.add(new Tarefa(2, "Estudar IoT"));

        //ui.addAttribute("tarefas", tarefas);
        ui.addAttribute("tarefas", tarefaRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String add(@RequestParam("tarefa") String nomeTarefa) {
        //tarefas.add(new Tarefa(0, nomeTarefa));
        
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setNome(nomeTarefa);

        tarefaRepository.save(novaTarefa);

        return "redirect:/tarefas/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui) {
        Optional<Tarefa> resultado = tarefaRepository.findById(id);

        if(resultado.isEmpty()) {
            return "redirect:/tarefas/list";
        }
        
        ui.addAttribute("tarefa", resultado.get());
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("tarefa") String nome) {

        Optional<Tarefa> resultado = tarefaRepository.findById(id);
        if(resultado.isPresent()) {
            resultado.get().setNome(nome);
            tarefaRepository.save(resultado.get());
        }
            
        return "redirect:/tarefas/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model ui) {
        Optional<Tarefa> resultado = tarefaRepository.findById(id);

        if(resultado.isEmpty()) {
            return "redirect:/tarefas/list";
        }

        ui.addAttribute("tarefa", resultado.get());
        return "delete";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        tarefaRepository.deleteById(id);
        return "redirect:/tarefas/list";
    }
}
