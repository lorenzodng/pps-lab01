package tdd;


public class SimpleSmartDoorLock implements SmartDoorLock {

    private int pin;
    private int failedAttempts= 0;
    private static final int MAX_ATTEMPTS= 3;
    private Status statusDoor;
    public enum Status {
        LOCKED, UNLOCKED, BLOCKED
    }

    public SimpleSmartDoorLock(int pin, Status statusDoor) {
        this.pin = pin;
        this.statusDoor = statusDoor;
    }

    @Override
    public void setPin(int pin) {
        if(statusDoor == Status.UNLOCKED) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(failedAttempts == MAX_ATTEMPTS) {
            statusDoor = Status.BLOCKED;
        }
        if(this.pin == pin && statusDoor != Status.BLOCKED) {
            statusDoor = Status.UNLOCKED;
        }else {
            failedAttempts++;
        }
    }

    @Override
    public void lock() {
        int emptyPin= 0;
        if(pin != emptyPin){
            setStatusDoor(Status.LOCKED);
        }else throw new IllegalStateException();
    }

    @Override
    public boolean isLocked() {
        return statusDoor == Status.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return statusDoor == Status.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void reset() {
        pin= 0;
        statusDoor= Status.UNLOCKED;
        failedAttempts= 0;
    }

    //more methods

    public int getPin() {
        return pin;
    }

    public Status getStatusDoor() {
        return statusDoor;
    }

    public void setStatusDoor(Status statusDoor) {
        this.statusDoor = statusDoor;
    }
}

