package com.corporation.tax.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, IdentityCompany> {

  @Query(value = "select * from public.\"Company\"", nativeQuery = true)
  List<Company> getAllCompanies();

  @Transactional
  @Modifying
  @Query(value = "update public.\"Company\" set tax =:tax where siret = :siret", nativeQuery = true)
  void updateTax(@Param("tax") double tax, @Param("siret") int siret);
}
