package com.corporation.tax.myapp.constants;

public enum TaxRatioByBusiness {
  AUTO_BUSINESS(25),
  SAS_BUSINESS(33);

  private Integer ratio;

  private TaxRatioByBusiness(Integer ratio) {
    this.ratio = ratio;
  }

  public Integer getRatio() {
    return ratio;
  }
}
