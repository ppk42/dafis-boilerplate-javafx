package de.dafis.fxbp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("PMD.JUnitAssertionsShouldIncludeMessage")
@SpringBootTest
class SpringApplicationTests
{
   @Test
   void contextLoads()
   {
      assertNotNull( getClass() );
   }
}