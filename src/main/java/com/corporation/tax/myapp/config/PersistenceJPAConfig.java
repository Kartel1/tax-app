package com.corporation.tax.myapp.config;

//@Configuration
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//@EnableJpaRepositories(basePackages = "com.corporation.tax.myapp")

public class PersistenceJPAConfig {

  /*private final Environment env;

  @Autowired
  public PersistenceJPAConfig(Environment env) {
    this.env = env;
  }*/

  /* @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan(
        "",
        "");

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("datasource.hibernate.hbm2ddl.auto"));
    properties.put("hibernate.dialect", env.getProperty("datasource.hibernate.dialect"));
    properties.put("hibernate.show_sql", env.getProperty("datasource.hibernate.show_sql"));
    properties.put(
        "hibernate.default_schema", env.getProperty("datasource.hibernate.default_schema"));

    System.out.println("Properties = " + properties);

    em.setJpaPropertyMap(properties);

    return em;
  }
  @Bean(name = "dataSourceUnicode")
  public DataSource dataSourceUnicode() {
  	DriverManagerDataSource dataSource = new DriverManagerDataSource();
  	dataSource.setDriverClassName(env.getProperty("datasource.driver-class-name"));
  	dataSource.setUrl(env.getProperty("datasourceUnicode.url"));
  	dataSource.setUsername(env.getProperty("datasource.username"));
  	dataSource.setPassword(env.getProperty("datasource.password"));
  	return dataSource;
  }*/

  /*@Bean(name = "dataSource")
  @Primary
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("datasource.driver-class-name"));
    dataSource.setUrl(env.getProperty("datasource.url"));
    dataSource.setUsername(env.getProperty("datasource.username"));
    dataSource.setPassword(env.getProperty("datasource.password"));
    return dataSource;
  }*/
}
