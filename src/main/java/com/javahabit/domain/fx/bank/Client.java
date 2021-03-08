package com.javahabit.domain.fx.bank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private  String first_name;
    private String last_name;
    private String middle_name;
}
