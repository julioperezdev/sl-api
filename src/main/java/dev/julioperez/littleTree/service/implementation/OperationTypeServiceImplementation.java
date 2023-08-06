package dev.julioperez.littleTree.service.implementation;

import dev.julioperez.littleTree.model.OperationType;
import dev.julioperez.littleTree.repository.OperationTypeRepository;
import dev.julioperez.littleTree.service.OperationTypeService;
import org.springframework.stereotype.Service;

@Service
public class OperationTypeServiceImplementation implements OperationTypeService {

    private final OperationTypeRepository operationTypeRepository;

    public OperationTypeServiceImplementation(OperationTypeRepository operationTypeRepository) {
        this.operationTypeRepository = operationTypeRepository;
    }

    @Override
    public OperationType getOperationById(String id) throws Exception {
        try{
            return operationTypeRepository.getReferenceById(id);
        }catch (Exception exception){
            throw new Exception("Error in getOperationById method", exception);
        }
    }
}
