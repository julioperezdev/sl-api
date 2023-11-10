package dev.julioperez.littleTree.shared.infrastructure.spring;

import dev.julioperez.littleTree.box.balance.application.assignSellerBox.delivery.AssignSellerBoxDelivery;
import dev.julioperez.littleTree.box.balance.application.assignSellerBox.service.AssignSellerBoxService;
import dev.julioperez.littleTree.box.balance.application.saveOrUpdateBalance.adapter.SaveOrUpdateBalanceAdapterRepository;
import dev.julioperez.littleTree.box.balance.application.saveOrUpdateBalance.service.SaveOrUpdateBalanceService;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.application.getOfficeDebt.delivery.GetOfficeDebtDelivery;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.application.getOfficeDebt.service.GetOfficeDebtService;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.application.payDebt.delivery.PayDebtDelivery;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.application.payDebt.service.PayDebtService;
import dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.adapter.GetCurrencyMultiboxAdapterRepository;
import dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.delivery.GetCurrencyMultiboxDelivery;
import dev.julioperez.littleTree.box.currencyBox.shared.application.getCurrencyMultibox.service.GetCurrencyMultiboxService;
import dev.julioperez.littleTree.box.balance.application.manageBalance.adapter.ManageBalanceAdapterRepository;
import dev.julioperez.littleTree.box.balance.application.manageBalance.delivery.ManageBalanceDelivery;
import dev.julioperez.littleTree.box.balance.application.manageBalance.service.ManageBalanceService;
import dev.julioperez.littleTree.box.currencyBox.foreignExchange.application.manageForeignExchange.service.ManageForeignExchangeService;
import dev.julioperez.littleTree.box.currencyBox.officeDebt.application.manageOfficeDebt.service.ManageOfficeDebtService;
import dev.julioperez.littleTree.box.currencyBox.pesos.application.managePesos.service.ManagePesosService;
import dev.julioperez.littleTree.box.sellerbox.application.manageSellerBox.adapter.ManageSellerBoxAdapterRepository;
import dev.julioperez.littleTree.box.sellerbox.application.manageSellerBox.delivery.ManageSellerBoxDelivery;
import dev.julioperez.littleTree.box.sellerbox.application.manageSellerBox.service.ManageSellerBoxService;
import dev.julioperez.littleTree.box.balance.application.modelMapper.BalanceModelMapper;
import dev.julioperez.littleTree.box.currencyBox.shared.application.modelMapper.CurrencyMultiBoxModelMapper;
import dev.julioperez.littleTree.box.sellerbox.application.manualTransactionSellerBox.delivery.ManualTransactionSellerBoxDelivery;
import dev.julioperez.littleTree.box.sellerbox.application.manualTransactionSellerBox.service.ManualTransactionSellerBoxService;
import dev.julioperez.littleTree.box.sellerbox.application.modelMapper.SellerBoxModelMapper;
import dev.julioperez.littleTree.box.currencyBox.shared.application.updateCurrencyMultiBox.adapter.UpdateCurrencyMultiBoxAdapterRepository;
import dev.julioperez.littleTree.box.currencyBox.shared.application.updateCurrencyMultiBox.service.UpdateCurrencyMultiBoxService;
import dev.julioperez.littleTree.box.balance.infrastructure.repository.dao.BalanceDao;
import dev.julioperez.littleTree.box.currencyBox.shared.infrastructure.repository.dao.CurrencyMultiBoxDao;
import dev.julioperez.littleTree.box.sellerbox.infrastructure.repository.dao.SellerBoxDao;
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
import dev.julioperez.littleTree.operation.application.cancelOperation.adapter.CancelOperationAdapterRepository;
import dev.julioperez.littleTree.operation.application.cancelOperation.delivery.CancelOperationDelivery;
import dev.julioperez.littleTree.operation.application.cancelOperation.service.CancelOperationService;
import dev.julioperez.littleTree.operation.application.createOperation.adapter.CreateOperationAdapterRepository;
import dev.julioperez.littleTree.operation.application.createOperation.delivery.CreateOperationDelivery;
import dev.julioperez.littleTree.operation.application.createOperation.service.CreateOperationService;
import dev.julioperez.littleTree.operation.application.executeBuyOperation.adapter.ExecuteBuyOperationAdapterRepository;
import dev.julioperez.littleTree.operation.application.executeBuyOperation.service.ExecuteBuyOperationService;
import dev.julioperez.littleTree.operation.application.executeSellOperation.adapter.ExecuteSellOperationAdapterRepository;
import dev.julioperez.littleTree.operation.application.executeSellOperation.service.ExecuteSellOperationService;
import dev.julioperez.littleTree.operation.application.generateTicket.adapter.GenerateTicketAdapterGateway;
import dev.julioperez.littleTree.operation.application.generateTicket.service.GenerateTicketService;
import dev.julioperez.littleTree.operation.application.getOperations.adapter.GetOperationsAdapterRepository;
import dev.julioperez.littleTree.operation.application.getOperations.delivery.GetOperationsDelivery;
import dev.julioperez.littleTree.operation.application.getOperations.service.GetOperationsService;
import dev.julioperez.littleTree.operation.application.modelMapper.BuyOperationModelMapper;
import dev.julioperez.littleTree.operation.application.modelMapper.SellOperationModelMapper;
import dev.julioperez.littleTree.operation.application.pendingOperation.delivery.PendingOperationDelivery;
import dev.julioperez.littleTree.operation.application.pendingOperation.service.PendingOperationService;
import dev.julioperez.littleTree.operation.infrastructure.gateway.pdfBox.GenerateTicketPdfBox;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.BuyOperationDao;
import dev.julioperez.littleTree.operation.infrastructure.repository.dao.SellOperationDao;
import dev.julioperez.littleTree.box.currencyBox.shared.application.manualTransaction.delivery.ManualTransactionDelivery;
import dev.julioperez.littleTree.box.currencyBox.shared.application.manualTransaction.service.ManualTransactionService;
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
    private final BuyOperationDao buyOperationDao;
    private final SellOperationDao sellOperationDao;
    private final SellerDao sellerDao;
    private final SellerBoxDao sellerBoxDao;
    private final SellerCommissionDao sellerCommissionDao;
    private final ProviderDao providerDao;
    private final NoteDao noteDao;
    private final GenerateTicketPdfBox generateTicketPdfBox;


    public SpringDependenciesConfiguration(BalanceDao balanceDao, CurrencyMultiBoxDao currencyMultiBoxDao, ClientDao clientDao, ClientDifferenceDao clientDifferenceDao, CurrencyDao currencyDao, BuyOperationDao buyOperationDao, SellOperationDao sellOperationDao, SellerDao sellerDao, SellerBoxDao sellerBoxDao, SellerCommissionDao sellerCommissionDao, ProviderDao providerDao, NoteDao noteDao, GenerateTicketPdfBox generateTicketPdfBox) {
        this.balanceDao = balanceDao;
        this.currencyMultiBoxDao = currencyMultiBoxDao;
        this.clientDao = clientDao;
        this.clientDifferenceDao = clientDifferenceDao;
        this.currencyDao = currencyDao;
        this.buyOperationDao = buyOperationDao;
        this.sellOperationDao = sellOperationDao;
        this.sellerDao = sellerDao;
        this.sellerBoxDao = sellerBoxDao;
        this.sellerCommissionDao = sellerCommissionDao;
        this.providerDao = providerDao;
        this.noteDao = noteDao;
        this.generateTicketPdfBox = generateTicketPdfBox;
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
        return new CreateClientService(createClientAdapterRepository(), clientModelMapper(), getClientsService());
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
        return new GetClientDifferenceService(getClientDifferenceAdapterRepository(), getClientsService());
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
        return new CreateSellerService(createSellerAdapterRepository(), sellerModelMapper(), getSellerService());
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
        return new GetSellerCommissionService(getSellerCommissionAdapterRepository(), getSellerService());
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
        return new CreateSellerCommissionService(createSellerCommissionAdapterRepository(), sellerCommissionModelMapper(), getSellerCommissionService());
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
        return new CreateProviderService(createProviderAdapterRepository(), providerModelMapper(), getProviderService());
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

    /**
     * =====================================
     * Box
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    BalanceModelMapper balanceModelMapper(){
        return new BalanceModelMapper();
    }
    @Bean
    CurrencyMultiBoxModelMapper currencyMultiBoxModelMapper(){
        return new CurrencyMultiBoxModelMapper();
    }

    @Bean
    SellerBoxModelMapper sellerBoxModelMapper(){
        return new SellerBoxModelMapper();
    }

    /**
     * GetCurrencyMultibox
     */
    @Bean
    public GetCurrencyMultiboxAdapterRepository getCurrencyMultiboxAdapterRepository(){
        return new GetCurrencyMultiboxAdapterRepository(currencyMultiBoxDao,currencyMultiBoxModelMapper());
    }

    @Bean
    public GetCurrencyMultiboxService getCurrencyMultiboxService(){
        return new GetCurrencyMultiboxService(getCurrencyMultiboxAdapterRepository());
    }

    @Bean
    public GetCurrencyMultiboxDelivery getCurrencyMultiboxDelivery(){
        return new GetCurrencyMultiboxDelivery(getCurrencyMultiboxService());
    }

    /**
     * ManageBalance
     */
    @Bean
    public ManageBalanceAdapterRepository manageBalanceAdapterRepository(){
        return new ManageBalanceAdapterRepository(balanceDao,balanceModelMapper());
    }

    @Bean
    public ManageBalanceService manageBalanceService(){
        return new ManageBalanceService(manageBalanceAdapterRepository());
    }

    @Bean
    public ManageBalanceDelivery manageBalanceDelivery(){
        return new ManageBalanceDelivery(manageBalanceService());
    }

    /**
     * SaveOrUpdateBalance
     */

    @Bean
    public SaveOrUpdateBalanceAdapterRepository saveOrUpdateBalanceAdapterRepository(){
        return new SaveOrUpdateBalanceAdapterRepository(balanceDao,balanceModelMapper());
    }

    @Bean
    public SaveOrUpdateBalanceService saveOrUpdateBalanceService(){
        return new SaveOrUpdateBalanceService(saveOrUpdateBalanceAdapterRepository());
    }
    /**
     * AssignSellerBox
     */
    @Bean
    public AssignSellerBoxService assignSellerBoxService(){
        return new AssignSellerBoxService(manageBalanceService(),saveOrUpdateBalanceService(), manageSellerBoxService());
    }
    @Bean
    public AssignSellerBoxDelivery assignSellerBoxDelivery(){
        return new AssignSellerBoxDelivery(assignSellerBoxService());
    }

    /**
     * ManageForeignExchange
     */
    @Bean
    public ManageForeignExchangeService manageForeignExchangeService(){
        return new ManageForeignExchangeService();
    }

    /**
     * ManageOfficeDebt
     */
    @Bean
    public ManageOfficeDebtService manageOfficeDebtService(){
        return new ManageOfficeDebtService();
    }

    /**
     * PayDebt
     */
    @Bean
    public PayDebtService payDebtService(){
        return new PayDebtService(getCurrencyMultiboxService(),updateCurrencyMultiBoxService());
    }

    @Bean
    public PayDebtDelivery payDebtDelivery(){
        return new PayDebtDelivery(payDebtService());
    }

    /**
     * GetOfficeDebt
     */
    @Bean
    public GetOfficeDebtService getOfficeDebtService(){
        return new GetOfficeDebtService(getCurrencyMultiboxService());
    }

    @Bean
    public GetOfficeDebtDelivery getOfficeDebtDelivery(){
        return new GetOfficeDebtDelivery(getOfficeDebtService());
    }
    /**
     * ManagePesos
     */
    @Bean
    public ManagePesosService managePesosService(){
        return new ManagePesosService();
    }
    /**
     * ManageSellerBox
     */
    @Bean
    public ManageSellerBoxAdapterRepository manageSellerBoxAdapterRepository(){
        return new ManageSellerBoxAdapterRepository(sellerBoxDao,sellerBoxModelMapper());
    }
    @Bean
    public ManageSellerBoxService manageSellerBoxService(){
        return new ManageSellerBoxService(manageSellerBoxAdapterRepository());
    }
    @Bean
    public ManageSellerBoxDelivery manageSellerBoxDelivery(){
        return new ManageSellerBoxDelivery(manageSellerBoxService());
    }

    /**
     * ManualTransactionSellerBox
     */
    @Bean
    public ManualTransactionSellerBoxService manualTransactionSellerBox(){
        return new ManualTransactionSellerBoxService(manageSellerBoxService());
    }
    @Bean
    public ManualTransactionSellerBoxDelivery manualTransactionSellerBoxDelivery(){
        return new ManualTransactionSellerBoxDelivery(manualTransactionSellerBox());
    }

    /**
     * UpdateCurrencyMultiBox
     */
    @Bean
    public UpdateCurrencyMultiBoxAdapterRepository updateCurrencyMultiBoxAdapterRepository(){
        return new UpdateCurrencyMultiBoxAdapterRepository(currencyMultiBoxDao,currencyMultiBoxModelMapper());
    }
    @Bean
    public UpdateCurrencyMultiBoxService updateCurrencyMultiBoxService(){
        return new UpdateCurrencyMultiBoxService(updateCurrencyMultiBoxAdapterRepository(), manageForeignExchangeService(), managePesosService(), manageOfficeDebtService());
    }

    /**
     * =====================================
     * Operation
     * =====================================
     */
    /**
     * modelMapper
     */

    @Bean
    BuyOperationModelMapper buyOperationModelMapper(){
        return new BuyOperationModelMapper();
    }
    @Bean
    SellOperationModelMapper sellOperationModelMapper(){
        return new SellOperationModelMapper();
    }

    /**
     * CancelOperation
     */
    @Bean
    public CancelOperationAdapterRepository cancelOperationAdapterRepository(){
        return new CancelOperationAdapterRepository(buyOperationDao,sellOperationDao,buyOperationModelMapper(), sellOperationModelMapper());
    }

    @Bean
    public CancelOperationService cancelOperationService(){
        return new CancelOperationService(cancelOperationAdapterRepository(),getOperationsService() , updateCurrencyMultiBoxService());
    }
    @Bean
    public CancelOperationDelivery cancelOperationDelivery(){
        return new CancelOperationDelivery(cancelOperationService());
    }
    /**
     * CreateOperation
     */
    @Bean
    public CreateOperationAdapterRepository createOperationAdapterRepository(){
        return new CreateOperationAdapterRepository(buyOperationDao,sellOperationDao,buyOperationModelMapper(), sellOperationModelMapper());
    }

    @Bean
    public CreateOperationService createOperationService(){
        return new CreateOperationService(createOperationAdapterRepository(),updateCurrencyMultiBoxService(), getOperationsService());
    }
    @Bean
    public CreateOperationDelivery createOperationDelivery(){
        return new CreateOperationDelivery(createOperationService());
    }

    /**
     * ExecuteBuyOperation
     */
    @Bean
    public ExecuteBuyOperationAdapterRepository executeBuyOperationAdapterRepository(){
        return new ExecuteBuyOperationAdapterRepository(buyOperationDao,buyOperationModelMapper());
    }

    @Bean
    public ExecuteBuyOperationService executeBuyOperationService(){
        return new ExecuteBuyOperationService(executeBuyOperationAdapterRepository(), getOperationsService(), updateCurrencyMultiBoxService(),generateTicketService() );
    }

    /**
     * ExecuteSellOperation
     */
    @Bean
    public ExecuteSellOperationAdapterRepository executeSellOperationAdapterRepository(){
        return new ExecuteSellOperationAdapterRepository(sellOperationDao,sellOperationModelMapper());
    }

    @Bean
    public ExecuteSellOperationService executeSellOperationService(){
        return new ExecuteSellOperationService(executeSellOperationAdapterRepository(), getOperationsService(), updateCurrencyMultiBoxService(), manageBalanceService(), createSellerCommissionService(), generateTicketService());
    }
    /**
     * GetOperations
     */
    @Bean
    public GetOperationsAdapterRepository getOperationsAdapterRepository(){
        return new GetOperationsAdapterRepository(buyOperationDao,sellOperationDao,buyOperationModelMapper(), sellOperationModelMapper());
    }

    @Bean
    public GetOperationsService getOperationsService(){
        return new GetOperationsService(getOperationsAdapterRepository(), getClientsService());
    }
    @Bean
    public GetOperationsDelivery getOperationsDelivery(){
        return new GetOperationsDelivery(getOperationsService());
    }
    /**
     * PendingOperation
     */

    @Bean
    public PendingOperationService pendingOperationService(){
        return new PendingOperationService(executeBuyOperationService(),executeSellOperationService());
    }
    @Bean
    public PendingOperationDelivery pendingOperationDelivery(){
        return new PendingOperationDelivery(pendingOperationService());
    }

    /**
     * GenerateTicket
     */

    @Bean
    public GenerateTicketAdapterGateway generateTicketAdapterGateway(){
        return new GenerateTicketAdapterGateway(generateTicketPdfBox);
    }
    @Bean
    public GenerateTicketService generateTicketService(){
        return new GenerateTicketService(generateTicketAdapterGateway());
    }

    /**
     * ManualTransaction
     */

    @Bean
    public ManualTransactionService manualTransactionService(){
        return new ManualTransactionService(getCurrencyMultiboxService(),updateCurrencyMultiBoxService());
    }
    @Bean
    public ManualTransactionDelivery manualTransactionDelivery(){
        return new ManualTransactionDelivery(manualTransactionService());
    }
}

