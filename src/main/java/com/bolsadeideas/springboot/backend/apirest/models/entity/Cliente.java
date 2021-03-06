package com.bolsadeideas.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message ="no puede estar vacio")
    @Size(min=2, max=15)
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message ="no puede estar vacio")
    @Size(min=2, max=15)
    @Column(nullable = false)
    private String apellido;

    @NotEmpty(message ="no puede estar vacio")
    @Email(message = "Formato de correo incorrecto")
    @Column(nullable = false, unique = true)
    private String email;

    @Column( name = "create_at", nullable = false)
    @Temporal( TemporalType.DATE )
    private Date createAt;

    @PrePersist
    public void prePresist(){
        createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    private static final long serialVersionUID = 1L;
}
