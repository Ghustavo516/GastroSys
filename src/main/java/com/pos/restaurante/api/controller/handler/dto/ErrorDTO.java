package com.pos.restaurante.api.controller.handler.dto;

import java.util.List;

public record ErrorDTO(List<String> errors, int status) {
 
}
