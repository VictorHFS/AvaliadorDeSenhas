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

    @CrossOrigin(origins = "http://localhost:1994")
    @PostMapping("/avaliar")
    public @ResponseBody Senha avaliarSenha(HttpServletRequest request){
        String senha = request.getParameter("senha");
        String nota = request.getParameter("nota");
        String complexidade = request.getParameter("complexidade");
        SenhaCommand command = new SenhaCommand(senha, String.valueOf(nota), complexidade);
        Senha resultado = service.avaliarSenha(command);
        return resultado;
    }
}