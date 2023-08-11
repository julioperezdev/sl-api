package dev.julioperez.littleTree.shared.infrastructure.spring;

import dev.julioperez.littleTree.box.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.client.application.createClient.adapter.CreateClientAdapterRepository;
import dev.julioperez.littleTree.client.application.createClient.delivery.CreateClientDelivery;
import dev.julioperez.littleTree.client.application.createClient.service.CreateClientService;
import dev.julioperez.littleTree.client.application.getClients.adapter.GetClientsAdapterRepository;
import dev.julioperez.littleTree.client.application.getClients.delivery.GetClientsDelivery;
import dev.julioperez.littleTree.client.application.getClients.service.GetClientsService;
import dev.julioperez.littleTree.client.application.modelMapper.ClientModelMapper;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDao;
import dev.julioperez.littleTree.currency.infrastructure.repository.dao.CurrencyDao;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.OperationDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "dev.julioperez.*")
@EntityScan(basePackages = "dev.julioperez.*")
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = {"dev.julioperez.*"})
public class SpringDependenciesConfiguration {

    private final BalanceDao balanceDao;
    private final CurrencyMultiBoxDao currencyMultiBoxDao;
    private final ClientDao clientDao;
    private final CurrencyDao currencyDao;
    private final OperationDao operationDao;


    public SpringDependenciesConfiguration(BalanceDao balanceDao, CurrencyMultiBoxDao currencyMultiBoxDao, ClientDao clientDao, CurrencyDao currencyDao, OperationDao operationDao) {
        this.balanceDao = balanceDao;
        this.currencyMultiBoxDao = currencyMultiBoxDao;
        this.clientDao = clientDao;
        this.currencyDao = currencyDao;
        this.operationDao = operationDao;
    }

    /**
     * modelMapper
     */

    @Bean
    ClientModelMapper clientModelMapper(){
        return new ClientModelMapper();
    }
    /**
     * createClient
     */
    @Bean
    public CreateClientAdapterRepository createClientAdapterRepository(){
        return new CreateClientAdapterRepository(clientDao,clientModelMapper());
    }

    @Bean
    public CreateClientService createClientService(){
        return new CreateClientService(createClientAdapterRepository());
    }

    @Bean
    public CreateClientDelivery createClientDelivery(){
        return new CreateClientDelivery(createClientService(), clientModelMapper());
    }
    /**
     * getClients
     */
    @Bean
    public GetClientsAdapterRepository getClientsAdapterRepository(){
        return new GetClientsAdapterRepository(clientDao,clientModelMapper());
    }

    @Bean
    public GetClientsService getClientsService(){
        return new GetClientsService(getClientsAdapterRepository());
    }

    @Bean
    public GetClientsDelivery getClientsDelivery(){
        return new GetClientsDelivery(getClientsService());
    }

}
