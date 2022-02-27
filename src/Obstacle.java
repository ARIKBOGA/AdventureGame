import java.util.Random;

public abstract class Obstacle {
    private String name;
    private int demage, award, healthy, maxObsNumber;

    public Obstacle(String name, int demage, int healthy, int award, int maxObsNumber) {
        this.name = name;
        this.demage = demage;
        this.award = award;
        this.healthy = healthy;
        this.maxObsNumber = maxObsNumber;
    }
    public int obstacleCount(){
        Random random = new Random();
        return random.nextInt(this.maxObsNumber) + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMaxObsNumber() {
        return maxObsNumber;
    }

    public void setMaxObsNumber(int maxObsNumber) {
        this.maxObsNumber = maxObsNumber;
    }
}