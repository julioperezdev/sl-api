package dev.julioperez.littleTree.client.domain.enums;

import dev.julioperez.littleTree.client.clientDifference.domain.enums.DifferenceStatus;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DifferenceStatusTest {


    @Nested
    public class isPendingCases{

        @Test
        void itShouldBePendingHappyCase() {
            //given
            DifferenceStatus pending = DifferenceStatus.PENDING;
            //when
            boolean response = pending.isPending();
            //then
            assertTrue(response);
        }
        @Test
        void itShouldNotBePendingByDoneEnum() {
            //given
            DifferenceStatus done = DifferenceStatus.DONE;
            //when
            boolean response = done.isPending();
            //then
            assertFalse(response);
        }
    }
    @Nested
    public class getValueCases{
        @Test
        void itShouldGetDoneValueHappyCase() {
            //given
            DifferenceStatus differenceStatus = DifferenceStatus.DONE;
            //when
            String value = differenceStatus.value();
            //then
            assertNotNull(value);
            assertEquals( "resuelto", value);
        }
        @Test
        void itShouldGetPendingValueHappyCase() {
            //given
            DifferenceStatus differenceStatus = DifferenceStatus.PENDING;
            //when
            String value = differenceStatus.value();
            //then
            assertNotNull(value);
            assertEquals( "pendiente", value);
        }
        @Test
        void itShouldNotGetDoneValueByInvalidValue() {
            //given
            DifferenceStatus differenceStatus = DifferenceStatus.DONE;
            //when
            String value = differenceStatus.value();
            //then
            assertNotNull(value);
            assertNotEquals( "resueltoo", value);
        }
        @Test
        void itShouldNotGetPendingValueByInvalidValue() {
            //given
            DifferenceStatus differenceStatus = DifferenceStatus.PENDING;
            //when
            String value = differenceStatus.value();
            //then
            assertNotNull(value);
            assertNotEquals( "pendientee", value);
        }
    }
    @Nested
    public class returnDifferenceStatusByDescriptionCases{
        @Test
        void itShouldReturnPendingDifferenceStatusByDescriptionHappyCase() {
            //given
            String valueToTest = "pendiente";
            //when
            DifferenceStatus differenceStatus = DifferenceStatus.returnDifferenceStatusByDescription(valueToTest);
            //then
            assertNotNull(differenceStatus);
            assertEquals(DifferenceStatus.PENDING, differenceStatus);
        }

        @Test
        void itShouldNotReturnPendingDifferenceStatusByInvalidDescription() {
            //given
            String valueToTest = "pendientee";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceStatus.returnDifferenceStatusByDescription(valueToTest));
        }
        @Test
        void itShouldReturnDoneDifferenceStatusByDescriptionHappyCase() {
            //given
            String valueToTest = "resuelto";
            //when
            DifferenceStatus differenceStatus = DifferenceStatus.returnDifferenceStatusByDescription(valueToTest);
            //then
            assertNotNull(differenceStatus);
            assertEquals(DifferenceStatus.DONE, differenceStatus);
        }

        @Test
        void itShouldNotReturnDoneDifferenceStatusByInvalidDescription() {
            //given
            String valueToTest = "resueltoo";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceStatus.returnDifferenceStatusByDescription(valueToTest));
        }

        @Test
        void itShouldNotReturnAnyDifferenceStatusByNullDescription() {
            //given
            String valueToTest = null;
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceStatus.returnDifferenceStatusByDescription(valueToTest));
        }
        @Test
        void itShouldNotReturnAnyDifferenceStatusByEmptyDescription() {
            //given
            String valueToTest = "";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceStatus.returnDifferenceStatusByDescription(valueToTest));
        }

        @Test
        void itShouldNotReturnAnyDifferenceStatusBySpaceStringDescription() {
            //given
            String valueToTest = "   ";
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> DifferenceStatus.returnDifferenceStatusByDescription(valueToTest));
        }
    }
}