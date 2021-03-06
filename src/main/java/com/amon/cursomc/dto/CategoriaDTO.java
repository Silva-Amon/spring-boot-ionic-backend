package com.amon.cursomc.dto;

import com.amon.cursomc.domain.Categoria;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 4928913069341939418L;
    private Integer id;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min=5, max=80, message="O tamanho máximo deve ser entre 5 a 80 caracteres")
    private String nome;

    public CategoriaDTO(){

    }

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
