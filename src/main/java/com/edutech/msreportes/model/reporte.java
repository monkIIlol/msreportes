package com.edutech.msreportes.model;

import java.time.LocalDate;
//import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reporte")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private int idReporte;

    @Column(length = 50, nullable = false)
    private String tituloRep;

    @Column(length = 300, nullable = false)
    private String descripcion;

    @Column(length = 50, nullable = false)
    private String tipoRep;

    @Column(nullable = false)
    private LocalDate fechaRep;

    //@Column()
    //private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    //@Column()
    //private ArrayList<Nota> listaNotas = new ArrayList<>();
}
