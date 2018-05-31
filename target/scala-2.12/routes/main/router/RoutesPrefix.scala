// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/matthews/Documents/Stansa/TRAYIO/trayio-task/conf/routes
// @DATE:Wed May 30 21:26:32 BST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
