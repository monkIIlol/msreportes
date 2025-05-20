package com.edutech.msreportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.msreportes.model.Reporte;
import com.edutech.msreportes.service.ReporteService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/reportes")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> getAll() {
        List<Reporte> reportes = reporteService.findAll();
        if (!reportes.isEmpty()) {
            return new ResponseEntity<>(reportes, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Reporte> postReporte(@RequestBody Reporte reporte) {
        Reporte buscar = reporteService.findById(reporte.getIdReporte());
        if (buscar == null) {
            return new ResponseEntity<>(reporteService.save(reporte), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{idReporte}")
    public ResponseEntity<Reporte> getById(@PathVariable int idReporte) {
        return new ResponseEntity<Reporte>(reporteService.findById(idReporte), HttpStatus.OK);
    }
    
    
}