package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTest {

    Car car = new Car();

    @Test
    @DisplayName("자동차의 전진이 잘 작동하는가?")
    public void moveTest(){
        assertThat(car.getTravelDistance()).isEqualTo(0);
        car.move();
    }

    @Test
    @DisplayName("4 이상일 때만 가능한가?")
    public void isOrAboveEnableNumberTest(){
        assertFalse(car.isOrAboveEnableNumber(3));
        assertTrue(car.isOrAboveEnableNumber(4));
    }
}
