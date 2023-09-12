package com.corporation.tax.myapp.model;

import com.corporation.tax.myapp.constants.TaxRatioByBusiness;

import lombok.Data;

@Data
public class AutoBusiness implements BusinessRoot {

  private long siretNumber;
  private String designation;
  private int tax;

  @Override
  public Double computeTax(int ratio, int salesRevenue) {
    return Double.valueOf((double) ratio / 100 * salesRevenue);
  }

  @Override
  public TaxRatioByBusiness getTypeOfBusiness() {
    return TaxRatioByBusiness.AUTO_BUSINESS;
  }
}
