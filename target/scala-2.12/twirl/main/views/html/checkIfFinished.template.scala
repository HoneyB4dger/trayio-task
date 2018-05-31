
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

object checkIfFinished extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CheckIfFinishedForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(checkIfFinished: Form[CheckIfFinishedForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
   """),_display_(/*6.5*/request/*6.12*/.messages(key)),format.raw/*6.26*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Tray.io task")/*9.22*/ {_display_(Seq[Any](format.raw/*9.24*/("""

  """),_display_(/*11.4*/form(routes.CheckIfFinishedController.checkIfFinished())/*11.60*/ {_display_(Seq[Any](format.raw/*11.62*/("""
		"""),_display_(/*12.4*/inputText(checkIfFinished("workflow_execution_id"))),format.raw/*12.55*/("""

		"""),format.raw/*14.3*/("""<div class="buttons">
			<input type="submit" value="Check if Finished"/>
		</div>
    <br>
    <a href='/'>Back to index</a>
	""")))}),format.raw/*19.3*/("""
""")))}),format.raw/*20.2*/("""
"""))
      }
    }
  }

  def render(checkIfFinished:Form[CheckIfFinishedForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(checkIfFinished)(request)

  def f:((Form[CheckIfFinishedForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (checkIfFinished) => (request) => apply(checkIfFinished)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 30 22:55:31 BST 2018
                  SOURCE: C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/app/views/checkIfFinished.scala.html
                  HASH: 508f9d7de9053ca4c00b7a9854d5755b2e16285e
                  MATRIX: 780->1|938->89|982->87|1009->105|1036->107|1050->114|1083->139|1129->148|1159->153|1174->160|1208->174|1239->176|1267->179|1295->199|1334->201|1365->206|1430->262|1470->264|1500->268|1572->319|1603->323|1761->451|1793->453
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|30->6|30->6|31->7|33->9|33->9|33->9|35->11|35->11|35->11|36->12|36->12|38->14|43->19|44->20
                  -- GENERATED --
              */
          