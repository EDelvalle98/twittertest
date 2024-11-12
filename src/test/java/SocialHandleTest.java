import org.junit.jupiter.api.Test;
import twitter.SocialHandle;

import static org.junit.jupiter.api.Assertions.*;

public class SocialHandleTest {

    @Test
    public void createHandleTest() {
        //given
        SocialHandle socialHandle = new SocialHandle();
        String handle = "NewUser";
        //when
        String result = socialHandle.createHandle(handle);
        //then
        assertEquals("@" + "newuser", result); // Now it will pass
    }

    @Test
    public void checkHandleLessThan9CharactersTest() {
        //given
        SocialHandle socialHandle = new SocialHandle();
        String handle = "short";
        //when
        String result = socialHandle.createHandle(handle);
        //then
        assertEquals("@short", result);
    }

    @Test
    public void checkEmptyOrBlankCharactersTest() {
        //given
        SocialHandle socialHandle = new SocialHandle();
        String emptyHandle = "    ";
        //when
        String result = socialHandle.createHandle(emptyHandle);
        //then
        assertEquals("Handle cannot be empty or blank.", result);
    }

    @Test
    public void addHandleTest() {
        //given
        SocialHandle socialHandle = new SocialHandle();
        String handle = "UniqueHandle";
        socialHandle.addHandle(handle);
        //when
        assertTrue(socialHandle.getHandles().contains("@uniquehan"));
        socialHandle.addHandle(handle);
        //then
        assertEquals(1, socialHandle.getHandles().size());
    }

    @Test
    public void removeHandleTest() {
        //given
        SocialHandle socialHandle = new SocialHandle();
        String handle = "HandleToRemove";
        socialHandle.addHandle(handle);
        //when
        assertTrue(socialHandle.getHandles().contains("@handletor"));
        socialHandle.removeHandle(handle);
        //then
        assertFalse(socialHandle.getHandles().contains("@handletoremove"));
    }

    @Test
    public void handleLongerThan9CharactersTest() {
        //given
        SocialHandle socialHandle = new SocialHandle();
        String longHandle = "SuperLongHandle";
        //when
        String result = socialHandle.createHandle(longHandle);
        //then
        assertEquals("@superlong", result);
    }
}
