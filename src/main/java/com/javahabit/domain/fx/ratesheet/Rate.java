package com.javahabit.domain.fx.ratesheet;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Rate {
    private String rate_type;
    private String receiving_method;
    private BuyOrSell buy_or_sell;
    private String base_currency_code;
    private String contra_currency_code;
    private Double exchange_rate;
    private int exchange_rate_precision;
    private String exchange_rate_conversion_rule;
    private String value_date_type;
    private Double maximum_amount;


}

