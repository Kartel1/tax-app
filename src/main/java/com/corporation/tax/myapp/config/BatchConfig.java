package com.corporation.tax.myapp.config;

import java.io.FileNotFoundException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.corporation.tax.myapp.dao.Company;
import com.corporation.tax.myapp.processor.MyAppProcessor;
import com.corporation.tax.myapp.reader.MyAppReader;
import com.corporation.tax.myapp.utils.MyAppSkipPolicy;
import com.corporation.tax.myapp.writer.MyAppWriter;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@ComponentScan(basePackages = "com.corporation.tax.myapp")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "com.corporation.tax.myapp")
@EntityScan(basePackages = "com.corporation.tax.myapp.dao")
public class BatchConfig extends DefaultBatchConfigurer {

  private static final Logger log = LoggerFactory.getLogger(BatchConfig.class);

  private final JobBuilderFactory jobBuilderFactory;

  private final StepBuilderFactory stepBuilderFactory;

  private MyAppReader reader;

  private MyAppProcessor processor;

  @Autowired
  public BatchConfig(
      JobBuilderFactory jobBuilderFactory,
      StepBuilderFactory stepBuilderFactory,
      MyAppReader reader,
      MyAppProcessor processor) {
    this.jobBuilderFactory = jobBuilderFactory;
    this.stepBuilderFactory = stepBuilderFactory;
    this.reader = reader;
    this.processor = processor;
  }

  @Override
  public void setDataSource(DataSource dataSource) {
    // override to do not set datasource even if a datasource exist.
    // initialize will use a Map based JobRepository (instead of database)
  }

  @Bean
  public Job job() {
    return jobBuilderFactory
        .get("myapp-job")
        .incrementer(new RunIdIncrementer())
        .flow(step())
        .end()
        .build();
  }

  @Bean
  public Step step() {
    return stepBuilderFactory
        .get("myapp-step")
        .<Company, Company>chunk(1)
        .reader(reader)
        .processor(processor)
        .writer(writer())
        .faultTolerant()
        .skip(Exception.class)
        .skipPolicy(policy())
        .noSkip(FileNotFoundException.class)
        .build();
  }

  @Bean
  public MyAppWriter writer() {
    return new MyAppWriter();
  }


  @Bean
  public MyAppSkipPolicy policy() {
    return new MyAppSkipPolicy();
  }

  @Bean
  ExitCodeExceptionMapper exitCodeToExceptionMapper() {
    return e -> {
      if (log.isDebugEnabled()) log.debug(e.toString(), e);
      else log.error(e.toString(), e);
      return 0;
    };
  }
}
