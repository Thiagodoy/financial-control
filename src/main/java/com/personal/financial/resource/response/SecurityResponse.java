package com.personal.financial.resource.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityResponse {
    private String token;
    private Long expiresIn;
    private String dateTimeExpiresIn;
}
