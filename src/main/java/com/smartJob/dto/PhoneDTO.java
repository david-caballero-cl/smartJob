package com.smartJob.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
    private String number;
    private String cityCode;
    private String countryCode;
}
