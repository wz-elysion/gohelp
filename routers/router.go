package routers

import (
	"github.com/astaxie/beego"
	"goHelp/controllers"
)

func init() {
	beego.Router("/", &controllers.MainController{})
}
