var bgColors = {"Black": "#000000",
                "White": "#FFFFFF",
};


const buttonStyle = {
    backgroundColor: bgColors.White
};

const textStyle = {
    color: bgColors.Black
};

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


ReactDOM.render(<Paquete />, document.getElementById('paqueteComponent'));