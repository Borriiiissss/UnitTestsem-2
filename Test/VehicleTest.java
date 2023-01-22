import static org.assertj.core.api.Assertions.*;
import org.example.Car;
import org.example.Motorcycle;
import org.example.Vehicle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleTest {

    Car car1 = new Car("BMW", "115", 1979);
    Motorcycle moto1 = new Motorcycle("BMW", "x333", 1979);
    @Test
    @DisplayName("проверка того, что экземпляр объекта Car " +
            "также является экземпляром транспортного средства; (instanceof)")
    public void isItInstanceOfVehicleClass() {
        assertThat(car1).isInstanceOf(Vehicle.class);
    }

    @Test
    @DisplayName("проверка того, объект Car создается с 4-мя колесами")
    public void checkCarHasFourWheels(){
        assertThat(car1.getNumWheels()).isEqualTo(4);
    }
    @Test
    @DisplayName("проверка того, объект Motorcycle создается с 2-мя колесами")
    public void checkMotorCycleHasTwoWheels(){
        assertThat(moto1.getNumWheels()).isEqualTo(2);
    }
    @Test
    @DisplayName("проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())")
    public void carHasSpeedSixtyInTestModeDriving(){
        car1.testDrive();
        assertThat(car1.getSpeed()).isEqualTo(60);
    }
    @Test
    @DisplayName("проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения " +
            "(testDrive())")
    public void motoHasSpeedSeventyFiveInTestDriveMode(){
        moto1.testDrive();
        assertThat(moto1.getSpeed()).isEqualTo(75);
    }
    @Test
    @DisplayName("проверить, что в режиме парковки (сначала testDrive, " +
            "потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)")
    public void carHasZeroSpeedInParkMode(){
        car1.testDrive();
        car1.park();
        assertThat(car1.getSpeed()).isEqualTo(0);
    }
    @Test
    @DisplayName("проверить, что в режиме парковки (сначала testDrive, " +
            "потом park  т.е эмуляция движения транспорта)  мотоцикл останавливается (speed = 0)")
    public void motoHasZeroSpeedInParkMode (){
        moto1.testDrive();
        moto1.park();
        assertThat(moto1.getSpeed()).isEqualTo(0);
    }
}
