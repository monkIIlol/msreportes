package com.edutech.msreportes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.msreportes.model.Reporte;



@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    
    List<Reporte> findAll();

    @SuppressWarnings("unchecked")
    Reporte save(Reporte reporte);

    Reporte findById(int id);
}
