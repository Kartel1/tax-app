package com.corporation.tax.myapp.writer;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.corporation.tax.myapp.dao.Company;
import com.corporation.tax.myapp.dao.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAppWriter implements ItemWriter<Company> {
  @Autowired private CompanyRepository companyRepository;

  @Override
  public void write(List<? extends Company> items) throws Exception {
    try {
      items.stream().forEach(i -> companyRepository.updateTax(i.getTax(), i.getSiret()));
    } catch (HibernateException e) {
      log.error(e.getMessage());
    }
  }
}
