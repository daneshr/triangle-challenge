const React = require('react');
const ReactDOM = require('react-dom');
const axios = require('axios');
import './main.css';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {sideA: 0, sideB: 0, sideC: 0, message: "", error: ""};
        this.handleAChange = this.handleAChange.bind(this);
        this.handleBChange = this.handleBChange.bind(this);
        this.handleCChange = this.handleCChange.bind(this);
        this.getType = this.getType.bind(this);
    }

    handleAChange(event) {
        this.setState(Object.assign({}, this.state, {sideA: event.target.value}))
    }

    handleBChange(event) {
        this.setState(Object.assign({}, this.state, {sideB: event.target.value}))
    }

    handleCChange(event) {
        this.setState(Object.assign({}, this.state, {sideC: event.target.value}))
    }

    determine() {
        axios.get(`/shape/triangle/${this.state.sideA}/${this.state.sideB}/${this.state.sideC}`)
            .then(response => this.setState({message: response.data, error: ""}))
            .catch(reason => this.setState({error: reason.response.data, message: ""}));
    }

    getType() {
        if (this.state.message != "") {
            return (<div className="status">Type: {this.state.message}</div>)
        } else if (this.state.error != "") {
            return (<div className="error">Error: {this.state.error}</div>)
        }
    }

    render() {
        return (

            <div className="container">
                <div className="title">Triangle Challenge</div>
                <div className="status">
                    <label>
                        side A:
                        <input type="number" value={this.state.sideA} onChange={this.handleAChange}/>
                    </label>
                </div>
                <div className="status">
                    <label>
                        side B:
                        <input type="number" value={this.state.sideB} onChange={this.handleBChange}/>
                    </label>
                </div>
                <div className="status">
                    <label>
                        side C:
                        <input type="number" value={this.state.sideC} onChange={this.handleCChange}/>
                    </label>
                </div>

                <button onClick={() => this.determine()}> Determine Type!</button>
                {this.getType()}
            </div>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
);