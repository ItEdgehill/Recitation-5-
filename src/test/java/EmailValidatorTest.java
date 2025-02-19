import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    @DisplayName("Testing Valid Local-Part")
    void isEmailValid_ValidLocalPart() {
        //Test valid local-parts
        assertTrue(EmailValidator.isEmailValid("jsmith@localhost"));
        assertTrue(EmailValidator.isEmailValid("ane@example.com"));
        assertTrue(EmailValidator.isEmailValid("jane.smith@example.com"));
        assertTrue(EmailValidator.isEmailValid("jane.smith@international.example.com"));
        assertTrue(EmailValidator.isEmailValid("jane/smith@example.com"));
        assertTrue(EmailValidator.isEmailValid("jane*smith@example.com"));
    }

    @Test
    @DisplayName("Testing Invalid Local-Part")
    void isEmailValid_InvalidLocalPart() {
        // Test invalid addresses due to local-part
        assertFalse(EmailValidator.isEmailValid(".jane-smith@example.com"));
        assertFalse(EmailValidator.isEmailValid("janesmith.@example.com"));
        assertFalse(EmailValidator.isEmailValid("jane..smith@example.com"));
        assertFalse(EmailValidator.isEmailValid("jane:smith@example.com"));
        assertFalse(EmailValidator.isEmailValid("a".repeat(65)+"@example.com"));

    }

    @Test
    @DisplayName("Testing Valid Domain")
    void isEmailValid_ValidDomain() {
        // Test valid domains
        assertTrue(EmailValidator.isEmailValid("jsmith@example---me.com"));
        assertTrue(EmailValidator.isEmailValid("j.smith.helio@blip.com"));
        assertTrue(EmailValidator.isEmailValid("!#$%&'*+-/=?^_`{|}~@blip.com"));
    }

    @Test
    @DisplayName("Testing Invalid Domain")
    void isEmailValid_InvalidDomain() {
        // Test invalid addresses due to domain
        assertFalse(EmailValidator.isEmailValid("j.s@-example.com"));
        assertFalse(EmailValidator.isEmailValid("j.s@example-.com"));
        assertFalse(EmailValidator.isEmailValid("j.s@.example.com"));
        assertFalse(EmailValidator.isEmailValid("j.s@example..com"));
        assertFalse(EmailValidator.isEmailValid("j.s@"+"a".repeat(255)));
    }
}