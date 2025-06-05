package com.pos.restaurante.api.controller.endereco;

import com.pos.restaurante.api.controller.dto.endereco.AtualizaEnderecoRequestDTO;
import com.pos.restaurante.api.controller.dto.endereco.CadastraEnderecoRequestDTO;
import com.pos.restaurante.api.entity.Endereco;
import com.pos.restaurante.api.service.endereco.atualizaEndereco.AtualizaEnderecoService;
import com.pos.restaurante.api.controller.dto.endereco.BuscaEnderecoResponseDTO;
import com.pos.restaurante.api.service.endereco.buscaEndereco.BuscaEnderecoMapper;
import com.pos.restaurante.api.service.endereco.buscaEndereco.BuscaEnderecoService;
import com.pos.restaurante.api.controller.dto.endereco.BuscaTodosEnderecoResponseDTO;
import com.pos.restaurante.api.service.endereco.buscaTodosEnderecos.BuscaTodosEnderecoService;
import com.pos.restaurante.api.service.endereco.cadastraEndereco.CadastraEnderecoService;
import com.pos.restaurante.api.service.endereco.excluiEndereco.ExcluiEnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/endereco")
@Slf4j
public class EnderecoController implements EnderecoAPI{

    private final CadastraEnderecoService cadastraEnderecoService;
    private final BuscaEnderecoService buscaEnderecoService;
    private final BuscaTodosEnderecoService buscaTodosEnderecoService;
    private final AtualizaEnderecoService atualizaEnderecoService;
    private final ExcluiEnderecoService excluiEnderecoService;

    private static final Logger logger = Logger.getLogger(EnderecoController.class.getName());

    public EnderecoController(CadastraEnderecoService cadastra, BuscaEnderecoService busca, BuscaTodosEnderecoService buscaTodos, AtualizaEnderecoService atualiza, ExcluiEnderecoService exclui) {
        this.cadastraEnderecoService = cadastra;
        this.buscaEnderecoService = busca;
        this.buscaTodosEnderecoService = buscaTodos;
        this.atualizaEnderecoService = atualiza;
        this.excluiEnderecoService = exclui;
    }

    @Override
    public ResponseEntity<BuscaEnderecoResponseDTO> findById(Long id) {
        logger.info("GET -> Buscando endereco");
        Optional<Endereco> endereco = buscaEnderecoService.findById(id);

        if(!endereco.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(BuscaEnderecoMapper.toDTO(endereco.get()));
    }

    @Override
    public ResponseEntity<List<BuscaTodosEnderecoResponseDTO>> findAll(int page, int size) {
        logger.info("GET -> Buscando todos os enderecos");
        int offset = (page - 1) * size;
        List<BuscaTodosEnderecoResponseDTO> enderecosDTO = buscaTodosEnderecoService.findAll(size, offset);
        return ResponseEntity.ok(enderecosDTO);
    }

    @Override
    public ResponseEntity<Void> save(CadastraEnderecoRequestDTO cadastraEnderecoRequestDTO) {
        logger.info("POST -> Cadastro do endereco");
        this.cadastraEnderecoService.save(cadastraEnderecoRequestDTO);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> update(Long id, AtualizaEnderecoRequestDTO atualizaEnderecoRequestDTO) {
        logger.info("PUT -> Atualiza Endereco");
        this.atualizaEnderecoService.update(atualizaEnderecoRequestDTO, id);
        return ResponseEntity.status(200).build();
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        logger.info("DELETE -> Atualiza Endereco");
        this.excluiEnderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
