package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tarefa {
    @Id
    private long id;
    private String nome;

    public Tarefa(long id, String nome){
        this.setId(id);
        this.setNome(nome);
    }
}
