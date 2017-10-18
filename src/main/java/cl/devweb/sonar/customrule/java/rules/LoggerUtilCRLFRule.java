package cl.devweb.sonar.customrule.java.rules;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.VariableTree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

@Rule( key = "LoggerUtilCRLFRule",
      name = "chequea uso de LoggerUtil",
      description = "Esta regla chequea si se esta usando LoggerUtil para valores dinamicos dentro de un logeo.",
      tags = {"coding-guideline"},
      priority = Priority.MAJOR )
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.ARCHITECTURE_CHANGEABILITY)
@SqaleConstantRemediation("10min")
public class LoggerUtilCRLFRule extends BaseTreeVisitor implements JavaFileScanner {

  private static final String DEFAULT_VALUE = "LogUtilCRLF";

  private JavaFileScannerContext context;

  /**
   * Avoid usage of the smaller length in local variable name in Quality profiles.
   * The key
   */
  @RuleProperty(
    defaultValue = DEFAULT_VALUE,
    description = "chequea uso de LoggerUtil")
  protected String name;

  @Override
  public void scanFile(JavaFileScannerContext context) {

    System.out.println("Scanning LogUtilCRLF !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    this.context = context;

    scan(context.getTree());
  }


    @Override
    public void visitVariable(VariableTree tree) {
      super.visitVariable(tree);

      String variableName = tree.simpleName().name();
      System.out.println("Scanning the variable : " + variableName);

      if(variableName.length() < 4) {
          context.addIssue(tree, this, "no se usa LoggerUtil");
          //addIssue   --  reportIssue: (MethodError)
      }

    }

}

