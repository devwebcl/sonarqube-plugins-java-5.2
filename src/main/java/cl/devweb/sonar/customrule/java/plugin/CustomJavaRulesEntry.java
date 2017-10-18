package cl.devweb.sonar.customrule.java.plugin;

import java.util.List;

import org.sonar.api.SonarPlugin;

import com.google.common.collect.ImmutableList;


/*********************************
 * Entry point of the sonar plugin
 ********************************/
public class CustomJavaRulesEntry extends SonarPlugin {

  @Override
  public List getExtensions() {
      return ImmutableList.of(
      // server extensions -> objects are instantiated during sonarqube startup
      CustomRulesDefinition.class,

      // batch extensions -> objects are instantiated during the code analysis
      CustomJavaFileCheckRegistrar.class);
  }

}
