package patoes.bet.patoes.bet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import patoes.bet.patoes.bet.model.ImagemModel;
import patoes.bet.patoes.bet.service.ImagemService;

@RestController
@RequestMapping("/imagens")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;


    @GetMapping
    public ResponseEntity<?> listarImagens(){
        return new ResponseEntity<>(imagemService.listarImagens(), HttpStatus.OK);
    }

    @GetMapping(path = "/{codigo}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> buscarImagemPorCodigo(@PathVariable Long codigo){
        return new ResponseEntity<>(imagemService.buscarImagemPorCodigo(codigo), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> salvarImagem(@RequestBody ImagemModel imagem){
        return new ResponseEntity<>(imagemService.salvarImagem(imagem), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{codigo}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> excluirImagemPorCodigo(@PathVariable Long codigo){
        return new ResponseEntity<>(imagemService.deletarImagemPorCodigo(codigo), HttpStatus.OK);
    }
}
