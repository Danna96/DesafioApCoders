package com.apcoder.apcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class Inquilino {

    @Id
    @SequenceGenerator(name = "inquilino_sequence", sequenceName = "seq_inquilino")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inquilino_sequence")
    private Long id;

    @JsonProperty("nome")
    @NotBlank(message = "Insira seu nome.")
    private String nome;

    @JsonProperty("idade")
    @NotNull(message = "Insira sua idade.")
    private int idade;

    @JsonProperty("sexo")
    @NotBlank(message = "MASCULINO ou FEMININO")
    private Genero sexo;

    @JsonProperty("phone")
    @NotNull(message = "Insira um número de telefone com DDD.")
    @Length(min = 11, max = 11, message = "Insira um número de telefone com DDD.")
    private String phone;

    @JsonProperty("email")
    @Email(message = "Insira um e-mail válido.")
    private String email;

    public Inquilino(String nome, int idade, Genero sexo, String phone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.phone = phone;
        this.email = email;
    }

    public Inquilino() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
