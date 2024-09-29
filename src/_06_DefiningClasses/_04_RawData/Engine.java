package _06_DefiningClasses._04_RawData;

public class Engine {

    private int horsePower;
    private int engineSpeed;

    public Engine(int engineSpeed, int horsePower) {
        this.engineSpeed = engineSpeed;
        this.horsePower = horsePower;
    }


    public int getHorsePower() {
        return horsePower;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public boolean isTooPowerfull() {
        return horsePower > 250;
    }


}
