package controllers

import "github.com/astaxie/beego"

type FileController struct {
	beego.Controller
}

func (f *FileController) Get() {
	//第一个参数是文件的地址，第二个参数是下载显示的文件的名称
	f.Ctx.Output.Download("static/img/test.jpg","test.jpg")
}

func init() {
	beego.Router("/downtest", &FileController{})
}
