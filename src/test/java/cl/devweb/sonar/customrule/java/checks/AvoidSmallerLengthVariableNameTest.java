package cl.devweb.sonar.customrule.java.checks;


import org.junit.Test;

import org.sonar.java.checks.verifier.JavaCheckVerifier;

import cl.devweb.sonar.customrule.java.rules.AvoidSmallerLengthVariableNameRule;

public class AvoidSmallerLengthVariableNameTest {

    @Test
    public void test() {
      //  it relies on usage of the JavaCheckVerifier class, provided by the Java Plugin rule testing API.
      //      <groupId>org.sonarsource.java</groupId>
      //  		<artifactId>java-checks-testkit</artifactId>

          // In the test file, lines which should raise an issue have been commented out
        // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
      JavaCheckVerifier.verify("src/test/files/AvoidSmallerLengthVariableNameCheck.java", new AvoidSmallerLengthVariableNameRule());
    }

}


