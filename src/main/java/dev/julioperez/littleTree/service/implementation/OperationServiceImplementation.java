package dev.julioperez.littleTree.service.implementation;

import dev.julioperez.littleTree.model.Operation;
import dev.julioperez.littleTree.repository.OperationRepository;
import dev.julioperez.littleTree.service.OperationService;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImplementation implements OperationService {

    private final OperationRepository operationRepository;

    public OperationServiceImplementation(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }
}
