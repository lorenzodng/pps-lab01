package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private int expectedPin;

    private String expectedStatus;
    private int pin= 0000;
    private String status= "unlocked";
    private int expectedFailedAttempts;
    private SimpleSmartDoorLock smartDoorLock;


    @BeforeEach
    void beforeEach(){
        smartDoorLock= new SimpleSmartDoorLock(pin, status);
    }

    @Test
    void testGetPin(){
        expectedPin= 0000;
        assertEquals(expectedPin, pin);
    }

    @Test
    void testGetStatusDoor(){
        expectedStatus= "unlocked";
        assertEquals(expectedStatus, status);
    }

    @Test
    void testSetPin(){
        pin= 1111;
        smartDoorLock.setPin(pin);

        expectedPin= 1111;
        assertEquals(expectedPin, smartDoorLock.getPin());
    }

    @Test
    void testSetStatusDoor(){
        status= "locked";
        smartDoorLock.setStatusDoor(status);

        expectedStatus= "locked";
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testUnlock(){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(Integer.toString(pin).getBytes());
        System.setIn(inputStream);

        smartDoorLock.setStatusDoor("locked");

        smartDoorLock.unlock(pin);
        expectedStatus= "unlocked";
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }
    @Test
    void testFailUnlock(){
        expectedPin= 1111;
        String expectedPinToString= Integer.toString(expectedPin)+ " " +Integer.toString(expectedPin)+ " " +Integer.toString(expectedPin);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(expectedPinToString.getBytes());
        System.setIn(inputStream);

        smartDoorLock.setStatusDoor("locked");

        smartDoorLock.unlock(pin);
        expectedStatus= "blocked";
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testLock(){
        smartDoorLock.lock();
        expectedStatus= "locked";
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testFailLock(){
        smartDoorLock.setStatusDoor("locked");

        smartDoorLock.lock();
        expectedStatus= "locked";
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testIsLocked(){
        smartDoorLock.setStatusDoor("locked");
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testIsNotLocked(){
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void testIsBlocked(){
        smartDoorLock.setStatusDoor("blocked");
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    void testIsNotBlocked(){
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    void testGetMaxAttempts(){
        int attempts= 3;
        assertEquals(attempts, smartDoorLock.getMaxAttempts());
    }

    @Test
    void testGetFailedAttempts(){
        expectedPin= 0000;

        ByteArrayInputStream inputStream = new ByteArrayInputStream(Integer.toString(expectedPin).getBytes());
        System.setIn(inputStream);

        smartDoorLock.setStatusDoor("locked");

        smartDoorLock.unlock(pin);

        expectedFailedAttempts= 0;
        assertEquals(expectedFailedAttempts, smartDoorLock.getFailedAttempts());
    }

    @Test
    void reset(){
        smartDoorLock.reset();

        expectedPin= 0000;
        assertEquals(expectedPin, pin);

        expectedStatus= "unlocked";
        assertEquals(expectedStatus, status);

        expectedFailedAttempts= 0;
        int failedAttempts= 0;
        assertEquals(expectedFailedAttempts, failedAttempts);
    }


}
