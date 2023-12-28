package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * Classe que representa a entidade de pedido (Order).
 * <p>
 * Esta classe é mapeada para a tabela "tb_order" no banco de dados.
 */
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    /**
     * Construtor padrão sem argumentos.
     */
    public Order() {
    }

    /**
     * Construtor que inicializa os atributos da classe.
     *
     * @param id     O identificador único do pedido.
     * @param moment O momento em que o pedido foi realizado (Instant).
     * @param client O cliente associado a este pedido (objeto User).
     */
    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    /**
     * Obtém o identificador único do pedido.
     *
     * @return O identificador único do pedido.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o identificador único do pedido.
     *
     * @param id O identificador único do pedido.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o momento em que o pedido foi realizado.
     *
     * @return O momento em que o pedido foi realizado (Instant).
     */
    public Instant getMoment() {
        return moment;
    }

    /**
     * Define o momento em que o pedido foi realizado.
     *
     * @param moment O momento em que o pedido foi realizado (Instant).
     */
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    /**
     * Obtém o cliente associado a este pedido.
     *
     * @return O cliente associado a este pedido (objeto User).
     */
    public User getClient() {
        return client;
    }

    /**
     * Define o cliente associado a este pedido.
     *
     * @param client O cliente associado a este pedido (objeto User).
     */
    public void setClient(User client) {
        this.client = client;
    }

    /**
     * Sobrescreve o método equals para comparar objetos Order por seus identificadores únicos.
     *
     * @param o O objeto a ser comparado.
     * @return true se os objetos são iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    /**
     * Sobrescreve o método hashCode para gerar um código de hash baseado no identificador único do pedido.
     *
     * @return O código de hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}