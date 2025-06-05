package com.pos.restaurante.api.controller;

import com.pos.restaurante.api.controller.dto.LoginRequestDTO;
import com.pos.restaurante.api.controller.dto.LoginResponseDTO;
import com.pos.restaurante.api.service.usuario.autenticaUsuario.AutenticaUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@Slf4j
@Tag(name = "Login", description = "Endpoint para requisições de login")
public class AuthController {

    private final AutenticaUsuarioService autenticaUsuarioService;

    public AuthController(AutenticaUsuarioService autenticaUsuarioService) {
        this.autenticaUsuarioService = autenticaUsuarioService;
    }

    @Operation(summary = "Realiza o login", description = "Retorna status se validado o login")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO response = autenticaUsuarioService.autenticaUsuario(loginRequestDTO);
        return ResponseEntity.ok(response);
    }
}
