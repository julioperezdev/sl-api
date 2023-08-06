package dev.julioperez.littleTree.service;

import dev.julioperez.littleTree.model.OperationType;

public interface OperationTypeService {
    OperationType getOperationById(String id) throws Exception;
}
