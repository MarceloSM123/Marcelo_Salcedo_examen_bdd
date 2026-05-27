package com.krakedev.examen.vuelos.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.repositories.VueloRepository;

@Service
public class ServicioVuelo {

    private final VueloRepository repository;

    public ServicioVuelo(VueloRepository repository) {
        this.repository = repository;
    }

 
    public Vuelo crear(Vuelo vuelo) {
        return repository.save(vuelo);
    }

    
    public List<Vuelo> listar() {
        return repository.findAll();
    }

    
    public Vuelo buscarPorId(Long id) {
        Optional<Vuelo> resultado = repository.findById(id);
        return resultado.orElse(null);
    }

   
    public Vuelo buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    
    public Vuelo actualizar(Long id, Vuelo vueloActualizado) {
        Vuelo vuelo = buscarPorId(id);

        if (vuelo == null) {
            return null;
        }

        vuelo.setCodigo(vueloActualizado.getCodigo());
        vuelo.setOrigen(vueloActualizado.getOrigen());
        vuelo.setDestino(vueloActualizado.getDestino());
        vuelo.setFechaSalida(vueloActualizado.getFechaSalida());
        vuelo.setAsientosTotales(vueloActualizado.getAsientosTotales());
        vuelo.setAsientosDisponibles(vueloActualizado.getAsientosDisponibles());
        vuelo.setPrecioBoleto(vueloActualizado.getPrecioBoleto());

        return repository.save(vuelo);
    }

    
    public boolean eliminar(Long id) {
        Vuelo vuelo = buscarPorId(id);

        if (vuelo == null) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    
    public List<Vuelo> buscarPorPrecioMenorA(BigDecimal precio) {
        return repository.findByPrecioBoletoLessThan(precio);
    }

    public List<Vuelo> buscarPorAsientosDisponiblesMayorA(Integer asientos) {
        return repository.findByAsientosDisponiblesGreaterThan(asientos);
    }

    public List<Vuelo> buscarPorOrigen(String origen) {
        return repository.findByOrigen(origen);
    }

    public List<Vuelo> buscarPorDestino(String destino) {
        return repository.findByDestino(destino);
    }
}
