package com.corporation.tax.myapp.model;

import com.corporation.tax.myapp.constants.TaxRatioByBusiness;

public interface BusinessRoot {

	public Double computeTax(int ratio, int salesRevenue);
	
	public TaxRatioByBusiness getTypeOfBusiness();
}
