package com.pos.restaurante.api.controller.endereco;

import com.pos.restaurante.api.controller.dto.endereco.AtualizaEnderecoRequestDTO;
import com.pos.restaurante.api.controller.dto.endereco.BuscaEnderecoResponseDTO;
import com.pos.restaurante.api.controller.dto.endereco.BuscaTodosEnderecoResponseDTO;
import com.pos.restaurante.api.controller.dto.endereco.CadastraEnderecoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Endereço", description = "Endpoint para requisições de Endereço")
public interface EnderecoAPI {

    @Operation(summary = "Buscar endereço por id", description = "Endpoint para buscar endereço por id")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @GetMapping("/{id}")
    ResponseEntity<BuscaEnderecoResponseDTO> findById(@NotNull @PathVariable Long id);

    @Operation(summary = "Buscar todos os endereço", description = "Retorna uma lista paginada de endereço")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @GetMapping
    ResponseEntity<List<BuscaTodosEnderecoResponseDTO>> findAll(
            @RequestParam("page") @Valid @Min(value = 1, message = "A Paginação nao pode ser menor que um.") int page,
            @RequestParam("size") int size);

    @Operation(summary = "Cadastra endereço", description = "Endpoint para cadastrar de endereço")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PostMapping
    ResponseEntity<Void> save(@Valid @RequestBody CadastraEnderecoRequestDTO cadastraEnderecoRequestDTO);

    @Operation(summary = "Atualiza endereço", description = "Endpoint para atualiza endereço")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody AtualizaEnderecoRequestDTO atualizaEnderecoRequestDTO);

    @Operation(summary = "Deleta endereço", description = "Endpoint para deletar endereço")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
