package tdd;

import java.io.InputStream;
import java.util.Scanner;

public class SimpleSmartDoorLock implements SmartDoorLock {

    private int pin;
    private String statusDoor;
    private int failedAttempts;
    private final int maxAttempts= 3;

    public SimpleSmartDoorLock(int pin, String statusDoor) {
        this.pin = pin;
        this.statusDoor = statusDoor;
    }

    @Override
    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        Scanner input = new Scanner(System.in);
        if(statusDoor.equals("unlocked")){
            System.out.println(("The door is already unlocked"));
        }else if(statusDoor.equals("locked")) {
            for (failedAttempts = 0; failedAttempts < 3; failedAttempts++) {
                System.out.print("Insert PIN: ");
                int userPin = input.nextInt();
                if (userPin == pin) {
                    setStatusDoor("unlocked");
                    System.out.println(("\n\nThe door has been unlocked"));
                    break;
                }else {
                    System.out.println("\nPIN is incorrect");
                }
            }
            if (!statusDoor.equals("unlocked")) {
                System.err.println("\nThe door has been blocked");
                setStatusDoor("blocked");
            }
        }
    }

    @Override
    public void lock() {
        if(statusDoor.equals("unlocked")){
            setStatusDoor("locked");
            System.out.println("The door has been locked");
        }else try {
            throw new Exception();
        } catch (Exception e) {
            System.err.println("The door can't be locked");
        }
    }

    @Override
    public boolean isLocked() {
        if(statusDoor.equals("locked")){
            return true;
        }
        return false;
    }

    @Override
    public boolean isBlocked() {
        if(statusDoor.equals("blocked")){
            return true;
        }
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void reset() {
        setPin(0000);
        setStatusDoor("unlocked");
        failedAttempts= 0;
    }


    //more methods
    public int getPin() {
        return pin;
    }

    public String getStatusDoor() {
        return statusDoor;
    }

    public void setStatusDoor(String statusDoor) {
        this.statusDoor = statusDoor;
    }
}

