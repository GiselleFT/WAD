/*Creación de componentes en React:
    En este archivo se crea un componente para cada uno de los botones
    que se tienen para la creación de un diagrama de Clases UML,
    se obtiene un componente final que integra los creados individualmente,
    es decir el que tiene identificador diagramaClaseComponent es el que será colocado
    en el jsp
*/

//---Para dar estilos en los botones
var bgColors = {"Black": "#000000",
                "White": "#FFFFFF",
};
const buttonStyle = {
    backgroundColor: bgColors.White
};
const textStyle = {
    color: bgColors.Black
};

//---Creación de componente Clase
class Clase extends React.Component {
    constructor(props) {
        super(props);
        this.descubreClase = this.descubreClase.bind(this);
    }
    descubreClase(){
        document.getElementById("inputClase").classList.remove('hidden');
	    document.getElementById("inputAtributo").classList.add('hidden');
	    document.getElementById("inputMetodo").classList.add('hidden');
	    document.getElementById("inputPaquete").classList.add('hidden');
	    document.getElementById("inputComponente").classList.add('hidden');
    }
    render() {
        return (
			<button type="button" class="btn btn-secondary"
					onClick={this.descubreClase} style={buttonStyle}>
					<label style={textStyle}>Clase</label>
		    </button>
        );
    }
}

//---Creación de componente Atributo
class Atributo extends React.Component {
    constructor(props) {
        super(props);
        this.descubreAtributo = this.descubreAtributo.bind(this);
    }
    descubreAtributo(){
	    document.getElementById("inputAtributo").classList.remove('hidden');
	    document.getElementById("inputClase").classList.add('hidden');
	    document.getElementById("inputMetodo").classList.add('hidden');
	    document.getElementById("inputPaquete").classList.add('hidden');
	    document.getElementById("inputComponente").classList.add('hidden');
    }
    render() {
        return (
			<button type="button" class="btn btn-secondary"
					onClick={this.descubreAtributo} style={buttonStyle}>
					<label style={textStyle}>Atributo</label>
		    </button>
        );
    }
}

//---Creación de componente Metodo
class Metodo extends React.Component {
    constructor(props) {
        super(props);
        this.descubreMetodo = this.descubreMetodo.bind(this);
    }
    descubreMetodo(){
	    document.getElementById("inputMetodo").classList.remove('hidden');
	    document.getElementById("inputClase").classList.add('hidden');
	    document.getElementById("inputAtributo").classList.add('hidden');
	    document.getElementById("inputPaquete").classList.add('hidden');
	    document.getElementById("inputComponente").classList.add('hidden');
    }
    render() {
        return (
			<button type="button" class="btn btn-secondary"
					onClick={this.descubreMetodo} style={buttonStyle}>
					<label style={textStyle}>Metodo</label>
		    </button>
        );
    }
}


//---Creación de componente Componente
class Componente extends React.Component {
    constructor(props) {
        super(props);
        this.descubreComponente = this.descubreComponente.bind(this);
    }
    descubreComponente(){
	    document.getElementById("inputComponente").classList.remove('hidden');
	    document.getElementById("inputPaquete").classList.add('hidden');
	    document.getElementById("inputMetodo").classList.add('hidden');
	    document.getElementById("inputClase").classList.add('hidden');
	    document.getElementById("inputAtributo").classList.add('hidden');
    }
    render() {
        return (
			<button type="button" class="btn btn-secondary"
					onClick={this.descubreComponente} style={buttonStyle}>
					<label style={textStyle}>Componente</label>
		    </button>
        );
    }
}


//---Creación de componente Paquete
class Paquete extends React.Component {
    constructor(props) {
        super(props);
        this.descubrePaquete = this.descubrePaquete.bind(this);
    }
    descubrePaquete(){
	    document.getElementById("inputPaquete").classList.remove('hidden');
	    document.getElementById("inputMetodo").classList.add('hidden');
	    document.getElementById("inputClase").classList.add('hidden');
	    document.getElementById("inputAtributo").classList.add('hidden');
	    document.getElementById("inputComponente").classList.add('hidden');
    }
    render() {
        return (
			<button type="button" class="btn btn-secondary"
					onClick={this.descubrePaquete} style={buttonStyle}>
					<label style={textStyle}>Paquete</label>
		    </button>
        );
    }
}



//---Creación de componente final DiagramaClase
class DiagramaClase extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Clase/>
                <Atributo/>
                <Metodo/>
                <Componente/>
                <Paquete/>
            </div>
        );
    }
}


ReactDOM.render(<DiagramaClase />, document.getElementById('diagramaClaseComponent'));