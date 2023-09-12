package com.corporation.tax.myapp.model;

import com.corporation.tax.myapp.constants.TaxRatioByBusiness;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SASBusiness extends AutoBusiness {

  private String headerQuarterAddress;

  public TaxRatioByBusiness getTypeOfBusiness() {
    return TaxRatioByBusiness.SAS_BUSINESS;
  }
}
