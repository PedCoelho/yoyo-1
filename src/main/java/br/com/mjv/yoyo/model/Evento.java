package br.com.mjv.yoyo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@EqualsAndHashCode
@Entity
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Evento implements Serializable {

    private static final long serialVersionUID = -4075238063766743582L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime timestamp;

    @Column
    private Long duracao;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yoyo_id", referencedColumnName = "id")
    private Yoyo yoyo;

    @JsonView
    public Long score(){
        return duracao * duracao / 1000;
    }
}