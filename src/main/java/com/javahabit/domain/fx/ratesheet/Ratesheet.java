package com.javahabit.domain.fx.ratesheet;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Ratesheet {
    private String effective_start_date;
    private String effective_end_date;
    private String fixing_date;
    private List<Rate> rate_sheet;
}
