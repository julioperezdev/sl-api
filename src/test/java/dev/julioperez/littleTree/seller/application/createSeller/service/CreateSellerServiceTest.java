package dev.julioperez.littleTree.seller.application.createSeller.service;

import dev.julioperez.littleTree.seller.domain.dto.CreateSellerRequest;
import dev.julioperez.littleTree.seller.domain.model.Seller;
import dev.julioperez.littleTree.seller.domain.port.createSeller.CreateSellerOutputPort;
import dev.julioperez.littleTree.seller.domain.port.mapper.SellerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
class CreateSellerServiceTest {
/*
    @Mock
    CreateSellerOutputPort createSellerOutputPort;
    @Mock
    SellerMapper sellerMapper;
    @InjectMocks
    CreateSellerService createSellerService;

    @Nested
    public class createSellerCases{
        CreateSellerRequest createSellerRequest = mock(CreateSellerRequest.class);
        Seller seller = mock(Seller.class);
        @Test
        void itShouldCreateSellerHappyCase() throws Exception {
            //given
            given(sellerMapper.toSellerModel(createSellerRequest)).willReturn(seller);
            given(createSellerOutputPort.createSeller(seller)).willReturn(seller);
            //when
            createSellerService.createSeller(createSellerRequest);
            //then
            verify(sellerMapper, atMostOnce()).toSellerModel(createSellerRequest);
            verify(createSellerOutputPort, atMostOnce()).createSeller(seller);
            verifyNoMoreInteractions(sellerMapper, createSellerRequest);

        }

        @Test
        void itShouldNotCreateSellerBecauseHaveInvalidData() throws Exception {
            //given
            CreateSellerRequest input = new CreateSellerRequest("Pedro","name", "1154879855", "description");
            given(sellerMapper.toSellerModel(any(CreateSellerRequest.class))).willThrow(IllegalArgumentException.class);
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> createSellerService.createSeller(input));
            verify(sellerMapper, atMostOnce()).toSellerModel(createSellerRequest);
            verify(createSellerOutputPort, never()).createSeller(seller);
            verifyNoMoreInteractions(sellerMapper,createSellerOutputPort);
        }
    }

 */
}