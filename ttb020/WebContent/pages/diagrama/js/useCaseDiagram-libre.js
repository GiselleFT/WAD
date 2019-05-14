/**
 * Script para utilizar todos los componentes de un diagrama de casos de uso
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
	
//console.log("Canvas: El tamaño de la ventana actual: " + ancho + " de ancho "+alto+" de alto");
ancho = ancho*0.70;
alto = alto*0.75;

console.log("Tamaño del canvas: " + ancho + " de ancho "+alto+" de alto");
	
window.onload = function(){
   
	 var usecaseDiagram = new UMLUseCaseDiagram({id: 'useCaseDiagram', width: ancho, height: alto });
	 //usecaseDiagram.setName('ewe');
     // Drawing the diagram 
     usecaseDiagram.draw();
     // This diagram is editable
     usecaseDiagram.interaction(true);  
      
     function crearActor(){
    	 function f(usecaseDiagram, a, b){
    	 	var nactor = document.getElementById('nactor').value;	            	 
            		customerActor = new UMLActor({ x:a, y:b });
            		usecaseDiagram.addElement(customerActor);
   	             	customerActor.setName(nactor);
        	 document.getElementById('nactor').value = "";
        }
    	 interaccionUnClick( f );
	 }
      
     function crearSubSis(){
    	 function f(usecaseDiagram, a, b){
        	 var nsubsis = document.getElementById('nsubsis').value;
            	var subsystem = new UMLSubSystem({ x:a, y:b });
                subsystem.setHeight( 250 );
                subsystem.setName(nsubsis);
                usecaseDiagram.addElement(subsystem);
        	 document.getElementById('nsubsis').value = "";
    	 }
    	 interaccionUnClick( f );
     }
     
     function crearSis(){
    	 function f(usecaseDiagram, a, b){
        	 var nsis = document.getElementById('nsis').value;
            	 var system = new UMLSystem({ x:a, y:b });
                 system.setHeight( 250 );
                 system.setName(nsis);
                 usecaseDiagram.addElement(system);
        	 document.getElementById('nsis').value = "";
    	 }
    	 interaccionUnClick( f );
     }
     
     function crearCu(){
    	 function f(usecaseDiagram, a, b){
        	 var ncu = document.getElementById('ncu').value;
            	 var useCase = new UMLUseCase({ x:a, y:b });
                 useCase.setName(ncu);
                 usecaseDiagram.addElement(useCase);
        	 document.getElementById('ncu').value = "";
    	 }
    	 interaccionUnClick( f );
     }
     
     function crearRel(){
     	function f (usecaseDiagram, x1, y1, x2, y2){
     		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
     		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
     		usecaseDiagram.addElement(new UMLCommunication({a:elemento1, b:elemento2}));
     	 }
     	interactionDoubleClick( f );
      }
     
     function crearExt(){
    	 function f (usecaseDiagram, x1, y1, x2, y2){
    		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
      		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
      		usecaseDiagram.addElement(new UMLExtend({a:elemento1, b:elemento2}));
    	 }
    	 interactionDoubleClick( f );
     }
     
     function crearIncl(){
    	 function f (usecaseDiagram, x1, y1, x2, y2){
    		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
      		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
      		usecaseDiagram.addElement(new UMLInclude({a:elemento1, b:elemento2}));
    	 }
    	 interactionDoubleClick( f );
     }
     
     function crearGen(){
    	 function f (usecaseDiagram, x1, y1, x2, y2){
    		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
      		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
      		usecaseDiagram.addElement(new UMLGeneralization({a:elemento1, b:elemento2}));
    	 }
    	 interactionDoubleClick( f );
     }
     
     function crearNota(){
    	 function f(usecaseDiagram, a, b){
        	 var note = new UMLNote({x:a, y:b});
        	 usecaseDiagram.addElement(note);
             note.setName('Nota');
    	 }
    	 interaccionUnClick( f );
     }
     
     function borrar(){
    	 function f(classDiagram, x, y){
	    	 var elem = classDiagram.getElementByPoint( x, y );
	
	    	 if(elem && elem instanceof Element){
	    	    var msj= '¿Estás seguro que deseas eliminar ' + elem.getType() + '?';
	    	    var dialog = new Dialog({text: msj, cancelable: true});
	
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
    	 usecaseDiagram.interaction( false );
    	 var div = document.getElementsByClassName('ud_diagram_div')[0];
    	 
    	 var funcionCaptura = function( event ) {
        	 var mousex = event.pageX - div.offsetLeft;
        	 var mousey = event.pageY - div.offsetTop;
        	 funcion( usecaseDiagram, mousex, mousey );
        	 div.onclick = false;
        	 usecaseDiagram.draw();
        	 usecaseDiagram.interaction( true );
    	 }
    	 div.onclick = funcionCaptura;
    }
     
     var interactionDoubleClick = function( g){
    	 usecaseDiagram.interaction(false);
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
    	          g(usecaseDiagram, x, y, mousex, mousey);
    	          div.onclick = false;
    	          usecaseDiagram.draw();
    	          usecaseDiagram.interaction(true)
    	      }
    	    };
    	  div.onclick = a
     }
     
     document.getElementById('botonActor').onclick = crearActor;
     document.getElementById('botonSubSis').onclick = crearSubSis;
     document.getElementById('botonSis').onclick = crearSis;
     document.getElementById('botonCu').onclick = crearCu;
     document.getElementById('botonRel').onclick = crearRel;
     document.getElementById('botonExt').onclick = crearExt;
     document.getElementById('botonInc').onclick = crearIncl;
     document.getElementById('botonGen').onclick = crearGen;
     document.getElementById('botonNota').onclick = crearNota;
     document.getElementById('botonBorrar').onclick = borrar;
 }