 window.onload = function(){
    		 
	 var classDiagram = new UMLClassDiagram({id: 'classDiagram', width: 1000, height: 750 });
	 //usecaseDiagram.setName('ewe');
     // Drawing the diagram 
	 classDiagram.draw();
     // This diagram is editable
	 classDiagram.interaction(true);  	
     
     function crearPaquete(){
    	 function f(classDiagram, a, b){
    	 	var npaquete = document.getElementById('npaq').value;	            	 
        	 if (npaquete == "") {
           	   alert("Debes insertar un nombre para el paquete");
           	   return false;
             }else {
        	    var text = "Input OK";       
        	    var paquete = new UMLPackage({ x:a, y:b });
        	    classDiagram.addElement(paquete);
        	    paquete.setName(npaquete);
        	 }
        	 document.getElementById('npaq').value = "";
        	 document.getElementById('console').innerHTML = text;
        	 console.log('actor');
        }
    	 interaccionUnClick( f );
	 }
     
     function crearContPaq(){
    	 function f(classDiagram, a, b){
    	 	var npaquete = document.getElementById('ncontpaq').value;	            	 
        	 if (npaquete == "") {
           	   alert("Debes insertar un nombre para el paquete contenedor");
           	   return false;
             }else {
        	    var text = "Input OK";       
        	    var paquete = new UMLPackageContainer({ x:a, y:b });
        	    classDiagram.addElement(paquete);
        	    paquete.setName(npaquete);
        	 }
        	 document.getElementById('ncontpaq').value = "";
        	 document.getElementById('console').innerHTML = text;
        }
    	 interaccionUnClick( f );
	 }
     
     function crearClase(){
    	 function f(classDiagram, a, b){
    	 	var nclase = document.getElementById('nclase').value;	            	 
        	 if (nclase == "") {
           	   alert("Debes insertar un nombre para la clase");
           	   return false;
             }else {
        	    var text = "Input OK";       
        	    var clase = new UMLClass({ x:a, y:b });
        	    classDiagram.addElement(clase);
        	    clase.setName(nclase);
        	 }
        	 document.getElementById('nclase').value = "";
        	 document.getElementById('console').innerHTML = text;
        }
    	 //interaccionUnClick(f);
        dragAndDrop(f);
	 }
     
     function crearComponente(){
    	 function f(classDiagram, a, b){
    	 	var nombre = document.getElementById('ncomp').value;	            	 
        	 if (nombre == "") {
           	   alert("Debes insertar un nombre para el componente");
           	   return false;
             }else {
        	    var text = "Input OK";       
        	    var element = new UMLComponent({ x:a, y:b });
        	    classDiagram.addElement(element);
        	    element.setName(nombre);
        	 }
        	 document.getElementById('ncomp').value = "";
        	 document.getElementById('console').innerHTML = text;
        }
    	 interaccionUnClick( f );
	 }
     
     function crearInterfaz(){
    	 function f(classDiagram, a, b){
    	 	var nombre = document.getElementById('nint').value;	            	 
        	 if (nombre == "") {
           	   alert("Debes insertar un nombre para la interfaz");
           	   return false;
             }else {
        	    var text = "Input OK";       
        	    var element = new UMLInterfaceExtended({ x:a, y:b });
        	    classDiagram.addElement(element);
        	    element.setName(nombre);
        	 }
        	 document.getElementById('nint').value = "";
        	 document.getElementById('console').innerHTML = text;
        }
    	 interaccionUnClick( f );
	 }
     
     function crearAsMul(){
    	 function f(classDiagram, a, b){    
        	    var element = new UMLNAssociation({ x:a, y:b });
        	    classDiagram.addElement(element);
        }
    	 interaccionUnClick( f );
	 }
     
     function crearGeneralizacion(){
     	function f (classDiagram, x1, y1, x2, y2){
     		var elemento1 = classDiagram.getElementByPoint(x1,y1);
     		var elemento2= classDiagram.getElementByPoint(x2,y2);
     		classDiagram.addElement(new UMLGeneralization({a:elemento1, b:elemento2}));
     	 }
     	interactionDoubleClick( f );
      }
     
     function crearAsociacion(){
      	function f (classDiagram, x1, y1, x2, y2){
      		var elemento1 = classDiagram.getElementByPoint(x1,y1);
      		var elemento2= classDiagram.getElementByPoint(x2,y2);
      		classDiagram.addElement(new UMLAssociation({a:elemento1, b:elemento2}));
      	 }
      	interactionDoubleClick( f );
       }
     
     function crearAgregacion(){
       	function f (classDiagram, x1, y1, x2, y2){
       		var elemento1 = classDiagram.getElementByPoint(x1,y1);
       		var elemento2= classDiagram.getElementByPoint(x2,y2);
       		classDiagram.addElement(new UMLAggregation({a:elemento1, b:elemento2}));
       	 }
       	interactionDoubleClick( f );
        }
     
     function crearComposicion(){
        	function f (classDiagram, x1, y1, x2, y2){
        		var elemento1 = classDiagram.getElementByPoint(x1,y1);
        		var elemento2= classDiagram.getElementByPoint(x2,y2);
        		classDiagram.addElement(new UMLComposition({a:elemento1, b:elemento2}));
        	 }
        	interactionDoubleClick( f );
         }
     
     function crearDependencia(){
     	function f (classDiagram, x1, y1, x2, y2){
     		var elemento1 = classDiagram.getElementByPoint(x1,y1);
     		var elemento2= classDiagram.getElementByPoint(x2,y2);
     		classDiagram.addElement(new UMLDependency({a:elemento1, b:elemento2}));
     	 }
     	interactionDoubleClick( f );
      }
     
     function crearRealizacion(){
      	function f (classDiagram, x1, y1, x2, y2){
      		var elemento1 = classDiagram.getElementByPoint(x1,y1);
      		var elemento2= classDiagram.getElementByPoint(x2,y2);
      		classDiagram.addElement(new UMLRealization({a:elemento1, b:elemento2}));
      	 }
      	interactionDoubleClick( f );
       }
     
     function crearUso(){
       	function f (classDiagram, x1, y1, x2, y2){
       		var elemento1 = classDiagram.getElementByPoint(x1,y1);
       		var elemento2= classDiagram.getElementByPoint(x2,y2);
       		classDiagram.addElement(new UMLUsage({a:elemento1, b:elemento2}));
       	 }
       	interactionDoubleClick( f );
        }
     
     function crearCombinacion(){
        	function f (classDiagram, x1, y1, x2, y2){
        		var elemento1 = classDiagram.getElementByPoint(x1,y1);
        		var elemento2= classDiagram.getElementByPoint(x2,y2);
        		classDiagram.addElement(new UMLPackageMerge({a:elemento1, b:elemento2}));
        	 }
        	interactionDoubleClick( f );
         }
        
     function crearImpPub(){
     	function f (classDiagram, x1, y1, x2, y2){
     		var elemento1 = classDiagram.getElementByPoint(x1,y1);
     		var elemento2= classDiagram.getElementByPoint(x2,y2);
     		classDiagram.addElement(new UMLPackagePublicImport({a:elemento1, b:elemento2}));
     	 }
     	interactionDoubleClick( f );
      }
     
     function crearImpPriv(){
      	function f (classDiagram, x1, y1, x2, y2){
      		var elemento1 = classDiagram.getElementByPoint(x1,y1);
      		var elemento2= classDiagram.getElementByPoint(x2,y2);
      		classDiagram.addElement(new UMLPackagePrivateImport({a:elemento1, b:elemento2}));
      	 }
      	interactionDoubleClick( f );
       }
     
     function crearNota(){
    	 function f(classDiagram, a, b){
        	 var note = new UMLNote({x:a, y:b});
        	 classDiagram.addElement(note);
             note.setName('Nota');
    	 }
    	 interaccionUnClick( f );
     }
     
     function borrar(){
    	 function f(classDiagram, x, y){
	    	 var elem = classDiagram.getElementByPoint( x, y );
	
	    	 if(elem && elem instanceof Element){
	    	    var text= '¿Estás seguro que deseas eliminar ' + elem.getType() + '?';
	    	    var dialog = new Dialog({text: text, cancelable: true});
	
	    	    var fn = function(){
	    	    	classDiagram.delElement( elem );
	    	    	classDiagram.draw();
	    	    }
	    	    dialog.show( fn );
	    	}
    	 }
    	 interaccionUnClick( f );
     }
     
     var interaccionUnClick = function( funcion ) {
    	 classDiagram.interaction( false );
    	 var div = document.getElementsByClassName('ud_diagram_div')[0];
    	 
    	 var funcionCaptura = function( event ) {
        	 var mousex = event.pageX - div.offsetLeft;
        	 var mousey = event.pageY - div.offsetTop;
        	 funcion( classDiagram, mousex, mousey );
        	 div.onclick = false;
        	 classDiagram.draw();
        	 classDiagram.interaction( true );
    	 }
    	 div.onclick = funcionCaptura;
    }

    var dragAndDrop = function(funcion) {
		classDiagram.interaction(false);
		var div = document.getElementsByClassName('ud_diagram_div')[0];

        var ele = document.getElementById("botonClase");
        ele.onmousedown = function(event){
            var mousex = event.pageX - div.offsetLeft;
            var mousey = event.pageY - div.offsetTop;

            ele.style.position = 'absolute';
            //element.style.zIndex = 1000;
            document.body.append(ele);

            moveAt(event.pageX, event.pageY);
            
            //centra componente en las coordenadas
            function moveAt(pageX, pageY){
                ele.style.left = pageX - mousex + 'px';
                ele.style.top = pageY - mousey + 'px';
            }

            function onMouseMove(event){
                moveAt(event.pageX, event.pageY);
            }

            //mueve de acuerdo al mouse
            document.addEventListener('mousemove', onMouseMove);
            
            //drop
            ele.onmouseup = function(){
                document.removeEventListener('mousemove', onMouseMove);
                ele.onmouseup = null;
                div.onclick = funcionCaptura;
            };
        };

        ele.ondragstart = function(){
            return false;
        };
        
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
		//div.onclick = funcionCaptura;
	}
     
     var interactionDoubleClick = function( g ){
    	 classDiagram.interaction(false);
    	 var div = document.getElementsByClassName('ud_diagram_div')[0]; 	 
    	 var x = 0;
    	 var y = 0;
    	 var f = true;
    	    
    	 var a = function( event ) {
    	    var mousex = event.pageX - div.offsetLeft;
    	    var mousey = event.pageY - div.offsetTop;
    	      if (f) {
    	          f = false;
    	          x = mousex;
    	          y = mousey
    	      } else {
    	          console.log('x1: ' + x + '\ny1: ' + y + '\nx2: ' + mousex + '\ny2: ' + mousey);
    	          g(classDiagram, x, y, mousex, mousey);
    	          div.onclick = false;
    	          classDiagram.draw();
    	          classDiagram.interaction(true)
    	      }
    	    };
    	  div.onclick = a
     }
     
     document.getElementById('botonPaq').onclick = crearPaquete;
     document.getElementById('botonContPaq').onclick = crearContPaq;
     document.getElementById('botonClase').onclick = crearClase;
     document.getElementById('botonComp').onclick = crearComponente;
     document.getElementById('botonInt').onclick = crearInterfaz;
     document.getElementById('botonAsMul').onclick = crearAsMul;
     document.getElementById('botonGen').onclick = crearGeneralizacion;
     document.getElementById('botonAs').onclick = crearAsociacion;
     document.getElementById('botonAg').onclick = crearAgregacion;
     document.getElementById('botonComposicion').onclick = crearComposicion;
     document.getElementById('botonDep').onclick = crearDependencia;
     document.getElementById('botonReal').onclick = crearRealizacion;
     document.getElementById('botonUso').onclick = crearUso;
     document.getElementById('botonComb').onclick = crearCombinacion;
     document.getElementById('botonImpPub').onclick = crearImpPub;
     document.getElementById('botonImpPriv').onclick = crearImpPriv;
     document.getElementById('botonNota').onclick = crearNota;
     document.getElementById('botonBorrar').onclick = borrar;
}