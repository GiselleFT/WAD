/**
 * JS para crear el canvas responsivo
 */

var ancho = 0;
var alto = 0;
if (document.body){
		 ancho = (document.body.clientWidth);
		 alto = (document.body.clientHeight);
	}else{
		 ancho = (window.innerWidth);
		 alto = (window.innerHeight);
}
//console.log("El tamaño de la ventana actual: " + ancho + " de ancho "+alto+" de alto");

var lel = "" + 1;
var css = "* {" +
   " box-sizing: border-box;" +
   		"}"+

".firstcolumn {" +
"    float: left;" +
"    width: " + (ancho*0.12) + "px;" +
"    padding: 1%;" +
"    height: " + (alto*0.75) + "px;" +
"}" +

".secondcolumn {" +
"    float: left;" +
"    width:" + (ancho*0.7) + "px;" +
"    padding: 1%;" +
"    height:" + (alto*0.75) + "px;" +
"}" +

".thirdcolumn {" +
"    float: left;" +
"    width:" + (ancho*0.155) + "px;" +
"    padding: 1%;" +
"    height:" + (alto*0.75) + "px;" +
"}" +

".fourthcolumn {" +
"    float: left;" +
"    width: 100%;" +
"    padding: 10px;" +
"    height:" + (alto*0.12) + "px;" +
"	 overflow-y: scroll;" +
"}" +

".row:after {" +
"    content: '';" +
"    display: table;" +
"    clear: both;" +
"}",
    head = document.head || document.getElementsByTagName('head')[0],
    style = document.createElement('style');

style.type = 'text/css';
if (style.styleSheet){
  style.styleSheet.cssText = css;
} else {
  style.appendChild(document.createTextNode(css));
}

head.appendChild(style);
