import "./App.css";
import React from "react";
import Input from "./03/Input";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state={
      count:1
    };
  }

  increaseCount(){
    this.setState(({count})=>({count:count+1}));
  }
  render() {
    return (
      <Input name="AA"/>
    );
  }
}

export default App;
