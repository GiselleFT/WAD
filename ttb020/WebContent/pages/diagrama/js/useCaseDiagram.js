/**
 * Script para utilizar todos los componentes de un diagrama de casos de uso
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

// console.log("Canvas: El tamaño de la ventana actual: " + ancho + " de ancho
// "+alto+" de alto");
ancho = ancho * 0.70;
alto = alto * 0.75;

var text = "";

var limx = ancho * 0.5;
var limy = alto * 0.5;
var tip = 0;

console.log("Tamaño del canvas: " + ancho + " de ancho " + alto + " de alto");

function consoleWrite(texto) {
	text = text + texto;
	document.getElementById('console').innerHTML = text;
}
	
window.onload = function(){
   
	 var usecaseDiagram = new UMLUseCaseDiagram({id: 'useCaseDiagram', width: ancho, height: alto });
	 //usecaseDiagram.setName('ewe');
     // Drawing the diagram 
     usecaseDiagram.draw();
     // This diagram is editable
     usecaseDiagram.interaction(true);  
     
    
     var actorStack =[];
     var useCaseStack = [];
     var relationStack = [];
     
  //   Funcion primitiva para crear actor
     function crearActor(){
    	 function f(usecaseDiagram, a, b){
    	 	var nactor = document.getElementById('nactor').value;	            	 
        	 if (nactor == "") {
           	   alert("Debes insertar un nombre para el actor");
           	   return false;
             }else {            	
 	    		console.log("limite x: " + limx + "\limite y: " + limy);
 	    		console.log("x: " + a + "\ty: " + b);
 	    		
 	    		validaPosActor( a, b, nactor );    
        	    var customerActor = new UMLActor({ x:a, y:b });
        		usecaseDiagram.addElement(customerActor);
                customerActor.setName(nactor);
                actorStack.push(nactor);
               // consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Actor <b>" + nactor + "</b> creado correctamente.</p>");
        	 }
        	 cleanForm( 'nactor' );
        }
    	 consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Un <b>actor </b> es quien interactua con el sistema a traves de los casos de uso, se recomienda colocarle un nombre singular relevante para el dominio.</p>");
    	 interaccionUnClick( f );
	 }
     
     function validaPosActor( a, b, nactor ){	 
    	 if(actorStack.length == 0){
		    if((a >= limx && b <= limy) || ( a >= limx && b >= limy ) || ( a <= limx && b >= limy ))
		  		consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> Si <b>" + nactor + "</b> es el primer  <u>actor primario</u>, se recomienda colocarlo en la esquina superior izquierda.</p>");	
    	 }
    	 else if((actorStack.length == 1) || (actorStack.length == 2)){
	    	if((a >= limx))
			  	consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> Si <b>" + nactor + "</b> es un <u>actor primario</u>, se recomienda colocarlo del lado izquierdo.</p>");	
    	 }
    	 else{
	    	consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> Si <b>" + nactor + "</b> es un  <u>actor secundario</u>, se recomienda colocarlo del lado derecho.</p>");	  			 
    	 }   	 
     }
     
     
     function cleanForm( id ){
    	 document.getElementById( id ).value = "";
     }
     
     /* Funcion para monitorear que por lo menos exista una relacion entre los elementos del diagrama 
     var timerRel = setInterval(emptyRelationStack, 5000);
     
     function emptyRelationStack(){
    	 if((relationStack.length < 1) && (useCaseStack.length > 0) && (actorStack.length > 0))
    		 consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='red'>Warn:</font> Debe de existir al menos una relacion entre los elementos existentes</p>");	
     }
     */

     function crearSubSis(){
    	 function f(usecaseDiagram, a, b){
        	 var nsubsis = document.getElementById('nsubsis').value;
        	 if (nsubsis == "") {
             	alert("Debes insertar un nombre para el subsistema");
             	return false;
             }else {
            	//consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Subsistema <b>" + nsubsis + "</b> creado correctamente.</p>" ); 
            	var subsystem = new UMLSubSystem({ x:a, y:b });
                subsystem.setHeight( 250 );
                subsystem.setName(nsubsis);
                usecaseDiagram.addElement(subsystem);
             }
        	 cleanForm( 'nsubsis' );
    	 }
    	 interaccionUnClick( f );
     }
     
     function crearSis(){
    	 function f(usecaseDiagram, a, b){
        	 var nsis = document.getElementById('nsis').value;
        	 if (nsis == "") {
             	   alert("Debes insertar un nombre para el sistema");
             	   return false;
             }else {
            	// consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Sistema <b>" + nsis + "</b> creado correctamente.</p>" ); 
            	 var system = new UMLSystem({ x:a, y:b });
                 system.setHeight( 250 );
                 system.setName(nsis);
                 usecaseDiagram.addElement(system);
             }
        	 cleanForm( 'nsis' );
    	 }
    	 interaccionUnClick( f );
     }
     
     function crearCu(){
    	 var nera = $("#nombrecaso");
    	 function f(usecaseDiagram, a, b){
        	 var ncu = document.getElementById('nombrecaso').value;
    		 //var ncu = nera.value;
    		 console.log(ncu);
        	 if (ncu == "") {
             	   alert("Debes insertar un texto al caso de uso");
             	   return false;
             }else {
            	 var useCase = new UMLUseCase({ x:a, y:b });
                 useCase.setName(ncu);
                 usecaseDiagram.addElement(useCase);
                 useCaseStack.push(ncu);
                // consoleWrite( "<p align='left'>"+ new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Caso de uso <b>" + ncu + "</b> creado correctamente.</p>" );
             }
        	 cleanForm( 'nombrecaso' );
    	 }
    	 consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Un <b>caso de uso </b> describe la funcionalidad que se espera del sistema a desarrollar, se recomienda nombrarlo con un verbo fuerte y empleando la terminologia del dominio.</p>");
    	 interaccionUnClick( f );
     }
     
     function crearRel(){
     	function f(usecaseDiagram, x1, y1, x2, y2){
     		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
     		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
     		
     		if(((elemento1.getType() == "UMLActor") && (elemento2.getType() == "UMLUseCase")) || ((elemento1.getType() == "UMLUseCase") && (elemento2.getType() == "UMLActor"))){
     			usecaseDiagram.addElement(new UMLCommunication({a:elemento1, b:elemento2}));
         		relationStack.push( x1.toString() + y1.toString() + x2.toString() + y2.toString());
         		//consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Asociacion <b>" + elemento1.getName() + "-" + elemento2.getName() + "</b> creada correctamente</p>" );

     		}else{
     			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='red'>Warn:</font> Una <b>asociacion</b> debe ser exclusivamente entre un actor y un caso de uso.</p>");
       		}	
     	 }
     	$("#tipoRel").attr("value", "relacion");
     	$("#Rel").attr("value", "relacion");
     	consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Una <b>asociacion </b> expresa la conexion entre un actor y un caso de uso.</p>");
     	interactionDoubleClick( f );
      }
     
     function crearExt(){
    	 function f(usecaseDiagram, x1, y1, x2, y2){
    		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
      		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
      		
      		if((elemento1.getType() == "UMLUseCase") && (elemento2.getType() == "UMLUseCase")){
      			usecaseDiagram.addElement(new UMLExtend({a:elemento1, b:elemento2}));
	      		relationStack.push( x1.toString() + y1.toString() + x2.toString() + y2.toString());
	      	//	consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Extension <b>" + elemento1.getName() + "-" + elemento2.getName() + "</b> creada correctamente</p>" );
	      		
	      		if( y2>y1 )
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font>Se recomienda colocar la extension <b>" + elemento1.getName() + "</b> debajo del caso de uso base (<b>" + elemento2.getName() + "</b>)</p>");
	      		
      		}else{
      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='red'>Warn:</font> Una <b>extension</b> debe ser exclusivamente entre dos casos de uso.</p>");	
      		}
    	 }
    	 $("#tipoRel").attr("value", "extends");
    	 $("#Rel").attr("value", "extends");
    	 consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Una <b>extension </b> se utiliza cuando es posible que un nuevo caso de uso sea invocado (o no) anadiendo informacion extra al caso de uso base.</p>");
    	 interactionDoubleClick( f );
     }
     
     function crearIncl(){
    	 function f(usecaseDiagram, x1, y1, x2, y2){
    		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
      		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);    		

      		if((elemento1.getType() == "UMLUseCase") && (elemento2.getType() == "UMLUseCase")){
      			var inclusion = new UMLInclude({a:elemento1, b:elemento2});
	      		usecaseDiagram.addElement(inclusion);
	      		relationStack.push( x1.toString() + y1.toString() + x2.toString() + y2.toString());

	      		if( ( (x1+50) > x2 ) && ( y2 < (y1-50) || y2 > (y1+50) ) )
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font>Se recomienda colocar la inclusion <b>" + elemento2.getName() + "</b> a la derecha y de forma horizontal al caso de uso que lo invoca (<b>" + elemento1.getName() + "</b>)</p>");
	      		else if ( ( (x1+50) < x2 ) && ( y2 < (y1-50) || y2 > (y1+50) ) )
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font>Se recomienda colocar la inclusion <b>" + elemento2.getName() + "</b> de forma horizontal al caso de uso que lo invoca (<b>" + elemento1.getName() + "</b>)</p>");
	      		
      		}else{
      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='red'>Warn:</font> Una <b>inclusion</b> debe ser exclusivamente entre dos casos de uso.</p>");	
      		}
    	 }
    	 $("#tipoRel").attr("value", "include");
    	 $("#Rel").attr("value", "include");
    	 consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> Una <b>inclusion </b> se utiliza cuando un caso de uso es invocado obligatoriamente a partir de otro caso de uso.</p>");
    	 interactionDoubleClick( f );
     }
     
     function crearGen(){
    	 function f(usecaseDiagram, x1, y1, x2, y2){
    		var elemento1 = usecaseDiagram.getElementByPoint(x1,y1);
      		var elemento2= usecaseDiagram.getElementByPoint(x2,y2);
      		
      		if((elemento1.getType() == "UMLActor") && (elemento2.getType() == "UMLActor")){
	      		usecaseDiagram.addElement(new UMLGeneralization({a:elemento1, b:elemento2}));

	      		if( y2>y1 ){
	      			//consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191El actor <b>" + elemento1.getName() + " </b>hereda del actor <b>" + elemento2.getName() + "</b>? <a onclick='cambiaPos()'>Si es asi, "
	      			//	 + "se recomienda colocar <b>" + elemento1.getName() + "</b> debajo del actor que se hereda (<b>" + elemento2.getName() + "</b>) </a></p>");
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191Un(a) <b>" + elemento1.getName() + " </b>es como un(a) <b>" + elemento2.getName() + "</b>? Si es asi, "
		      				 + "se recomienda colocar <b>" + elemento1.getName() + "</b> debajo del actor que se hereda (<b>" + elemento2.getName() + "</b>) </p>");
	      		   			
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> O quiza &#191Un(a) <b>" + elemento2.getName() + " </b>es como un(a) <b>" + elemento1.getName() + "</b>? Si es asi, se recomienda invertir a los actores y colocar la direccion " +
	    	      			"de la herencia del actor <b>" + elemento2.getName() + "</b> hacia el actor <b>" + elemento1.getName() + "</b></p>");
	      		}
	      		else{
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191Un(a) <b>" + elemento1.getName() + " </b>es como un(a) <b>" + elemento2.getName() + "</b>? Si es asi, es correcta la direccion de la herencia.</p>");
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> O quiza &#191Un(a) <b>" + elemento2.getName() + " </b>es como un(a) <b>" + elemento1.getName() + "</b>? Se recomienda invertir a los actores y colocar la direccion " +
	    	      			"de la herencia del actor <b>" + elemento2.getName() + "</b> hacia el actor <b>" + elemento1.getName() + "</b></p>");
	      		}
	      		
      		}else if((elemento1.getType() == "UMLUseCase") && (elemento2.getType() == "UMLUseCase")){
      			usecaseDiagram.addElement(new UMLGeneralization({a:elemento1, b:elemento2}));
	      		
	      		if( y2>y1 ){
	     	      	consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191<b>" + elemento1.getName() + " </b>es como <b>" + elemento2.getName() + "</b>? Si es asi, "
		      				 + "se recomienda colocar <b>" + elemento1.getName() + "</b> debajo del caso de uso que se hereda (<b>" + elemento2.getName() + "</b>) </p>");
	      		   			
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> O quiza &#191<b>" + elemento2.getName() + " </b>es como <b>" + elemento1.getName() + "</b>? Si es asi, se recomienda invertir los caso de uso y colocar la direccion " +
	    	      			"de la herencia del caso de uso <b>" + elemento2.getName() + "</b> hacia el caso de uso <b>" + elemento1.getName() + "</b></p>");
	      		}
	      		else{
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> &#191<b>" + elemento1.getName() + " </b>es como <b>" + elemento2.getName() + "</b>? Si es asi, es correcta la direccion de la herencia.</p>");
	      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='green'>Tip:</font> O quiza &#191<b>" + elemento2.getName() + " </b>es como <b>" + elemento1.getName() + "</b>? Si es asi, se recomienda invertir los caso de uso y colocar la direccion " +
	    	      			"de la herencia del caso de uso <b>" + elemento2.getName() + "</b> hacia el caso de uso <b>" + elemento1.getName() + "</b></p>");
	      		}
      		}else{
      			consoleWrite("<p align='left'>" + new Date().toLocaleString() + " ==> <font color='red'>Warn:</font> Una <b>generalizacion</b> debe ser exclusivamente entre dos actores o entre dos casos de uso.</p>");	
      		}
    	 }
    	 $("#tipoRel").attr("value", "generalizacion");
    	 $("#Rel").attr("value", "generalizacion");
    	 consoleWrite( "<p align='left'>" + new Date().toLocaleString() + " ==> <font color='blue'>Info:</font> La <b>herencia</b> se utiliza cuando dos actores o dos caso de uso (o mas) comparten propiedades en comun. Esta debe ser entre elementos del mismo tipo: actor-actor o cu-cu.</p>");
    	 interactionDoubleClick( f );
     }
     
     function crearNota(){
    	 function f(usecaseDiagram, a, b){
        	 var note = new UMLNote({x:a, y:b});
        	 usecaseDiagram.addElement(note);
        	 var nota = document.getElementById('nota').value;
             note.setName(nota);
             cleanForm( 'nota' );
             $("#textoComentario").attr("value", nota);
             guardarComentario();
    	 }
    	 interaccionUnClick( f );
     }
     
     function borrar(){
    	 function f(classDiagram, x, y){
	    	 var elem = classDiagram.getElementByPoint( x, y );

	    	 if(elem && elem instanceof Element){
	    	    var msj= '&#191Estas seguro que deseas eliminar ' + elem.getType() + '?';
	    	    var dialog = new Dialog({text: msj, cancelable: true});

	    	    var fn = function(){ 	    	
	    	    	/* if para eliminar los elementos de las pilas */
	    	    	if( elem.getType() == "UMLActor"){
	    	    		actorStack.splice(actorStack.indexOf(elem.getName()),1);
	    	    		consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Actor <b>" + elem.getName() + "</b> eliminado exitosamente</p>" );
	    	    		console.log(actorStack.length);
	    	    	}
	    	    	else if( elem.getType() == "UMLUseCase"){
	    	    		useCaseStack.splice(useCaseStack.indexOf(elem.getName()),1);
	    	    		consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Caso de uso <b>" + elem.getName() + "</b> eliminado exitosamente</p>" );
	    	    		console.log(useCaseStack.length);
	    	    	}
	    	    	else if ((elem.getType() == "UMLCommunication") || (elem.getType() == "UMLExtend") || (elem.getType() == "UMLInclude")){
	    	    		relationStack.splice(relationStack.indexOf(elem.getElementA().getX().toString() + elem.getElementA().getY().toString() + elem.getElementB().getX().toString() + elem.getElementA().getY().toString()),1);
	    	    		consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='blue'>Info:</font> Elemento <b>" + elem.getType() + "</b> eliminado exitosamente</p>" );
	    	    		console.log(relationStack.length);
	    	    	}
	    	    	classDiagram.delElement( elem );
	    	    	classDiagram.draw();
	    	    }
	    	    dialog.show( fn );
	    	}
    	 }
    	 interaccionUnClick( f );
     }
     
     function guardar(){
    	 var save = usecaseDiagram.getXMLString();
    	 $("#idDiagrama").attr("value", save);
    	 guardarDiagrama();
    	 console.log(save);
     }
     
     
     var interaccionUnClick = function( funcion ) {
    	 usecaseDiagram.interaction( false );
    	 var div = document.getElementsByClassName('ud_diagram_div')[0];
    	 
    	 var funcionCaptura = function( event ) {
        	 var mousex = event.pageX - div.offsetLeft;
        	 var mousey = event.pageY - div.offsetTop;
        	 funcion( usecaseDiagram, mousex, mousey );
        	 console.log("x: " + mousex + "  y:" + mousey + "\n");
        	 div.onclick = false;
        	 usecaseDiagram.draw();
        	 usecaseDiagram.interaction( true );
    	 }
    	 div.onclick = funcionCaptura;
    }
     
     var interactionDoubleClick = function( g ){
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
    	          
    	          /* validacion para encontrar objetos con los que se puede relacionar el primer caso de uso*/ 
    	          var elemento1 = usecaseDiagram.getElementByPoint(x, y);
    	          if((elemento1.getType() == "UMLUseCase"))
    	        	  $("#idNcu").attr("value", elemento1.getName()); 	          
    	          obtenerDatos(elemento1.getName());
    	          
    	      } else {
    	          console.log('x1: ' + x + '\ny1: ' + y + '\nx2: ' + mousex + '\ny2: ' + mousey);    
    	          var elemento1 = usecaseDiagram.getElementByPoint(x, y);
    	          var elemento2 = usecaseDiagram.getElementByPoint(mousex, mousey);
    	          
    	          if((elemento1.getType() == "UMLUseCase") && (elemento2.getType() == "UMLUseCase")){
    	        	  $("#Nomcu").attr("value", elemento1.getName());
    	        	  $("#Nomcu2").attr("value", elemento2.getName());
    	        	  registrarDatos();
    	          }
    	          
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
     document.getElementById('botonGuardar').onclick = guardar;
 }

function setOpcion( a ){
	tip = a;
}

/**
 * Implementación de llamada a AJAX para obtener información de la base de
 * conocimiento de IA
 * 
 * @param
 * @returns
 */
function obtenerDatos() {
	var form = $("#hdnPruebaAjax");
	var cu = $("#idNcu").val();
	var rel = $("#tipoRel").val();
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
				
				if(rel == "extends"){ 
						consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='green'>Tip: </font>" + "El caso de uso <b>" +  cu + "</b> puede <u>extender</u> de: <b>" + cad + "</b></p>" );
				}
				else if(rel == "include"){
						consoleWrite( "<p align='left'>" + new Date().toLocaleString() + "==> <font color='green'>Tip: </font>" + "El caso de uso <b>" +  cu + "</b> puede <u>incluir</u>: <b>" + cad + "</b></p>" );
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
 * Implementación de llamada a AJAX para guardar el diagrama en BD.
 * 
 * @param
 * @returns
 */
function guardarDiagrama() {
	var form = $("#hdnSave");

	$
			.ajax({
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
//				consoleWrite("<p align='left'>" + new Date().toLocaleString()
//						+ "==> <font color='blue'>Info:</font> "
//						+ respuesta.response.string + "</p>");
			} else {
				console.log("No se encontro información correspondiente");
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
