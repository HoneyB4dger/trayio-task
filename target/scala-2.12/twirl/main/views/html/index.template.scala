
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>Tray.io task</title>
        <style> </style>
      </head>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.59*/routes/*8.65*/.Assets.versioned("images/favicon.png")),format.raw/*8.104*/(""""/>
    <body>

      <div>
        <h1>Welcome to Tray.io task</h1>
        <p>You are accessing the service over http.</p>
        <h3>Follow the links:</h3>
        <p>
          <a href="/workflows">View workflows</a><br>
          <a href="/workflowExecutions">View workflow executions</a><br>
          <a href="/workflow">Add a workflow</a><br>
          <a href="/workflowExecution">Add a workflow execution</a><br>
          <a href="/increment">Increment a step</a><br>
          <a href="/checkIfFinished">Check if finished</a><br>
        </p>

        <h3>Use REST endpoints:</h3>
        <p>
          <span>GET /workflows</span><br>
          <span>GET /workflowExecutions</span><br>
          <span>POST /workflow (format: '"""),format.raw/*28.42*/("""{"""),format.raw/*28.43*/(""""number_of_steps": 1"""),format.raw/*28.63*/("""}"""),format.raw/*28.64*/("""')</span><br>
          <span>POST /workflowExecution (format: '"""),format.raw/*29.51*/("""{"""),format.raw/*29.52*/(""""workflow_id": 1"""),format.raw/*29.68*/("""}"""),format.raw/*29.69*/("""')</span><br>
          <span>POST /increment (format: '"""),format.raw/*30.43*/("""{"""),format.raw/*30.44*/(""""workflow_execution_id": 1"""),format.raw/*30.70*/("""}"""),format.raw/*30.71*/("""')</span><br>
          <span>GET /checkIfFinished (format: '"""),format.raw/*31.48*/("""{"""),format.raw/*31.49*/(""""workflow_execution_id": 1"""),format.raw/*31.75*/("""}"""),format.raw/*31.76*/("""')</span><br>
        </p>

      </div>


    </body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 30 22:56:40 BST 2018
                  SOURCE: C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/app/views/index.scala.html
                  HASH: caf3bc7cc791747fa04583dcdb7ab0dce5fae267
                  MATRIX: 811->0|1005->168|1019->174|1079->213|1847->953|1876->954|1924->974|1953->975|2045->1039|2074->1040|2118->1056|2147->1057|2231->1113|2260->1114|2314->1140|2343->1141|2432->1202|2461->1203|2515->1229|2544->1230
                  LINES: 26->1|33->8|33->8|33->8|53->28|53->28|53->28|53->28|54->29|54->29|54->29|54->29|55->30|55->30|55->30|55->30|56->31|56->31|56->31|56->31
                  -- GENERATED --
              */
          