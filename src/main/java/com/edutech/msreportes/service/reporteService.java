package com.edutech.msreportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.msreportes.model.Reporte;
import com.edutech.msreportes.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> findAll() {
        return reporteRepository.findAll();
    }

    public Reporte findById(int idReporte) {
        return reporteRepository.findById(idReporte);
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public void deleteById(int idReporte) {
        reporteRepository.deleteById(idReporte);
    }

    public boolean update(int idReporte, Reporte reporte) {
        Reporte rep = reporteRepository.findById(idReporte);
        if(rep != null) {
            rep.setTituloRep(reporte.getTituloRep());
            rep.setDescripcion(reporte.getDescripcion());
            rep.setTipoRep(reporte.getTipoRep());
            rep.setFechaRep(reporte.getFechaRep());

            reporteRepository.save(rep);
            return true;
        }else{
            return false;
        }
    }
}
