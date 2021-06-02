import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component{
    state = {};

    componentDidMount = () => {
        this.getObject();
        this.getArray();
    };

    getArray = () => {
        fetch('/api/array')
            .then(response => response.text())
            .then(message => {
                this.setState({array: message});
            });
    };

    getObject = () => {
        fetch('/api/object')
            .then(response => response.text())
            .then(message => {
                this.setState({object: message});
            });
    };





    render() {
        return (
            <div className="App">
              <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                  Object is <code>{this.state.object}</code>.
                </p>
              </header>
              <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                  Array is <code>{this.state.array}</code>.
                </p>
              </header>
            </div>
        );
    }
}

export default App;
