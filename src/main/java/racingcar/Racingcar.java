package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Racingcar {

    private int carNumber;
    private int carMovePosition = 0;
    private Map<Integer, Integer> saveRoundResultPosition = new HashMap<>();

    public Racingcar(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getCarMovePosition() {
        return carMovePosition;
    }

    public void setCarMovePosition(int round, int carMovePosition) {
        this.carMovePosition = carMovePosition;
        saveRoundResultPosition.put(round, this.carMovePosition);
    }

    public void printCarPrintRoundPosition(int round, String expressionWord) {
        StringBuffer carPosition = new StringBuffer();
        int roundPosition = saveRoundResultPosition.get(round);
        for (int i = 0; i < roundPosition; i++) {
            carPosition.append(expressionWord);
        }
        System.out.println(carPosition.toString());
    }
}