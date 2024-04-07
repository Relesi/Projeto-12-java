package com.projeto12.service;

import com.projeto12.domain.Conta;
import com.projeto12.domain.Endereco;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContaService {

    private static List<Conta> contas;

    private static List<Endereco> enderecos;

    static {
        contas = new ArrayList<>(List.of(new Conta(1L, "Kolar", "Renato",
                "2000-10-09", 4040400404L, 29809339939L, "kolar.renato@gmail.com",

                enderecos = new ArrayList<>(List.of(new Endereco())))));


    }

    public List<Conta>listAll() {
        return contas;
    }

    public Conta findById(long id) {
        return contas.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Conta não encontrada"));
    }

    public Conta save(Conta conta) {
        conta.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        contas.add(conta);
        return conta;
    }

    public void replace(Conta conta) {
        delete(conta.getId());
        contas.add(conta);
    }

    public void delete(long id){
        contas.remove(findById(id));
    }
}
