package com.corporation.tax.myapp.reader;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corporation.tax.myapp.dao.Company;
import com.corporation.tax.myapp.dao.CompanyRepository;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class MyAppReader implements ItemReader<Company> {

  @Autowired CompanyRepository companyRepository;

  private List<Company> companylist;

  @BeforeStep
  public void initialize() {
    try {
      companylist = companyRepository.getAllCompanies();
    } catch (HibernateException e) {
      log.error(e.getMessage());
    }
  }

  @Override
  public Company read()
      throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    Company company = null;
    if (!companylist.isEmpty()) {
      company = companylist.get(0);
      companylist.remove(0);
    }
    return company;
  }
}
