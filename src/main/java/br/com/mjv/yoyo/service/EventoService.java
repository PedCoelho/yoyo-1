package br.com.mjv.yoyo.service;

import br.com.mjv.yoyo.model.Evento;
import br.com.mjv.yoyo.model.Yoyo;
import br.com.mjv.yoyo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;


    public Evento add(Evento evento){
        return eventoRepository.save(evento);
    }

    public List<Evento> findAll(){
        return eventoRepository.findAll();
    }
}
