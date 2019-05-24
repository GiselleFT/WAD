class NameForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = { username: '', password:'' };
    //this.handleChange = this.handleChange.bind(this)
    //this.handleSubmit = this.handleSubmit.bind(this)
    this.handleChange1 = this.handleChange1.bind(this);
    this.handleChange2 = this.handleChange2.bind(this);   
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange1(event) {
    this.setState({ username:event.target.value });
  }

  handleChange2(event) {
    this.setState({ password:event.target.value });
  }  

  handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);   
    //http://localhost/struts2react/input1.jsp
    //let url = 'http://localhost/struts2react/Login';
    //ESTE ES EL CASO DEL LOGIN EXITOSO let url = 'http://localhost:8089/struts2react/exitoso.jsp';
    let url = 'http://localhost:8089/struts2react/Login?username='+this.state.username+'&password='+this.state.password;
    //ESTE ES EL BUENO (sin /login, solo Login)*let url = 'http://localhost:8089/struts2react/login/Login.action?username='+this.state.username+'&password='+this.state.password;
    //var dataForm = {username: this.state.username, password: this.state.password};
    //let url = 'http://localhost:8083/struts2react/input1.jsp?username='+this.state.username+'&password='+this.state.password;
    //let url = 'http://localhost:8083/struts2react/input1.jsp';
    alert('URL:'+url);
//    fetch(url,{method: 'post', body: dataForm, headers:{
//    'Content-Type': 'text/plain'}}).then(response => response.text()).then(data => {
//      alert(data);
//      window.location.href = data;
//      }).catch((error) => {
//      console.error(error);
//    });
    fetch(url,{method: 'post'}).then(response => response.text()).then(data => {
      alert(data);
      window.location.href = data;
      });
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input
          type="text" 
          value={this.state.username}
          onChange={this.handleChange1}
        />
        <input
          type="password" 
          value={this.state.password}
          onChange={this.handleChange2}
        />
        <br />
        <input type="submit" value="Submit" />
      </form>
    );
  }
}


ReactDOM.render(<NameForm />, document.getElementById('create-article-form'));