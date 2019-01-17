package main

import (
	"github.com/astaxie/beego"
	_ "goHelp/routers"
)

func main() {
	beego.SetStaticPath("/down", "./")
	beego.Run()
}
