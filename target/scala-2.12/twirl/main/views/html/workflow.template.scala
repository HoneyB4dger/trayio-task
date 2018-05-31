
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

object workflow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CreateWorkflowForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(workflow: Form[CreateWorkflowForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import helper._


Seq[Any](format.raw/*2.1*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/request/*6.9*/.flash.get("success").map/*6.34*/ { key =>_display_(Seq[Any](format.raw/*6.43*/("""
   """),_display_(/*7.5*/request/*7.12*/.messages(key)),format.raw/*7.26*/("""
""")))}),format.raw/*8.2*/("""

"""),_display_(/*10.2*/main("Tray.io task")/*10.22*/ {_display_(Seq[Any](format.raw/*10.24*/("""

  """),_display_(/*12.4*/form(routes.WorkflowController.addWorkflow())/*12.49*/ {_display_(Seq[Any](format.raw/*12.51*/("""
		"""),_display_(/*13.4*/inputText(workflow("number_of_steps"))),format.raw/*13.42*/("""
    
		"""),format.raw/*15.3*/("""<div class="buttons">
			<input type="submit" value="Add Workflow"/>
		</div>
    <br>
    <a href='/'>Back to index</a>
	""")))}),format.raw/*20.3*/("""

""")))}),format.raw/*22.2*/("""
"""))
      }
    }
  }

  def render(workflow:Form[CreateWorkflowForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(workflow)(request)

  def f:((Form[CreateWorkflowForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (workflow) => (request) => apply(workflow)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu May 31 00:15:42 BST 2018
                  SOURCE: C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/app/views/workflow.scala.html
                  HASH: 1a4c4bc554a8f8274e4ce12510a8b967342497cf
                  MATRIX: 772->1|922->82|966->79|994->98|1021->100|1035->107|1068->132|1114->141|1144->146|1159->153|1193->167|1224->169|1253->172|1282->192|1322->194|1353->199|1407->244|1447->246|1477->250|1536->288|1571->296|1724->419|1757->422
                  LINES: 21->1|24->4|27->2|29->5|30->6|30->6|30->6|30->6|31->7|31->7|31->7|32->8|34->10|34->10|34->10|36->12|36->12|36->12|37->13|37->13|39->15|44->20|46->22
                  -- GENERATED --
              */
          