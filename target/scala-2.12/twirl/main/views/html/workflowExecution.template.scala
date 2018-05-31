
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

object workflowExecution extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CreateWorkflowExecutionForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

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

"""),_display_(/*9.2*/main("Tray.io task")/*9.22*/ {_display_(Seq[Any](format.raw/*9.24*/("""

  """),_display_(/*11.4*/form(routes.WorkflowExecutionController.addWorkflowExecution())/*11.67*/ {_display_(Seq[Any](format.raw/*11.69*/("""
		"""),_display_(/*12.4*/inputText(workflowExecution("workflow_id"))),format.raw/*12.47*/("""
	
		"""),format.raw/*14.3*/("""<div class="buttons">
			<input type="submit" value="Add Workflow Execution"/>
		</div>
    <br>
    <a href='/'>Back to index</a>
	""")))}),format.raw/*19.3*/("""
""")))}),format.raw/*20.2*/("""
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
                  DATE: Wed May 30 22:55:31 BST 2018
                  SOURCE: C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/app/views/workflowExecution.scala.html
                  HASH: afd8e769dbdbd8348289f663473a14e7601b1d3d
                  MATRIX: 790->1|958->99|1002->97|1029->115|1056->117|1070->124|1103->149|1149->158|1179->163|1194->170|1228->184|1259->186|1287->189|1315->209|1354->211|1385->216|1457->279|1497->281|1527->285|1591->328|1623->333|1786->466|1818->468
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|30->6|30->6|31->7|33->9|33->9|33->9|35->11|35->11|35->11|36->12|36->12|38->14|43->19|44->20
                  -- GENERATED --
              */
          