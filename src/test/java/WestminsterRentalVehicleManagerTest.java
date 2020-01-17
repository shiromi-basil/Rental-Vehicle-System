import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WestminsterRentalVehicleManagerTest {

    private WestminsterRentalVehicleManager manager;

    private List<Car> mockCarList = new ArrayList<>();
    private List<Car> mockMotorbikeList = new ArrayList<>();

    Car car;

    @Before
    public void before() throws Exception {
        mockCarList.add(car);
    }

    @BeforeEach
    void beforeEach() {
        manager = new WestminsterRentalVehicleManager();
    }

    @AfterEach
    void after() {
        mockCarList.clear();
        mockMotorbikeList.clear();
    }

    @Nested
    class IsParkingFullTest {
        @Test
        void testAddCarNotFull() {
            mockCarList.add(car);
            assertFalse(manager.isParkingFull(mockCarList, mockMotorbikeList));
        }

        @Test
        void testAddCarBorderlineFull() {
            while (mockCarList.size() < 49) {
                mockCarList.add(car);
            }

            mockCarList.add(car);
            assertFalse(manager.isParkingFull(mockCarList, mockMotorbikeList));
        }

        @Test
        void testAddCarWhenFull() {
            while (mockCarList.size() <= 50) {
                mockCarList.add(car);
            }

            mockCarList.add(car);
            assertTrue(manager.isParkingFull(mockCarList, mockMotorbikeList));
        }
    }
}
