package com.corporation.tax.myapp.processor;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corporation.tax.myapp.dao.Company;
import com.corporation.tax.myapp.factory.CompanyRootFactory;
import com.corporation.tax.myapp.model.BusinessRoot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyAppProcessor implements ItemProcessor<Company, Company> {

  @Autowired CompanyRootFactory businessRootFactory;

  /*public MyAppProcessor(BusinessRootFactory businessRootFactory) {
    this.businessRootFactory = businessRootFactory;
  }*/

  @Override
  public Company process(Company item) throws Exception {
    BusinessRoot businessRoot = businessRootFactory.getAutoBusiness(item.getType());
    item.setTax(
        businessRoot.computeTax(businessRoot.getTypeOfBusiness().getRatio(), item.getTotalvalue()));

    DecimalFormat df = new DecimalFormat("############.00");
    df.setRoundingMode(RoundingMode.HALF_UP);
    log.info("TAX  ==================== : " + df.format(item.getTax()));
    return item;
  }
}
