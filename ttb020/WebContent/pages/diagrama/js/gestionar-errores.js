function gestionarErrores(error, paramName, formId) {
	var valido;
	limpiarErrores(formId);
	if (error.keys.length == 0) {
		valido = true;
	} else {
		valido = false;
		var keys = error.keys;
		for (var i = 0; i < keys.length; i++) {
			var name = paramName + keys[i];
			var input = $("input[name='" + name + "']");
			if (input.length > 0) {
				input.addClass("field-error");
				mostrarErrores(error.listErrores, input, keys[i]);
			} else {
				var select = $("select[name='" + name + "']");
				if (select.length > 0) {
					select.addClass("field-error");
					mostrarErrores(error.listErrores, select, keys[i]);

				}
			}
		}
	}
	return valido;
}

/**
 * Recibe el JSON de un objeto de la clase AjaxResult.java. De el obtiene campos
 * a los que se le asignara un error y llama a la funcion
 * mostrarFieldErrorsAjaxResult para concatenar la lista de errores. Cada
 * mensaje es un objeto que tiene los siguientes atributos: <br>
 * <ul>
 * <li>enumTipoMensaje: Determina si es un fielError, actionError o
 * actionMessage</li>
 * <li>nombre: es el atributo name que tiene un input en el formulario</li>
 * <li>mensajes: son todos los mensajes asociados a un campo</li>
 * </ul>
 * 
 * @param ajaxResult
 * @param formId
 * @returns
 */
function gestionarErroresAjaxResult(ajaxResult, formId) {
	var isValido = true;
	limpiarErrores(formId);
	var listMensajes = ajaxResult.listMessages;
	listMensajes.forEach(function(mensaje) {
		if (mensaje.enumTipoMensaje === "FIELD_ERROR") {
			var input = $("#" + formId + " input[name='" + mensaje.nombre + "']");
			if (input.length > 0) {
				input.addClass("field-error");
				mostrarFieldErrorsAjaxResult(mensaje, input);
			} else {
				var select = $("select[name='" + mensaje.nombre + "']");
				if (select.length > 0) {
					select.addClass("field-error");
				}
				mostrarFieldErrorsAjaxResult(mensaje, select);
			}
			isValido = false;			
		} else if (mensaje.enumTipoMensaje === "ACTION_ERROR") {
			mostrarActionErrorsAjaxResult(mensaje);
			isValido = false;
		} else if (mensaje.enumTipoMensaje === "ACTION_MESSAGE") {
			mostrarActionMessagesAjaxResult(mensaje);
		}
	});	
	return isValido;
}

/**
 * Obtiene la lista de mensajes FIELD ERROR y se los asigna al campo
 * correspondiente.
 * 
 * @param ajaxResult
 * @param formId
 * @returns
 */
function mostrarFieldErrorsAjaxResult(mensaje, input) {
	var divErrorMessageContainer = $("<div></div>");
	var errores = mensaje.mensajes;
	errores.forEach(function(fieldError) {
		var message = $("<p></p>");
		message.text(fieldError);
		divErrorMessageContainer.append(message);
	});
	divErrorMessageContainer.addClass("alert alert-danger error");
	input.after(divErrorMessageContainer);
}

/**
 * Obtiene la lista de mensajes ACTION ERRORS y los muestra en su correspondiente div
 * 
 * @param ajaxResult
 * @param formId
 * @returns
 */
function mostrarActionErrorsAjaxResult(mensaje) {
	var divErrorMessageContainer = $("#divActionErrors");
	var errores = mensaje.mensajes;
	errores.forEach(function(actionError) {
		var message = $("<p></p>");
		message.text(actionError);
		divErrorMessageContainer.append(message);
	});
	divErrorMessageContainer.removeClass("hide");
}

/**
 * Obtiene la lista de mensajes ACTION MESSAGES y los muestra en su correspondiente div
 * 
 * @param ajaxResult
 * @param formId
 * @returns
 */
function mostrarActionMessagesAjaxResult(mensaje) {
	var divActionMessageContainer = $("#divActionMessages");
	var actionMessages = mensaje.mensajes;
	actionMessages.forEach(function(actionMessage) {
		var message = $("<p></p>");
		message.text(actionMessage);
		divActionMessageContainer.append(message);
	});
	divActionMessageContainer.removeClass("hide");
}

function mostrarErrores(listErrores, element, name) {
	var divErrorMessageContainer = $("<div></div>");
	var errores = listErrores[name];
	for (var i = 0; i < errores.length; i++) {
		var message = $("<p></p>");
		message.text(errores[i]);
		divErrorMessageContainer.append(message);
	}
	divErrorMessageContainer.addClass("alert alert-danger error");
	element.after(divErrorMessageContainer);
}

function limpiarErrores(formId) {
	$("#divActionMessages").addClass("hide").empty();
	$("#divActionErrors").addClass("hide").empty();
	
	var frm = $("#" + formId);
	if (frm.length > 0) {
		frm.find(".alert.alert-danger.error").remove();
		frm.find(".field-error").removeClass("field-error");
	}
	var globalErrors = $("#divGlobalErrors");
	if (globalErrors.length > 0) {
		globalErrors.find(".alert.alert-danger.error").remove();
		globalErrors.find(".field-error").removeClass("field-error");
	}
	var categoryErrors = $("#divCategoryErrors");
	if (categoryErrors.length > 0) {
		categoryErrors.find(".alert.alert-danger.error").remove();
		categoryErrors.find(".field-error").removeClass("field-error");
	}
}