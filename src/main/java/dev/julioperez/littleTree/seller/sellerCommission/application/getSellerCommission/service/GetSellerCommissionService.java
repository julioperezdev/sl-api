package dev.julioperez.littleTree.seller.sellerCommission.application.getSellerCommission.service;

import dev.julioperez.littleTree.seller.sellerCommission.domain.dto.SellerCommissionResponseDto;
import dev.julioperez.littleTree.seller.sellerCommission.domain.enums.SellerCommissionStatus;
import dev.julioperez.littleTree.seller.sellerCommission.domain.model.SellerCommission;
import dev.julioperez.littleTree.seller.seller.domain.port.getSeller.GetSeller;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission.GetSellerCommission;
import dev.julioperez.littleTree.seller.sellerCommission.domain.port.getSellerCommission.GetSellerCommissionOutputPort;

import java.util.*;

public class GetSellerCommissionService implements GetSellerCommission {
    private final GetSellerCommissionOutputPort getSellerCommissionOutputPort;
    private final GetSeller getSeller;

    public GetSellerCommissionService(GetSellerCommissionOutputPort getSellerCommissionOutputPort, GetSeller getSeller) {
        this.getSellerCommissionOutputPort = getSellerCommissionOutputPort;
        this.getSeller = getSeller;
    }

    @Override
    public List<SellerCommission> getSellerCommission() {
        return getSellerCommissionOutputPort.getSellerCommission();
    }

    @Override
    public List<SellerCommissionResponseDto> getPendingSellerCommission(){
        return getSellerCommissionResponseDtoByStatus(SellerCommissionStatus.PENDING);
    }
    @Override
    public List<SellerCommissionResponseDto> getDoneSellerCommission(){
        return getSellerCommissionResponseDtoByStatus(SellerCommissionStatus.DONE);
    }

    private List<SellerCommissionResponseDto> getSellerCommissionResponseDtoByStatus(SellerCommissionStatus sellerCommissionStatus) {
        List<SellerCommission> sellerCommission = getSellerCommission()
                .stream()
                .filter(particular -> particular.getStatus().equals(sellerCommissionStatus.value()))
                .sorted(Comparator.comparing(SellerCommission::getUpdatedAt).reversed())
                .toList();
        List<String> sellerIds = sellerCommission.stream().map(SellerCommission::getSellerId).toList();
        Map<String, String> sellerNamesById = getSeller.getSellerNamesById(sellerIds);
        List<SellerCommissionResponseDto> sellerCommissionResponseDto = new ArrayList<>();
        sellerCommission.forEach(particular->{
            String sellerName = sellerNamesById.get(particular.getSellerId());
            SellerCommissionResponseDto mapped = mapToSellerCommissionResponseDto(particular, sellerName);

            sellerCommissionResponseDto.add(mapped);
        });
        return sellerCommissionResponseDto;
    }

    private SellerCommissionResponseDto mapToSellerCommissionResponseDto(SellerCommission sellerCommission, String sellerName){
        return new SellerCommissionResponseDto(
                sellerCommission.getId(),
                sellerCommission.getUpdatedAt().toString(),
                sellerName,
                sellerCommission.getPesos(),
                sellerCommission.getQuantity(),
                sellerCommission.getProfit(),
                sellerCommission.getOperationId(),
                sellerCommission.getStatus());
    }

    @Override
    public Optional<SellerCommission> getSellerCommissionById(String id) {
        List<SellerCommission> sellerCommissions = getSellerCommission();
        return sellerCommissions.stream()
                .filter(sellerCommission -> sellerCommission.getId().equals(id))
                .findFirst();
    }
    public Optional<SellerCommission> getLastSellerCommissionBySellerId(String sellerId) {
        List<SellerCommission> sellerCommissions = getSellerCommission();
        if(sellerCommissions.isEmpty()) return Optional.empty();
        return sellerCommissions
                .stream()
                .filter(particular -> particular.getSellerId().equals(sellerId))
                .max(Comparator.comparing(SellerCommission::getUpdatedAt));

    }



}
