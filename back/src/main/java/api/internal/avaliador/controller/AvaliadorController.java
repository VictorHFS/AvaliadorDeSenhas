package api.internal.avaliador.controller;

import api.internal.avaliador.model.senha.Senha;
import api.internal.avaliador.model.senha.SenhaCommand;
import api.internal.avaliador.service.AvaliadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AvaliadorController {

    @Autowired
    AvaliadorService service;

    @GetMapping("/")
    public String index(){return "Bem vindo ao avaliado de senhas.";}

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/avaliar")
    @ResponseBody
    public Senha avaliarSenha(@RequestParam String senha, @RequestParam Integer nota, @RequestParam String complexidade){
        SenhaCommand command = new SenhaCommand(senha, String.valueOf(nota), complexidade);
        Senha resultado = service.avaliarSenha(command);
        return resultado;
    }
}