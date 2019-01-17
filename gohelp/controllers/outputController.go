package controllers

import "github.com/astaxie/beego"

type OutputController struct {
	beego.Controller
}

type OutputData struct {
	Id   string `json:"id" xml:"id"`
	Name string `json:"name" xml:"name"`
}

func (o *OutputController) GetJson() {
	output := OutputData{"id", "name"}
	o.Data["json"] = &output
	o.ServeJSON()
}

func (o *OutputController) GetXml() {
	output := OutputData{"id", "name"}
	o.Data["xml"] = &output
	o.ServeXML()
}

func init() {
	beego.Router("/getJson", &OutputController{},"*:GetJson")
	beego.Router("/getXml", &OutputController{},"*:GetXml")
}
