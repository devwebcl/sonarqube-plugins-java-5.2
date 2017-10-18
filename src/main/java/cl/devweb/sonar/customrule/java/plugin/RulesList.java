package cl.devweb.sonar.customrule.java.plugin;

import java.util.List;

import org.sonar.plugins.java.api.JavaCheck;

import com.google.common.collect.ImmutableList;

import cl.devweb.sonar.customrule.java.rules.AvoidCallableStatementRule;
import cl.devweb.sonar.customrule.java.rules.AvoidSmallerLengthVariableNameRule;
import cl.devweb.sonar.customrule.java.rules.LoggerUtilCRLFRule;


public final class RulesList {

  private RulesList() {
  }

  public static List<Class> getChecks() {
    return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
  }

  public static List<Class<? extends JavaCheck>> getJavaChecks() {

    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .add(AvoidSmallerLengthVariableNameRule.class)
      //.add(LoggerUtilCRLFRule.class)  //TODO
      .add(AvoidCallableStatementRule.class)
      .build();

  }

  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .build();
  }
}
