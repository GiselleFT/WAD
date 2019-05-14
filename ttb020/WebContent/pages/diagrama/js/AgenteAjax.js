function descubreActor() {
	document.getElementById("inputActor").classList.remove('hidden');
	document.getElementById("inputCaso").classList.add('hidden');
	document.getElementById("inputSistema").classList.add('hidden');
	document.getElementById("inputSubsistema").classList.add('hidden');
	document.getElementById("inputComen").classList.add('hidden');
}

function descubreUseCase() {
	document.getElementById("inputCaso").classList.remove('hidden');
	document.getElementById("inputActor").classList.add('hidden');
	document.getElementById("inputSistema").classList.add('hidden');
	document.getElementById("inputSubsistema").classList.add('hidden');
	document.getElementById("inputComen").classList.add('hidden');
}

function descubreSistema() {
	document.getElementById("inputSistema").classList.remove('hidden');
	document.getElementById("inputCaso").classList.add('hidden');
	document.getElementById("inputActor").classList.add('hidden');
	document.getElementById("inputSubsistema").classList.add('hidden');
	document.getElementById("inputComen").classList.add('hidden');
}

function descubreSubsistema() {
	document.getElementById("inputSubsistema").classList.remove('hidden');
	document.getElementById("inputCaso").classList.add('hidden');
	document.getElementById("inputActor").classList.add('hidden');
	document.getElementById("inputSistema").classList.add('hidden');
	document.getElementById("inputComen").classList.add('hidden');
}

function descubreComentario() {
	document.getElementById("inputComen").classList.remove('hidden');
	document.getElementById("inputSubsistema").classList.add('hidden');
	document.getElementById("inputCaso").classList.add('hidden');
	document.getElementById("inputActor").classList.add('hidden');
	document.getElementById("inputSistema").classList.add('hidden');
}

function descubreClase() {
	document.getElementById("inputClase").classList.remove('hidden');
	document.getElementById("inputAtributo").classList.add('hidden');
	document.getElementById("inputMetodo").classList.add('hidden');
	document.getElementById("inputPaquete").classList.add('hidden');
	document.getElementById("inputComponente").classList.add('hidden');
}

function descubreAtributo() {
	document.getElementById("inputAtributo").classList.remove('hidden');
	document.getElementById("inputClase").classList.add('hidden');
	document.getElementById("inputMetodo").classList.add('hidden');
	document.getElementById("inputPaquete").classList.add('hidden');
	document.getElementById("inputComponente").classList.add('hidden');
}

function descubreMetodo(){
	document.getElementById("inputMetodo").classList.remove('hidden');
	document.getElementById("inputClase").classList.add('hidden');
	document.getElementById("inputAtributo").classList.add('hidden');
	document.getElementById("inputPaquete").classList.add('hidden');
	document.getElementById("inputComponente").classList.add('hidden');
}

function descubrePaquete(){
	document.getElementById("inputPaquete").classList.remove('hidden');
	document.getElementById("inputMetodo").classList.add('hidden');
	document.getElementById("inputClase").classList.add('hidden');
	document.getElementById("inputAtributo").classList.add('hidden');
	document.getElementById("inputComponente").classList.add('hidden');
}

function descubreComponente(){
	document.getElementById("inputComponente").classList.remove('hidden');
	document.getElementById("inputPaquete").classList.add('hidden');
	document.getElementById("inputMetodo").classList.add('hidden');
	document.getElementById("inputClase").classList.add('hidden');
	document.getElementById("inputAtributo").classList.add('hidden');
}