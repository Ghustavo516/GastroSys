package com.pos.restaurante.api.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDTO(@NotNull @NotEmpty String login, @NotNull @NotEmpty String password) {
}
