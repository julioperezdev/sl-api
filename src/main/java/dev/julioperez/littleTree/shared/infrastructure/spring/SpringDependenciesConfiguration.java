package dev.julioperez.littleTree.shared.infrastructure.spring;

import dev.julioperez.littleTree.box.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.client.application.createClient.adapter.CreateClientAdapterRepository;
import dev.julioperez.littleTree.client.application.createClient.delivery.CreateClientDelivery;
import dev.julioperez.littleTree.client.application.createClient.service.CreateClientService;
import dev.julioperez.littleTree.client.application.createClientDifference.adapter.CreateClientDifferenceAdapterRepository;
import dev.julioperez.littleTree.client.application.createClientDifference.delivery.CreateClientDifferenceDelivery;
import dev.julioperez.littleTree.client.application.createClientDifference.service.CreateClientDifferenceService;
import dev.julioperez.littleTree.client.application.getClientDifference.adapter.GetClientDifferenceAdapterRepository;
import dev.julioperez.littleTree.client.application.getClientDifference.delivery.GetClientDifferenceDelivery;
import dev.julioperez.littleTree.client.application.getClientDifference.service.GetClientDifferenceService;
import dev.julioperez.littleTree.client.application.getClients.adapter.GetClientsAdapterRepository;
import dev.julioperez.littleTree.client.application.getClients.delivery.GetClientsDelivery;
import dev.julioperez.littleTree.client.application.getClients.service.GetClientsService;
import dev.julioperez.littleTree.client.application.modelMapper.ClientDifferenceModelMapper;
import dev.julioperez.littleTree.client.application.modelMapper.ClientModelMapper;
import dev.julioperez.littleTree.client.application.updateClient.adapter.UpdateClientAdapterRepository;
import dev.julioperez.littleTree.client.application.updateClient.delivery.UpdateClientDelivery;
import dev.julioperez.littleTree.client.application.updateClient.service.UpdateClientService;
import dev.julioperez.littleTree.client.application.updateClientDifference.adapter.UpdateClientDifferenceAdapterRepository;
import dev.julioperez.littleTree.client.application.updateClientDifference.delivery.UpdateClientDifferenceDelivery;
import dev.julioperez.littleTree.client.application.updateClientDifference.service.UpdateClientDifferenceService;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDao;
import dev.julioperez.littleTree.client.infrastructure.repository.dao.ClientDifferenceDao;
import dev.julioperez.littleTree.currency.application.getCurrency.adapter.GetCurrencyAdapterRepository;
import dev.julioperez.littleTree.currency.application.getCurrency.delivery.GetCurrencyDelivery;
import dev.julioperez.littleTree.currency.application.getCurrency.service.GetCurrencyService;
import dev.julioperez.littleTree.currency.application.modelMapper.CurrencyModelMapper;
import dev.julioperez.littleTree.currency.application.updateCurrency.adapter.UpdateCurrencyAdapterRepository;
import dev.julioperez.littleTree.currency.application.updateCurrency.delivery.UpdateCurrencyDelivery;
import dev.julioperez.littleTree.currency.application.updateCurrency.service.UpdateCurrencyService;
import dev.julioperez.littleTree.currency.infrastructure.repository.dao.CurrencyDao;
import dev.julioperez.littleTree.note.application.createNote.adapter.CreateNoteAdapterRepository;
import dev.julioperez.littleTree.note.application.createNote.delivery.CreateNoteDelivery;
import dev.julioperez.littleTree.note.application.createNote.service.CreateNoteService;
import dev.julioperez.littleTree.note.application.deleteNote.adapter.DeleteNoteAdapterRepository;
import dev.julioperez.littleTree.note.application.deleteNote.delivery.DeleteNoteDelivery;
import dev.julioperez.littleTree.note.application.deleteNote.service.DeleteNoteService;
import dev.julioperez.littleTree.note.application.getNote.adapter.GetNoteAdapterRepository;
import dev.julioperez.littleTree.note.application.getNote.delivery.GetNoteDelivery;
import dev.julioperez.littleTree.note.application.getNote.service.GetNoteService;
import dev.julioperez.littleTree.note.application.modelMapper.NoteModelMapper;
import dev.julioperez.littleTree.note.application.updateNote.adapter.UpdateNoteAdapterRepository;
import dev.julioperez.littleTree.note.application.updateNote.delivery.UpdateNoteDelivery;
import dev.julioperez.littleTree.note.application.updateNote.service.UpdateNoteService;
import dev.julioperez.littleTree.note.infrastructure.repository.dao.NoteDao;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.OperationDao;
import dev.julioperez.littleTree.provider.application.createProvider.adapter.CreateProviderAdapterRepository;
import dev.julioperez.littleTree.provider.application.createProvider.delivery.CreateProviderDelivery;
import dev.julioperez.littleTree.provider.application.createProvider.service.CreateProviderService;
import dev.julioperez.littleTree.provider.application.getProviders.adapter.GetProviderAdapterRepository;
import dev.julioperez.littleTree.provider.application.getProviders.delivery.GetProviderDelivery;
import dev.julioperez.littleTree.provider.application.getProviders.service.GetProviderService;
import dev.julioperez.littleTree.provider.application.modelMapper.ProviderModelMapper;
import dev.julioperez.littleTree.provider.application.updateProvider.adapter.UpdateProviderAdapterRepository;
import dev.julioperez.littleTree.provider.application.updateProvider.delivery.UpdateProviderDelivery;
import dev.julioperez.littleTree.provider.application.updateProvider.service.UpdateProviderService;
import dev.julioperez.littleTree.provider.infrastructure.repository.dao.ProviderDao;
import dev.julioperez.littleTree.seller.application.createSeller.adapter.CreateSellerAdapterRepository;
import dev.julioperez.littleTree.seller.application.createSeller.delivery.CreateSellerDelivery;
import dev.julioperez.littleTree.seller.application.createSeller.service.CreateSellerService;
import dev.julioperez.littleTree.seller.application.createSellerCommission.adapter.CreateSellerCommissionAdapterRepository;
import dev.julioperez.littleTree.seller.application.createSellerCommission.delivery.CreateSellerCommissionDelivery;
import dev.julioperez.littleTree.seller.application.createSellerCommission.service.CreateSellerCommissionService;
import dev.julioperez.littleTree.seller.application.getSeller.adapter.GetSellerAdapterRepository;
import dev.julioperez.littleTree.seller.application.getSeller.delivery.GetSellerDelivery;
import dev.julioperez.littleTree.seller.application.getSeller.service.GetSellerService;
import dev.julioperez.littleTree.seller.application.getSellerCommission.adapter.GetSellerCommissionAdapterRepository;
import dev.julioperez.littleTree.seller.application.getSellerCommission.delivery.GetSellerCommissionDelivery;
import dev.julioperez.littleTree.seller.application.getSellerCommission.service.GetSellerCommissionService;
import dev.julioperez.littleTree.seller.application.modelMapper.SellerCommissionModelMapper;
import dev.julioperez.littleTree.seller.application.modelMapper.SellerModelMapper;
import dev.julioperez.littleTree.seller.application.updateSeller.adapter.UpdateSellerAdapterRepository;
import dev.julioperez.littleTree.seller.application.updateSeller.delivery.UpdateSellerDelivery;
import dev.julioperez.littleTree.seller.application.updateSeller.service.UpdateSellerService;
import dev.julioperez.littleTree.seller.application.updateSellerCommission.adapter.UpdateSellerCommissionAdapterRepository;
import dev.julioperez.littleTree.seller.application.updateSellerCommission.delivery.UpdateSellerCommissionDelivery;
import dev.julioperez.littleTree.seller.application.updateSellerCommission.service.UpdateSellerCommissionService;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerCommissionDao;
import dev.julioperez.littleTree.seller.infrastructure.repository.dao.SellerDao;
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
    private final ClientDifferenceDao clientDifferenceDao;
    private final CurrencyDao currencyDao;
    private final OperationDao operationDao;
    private final SellerDao sellerDao;
    private final SellerCommissionDao sellerCommissionDao;
    private final ProviderDao providerDao;
    private final NoteDao noteDao;


    public SpringDependenciesConfiguration(BalanceDao balanceDao, CurrencyMultiBoxDao currencyMultiBoxDao, ClientDao clientDao, ClientDifferenceDao clientDifferenceDao, CurrencyDao currencyDao, OperationDao operationDao, SellerDao sellerDao, SellerCommissionDao sellerCommissionDao, ProviderDao providerDao, NoteDao noteDao) {
        this.balanceDao = balanceDao;
        this.currencyMultiBoxDao = currencyMultiBoxDao;
        this.clientDao = clientDao;
        this.clientDifferenceDao = clientDifferenceDao;
        this.currencyDao = currencyDao;
        this.operationDao = operationDao;
        this.sellerDao = sellerDao;
        this.sellerCommissionDao = sellerCommissionDao;
        this.providerDao = providerDao;
        this.noteDao = noteDao;
    }

    /**
     * =====================================
     * Client
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    ClientModelMapper clientModelMapper(){
        return new ClientModelMapper();
    }
    @Bean
    ClientDifferenceModelMapper clientDifferenceModelMapper(){
        return new ClientDifferenceModelMapper();
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
        return new CreateClientService(createClientAdapterRepository(), clientModelMapper());
    }

    @Bean
    public CreateClientDelivery createClientDelivery(){
        return new CreateClientDelivery(createClientService());
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
    /**
     * UpdateClient
     */
    @Bean
    public UpdateClientAdapterRepository updateClientAdapterRepository(){
        return new UpdateClientAdapterRepository(clientDao,clientModelMapper());
    }

    @Bean
    public UpdateClientService updateClientService(){
        return new UpdateClientService(updateClientAdapterRepository(), getClientsService(), clientModelMapper());
    }

    @Bean
    public UpdateClientDelivery updateClientDelivery(){
        return new UpdateClientDelivery(updateClientService());
    }

    /**
     * GetClientDifference
     */
    @Bean
    public GetClientDifferenceAdapterRepository getClientDifferenceAdapterRepository(){
        return new GetClientDifferenceAdapterRepository(clientDifferenceDao,clientDifferenceModelMapper());
    }

    @Bean
    public GetClientDifferenceService getClientDifferenceService(){
        return new GetClientDifferenceService(getClientDifferenceAdapterRepository());
    }

    @Bean
    public GetClientDifferenceDelivery getClientDifferenceDelivery(){
        return new GetClientDifferenceDelivery(getClientDifferenceService());
    }

    /**
     * CreateClientDifference
     */
    @Bean
    public CreateClientDifferenceAdapterRepository createClientDifferenceAdapterRepository(){
        return new CreateClientDifferenceAdapterRepository(clientDifferenceDao,clientDifferenceModelMapper());
    }

    @Bean
    public CreateClientDifferenceService createClientDifferenceService(){
        return new CreateClientDifferenceService(createClientDifferenceAdapterRepository(),clientDifferenceModelMapper());
    }

    @Bean
    public CreateClientDifferenceDelivery createClientDifferenceDelivery(){
        return new CreateClientDifferenceDelivery(createClientDifferenceService());
    }

    /**
     * UpdateClientDifference
     */
    @Bean
    public UpdateClientDifferenceAdapterRepository updateClientDifferenceAdapterRepository(){
        return new UpdateClientDifferenceAdapterRepository(clientDifferenceDao,clientDifferenceModelMapper());
    }

    @Bean
    public UpdateClientDifferenceService updateClientDifferenceService(){
        return new UpdateClientDifferenceService(updateClientDifferenceAdapterRepository(), getClientDifferenceService(),clientDifferenceModelMapper());
    }

    @Bean
    public UpdateClientDifferenceDelivery updateClientDifferenceDelivery(){
        return new UpdateClientDifferenceDelivery(updateClientDifferenceService());
    }
    /**
     * =====================================
     * Seller
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    SellerModelMapper sellerModelMapper(){
        return new SellerModelMapper();
    }
    @Bean
    SellerCommissionModelMapper sellerCommissionModelMapper(){
        return new SellerCommissionModelMapper();
    }

    /**
     * CreateSeller
     */
    @Bean
    public CreateSellerAdapterRepository createSellerAdapterRepository(){
        return new CreateSellerAdapterRepository(sellerDao,sellerModelMapper());
    }

    @Bean
    public CreateSellerService createSellerService(){
        return new CreateSellerService(createSellerAdapterRepository(), sellerModelMapper());
    }

    @Bean
    public CreateSellerDelivery createSellerDelivery(){
        return new CreateSellerDelivery(createSellerService());
    }
    /**
     * GetSeller
     */
    @Bean
    public GetSellerAdapterRepository getSellerAdapterRepository(){
        return new GetSellerAdapterRepository(sellerDao,sellerModelMapper());
    }

    @Bean
    public GetSellerDelivery getSellerDelivery(){
        return new GetSellerDelivery(getSellerService());
    }

    @Bean
    public GetSellerService getSellerService(){
        return new GetSellerService(getSellerAdapterRepository());
    }
    /**
     * UpdateSeller
     */
    @Bean
    public UpdateSellerAdapterRepository updateSellerAdapterRepository(){
        return new UpdateSellerAdapterRepository(sellerDao,sellerModelMapper());
    }

    @Bean
    public UpdateSellerDelivery updateSellerDelivery(){
        return new UpdateSellerDelivery(updateSellerService());
    }

    @Bean
    public UpdateSellerService updateSellerService(){
        return new UpdateSellerService(updateSellerAdapterRepository(), getSellerService(), sellerModelMapper());
    }
    /**
     * GetSellerCommission
     */
    @Bean
    public GetSellerCommissionAdapterRepository getSellerCommissionAdapterRepository(){
        return new GetSellerCommissionAdapterRepository(sellerCommissionDao,sellerCommissionModelMapper());
    }

    @Bean
    public GetSellerCommissionDelivery getSellerCommissionDelivery(){
        return new GetSellerCommissionDelivery(getSellerCommissionService());
    }

    @Bean
    public GetSellerCommissionService getSellerCommissionService(){
        return new GetSellerCommissionService(getSellerCommissionAdapterRepository());
    }
    /**
     * CreateSellerCommission
     */
    @Bean
    public CreateSellerCommissionAdapterRepository createSellerCommissionAdapterRepository(){
        return new CreateSellerCommissionAdapterRepository(sellerCommissionDao,sellerCommissionModelMapper());
    }

    @Bean
    public CreateSellerCommissionService createSellerCommissionService(){
        return new CreateSellerCommissionService(createSellerCommissionAdapterRepository(), sellerCommissionModelMapper());
    }

    @Bean
    public CreateSellerCommissionDelivery createSellerCommissionDelivery(){
        return new CreateSellerCommissionDelivery(createSellerCommissionService());
    }
    /**
     * UpdateSellerCommission
     */
    @Bean
    public UpdateSellerCommissionAdapterRepository updateSellerCommissionAdapterRepository(){
        return new UpdateSellerCommissionAdapterRepository(sellerCommissionDao,sellerCommissionModelMapper());
    }

    @Bean
    public UpdateSellerCommissionDelivery updateSellerCommissionDelivery(){
        return new UpdateSellerCommissionDelivery(updateSellerCommissionService());
    }

    @Bean
    public UpdateSellerCommissionService updateSellerCommissionService(){
        return new UpdateSellerCommissionService(updateSellerCommissionAdapterRepository(), getSellerCommissionService(), sellerCommissionModelMapper());
    }
    /**
     * =====================================
     * Provider
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    ProviderModelMapper providerModelMapper(){
        return new ProviderModelMapper();
    }

    /**
     * CreateProvider
     */
    @Bean
    public CreateProviderAdapterRepository createProviderAdapterRepository(){
        return new CreateProviderAdapterRepository(providerDao,providerModelMapper());
    }

    @Bean
    public CreateProviderService createProviderService(){
        return new CreateProviderService(createProviderAdapterRepository(), providerModelMapper());
    }

    @Bean
    public CreateProviderDelivery createProviderDelivery(){
        return new CreateProviderDelivery(createProviderService());
    }
    /**
     * GetProvider
     */
    @Bean
    public GetProviderAdapterRepository getProviderAdapterRepository(){
        return new GetProviderAdapterRepository(providerDao,providerModelMapper());
    }

    @Bean
    public GetProviderDelivery getProviderDelivery(){
        return new GetProviderDelivery(getProviderService());
    }

    @Bean
    public GetProviderService getProviderService(){
        return new GetProviderService(getProviderAdapterRepository());
    }
    /**
     * UpdateProvider
     */
    @Bean
    public UpdateProviderAdapterRepository updateProviderAdapterRepository(){
        return new UpdateProviderAdapterRepository(providerDao,providerModelMapper());
    }

    @Bean
    public UpdateProviderDelivery updateProviderDelivery(){
        return new UpdateProviderDelivery(updateProviderService());
    }

    @Bean
    public UpdateProviderService updateProviderService(){
        return new UpdateProviderService(updateProviderAdapterRepository(), getProviderService(), providerModelMapper());
    }

    /**
     * =====================================
     * Currency
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    CurrencyModelMapper currencyModelMapper(){
        return new CurrencyModelMapper();
    }

    /**
     * GetCurrency
     */
    @Bean
    public GetCurrencyAdapterRepository getCurrencyAdapterRepository(){
        return new GetCurrencyAdapterRepository(currencyDao,currencyModelMapper());
    }

    @Bean
    public GetCurrencyDelivery getCurrencyDelivery(){
        return new GetCurrencyDelivery(getCurrencyService());
    }

    @Bean
    public GetCurrencyService getCurrencyService(){
        return new GetCurrencyService(getCurrencyAdapterRepository());
    }
    /**
     * UpdateCurrency
     */
    @Bean
    public UpdateCurrencyAdapterRepository updateCurrencyAdapterRepository(){
        return new UpdateCurrencyAdapterRepository(currencyDao,currencyModelMapper());
    }

    @Bean
    public UpdateCurrencyDelivery updateCurrencyDelivery(){
        return new UpdateCurrencyDelivery(updateCurrencyService());
    }

    @Bean
    public UpdateCurrencyService updateCurrencyService(){
        return new UpdateCurrencyService(updateCurrencyAdapterRepository(), getCurrencyService(), currencyModelMapper());
    }
    /**
     * =====================================
     * Note
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    NoteModelMapper noteModelMapper(){
        return new NoteModelMapper();
    }

    /**
     * CreateNote
     */
    @Bean
    public CreateNoteAdapterRepository createNoteAdapterRepository(){
        return new CreateNoteAdapterRepository(noteDao,noteModelMapper());
    }

    @Bean
    public CreateNoteService createNoteService(){
        return new CreateNoteService(createNoteAdapterRepository(), noteModelMapper());
    }

    @Bean
    public CreateNoteDelivery createNoteDelivery(){
        return new CreateNoteDelivery(createNoteService());
    }
    /**
     * GetNote
     */
    @Bean
    public GetNoteAdapterRepository getNoteAdapterRepository(){
        return new GetNoteAdapterRepository(noteDao,noteModelMapper());
    }

    @Bean
    public GetNoteDelivery getNoteDelivery(){
        return new GetNoteDelivery(getNoteService());
    }

    @Bean
    public GetNoteService getNoteService(){
        return new GetNoteService(getNoteAdapterRepository());
    }
    /**
     * UpdateNote
     */
    @Bean
    public UpdateNoteAdapterRepository updateNoteAdapterRepository(){
        return new UpdateNoteAdapterRepository(noteDao,noteModelMapper());
    }

    @Bean
    public UpdateNoteDelivery updateNoteDelivery(){
        return new UpdateNoteDelivery(updateNoteService());
    }

    @Bean
    public UpdateNoteService updateNoteService(){
        return new UpdateNoteService(updateNoteAdapterRepository(), getNoteService(), noteModelMapper());
    }
    /**
     * DeleteNote
     */
    @Bean
    public DeleteNoteAdapterRepository deleteNoteAdapterRepository(){
        return new DeleteNoteAdapterRepository(noteDao);
    }

    @Bean
    public DeleteNoteDelivery deleteNoteDelivery(){
        return new DeleteNoteDelivery(deleteNoteService());
    }

    @Bean
    public DeleteNoteService deleteNoteService(){
        return new DeleteNoteService(deleteNoteAdapterRepository());
    }
}
