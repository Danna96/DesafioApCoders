package com.apcoder.apcoder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
public class DespesaUnidade {

    @Id
    @SequenceGenerator(name = "despesaUnidade_sequence", sequenceName = "seq_despesaUnidade")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "despesaUnidade_sequence")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "unidadeId")
    @NotNull(message = "Informe a unidade.")
    private Unidade unidade;

    @JsonProperty("descricao")
    @NotBlank(message = "Insira a descrição da despesa.")
    private String descricao;

    @JsonProperty("tipoDespesa")
    @NotBlank(message = "Insira o tipo de despesa.")
    private String tipoDespesa;

    @JsonProperty("valor")
    @NotNull(message = "Insira o valor da despesa.")
    private Double valor;

    @JsonProperty("vencimentoFatura")
    @NotNull(message = "Insira a data de vencimento da fatura.")
    private Date vencimentoFatura;

    @JsonProperty("statusPagamento")
    @NotNull(message = "Insira o status do pagamento.")
    private Boolean statusPagamento;

    public DespesaUnidade(Unidade unidade, String descricao, String tipoDespesa, Double valor,
                          Date vencimentoFatura, Boolean statusPagamento) {

        this.unidade = unidade;
        this.descricao = descricao;
        this.tipoDespesa = tipoDespesa;
        this.valor = valor;
        this.vencimentoFatura = vencimentoFatura;
        this.statusPagamento = statusPagamento;
    }

    public DespesaUnidade() {

    }

    public Long getId() {
        return id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getVencimentoFatura() {
        return vencimentoFatura;
    }

    public void setVencimentoFatura(Date vencimentoFatura) {
        this.vencimentoFatura = vencimentoFatura;
    }

    public Boolean getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(Boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

}
