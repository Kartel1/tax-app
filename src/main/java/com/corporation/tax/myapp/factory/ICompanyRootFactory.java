package com.corporation.tax.myapp.factory;

import com.corporation.tax.myapp.model.BusinessRoot;

public interface ICompanyRootFactory {

  public BusinessRoot getAutoBusiness(int type);
}
