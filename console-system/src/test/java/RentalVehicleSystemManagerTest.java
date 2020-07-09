import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalVehicleSystemManagerTest {

    private RentalVehicleSystemManager manager;

    private List<Vehicle> mockVehicleList = new ArrayList<>();

    Vehicle car;

    @Before
    public void before() throws Exception {
        mockVehicleList.add(car);
    }

    @BeforeEach
    void beforeEach() {
        manager = new RentalVehicleSystemManager();
    }

    @AfterEach
    void after() {
        mockVehicleList.clear();
    }

    @Nested
    class IsParkingFullTest {
        @Test
        void testAddCarNotFull() {
            mockVehicleList.add(car);
            assertFalse(manager.isParkingFull(mockVehicleList));
        }

        @Test
        void testAddCarBorderlineFull() {
            while (mockVehicleList.size() < 49) {
                mockVehicleList.add(car);
            }

            mockVehicleList.add(car);
            assertFalse(manager.isParkingFull(mockVehicleList));
        }

        @Test
        void testAddCarWhenFull() {
            while (mockVehicleList.size() <= 50) {
                mockVehicleList.add(car);
            }

            mockVehicleList.add(car);
            assertTrue(manager.isParkingFull(mockVehicleList));
        }
    }
}
