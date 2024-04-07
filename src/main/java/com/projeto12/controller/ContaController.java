package com.projeto12.controller;

import com.projeto12.Util.DataUtil;
import com.projeto12.domain.Conta;
import com.projeto12.service.ContaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("projeto-java")
@Log4j2
@RequiredArgsConstructor
public class ContaController {

    private final DataUtil dataUtil;
    private final ContaService contaService;

    @GetMapping("listar-todos")
    public ResponseEntity<List<Conta>> list() {
        return new ResponseEntity<>(contaService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> findById(@PathVariable long id) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return ResponseEntity.ok(contaService.findById(id));
    }

    @PostMapping("inserir-contas")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return new ResponseEntity<>(contaService.save(conta), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> replace(@RequestBody Conta conta) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        contaService.replace(conta);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(@PathVariable long id) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}