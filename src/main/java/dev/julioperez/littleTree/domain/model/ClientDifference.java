package dev.julioperez.littleTree.domain.model;

import dev.julioperez.littleTree.domain.enums.DifferenceStatus;
import dev.julioperez.littleTree.domain.enums.DifferenceType;
import java.util.Date;
import java.util.UUID;


public class ClientDifference {


    private UUID uuid;
    private Date createdAt;
    private UUID clientId;
    private Float amount;
    private String description;
    private DifferenceType differenceType;
    private DifferenceStatus differenceStatus;

}
