class Paquete extends React.Component {
    constructor() {
        super();
    }

    render() {
        return (
            
                <div id="inputPaqueteInside" class="form-group outter-section">
                    <label class="control-label label-obligatorio">Paquete</label>
                    <input id="npaq" class="form-control campo" /> 
                    <br />
					<input id="botonPaq" type="image" src="${pageContext.request.contextPath}/pages/diagrama/clases/img/paquete.png" width="90" height="80" />
                </div>
            
        );
    }
}


ReactDOM.render(<Paquete />, document.getElementById('paqueteComponent'));