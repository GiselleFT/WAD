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


//---Creación de componente Comentario
class Comentario extends React.Component {
    constructor(props) {
        super(props);
        this.descubreComentario = this.descubreComentario.bind(this);
    }
    descubreComentario(){
	    document.getElementById("inputComen").classList.remove('hidden');
	    document.getElementById("inputSubsistema").classList.add('hidden');
	    document.getElementById("inputCaso").classList.add('hidden');
	    document.getElementById("inputActor").classList.add('hidden');
	    document.getElementById("inputSistema").classList.add('hidden');
    }
    render() {
        return (
			<button type="button" class="btn btn-secondary"
					onClick={this.descubreComentario} style={buttonStyle}>
					<label style={textStyle}>Comentario</label>
		    </button>
        );
    }
}


ReactDOM.render(<Comentario />, document.getElementById('comentarioComponent'));