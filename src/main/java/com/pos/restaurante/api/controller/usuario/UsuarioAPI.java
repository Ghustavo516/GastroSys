package com.pos.restaurante.api.controller.usuario;

import com.pos.restaurante.api.controller.dto.usuario.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuario", description = "Endpoint para requisições de Usuario")
public interface UsuarioAPI {

    @Operation(summary = "Buscar todos os usuários", description = "Endpoint retorna uma lista paginada de usuários")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @GetMapping
    ResponseEntity<List<BuscarTodosUsuarioResponseDTO>> buscarTodos(
            @RequestParam("page") @Valid @Min(value = 1, message = "Endpoint para buscar todos os usuarios") int page,
            @RequestParam("size") int size);


    @Operation(summary = "Buscar usuário por id", description = "Endpoint para buscar usuario pelo id")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @GetMapping("/{id}")
    ResponseEntity<BuscarUsuarioResponseDTO> buscarPorId(@NotNull @PathVariable("id") Long id);


    @Operation(summary = "Cadastra usuário", description = "Endpoint para cadastrar de usuário")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PostMapping
    ResponseEntity<Void> cadastrar(
            @Valid @RequestBody CadastrarUsuarioRequest cadastrarUsuarioRequest);


    @Operation(summary = "Atualiza usuário", description = "Endpoint para atualiza usuário")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PutMapping("/{id}")
    ResponseEntity<Void> atualizar(@PathVariable("id") Long id,
                                   @Valid @RequestBody AtualizarUsuarioRequestDTO atualizarUsuarioRequestDTO);


    @Operation(summary = "Deleta usuário", description = "Endpoint para deletar usuário")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> excluir(@PathVariable("id") Long id);


    @Operation(summary = "Troca senha de usuário", description = "Endpoint para troca de senha do usuario")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PutMapping("/trocarSenha/{id}")
    ResponseEntity<Void> trocarSenha(@PathVariable Long id,
                                     @Valid @RequestBody TrocarSenhaUsuarioRequestDTO requestDTO);
}
