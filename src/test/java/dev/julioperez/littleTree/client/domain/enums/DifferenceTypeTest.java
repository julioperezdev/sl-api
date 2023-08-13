package dev.julioperez.littleTree.client.domain.enums;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifferenceTypeTest {

    @Nested
    public class isLackCases{
        @Test
        void itShouldBeLackHappyCase(){
            //given
            DifferenceType differenceType = DifferenceType.LACK;
            //when
            boolean result = differenceType.isLack();
            //then
            assertTrue(result);
        }
        @Test
        void itShouldNotBeLack(){
            //given
            DifferenceType differenceType = DifferenceType.SPARE;
            //when
            boolean result = differenceType.isLack();
            //then
            assertFalse(result);
        }

    }
    @Nested
    public class returnDifferenceTypeByDescriptionCases{
        @Test
        void itShouldReturnLackDifferenceTypeByDescriptionHappyCase() {
            //given
            String valueToTest = "falta";
            //when
            DifferenceType differenceType = DifferenceType.returnDifferenceTypeByDescription(valueToTest);
            //then
            assertNotNull(differenceType);
            assertEquals(DifferenceType.LACK, differenceType);
        }
        @Test
        void itShouldNotReturnLackDifferenceTypeByDescription() {
            //given
            String valueToTest = "faltaa";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceType.returnDifferenceTypeByDescription(valueToTest));
        }
        @Test
        void itShouldReturnSpareDifferenceTypeByDescriptionHappyCase() {
            //given
            String valueToTest = "sobra";
            //when
            DifferenceType differenceType = DifferenceType.returnDifferenceTypeByDescription(valueToTest);
            //then
            assertNotNull(differenceType);
            assertEquals(DifferenceType.SPARE, differenceType);
        }
        @Test
        void itShouldNotSpareLackDifferenceTypeByDescription() {
            //given
            String valueToTest = "sobraa";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceType.returnDifferenceTypeByDescription(valueToTest));
        }

        @Test
        void itShouldNotReturnAnyDifferenceTypeByNullDescription() {
            //given
            String valueToTest = null;
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceType.returnDifferenceTypeByDescription(valueToTest));
        }
        @Test
        void itShouldNotReturnAnyDifferenceTypeByEmptyDescription() {
            //given
            String valueToTest = "";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceType.returnDifferenceTypeByDescription(valueToTest));
        }

        @Test
        void itShouldNotReturnAnyDifferenceTypeBySpaceStringDescription() {
            //given
            String valueToTest = "   ";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceType.returnDifferenceTypeByDescription(valueToTest));
        }

    }

}