package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SimpleSmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach(){
        int initialPin= 1111;
        SimpleSmartDoorLock.Status initialStatus = SimpleSmartDoorLock.Status.UNLOCKED;
        smartDoorLock= new SimpleSmartDoorLock(initialPin, initialStatus);
    }

    @Test
    void testSetPin(){
        int pin= 2222;
        smartDoorLock.setPin(pin);
        int expectedPin= 2222;
        assertEquals(expectedPin, smartDoorLock.getPin());
    }

    @Test
    void testUnlock(){
        smartDoorLock.lock();
        int pin= 1111;
        smartDoorLock.unlock(pin);
        SimpleSmartDoorLock.Status expectedStatus = SimpleSmartDoorLock.Status.UNLOCKED;
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testFailUnlock(){
        int emptyPin= 0;
        int tooManyAttempts= 4;
        for(int attempts= 0; attempts<tooManyAttempts; attempts++){
            smartDoorLock.unlock(emptyPin);
        }
        SimpleSmartDoorLock.Status expectedStatus = SimpleSmartDoorLock.Status.BLOCKED;
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testLock(){
        smartDoorLock.lock();
        SimpleSmartDoorLock.Status expectedStatus = SimpleSmartDoorLock.Status.LOCKED;
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testFailLock(){
        int wrongPin= 0;
        smartDoorLock.setPin(wrongPin);
        assertThrows(IllegalStateException.class, ()-> smartDoorLock.lock());
    }

    @Test
    void testIsLocked(){
        SimpleSmartDoorLock.Status locked = SimpleSmartDoorLock.Status.LOCKED;
        smartDoorLock.setStatusDoor(locked);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void testIsNotLocked(){
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void testIsBlocked(){
        SimpleSmartDoorLock.Status blocked = SimpleSmartDoorLock.Status.BLOCKED;
        smartDoorLock.setStatusDoor(blocked);
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    void testIsNotBlocked(){
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    void testGetMaxAttempts(){
        int expectedMaxAttempts= 3;
        assertEquals(expectedMaxAttempts, smartDoorLock.getMaxAttempts());
    }

    @Test
    void testGetFailedAttempts(){
        int wrongPin= 0;
        smartDoorLock.unlock(wrongPin);
        int expectedFailedAttempts= 1;
        assertEquals(expectedFailedAttempts, smartDoorLock.getFailedAttempts());
    }

    @Test
    void testReset(){
        smartDoorLock.reset();
        int expectedPin=0;
        SimpleSmartDoorLock.Status expectedStatus = SimpleSmartDoorLock.Status.UNLOCKED;
        int expectedFailedAttempts= 0;
        assertEquals(expectedPin, smartDoorLock.getPin());
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
        assertEquals(expectedFailedAttempts, smartDoorLock.getFailedAttempts());
    }

    //more tests

    @Test
    void testGetPin(){
        int expectedPin= 1111;
        assertEquals(expectedPin, smartDoorLock.getPin());
    }

    @Test
    void testGetStatusDoor(){
        SimpleSmartDoorLock.Status expectedStatus = SimpleSmartDoorLock.Status.UNLOCKED;
        assertEquals(expectedStatus, smartDoorLock.getStatusDoor());
    }

    @Test
    void testSetStatusDoor(){
        SimpleSmartDoorLock.Status statusOrExpectedStatus = SimpleSmartDoorLock.Status.LOCKED;
        smartDoorLock.setStatusDoor(statusOrExpectedStatus);
        assertEquals(statusOrExpectedStatus, smartDoorLock.getStatusDoor());
    }

}
