package cl.devweb.sonar.customrule.java.rules;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.java.syntaxtoken.FirstSyntaxTokenFinder;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.SyntaxToken;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

import cl.devweb.sonar.customrule.java.domain.FqnStd;



@Rule( key = "AvoidCallableStatement",
      name = "chequea uso de llamadas a stored procedures y functions",
      description = "Esta regla chequea si se esta usando algo diferente que pl-generator para llamadas a base de datos.",
      tags = {"coding-guideline"},
      priority = Priority.MINOR )
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.ARCHITECTURE_CHANGEABILITY)
@SqaleConstantRemediation("10min")
public class AvoidCallableStatementRule extends BaseTreeVisitor implements JavaFileScanner {

  private static final String DEFAULT_VALUE = "CallableStatement";

  private JavaFileScannerContext context;


  @RuleProperty(
    defaultValue = DEFAULT_VALUE,
    description = "chequea uso de llamadas a stored procedures y functions")
  protected String name;

  @Override
  public void scanFile(JavaFileScannerContext context) {

    System.out.println("Scanning CallableStatement !!!");

    this.context = context;

    scan(context.getTree());
  }


    @Override
    public void visitVariable(VariableTree tree) {
      super.visitVariable(tree);

      //REMOVE:
      System.out.println("visitVariable() == " + tree. symbol().type()  + "  linea: " +  getLine(tree) );

      //TODO: agregar los Strings a una Collection y recorrerlas
      for (FqnStd fqn : FqnStd.values()) {
          if (tree.symbol().type().is(fqn.fqn())) {
              System.out.println("NO! se usa " + fqn.fqn() + "  ************");
              //context.addIssue(tree, this, "no se usa CallableStatement ***********************");
              context.reportIssue(this, tree, "no se usa " + fqn.fqn() + "  ************");
          }
      }
    }

    //TODO: que este bajo "utils"
    public int getLine(Tree tree) {
        SyntaxToken firstSyntaxToken = FirstSyntaxTokenFinder.firstSyntaxToken(tree);
        if (firstSyntaxToken == null) {
          return -1;
        }
        return firstSyntaxToken.line();
      }

}

