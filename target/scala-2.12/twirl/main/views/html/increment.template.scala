
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

object increment extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[IncrementForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(increment: Form[IncrementForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
   """),_display_(/*6.5*/request/*6.12*/.messages(key)),format.raw/*6.26*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Tray.io task")/*9.22*/ {_display_(Seq[Any](format.raw/*9.24*/("""

  """),_display_(/*11.4*/form(routes.IncrementController.increment())/*11.48*/ {_display_(Seq[Any](format.raw/*11.50*/("""
		"""),_display_(/*12.4*/inputText(increment("workflow_execution_id"))),format.raw/*12.49*/("""

		"""),format.raw/*14.3*/("""<div class="buttons">
			<input type="submit" value="Increment"/>
		</div>
    <br>
    <a href='/'>Back to index</a>
	""")))}),format.raw/*19.3*/("""
""")))}),format.raw/*20.2*/("""
"""))
      }
    }
  }

  def render(increment:Form[IncrementForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(increment)(request)

  def f:((Form[IncrementForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (increment) => (request) => apply(increment)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 30 22:55:31 BST 2018
                  SOURCE: C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/app/views/increment.scala.html
                  HASH: 9109a83760fd19e80bc6ce644458cffb7e58fd9c
                  MATRIX: 768->1|914->77|958->75|985->93|1012->95|1026->102|1059->127|1105->136|1135->141|1150->148|1184->162|1215->164|1243->167|1271->187|1310->189|1341->194|1394->238|1434->240|1464->244|1530->289|1561->293|1711->413|1743->415
                  LINES: 21->1|24->3|27->2|28->4|29->5|29->5|29->5|29->5|30->6|30->6|30->6|31->7|33->9|33->9|33->9|35->11|35->11|35->11|36->12|36->12|38->14|43->19|44->20
                  -- GENERATED --
              */
          