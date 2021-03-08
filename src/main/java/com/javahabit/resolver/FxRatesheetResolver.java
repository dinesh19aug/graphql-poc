package com.javahabit.resolver;

import com.google.gson.Gson;
import com.javahabit.domain.fx.ratesheet.BuyOrSell;
import com.javahabit.domain.fx.ratesheet.Rate;
import com.javahabit.domain.fx.ratesheet.Ratesheet;
import com.javahabit.exception.BusinessException;
import com.javahabit.filter.BuyOrSellFilter;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class FxRatesheetResolver implements GraphQLQueryResolver {



    public Ratesheet ratesheet(BuyOrSellFilter  buyOrSellFilter){
        log.info("Calling ratesheet ... ");

        Ratesheet ratesheet = readRateSheetResponse();

        applyFilters(ratesheet, buyOrSellFilter);
        return ratesheet;
    }

    private void applyFilters(Ratesheet ratesheet, BuyOrSellFilter buyOrSellFilter) {

        if(buyOrSellFilter!=null) {
            String filterValue = buyOrSellFilter.getBuyOrSell();
            if(!isEnumInBuyOrSell(filterValue, BuyOrSell.class)){
                throw new BusinessException("1007-063","BuyOrSell.NOT is not a valid enum value");
            }
            List<Rate> filteredRateList = new ArrayList<>();
            for (Rate rate : ratesheet.getRate_sheet()) {
                if (rate.getBuy_or_sell() != null && rate.getBuy_or_sell().toString().equalsIgnoreCase(filterValue)) {
                    filteredRateList.add(rate);
                }
            }
            ratesheet.setRate_sheet(filteredRateList);
        }



}

    private boolean isEnumInBuyOrSell(String filterValue, Class<BuyOrSell> buyOrSellClass) {
        boolean isEnumExist = Arrays.stream(buyOrSellClass.getEnumConstants()).anyMatch(value -> value.name().equalsIgnoreCase(filterValue));
        return isEnumExist;
    }



    public Ratesheet readRateSheetResponse(){
        Gson gson = new Gson();
        Ratesheet ratesheet = null;
        try {
             ratesheet = gson.fromJson(new FileReader("src/main/resources/json/rateSheetResp.json"), Ratesheet.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ratesheet;
    }

}

