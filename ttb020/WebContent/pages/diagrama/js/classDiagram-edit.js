/**
 * Script para utilizar todos los componentes de un diagrama de clases
 */

var ancho = 0;
var alto = 0;
if (document.body) {
	ancho = (document.body.clientWidth);
	alto = (document.body.clientHeight);
} else {
	ancho = (window.innerWidth);
	alto = (window.innerHeight);
}

ancho = ancho * 0.70;
alto = alto * 0.75;

var text = "";

var limx = ancho * 0.5;
var limy = alto * 0.5;
var isrel = true;

function consoleWrite(texto) {
	text = text + texto;
	document.getElementById('console').innerHTML = text;
}

function cleanForm(id) {
	document.getElementById(id).value = "";
}

window.onload = function() {

	var classDiagram = new UMLClassDiagram({
		id : 'classDiagram',
		width : ancho,
		height : alto
	});
	// usecaseDiagram.setName('ewe');
	// Drawing the diagram

	var xmlData = $("#hdnXML").val();
	console.log("var CML" + xmlData);
	if (xmlData == null) {
		classDiagram.draw();
	} else {
		classDiagram.setXMLString(xmlData);
		classDiagram.draw();
	}

	classDiagram.draw();
	// This diagram is editable
	classDiagram.interaction(true);

	function crearPaquete() {
		function f(classDiagram, a, b) {
			var npaquete = document.getElementById('npaq').value;
			if (npaquete == "") {
				alert("Debes insertar un nombre para el paquete");
				return false;
			} else {
				var paquete = new UMLPackage({
					x : a,
					y : b
				});
				classDiagram.addElement(paquete);
				paquete.setName(npaquete);
			}
			cleanForm('npaq');
		}
		//interaccionUnClick(f);
        dragAndDropPaquete(f);
	}

	function addAttribute() {
		function f(classDiagram, a, b) {
			var atributo = document.getElementById('nat').value;
			var access = document.getElementById("access");
			var strUser = access.options[access.selectedIndex].value;
			var tipo = document.getElementById('tipoDato').value;
			var elemento1 = classDiagram.getElementByPoint(a, b);
			$("#clase").attr("value", elemento1.getName());
			$("#hdnAt").attr("value", atributo);
			registrarAtributos();

			if (elemento1.getType() == "UMLClass") {
				if (tipo == "")
					elemento1.addAttribute(strUser + atributo);
				else
					elemento1.addAttribute(strUser + atributo + ":" + tipo);

				classDiagram.interaction(true);
			}
			cleanForm('nat');
			cleanForm('tipoDato');
			$('#access').get(0).selectedIndex = 0;
		}
		//interaccionUnClickEnviar(f);
        dragAndDropAtributoEnviar(f);
	}

	function addOperation() {
		function f(classDiagram, a, b) {
			var metodo = document.getElementById('met').value;
			var param = document.getElementById('param').value;
			var ret = document.getElementById('ret').value;
			var access = document.getElementById("accessMet");
			var strUser = access.options[access.selectedIndex].value;
			var elemento1 = classDiagram.getElementByPoint(a, b);
			$("#classehdn").attr("value", elemento1.getName());
			$("#hdnMet").attr("value", metodo);
			registrarMetodos();

			if (elemento1.getType() == "UMLClass") {
				if (ret == "")
					elemento1
							.addOperation(strUser + metodo + "(" + param + ")");
				else
					elemento1.addOperation(strUser + metodo + "(" + param
							+ "):" + ret);
				classDiagram.interaction(true);
			}
			cleanForm('met');
			cleanForm('param');
			cleanForm('ret');
			$('#accessMet').get(0).selectedIndex = 0;
		}
		//interaccionUnClickEnviar(f);
        dragAndDropMetodoEnviar(f);
	}

	function crearClase() {
		function f(classDiagram, a, b) {
            var nclase = document.getElementById('nclase').value;
			if (nclase == "") {
				alert("Debes insertar un nombre para la clase");
				return false;
			} else {
				var clase = new UMLClass({
					x : a,
					y : b
				});
				classDiagram.addElement(clase);
                clase.setName(nclase);
			}
			cleanForm('nclase');
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Info:</font> Una <b>clase</b> es una plantilla con atributos y metodos, a partir de la cual se van a crear (instanciar) objetos.</p>");
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='green'>Tip:</font> Se recomienda utilizar un <b>sustantivo en singular</b> para nombrar una clase.</p>");
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='green'>Tip:</font> Se recomienda utilizar un <b>verbo fuerte</b> para nombrar los metodos de la clase y ordenarlos en orden descendente por su tipo de acceso.</p>");
		var nclase = document.getElementById('nclase').value;
		//interaccionUnClick(f);
        dragAndDropClase(f);
	}

	function crearComponente() {
		function f(classDiagram, a, b) {
			var nombre = document.getElementById('ncomp').value;
			if (nombre == "") {
				alert("Debes insertar un nombre para el componente");
				return false;
			} else {
				var element = new UMLComponent({
					x : a,
					y : b
				});
				classDiagram.addElement(element);
				element.setName(nombre);
			}
			cleanForm('ncomp');
		}
		//interaccionUnClick(f);
        dragAndDropComponente(f);
	}

	function guardar() {
		var save = classDiagram.getXMLString();
		$("#idDiagrama").attr("value", save);
		guardarDiagrama();
		console.log(save);
	}

	function crearInterfaz() {
		function f(classDiagram, a, b) {
			var nombre = document.getElementById('nint').value;
			if (nombre == "") {
				alert("Debes insertar un nombre para la interfaz");
				return false;
			} else {
				var element = new UMLInterfaceExtended({
					x : a,
					y : b
				});
				classDiagram.addElement(element);
				element.setName(nombre);
			}
			cleanForm('nint');
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Info:</font> Una <b>interfaz</b> es una clase con atributos y metodos que son implementados por otras clases, obligandolas a utilizar todos estos elementos ya definidos.</p>");
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='green'>Tip:</font> Se recomienda <b>no modelar</b> los metodos y atributos de esta interfaz en las clases que la implementan.</p>");
		interaccionUnClick(f);
	}

	function crearAsMul() {
		function f(classDiagram, a, b) {
			var element = new UMLNAssociation({
				x : a,
				y : b
			});
			classDiagram.addElement(element);
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Info:</font> Una <b>asociacion multiple</b> indica una relacion entre mas de dos clases.</p>");
		interaccionUnClick(f);
	}

	function crearGeneralizacion() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);
			
			if ((elemento1.getType() == "UMLClass" || elemento1.getType() == "UMLInterfaceExtended") && (elemento2.getType() == "UMLClass" || elemento2.getType() == "UMLInterfaceExtended")) {
				classDiagram.addElement(new UMLGeneralization({a : elemento1,b : elemento2}));
				
				if (y2 > y1)
					 consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> Se recomienda colocar la clase <b>" + elemento1.getName() + "</b> debajo de la superclase <b>" + elemento2.getName() + "</b>.</p>");

				consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> &#191Un(a) <b>"
						+ elemento1.getName() + "</b> es un(a) <b>"
						+ elemento2.getName() + "</b>? Si es asi, "
						+ "es correcta la direccion de la herencia. </p>");
				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> O quiza &#191Un(a) <b>"
						+ elemento2.getName()
						+ " </b>es un(a) <b>"
						+ elemento1.getName()
						+ "</b>? Si es asi, se recomienda invertir las clases y colocar la direccion "
						+ "de la herencia de la clase <b>"
						+ elemento2.getName() + "</b> hacia la clase <b>"
						+ elemento1.getName() + ".</b></p>");
			} else {
				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='red'>Warn:</font> Una <b>herencia</b> debe ser exclusivamente entre dos clases.</p>");
			}
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Info:</font> La <b>herencia</b> es una forma de resaltar los puntos comunes entre clases, evitando asi, la definicion de estas caracteristicas multiples veces.</p>");
		$("#clase").attr("value", nclase);
		$("#hdntipoRel").attr("value", "herencia");
		$("#hdnRel").attr("value", "herencia");
		interactionDoubleClick(f);
	}

	function crearAsociacion() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);

			if ((elemento1.getType() == "UMLClass"
					|| elemento1.getType() == "UMLInterfaceExtended" || elemento1
					.getType() == "UMLNAssociation")
					&& (elemento2.getType() == "UMLClass"
							|| elemento2.getType() == "UMLInterfaceExtended" || elemento2
							.getType() == "UMLNAssociation")) {
				classDiagram.addElement(new UMLAssociation({
					a : elemento1,
					b : elemento2
				}));
				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> Se recomienda colocar el nombre de la asociacion (utilizando voz activa) en el centro de la misma, a fin de tener sentido al leerse toda la asociacion de izquierda a derecha.</p>");
			} else {
				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='red'>Warn:</font> Una <b>asociacion</b> debe ser exclusivamente entre dos clases.</p>");
			}
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Tip:</font> Una <b>asociacion</b> indica una relacion entre dos clases. Se recomienda colocarlas de manera horizontal. </p>");
		$("#hdntipoRel").attr("value", "asociacion");
		$("#hdnRel").attr("value", "asociacion");
		interactionDoubleClick(f);
	}

	function crearAgregacion() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);

			if ((elemento1.getType() == "UMLClass" || elemento1.getType() == "UMLInterfaceExtended")
					&& (elemento2.getType() == "UMLClass" || elemento2
							.getType() == "UMLInterfaceExtended")) {
				classDiagram.addElement(new UMLAggregation({
					a : elemento1,
					b : elemento2
				}));

				if ((x1 + 50) > x2)
					consoleWrite("<p align='left'>"
							+ new Date().toLocaleString()
							+ " ==> <font color='green'>Tip:</font>Se recomienda colocar la clase <b>"
							+ elemento1.getName()
							+ "</b> a la derecha de la clase <b>"
							+ elemento2.getName() + "</b>.</p>");

				consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> &#191Un(a) <b>"
						+ elemento2.getName() + "</b> es parte de un(a) <b>"
						+ elemento1.getName() + "</b>? Si es asi, "
						+ "es correcta la agregacion. </p>");
				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> O quiza &#191Un(a) <b>"
						+ elemento1.getName()
						+ " </b>es parte de un(a) <b>"
						+ elemento2.getName()
						+ "</b>? Si es asi, se recomienda invertir las clases y colocar la direccion "
						+ "de la agregacion de la clase <b>"
						+ elemento2.getName() + "</b> hacia la clase <b>"
						+ elemento1.getName() + ".</b></p>");

			}
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Info:</font> Una <b>agregacion</b> indica que un objeto es creado a partir de otros objetos.</p>");
		$("#hdntipoRel").attr("value", "agregacion");
		$("#hdnRel").attr("value", "agregacion");
		interactionDoubleClick(f);
	}

	function crearComposicion() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);

			if ((elemento1.getType() == "UMLClass" || elemento1.getType() == "UMLInterfaceExtended")
					&& (elemento2.getType() == "UMLClass" || elemento2
							.getType() == "UMLInterfaceExtended")) {
				classDiagram.addElement(new UMLComposition({
					a : elemento1,
					b : elemento2
				}));

				if ((x1 + 50) > x2)
					consoleWrite("<p align='left'>"
							+ new Date().toLocaleString()
							+ " ==> <font color='green'>Tip:</font>Se recomienda colocar la clase <b>"
							+ elemento1.getName()
							+ "</b> a la derecha de la clase <b>"
							+ elemento2.getName() + "</b>.</p>");

				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> &#191La clase <b>"
						+ elemento2.getName()
						+ "</b> puede existir sin la clase <b>"
						+ elemento1.getName() + "</b>? Si es asi, "
						+ "es correcta la composicion. </p>");
				consoleWrite("<p align='left'>"
						+ new Date().toLocaleString()
						+ " ==> <font color='green'>Tip:</font> O quiza &#191La clase <b>"
						+ elemento1.getName()
						+ " </b>puede existir sin la clase <b>"
						+ elemento2.getName()
						+ "</b>? Si es asi, se recomienda invertir las clases y colocar la direccion "
						+ "de la composicion de la clase <b>"
						+ elemento2.getName() + "</b> hacia la clase <b>"
						+ elemento1.getName() + ".</b></p>");

			}
		}
		consoleWrite("<p align='left'>"
				+ new Date().toLocaleString()
				+ " ==> <font color='blue'>Info:</font> Una <b>composicion</b> indica que la existencia de un objeto depende totalmente de otros objetos.</p>");
		$("#hdntipoRel").attr("value", "composicion");
		$("#hdnRel").attr("value", "composicion");
		interactionDoubleClick(f);
	}

	function crearDependencia() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);

			if ((elemento1.getType() == "UMLClass" || elemento1.getType() == "UMLInterfaceExtended") && (elemento2.getType() == "UMLClass" || elemento2.getType() == "UMLInterfaceExtended")) {
				classDiagram.addElement(new UMLDependency({ a : elemento1, b : elemento2 }));
				consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191La clase <b>" + elemento1.getName() + "</b> usa la clase  <b>" + elemento2.getName() + "</b>? Si es asi, " + "es correcta la direccion del uso. </p>");
				consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> O quiza &#191La clase <b>" + elemento2.getName() + "</b> usa la clase  <b>" + elemento1.getName() + "</b>? Si es asi, " + "se recomienda invertir las clases y colocar " +
						"la direccion del uso de la clase <b>"
						+ elemento2.getName() + "</b> hacia la clase <b>"
						+ elemento1.getName() + "</b>.</p>");
			}
		}
		consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Una <b>dependencia</b> indica que una clase es instanciada por otra clase.</p>");
		$("#hdntipoRel").attr("value", "dependencia");
		$("#hdnRel").attr("value", "dependencia");
		interactionDoubleClick(f);
	}

	function crearRealizacion() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);

			if ((elemento1.getType() == "UMLClass" || elemento1.getType() == "UMLInterfaceExtended") && (elemento2.getType() == "UMLClass" || elemento2.getType() == "UMLInterfaceExtended")) {
				classDiagram.addElement(new UMLRealization({ a : elemento1, b : elemento2 }));
				consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191La clase <b>" + elemento1.getName() + "</b> implementa la interfaz  <b>" + elemento2.getName() + "</b>? Si es asi, " + "es correcta la direccion de la realizacion. </p>");
				consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> O quiza &#191La clase <b>" + elemento2.getName() + "</b> implementa la interfaz <b>" + elemento1.getName() + "</b>? Si es asi, " + "se recomienda invertir las clases y colocar " +
						"la direccion de la realizacion de la clase <b>"
						+ elemento2.getName() + "</b> hacia la clase <b>"
						+ elemento1.getName() + "</b>.</p>");
			}
		}
		consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Una <b>realizacion</b> indica que se implementara una interfaz.</p>");
		interactionDoubleClick(f);
	}

	function crearUso() {
		function f(classDiagram, x1, y1, x2, y2) {
			var elemento1 = classDiagram.getElementByPoint(x1, y1);
			var elemento2 = classDiagram.getElementByPoint(x2, y2);

			if ((elemento1.getType() == "UMLClass" || elemento1.getType() == "UMLInterfaceExtended")
					&& (elemento2.getType() == "UMLClass" || elemento2
							.getType() == "UMLInterfaceExtended")) {
				classDiagram.addElement(new UMLUsage({
					a : elemento1,
					b : elemento2
				}));
			}
		}
		interactionDoubleClick(f);
	}

	function crearNota() {
		function f(classDiagram, a, b) {
			var note = new UMLNote({
				x : a,
				y : b
			});
			classDiagram.addElement(note);
			note.setName('Nota');
		}
		interaccionUnClick(f);
	}

	function borrar() {
		function f(classDiagram, x, y) {
			var elem = classDiagram.getElementByPoint(x, y);

			if (elem && elem instanceof Element) {
				var text = '¿Estás seguro que deseas eliminar '
						+ elem.getType() + '?';
				var dialog = new Dialog({
					text : text,
					cancelable : true
				});

				var fn = function() {
					classDiagram.delElement(elem);
					classDiagram.draw();
				}
				dialog.show(fn);
			}
		}
		interaccionUnClick(f);
	}

	var interaccionUnClickEnviar = function(funcion) {
		classDiagram.interaction(false);
		var div = document.getElementsByClassName('ud_diagram_div')[0];

		var funcionCaptura = function(event) {
			var mousex = event.pageX - div.offsetLeft;
			var mousey = event.pageY - div.offsetTop;
			funcion(classDiagram, mousex, mousey);
			div.onclick = false;
			classDiagram.draw();
		}
		div.onclick = funcionCaptura;
	}

	var interaccionUnClick = function(funcion) {
		classDiagram.interaction(false);
		var div = document.getElementsByClassName('ud_diagram_div')[0];

		var funcionCaptura = function(event) {
			var mousex = event.pageX - div.offsetLeft;
			var mousey = event.pageY - div.offsetTop;
			funcion(classDiagram, mousex, mousey);
			div.onclick = false;
			classDiagram.draw();
			var elemento1 = classDiagram.getElementByPoint(mousex, mousey);
			if (elemento1.getType() == "UMLClass")
				$("#hdnClase").attr("value", elemento1.getName());
			obtenerMetodos(elemento1.getName());
			classDiagram.interaction(true);
		}
		div.onclick = funcionCaptura;
    }

    var dragAndDropAtributoEnviar = function(funcion) {
		classDiagram.interaction(false);
        var row = document.getElementById("main");
		var div = document.getElementsByClassName('ud_diagram_div')[0];
        var ele = document.getElementById("botonAt");

        var xInicial = 0;
        var yInicial = 0;

        ele.onmousedown = function(event){
            var shiftX = event.clientX - ele.getBoundingClientRect().left;
            var shiftY = event.clientY - ele.getBoundingClientRect().top;

            //xInicial = 29.953125 , yInicial= 10.484375
            xInicial = shiftX;
            yInicial = shiftY;
            
            //console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);

            ele.style.position = 'absolute';
            document.body.append(ele);

            moveAt(event.pageX, event.pageY);
            
            //centra componente en las coordenadas
            function moveAt(pageX, pageY){
                ele.style.left = pageX - shiftX + 'px';
                ele.style.top = pageY - shiftY + 'px';
            }

            function onMouseMove(event){
                moveAt(event.pageX, event.pageY);
            }

            //mueve de acuerdo al mouse
            document.addEventListener('mousemove', onMouseMove);
            
            //drop
            ele.onmouseup = function(){
                document.removeEventListener('mousemove', onMouseMove);
                var xFinal = event.pageX - shiftX + 'px';
                var yFinal = event.pageY - shiftY + 'px';
                console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);
                console.log("xFinal = " + xFinal + " , yFinal= " + yFinal);
                ele.onclick = funcionCaptura(xFinal, yFinal);
                
                ele.style.position = "absolute";
                ele.style.left = 50+'px';
                ele.style.top = 560.484375+'px';
                document.body.append(ele);
                
                ele.onmouseup = null;
            };
        };

        ele.ondragstart = function(event){
            return false;
        };

        var funcionCaptura = function(xFinal, yFinal) {
			var mousex = event.pageX - div.offsetLeft;
            var mousey = event.pageY - div.offsetTop;
            
            funcion(classDiagram, mousex, mousey);
            ele.onclick = false;
			//div.onclick = false;
            //var nclase = document.getElementById('nclase').value;
            console.log("funcionCaptura nclase= " + nclase);
			classDiagram.draw();
		}
        
        //Para regresar el boton al componente de clase y que no aparezca en otros componentes haciendo cualquier clic en la seccion main
        var funcionClickDespues = function(event){
            var dbotonAt = document.getElementById("botonAt");
            var dbody = document.getElementsByTagName("BODY")[0];
            dbody.removeChild(dbotonAt);
            document.getElementById("inputClaseInside").appendChild(dbotonAt);
        }
        main.onclick = funcionClickDespues;
        main.onclick = null;

	}

    var dragAndDropMetodoEnviar = function(funcion) {
		classDiagram.interaction(false);
        var row = document.getElementById("main");
		var div = document.getElementsByClassName('ud_diagram_div')[0];
        var ele = document.getElementById("botonMet");

        var xInicial = 0;
        var yInicial = 0;

        ele.onmousedown = function(event){
            var shiftX = event.clientX - ele.getBoundingClientRect().left;
            var shiftY = event.clientY - ele.getBoundingClientRect().top;

            //xInicial = 29.953125 , yInicial= 10.484375
            xInicial = shiftX;
            yInicial = shiftY;
            
            //console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);

            ele.style.position = 'absolute';
            document.body.append(ele);

            moveAt(event.pageX, event.pageY);
            
            //centra componente en las coordenadas
            function moveAt(pageX, pageY){
                ele.style.left = pageX - shiftX + 'px';
                ele.style.top = pageY - shiftY + 'px';
            }

            function onMouseMove(event){
                moveAt(event.pageX, event.pageY);
            }

            //mueve de acuerdo al mouse
            document.addEventListener('mousemove', onMouseMove);
            
            //drop
            ele.onmouseup = function(){
                document.removeEventListener('mousemove', onMouseMove);
                var xFinal = event.pageX - shiftX + 'px';
                var yFinal = event.pageY - shiftY + 'px';
                console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);
                console.log("xFinal = " + xFinal + " , yFinal= " + yFinal);
                ele.onclick = funcionCaptura(xFinal, yFinal);
                
                ele.style.position = "absolute";
                ele.style.left = 50+'px';
                ele.style.top = 630.484375+'px';
                document.body.append(ele);
                
                ele.onmouseup = null;
            };
        };

        ele.ondragstart = function(event){
            return false;
        };

        var funcionCaptura = function(xFinal, yFinal) {
			var mousex = event.pageX - div.offsetLeft;
            var mousey = event.pageY - div.offsetTop;
            
            funcion(classDiagram, mousex, mousey);
            ele.onclick = false;
			//div.onclick = false;
            //var nclase = document.getElementById('nclase').value;
            console.log("funcionCaptura nclase= " + nclase);
			classDiagram.draw();
		}
        
        //Para regresar el boton al componente de clase y que no aparezca en otros componentes haciendo cualquier clic en la seccion main
        var funcionClickDespues = function(event){
            var dbotonMet = document.getElementById("botonMet");
            var dbody = document.getElementsByTagName("BODY")[0];
            dbody.removeChild(dbotonMet);
            document.getElementById("inputClaseInside").appendChild(dbotonMet);
        }
        main.onclick = funcionClickDespues;
        main.onclick = null;

	}
    
    var dragAndDropClase = function(funcion) {
		classDiagram.interaction(false);
        var row = document.getElementById("main");
		var div = document.getElementsByClassName('ud_diagram_div')[0];
        var ele = document.getElementById("botonClase");
        var xInicial = 0;
        var yInicial = 0;

        
        ele.onmousedown = function(event){
            var shiftX = event.clientX - ele.getBoundingClientRect().left;
            var shiftY = event.clientY - ele.getBoundingClientRect().top;

            //xInicial = 29.953125 , yInicial= 10.484375
            xInicial = shiftX;
            yInicial = shiftY;
            
            //console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);

            ele.style.position = 'absolute';
            document.body.append(ele);

            moveAt(event.pageX, event.pageY);
            
            //centra componente en las coordenadas
            function moveAt(pageX, pageY){
                ele.style.left = pageX - shiftX + 'px';
                ele.style.top = pageY - shiftY + 'px';
            }

            function onMouseMove(event){
                moveAt(event.pageX, event.pageY);
            }

            //mueve de acuerdo al mouse
            document.addEventListener('mousemove', onMouseMove);
            
            //drop
            ele.onmouseup = function(){
                document.removeEventListener('mousemove', onMouseMove);
                var xFinal = event.pageX - shiftX + 'px';
                var yFinal = event.pageY - shiftY + 'px';
                console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);
                console.log("xFinal = " + xFinal + " , yFinal= " + yFinal);
                ele.onclick = funcionCaptura(xFinal, yFinal);
                
                ele.style.position = "absolute";
                ele.style.left = 50+'px';
                ele.style.top = 480.484375+'px';
                document.body.append(ele);
                
                ele.onmouseup = null;
            };
        };

        ele.ondragstart = function(event){
            return false;
        };

        
		var funcionCaptura = function(xFinal, yFinal) {
			var mousex = event.pageX - div.offsetLeft;
            var mousey = event.pageY - div.offsetTop;
            
            funcion(classDiagram, mousex, mousey);
            ele.onclick = false;
			//div.onclick = false;
            //var nclase = document.getElementById('nclase').value;
            console.log("funcionCaptura nclase= " + nclase);
			classDiagram.draw();
			var elemento1 = classDiagram.getElementByPoint(mousex, mousey);
            console.log("elemento1 = " + elemento1.getName());
			if (elemento1.getType() == "UMLClass")
				$("#hdnClase").attr("value", elemento1.getName());
			obtenerMetodos(elemento1.getName());
			classDiagram.interaction(true);
		}
        
        //Para regresar el boton al componente de clase y que no aparezca en otros componentes haciendo cualquier clic en la seccion main
        var funcionClickDespues = function(event){
            var dbotonClase = document.getElementById("botonClase");
            var dbody = document.getElementsByTagName("BODY")[0];
            dbody.removeChild(dbotonClase);
            document.getElementById("inputClaseInside").appendChild(dbotonClase);
        }
        main.onclick = funcionClickDespues;
    }


    var dragAndDropPaquete = function(funcion) {
		classDiagram.interaction(false);
        var row = document.getElementById("main");
		var div = document.getElementsByClassName('ud_diagram_div')[0];
        var ele = document.getElementById("botonPaq");
        var xInicial = 0;
        var yInicial = 0;

        
        ele.onmousedown = function(event){
            var shiftX = event.clientX - ele.getBoundingClientRect().left;
            var shiftY = event.clientY - ele.getBoundingClientRect().top;

            //xInicial = 29.953125 , yInicial= 10.484375
            xInicial = shiftX;
            yInicial = shiftY;
            
            //console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);

            ele.style.position = 'absolute';
            document.body.append(ele);

            moveAt(event.pageX, event.pageY);
            
            //centra componente en las coordenadas
            function moveAt(pageX, pageY){
                ele.style.left = pageX - shiftX + 'px';
                ele.style.top = pageY - shiftY + 'px';
            }

            function onMouseMove(event){
                moveAt(event.pageX, event.pageY);
            }

            //mueve de acuerdo al mouse
            document.addEventListener('mousemove', onMouseMove);
            
            //drop
            ele.onmouseup = function(){
                document.removeEventListener('mousemove', onMouseMove);
                var xFinal = event.pageX - shiftX + 'px';
                var yFinal = event.pageY - shiftY + 'px';
                console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);
                console.log("xFinal = " + xFinal + " , yFinal= " + yFinal);
                ele.onclick = funcionCaptura(xFinal, yFinal);
                
                ele.style.position = "absolute";
                ele.style.left = 50+'px';
                ele.style.top = 480.484375+'px';
                document.body.append(ele);
                
                ele.onmouseup = null;
            };
        };

        ele.ondragstart = function(event){
            return false;
        };

        
		var funcionCaptura = function(xFinal, yFinal) {
			var mousex = event.pageX - div.offsetLeft;
            var mousey = event.pageY - div.offsetTop;
            
            funcion(classDiagram, mousex, mousey);
            ele.onclick = false;
			//div.onclick = false;
            //var nclase = document.getElementById('nclase').value;
            console.log("funcionCaptura nclase= " + nclase);
			classDiagram.draw();
			var elemento1 = classDiagram.getElementByPoint(mousex, mousey);
            console.log("elemento1 = " + elemento1.getName());
			if (elemento1.getType() == "UMLClass")
				$("#hdnClase").attr("value", elemento1.getName());
			obtenerMetodos(elemento1.getName());
			classDiagram.interaction(true);
		}
        
        //Para regresar el boton al componente de clase y que no aparezca en otros componentes haciendo cualquier clic en la seccion main
        var funcionClickDespues = function(event){
            var dbotonPaq = document.getElementById("botonPaq");
            var dbody = document.getElementsByTagName("BODY")[0];
            dbody.removeChild(dbotonPaq);
            document.getElementById("inputClaseInside").appendChild(dbotonPaq);
        }
        main.onclick = funcionClickDespues;
    }

    var dragAndDropComponente = function(funcion) {
		classDiagram.interaction(false);
        var row = document.getElementById("main");
		var div = document.getElementsByClassName('ud_diagram_div')[0];
        var ele = document.getElementById("botonComp");
        var xInicial = 0;
        var yInicial = 0;

        
        ele.onmousedown = function(event){
            var shiftX = event.clientX - ele.getBoundingClientRect().left;
            var shiftY = event.clientY - ele.getBoundingClientRect().top;

            //xInicial = 29.953125 , yInicial= 10.484375
            xInicial = shiftX;
            yInicial = shiftY;
            
            //console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);

            ele.style.position = 'absolute';
            document.body.append(ele);

            moveAt(event.pageX, event.pageY);
            
            //centra componente en las coordenadas
            function moveAt(pageX, pageY){
                ele.style.left = pageX - shiftX + 'px';
                ele.style.top = pageY - shiftY + 'px';
            }

            function onMouseMove(event){
                moveAt(event.pageX, event.pageY);
            }

            //mueve de acuerdo al mouse
            document.addEventListener('mousemove', onMouseMove);
            
            //drop
            ele.onmouseup = function(){
                document.removeEventListener('mousemove', onMouseMove);
                var xFinal = event.pageX - shiftX + 'px';
                var yFinal = event.pageY - shiftY + 'px';
                console.log("xInicial = " + xInicial + " , yInicial= " + yInicial);
                console.log("xFinal = " + xFinal + " , yFinal= " + yFinal);
                ele.onclick = funcionCaptura(xFinal, yFinal);
                
                ele.style.position = "absolute";
                ele.style.left = 30+'px';
                ele.style.top = 465.484375+'px';
                document.body.append(ele);
                
                ele.onmouseup = null;
            };
        };

        ele.ondragstart = function(event){
            return false;
        };

        
		var funcionCaptura = function(xFinal, yFinal) {
			var mousex = event.pageX - div.offsetLeft;
            var mousey = event.pageY - div.offsetTop;
            
            funcion(classDiagram, mousex, mousey);
            ele.onclick = false;
			//div.onclick = false;
            //var nclase = document.getElementById('nclase').value;
            console.log("funcionCaptura nclase= " + nclase);
			classDiagram.draw();
			var elemento1 = classDiagram.getElementByPoint(mousex, mousey);
            console.log("elemento1 = " + elemento1.getName());
			if (elemento1.getType() == "UMLClass")
				$("#hdnClase").attr("value", elemento1.getName());
			obtenerMetodos(elemento1.getName());
			classDiagram.interaction(true);
		}
        
        //Para regresar el boton al componente de clase y que no aparezca en otros componentes haciendo cualquier clic en la seccion main
        var funcionClickDespues = function(event){
            var dbotonComp = document.getElementById("botonComp");
            var dbody = document.getElementsByTagName("BODY")[0];
            dbody.removeChild(dbotonComp);
            document.getElementById("inputClaseInside").appendChild(dbotonComp);
        }
        main.onclick = funcionClickDespues;
    }

	var interactionDoubleClick = function(g) {
		classDiagram.interaction(false);
		var div = document.getElementsByClassName('ud_diagram_div')[0];
		var x = 0;
		var y = 0;
		var f = true;

		var a = function(event) {
			var mousex = event.pageX - div.offsetLeft;
			var mousey = event.pageY - div.offsetTop;
			if (f) {
				f = false;
				x = mousex;
				y = mousey;
				/*
				 * validacion para encontrar objetos con los que se puede
				 * relacionar el primer caso de uso
				 */
				var elemento1 = classDiagram.getElementByPoint(x, y);
				if ((elemento1.getType() == "UMLClass")) {
					$("#hdnNomClase").attr("value", elemento1.getName());
					obtenerDatos(elemento1.getName());
				}
			} else {
				console.log('x1: ' + x + '\ny1: ' + y + '\nx2: ' + mousex
						+ '\ny2: ' + mousey);
				var elemento1 = classDiagram.getElementByPoint(x, y);
				var elemento2 = classDiagram.getElementByPoint(mousex, mousey);

				if ((elemento1.getType() == "UMLClass")
						&& (elemento2.getType() == "UMLClass")) {
					$("#hdnClaseUno").attr("value", elemento1.getName());
					$("#hdnClaseDos").attr("value", elemento2.getName());
					registrarDatos();
				}
				g(classDiagram, x, y, mousex, mousey);
				div.onclick = false;
				classDiagram.draw();
				classDiagram.interaction(true)
			}
		};
		div.onclick = a
	}

	function saveComentary() {
		var nota = document.getElementById('comentarioIn').value;
		$("#textoComentario").attr("value", nota);
		guardarComentario();
	}

	document.getElementById('botonPaq').onclick = crearPaquete;
	document.getElementById('botonClase').onclick = crearClase;
	document.getElementById('botonComp').onclick = crearComponente;
	document.getElementById('botonGen').onclick = crearGeneralizacion;
	document.getElementById('botonAs').onclick = crearAsociacion;
	document.getElementById('botonAg').onclick = crearAgregacion;
	document.getElementById('botonComposicion').onclick = crearComposicion;
	document.getElementById('botonDep').onclick = crearDependencia;
	document.getElementById('botonGuardar').onclick = guardar;
	//document.getElementById('botonReal').onclick = crearRealizacion;
	document.getElementById('botonNota').onclick = crearNota;
	document.getElementById('botonBorrar').onclick = borrar;
	document.getElementById('botonAt').onclick = addAttribute;
	document.getElementById('botonMet').onclick = addOperation;
	document.getElementById('botonComentario').onclick = saveComentary;
}

/**
 * Implementación de llamada a AJAX para obtener información de la base de
 * conocimiento de IA
 * 
 * @param
 * @returns
 */
function obtenerDatos() {
	var form = $("#hdnClaseRel");
	var clase = $("#hdnNomClase").val();
	var rel = $("#hdntipoRel").val();
	console.log("rel: " + rel);
	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		async : false,
		success : function(data) {
			var respuesta = data.ajaxResult;
			if (respuesta.response.estatus == "ENCONTRADO") {

				var cadena = respuesta.response.data;
				var cad = "";
				
				for(var i=0; i<cadena.length; i++){
					cad = cad + cadena[i] + ", ";
				}
				
				if(rel == "asociacion"){
					
						consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>" + clase
						+ "</b> se puede <u>relacionar</u> " +
						+ "con las clases: <b>" + cad + "</b></p>");
						
				}else if(rel == "agregacion"){

					consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>" + clase
						+ "</b> puede <u>agregar</u> las clases: <b>" + cad + "</b></p>");
				
				}else if(rel == "composicion"){

						consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>" + clase
						+ "</b> se puede <u>componer</u> " +
						+ "de las clases: <b>" + cad + "</b></p>");
				
				}else if(rel == "dependencia"){
			
						consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>" + clase
						+ "</b> puede tener <u>dependencia</u> " +
						+ "con las clases: <b>" + cad + "</b></p>");
				
				}else if(rel == "herencia"){
					
						consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>" + clase
						+ "</b> puede <u>heredar</u> " +
						+ "de las clases: <b>" + cad + "</b></p>");
					
				}				

			} else {
				console.log(respuesta.response.estatus);
				console.log("No se encontro información correspondiente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}

/**
 * Implementación de llamada a AJAX para obtener información de la base de
 * conocimiento de IA
 * 
 * @param
 * @returns
 */
function obtenerMetodos() {
	var form = $("#hdnNombreClase");
	var clase = $("#hdnClase").val();
	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		async : false,
		success : function(data) {
			var respuesta = data.ajaxResult;
			if (respuesta.response.estatus == "ENCONTRADO") {

				var cadena = respuesta.response.dataMetodos;
				var cadena2 = respuesta.response.dataAtributos;

				var cad1 = "";
				var cad2 = "";

				for (var i = 0; i < cadena.length; i++) {
					cad1 = cad1 + cadena[i] + ", ";
				}

				for (var i = 0; i < cadena2.length; i++) {
					cad2 = cad2 + cadena2[i] + ", ";
				}

				consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>"
						+ clase + "</b> puede tener los"
						+ " siguientes <u>atributos</u>: " + cad2 + "</p>");

				consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='green'>Tip:</font> La clase <b>"
						+ clase + "</b> puede tener los"
						+ " siguientes <u>metodos</u>: " + cad1 + "</p>");

			} else {
				console.log(respuesta.response.estatus);
				console.log("No se encontro información correspondiente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}

/**
 * Implementación de llamada a AJAX para obtener información de la base de
 * conocimiento de IA
 * 
 * @param
 * @returns
 */
function registrarDatos() {
	var form = $("#hdnRegistrar");

	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		async : false,
		success : function(data) {
			var respuesta = data.ajaxResult;
			if (respuesta.response.estatus == "ENCONTRADO") {
//				consoleWrite("<p align='left'>" + new Date().toLocaleString()
//						+ "==> <font color='green'>Tip: </font>"
//						+ respuesta.response.data + "</p>");
			} else {
				console.log(respuesta.response.estatus);
				console.log("No se encontro información correspondiente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}

/**
 * Implementación de llamada a AJAX para guardar el diagrama en BD.
 * 
 * @param
 * @returns
 */
function guardarDiagrama() {
	var form = $("#hdnSave");

	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		async : false,
		success : function(data) {
			var ajaxResult = data.ajaxResult;
			if (gestionarErroresAjaxResult(ajaxResult, form.attr("id"))) {
				CancelarDlgConfirm();
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}

function CancelarDlgConfirm() {
	$.publish("showDlgCancelarOperacion");
}

function cerrarDlgCancelar() {
	$.publish("closeDlgCancelarOPeracion");
}

function registrarAtributos() {
	var form = $("#hdnAtributos");

	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		async : false,
		success : function(data) {
			var respuesta = data.ajaxResult;
			if (respuesta.response.estatus == "ENCONTRADO") {
//				consoleWrite("<p align='left'>" + new Date().toLocaleString()
//						+ "==> <font color='green'>Tip: </font>"
//						+ "Atributos OK </p>");
			} else {
				console.log(respuesta.response.estatus);
				console.log("No se encontro información correspondiente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}

/**
 * Implementación de llamada a AJAX para obtener información de la base de
 * conocimiento de IA
 * 
 * @param
 * @returns
 */
function registrarMetodos() {
	var form = $("#hdnOperaciones");

	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		async : false,
		success : function(data) {
			var respuesta = data.ajaxResult;
			if (respuesta.response.estatus == "ENCONTRADO") {
//				consoleWrite("<p align='left'>" + new Date().toLocaleString()
//						+ "==> <font color='green'>Tip: </font>"
//						+ "Metodos OK </p>");
			} else {
				console.log(respuesta.response.estatus);
				console.log("No se encontro información correspondiente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}

/**
 * Implementación de llamada a AJAX para guardar comentarios en la BD
 * 
 * @param
 * @returns
 */
function guardarComentario() {
	var form = $("#guardarComentario");
	$.ajax({
		type : form.attr("method"),
		url : form.attr("action"),
		data : form.serialize(),
		cache : false,
		dataType : 'html',
		async : false,
		success : function(data) {
			var respuesta = JSON.parse(data).ajaxResult;
			if (respuesta.response.estatus == "ENCONTRADO") {
				consoleWrite("<p align='left'>" + new Date().toLocaleString()
						+ "==> <font color='blue'>Info:</font> "
						+ respuesta.response.string + "</p>");
			} else {
				console.log("No se encontro información correspondiente");
			}
		},
		error : function(data) {
			console.log("error");
		}
	});
}