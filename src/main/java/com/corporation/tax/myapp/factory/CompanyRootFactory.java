package com.corporation.tax.myapp.factory;

import org.springframework.stereotype.Component;

import com.corporation.tax.myapp.model.AutoBusiness;
import com.corporation.tax.myapp.model.BusinessRoot;
import com.corporation.tax.myapp.model.SASBusiness;

@Component
public class CompanyRootFactory implements ICompanyRootFactory {

  @Override
  public BusinessRoot getAutoBusiness(int type) {
    switch (type) {
      case 1:
        return new AutoBusiness();
      case 2:
        return new SASBusiness();

      default:
        throw new IllegalArgumentException("Unknown type business");
    }
  }
}
