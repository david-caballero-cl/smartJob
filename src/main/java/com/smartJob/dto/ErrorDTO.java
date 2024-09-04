package com.smartJob.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {
    String message;
}
