import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    public void test_hello_world(){
        String helloWorld = "hello world";
        assertEquals("hello world", helloWorld);
    }
}