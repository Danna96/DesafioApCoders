package com.apcoder.apcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Unidade {

    @Id
    @SequenceGenerator(name = "unidade_sequence", sequenceName = "seq_unidade")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_sequence")
    private Long id;

    @JsonProperty("proprietario")
    @NotBlank(message = "Informe o proprietário.")
    private String proprietario;

    @JsonProperty("condominio")
    @NotBlank(message = "Informe o condomínio.")
    private String condominio;

    @JsonProperty("endereco")
    @NotBlank(message = "Informe o endereço.")
    private String endereco;

    public Unidade(String proprietario, String condominio, String endereco) {
        this.proprietario = proprietario;
        this.condominio = condominio;
        this.endereco = endereco;
    }

    public Unidade() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getCondominio() {
        return condominio;
    }

    public void setCondominio(String condominio) {
        this.condominio = condominio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
