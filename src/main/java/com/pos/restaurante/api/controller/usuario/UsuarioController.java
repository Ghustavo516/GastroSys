package com.pos.restaurante.api.controller.usuario;

import java.util.List;
import java.util.Optional;

import com.pos.restaurante.api.controller.dto.usuario.*;
import com.pos.restaurante.api.entity.Usuario;
import com.pos.restaurante.api.service.usuario.buscar.BuscarUsuarioMapper;
import com.pos.restaurante.api.service.usuario.trocarSenhaUsuario.TrocaSenhaUsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pos.restaurante.api.service.usuario.atualizar.AtualizarUsuarioService;
import com.pos.restaurante.api.service.usuario.buscar.BuscarUsuarioService;
import com.pos.restaurante.api.service.usuario.buscarTodos.BuscarTodosUsuarioService;
import com.pos.restaurante.api.service.usuario.cadastrar.CadastrarUsuarioService;
import com.pos.restaurante.api.service.usuario.excluir.ExcluirUsuarioService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/usuario")
@Slf4j
public class UsuarioController implements UsuarioAPI {

    private final CadastrarUsuarioService cadastrarUsuarioService;
    private final BuscarUsuarioService buscarUsuarioService;
    private final BuscarTodosUsuarioService buscarTodosUsuarioService;
    private final ExcluirUsuarioService excluirUsuarioService;
    private final AtualizarUsuarioService atualizarUsuarioService;
    private final TrocaSenhaUsuarioService trocaSenhaUsuarioService;

    public UsuarioController(CadastrarUsuarioService cadastrarUsuarioService,
                             BuscarUsuarioService buscarUsuarioService,
                             BuscarTodosUsuarioService buscarTodosUsuarioService,
                             ExcluirUsuarioService excluirUsuarioService,
                             AtualizarUsuarioService atualizarUsuarioService,
                             TrocaSenhaUsuarioService trocaSenhaUsuarioService) {
        this.cadastrarUsuarioService = cadastrarUsuarioService;
        this.buscarUsuarioService = buscarUsuarioService;
        this.buscarTodosUsuarioService = buscarTodosUsuarioService;
        this.excluirUsuarioService = excluirUsuarioService;
        this.atualizarUsuarioService = atualizarUsuarioService;
        this.trocaSenhaUsuarioService = trocaSenhaUsuarioService;
    }

    @Override
    public ResponseEntity<List<BuscarTodosUsuarioResponseDTO>> buscarTodos(int page, int size) {
        log.info("/usuario");
        List<BuscarTodosUsuarioResponseDTO> tipoProdutosDTOs = buscarTodosUsuarioService.buscarTodos(page, size);
        return ResponseEntity.ok(tipoProdutosDTOs);
    }

    @Override
    public ResponseEntity<BuscarUsuarioResponseDTO> buscarPorId(Long id) {
        log.info("/usuario/" + id);
        Optional<Usuario> usuario = buscarUsuarioService.findById(id);

        if (!usuario.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BuscarUsuarioMapper.toDTO(usuario.get()));
    }

    @Override
    public ResponseEntity<Void> cadastrar(CadastrarUsuarioRequest cadastrarUsuarioRequest) {
        log.info("POST -> /usuario");
        cadastrarUsuarioService.cadastrar(cadastrarUsuarioRequest);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> atualizar(Long id, AtualizarUsuarioRequestDTO atualizarUsuarioRequestDTO) {
        log.info("PUT -> /usuario/" + id);
        this.atualizarUsuarioService.atualizar(atualizarUsuarioRequestDTO, id);
        return ResponseEntity.status(200).build();
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {
        log.info("DELETE -> /usuario/" + id);
        this.excluirUsuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> trocarSenha(Long id, TrocarSenhaUsuarioRequestDTO requestDTO) {
        log.info("PUT -> /usuario/trocaSenha");
        this.trocaSenhaUsuarioService.trocaSenhaUsuario(requestDTO, id);
        return ResponseEntity.ok().build();
    }
}
