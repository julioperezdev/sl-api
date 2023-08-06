package dev.julioperez.littleTree.domain.model;

import dev.julioperez.littleTree.domain.enums.OperationType;

import java.util.Date;
import java.util.UUID;

public class Operation {

    private UUID uuid;
    private Date createdAt;
    private UUID clientId;
    private OperationType operationType;
}
