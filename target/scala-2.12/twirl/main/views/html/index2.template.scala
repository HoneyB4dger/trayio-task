
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CreateWorkflowExecutionForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(workflowExecution: Form[CreateWorkflowExecutionForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
   """),_display_(/*6.5*/request/*6.12*/.messages(key)),format.raw/*6.26*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Welcome to Play")/*9.25*/ {_display_(Seq[Any](format.raw/*9.27*/("""

  """),_display_(/*11.4*/form(routes.WorkflowExecutionController.addWorkflowExecution())/*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/("""
		"""),_display_(/*12.4*/inputText(workflowExecution("workflow_id"))),format.raw/*12.47*/("""
		"""),_display_(/*13.4*/CSRF/*13.8*/.formField),format.raw/*13.18*/("""

		"""),format.raw/*15.3*/("""<div class="buttons">
			<input type="submit" value="Add Workflow Execution"/>
		</div>
	""")))}),format.raw/*18.3*/("""
""")))}),format.raw/*19.2*/("""
"""))
      }
    }
  }

  def render(workflowExecution:Form[CreateWorkflowExecutionForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(workflowExecution)(request)

  def f:((Form[CreateWorkflowExecutionForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (workflowExecution) => (request) => apply(workflowExecution)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon May 28 20:16:48 BST 2018
                  SOURCE: /home/matthews/TRAY/trayio-task3/app/views/index2.scala.html
                  HASH: 24a4dd607793e1e1be6107e56c8d0646ab36d404
                  MATRIX: 779->1|947->99|991->97|1018->115|1045->117|1059->124|1092->149|1138->158|1168->163|1183->170|1217->184|1248->186|1276->189|1307->212|1346->214|1377->219|1449->282|1489->284|1519->288|1583->331|1613->335|1625->339|1656->349|1687->353|1807->443|1839->445
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|30->6|30->6|31->7|33->9|33->9|33->9|35->11|35->11|35->11|36->12|36->12|37->13|37->13|37->13|39->15|42->18|43->19
                  -- GENERATED --
              */
          