package dev.julioperez.littleTree.seller.application.createSeller.service;

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