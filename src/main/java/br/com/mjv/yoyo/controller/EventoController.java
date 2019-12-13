package br.com.mjv.yoyo.controller;

import br.com.mjv.yoyo.model.Evento;
import br.com.mjv.yoyo.model.Yoyo;
import br.com.mjv.yoyo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private Evento evento;

    @Autowired
    private Yoyo yoyo;

    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping(value = "/save/{idYoyo}/{ducarao}")
    public ResponseEntity save(
            @PathVariable("idYoyo") Integer idYoyo,
            @PathVariable("ducarao") Long ducarao ){

        yoyo.setId(idYoyo);
        evento.setDuracao(ducarao);
        evento.setId(null);
        evento.setTimestamp(LocalDateTime.now());
        evento.setYoyo(yoyo);

        evento = eventoService.add(evento);
        template.convertAndSend("/topic/save",evento);

        return ResponseEntity.status(HttpStatus.OK).body(evento);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(eventoService.findAll());
    }
}