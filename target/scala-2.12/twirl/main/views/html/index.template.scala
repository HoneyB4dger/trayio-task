
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CreateWorkflowForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

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

"""),_display_(/*10.2*/main("Welcome to Play")/*10.25*/ {_display_(Seq[Any](format.raw/*10.27*/("""

  """),_display_(/*12.4*/form(routes.WorkflowController.addWorkflow())/*12.49*/ {_display_(Seq[Any](format.raw/*12.51*/("""
		"""),_display_(/*13.4*/inputText(workflow("number_of_steps"))),format.raw/*13.42*/("""
		"""),_display_(/*14.4*/CSRF/*14.8*/.formField),format.raw/*14.18*/("""

		"""),format.raw/*16.3*/("""<div class="buttons">
			<input type="submit" value="Add Workflow"/>
		</div>
	""")))}),format.raw/*19.3*/("""

""")))}),format.raw/*21.2*/("""
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
                  DATE: Mon May 28 19:50:19 BST 2018
                  SOURCE: /home/matthews/TRAY/trayio-task3/app/views/index.scala.html
                  HASH: eb30d415da9332ea5fe311c3160085f63cba5232
                  MATRIX: 769->1|919->82|963->79|991->98|1018->100|1032->107|1065->132|1111->141|1141->146|1156->153|1190->167|1221->169|1250->172|1282->195|1322->197|1353->202|1407->247|1447->249|1477->253|1536->291|1566->295|1578->299|1609->309|1640->313|1750->393|1783->396
                  LINES: 21->1|24->4|27->2|29->5|30->6|30->6|30->6|30->6|31->7|31->7|31->7|32->8|34->10|34->10|34->10|36->12|36->12|36->12|37->13|37->13|38->14|38->14|38->14|40->16|43->19|45->21
                  -- GENERATED --
              */
          