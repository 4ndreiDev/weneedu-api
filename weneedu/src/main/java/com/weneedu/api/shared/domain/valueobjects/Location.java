package com.weneedu.api.shared.domain.valueobjects;

import java.util.UUID;

public record Location(UUID id, String cityCode, String provinceCode) {
}
