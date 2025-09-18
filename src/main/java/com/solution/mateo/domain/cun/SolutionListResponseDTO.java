package com.solution.mateo.domain.cun;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@Builder
public class SolutionListResponseDTO {
    private String id;
    private String nombreAlimento;
    private String nombrePlague;
    private String nombreRegion;
}
