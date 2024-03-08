package enums;

public enum WaitStrategy {
    PRESENT("present"), CLICKABLE("clickable"), VISIBLE("visible");

    private String waitStrategy;

    WaitStrategy(String strategy){
        this.waitStrategy = strategy;
    }

    public String getWaitStrategy(){
        return waitStrategy;
    }


}
