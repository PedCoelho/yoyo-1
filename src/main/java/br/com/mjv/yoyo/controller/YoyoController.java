package br.com.mjv.yoyo.controller;

import br.com.mjv.yoyo.model.Yoyo;
import br.com.mjv.yoyo.service.YoyoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/yoyo")
public class YoyoController {

    @Autowired
    private YoyoService yoyoService;

    @Autowired
    private Yoyo yoyo;

    @GetMapping(value = "/save")
    public ResponseEntity<Yoyo> save(){
        return ResponseEntity.status(HttpStatus.OK).body(yoyoService.add(yoyo));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Yoyo>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(yoyoService.findAll());
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Yoyo> findAll( @PathVariable("id") Integer id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(yoyoService.findById(id));
    }
}