// @GENERATOR:play-routes-compiler
// @SOURCE:/home/matthews/TRAY/trayio-task3/conf/routes
// @DATE:Mon May 28 19:50:19 BST 2018


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
