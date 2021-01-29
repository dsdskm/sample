import React, { Component } from "react";

class Counter extends Component {
  constructor(props) {
    super(props);
    this.handleIncrease = this.handleIncrease.bind(this);
    this.handleDecrease = this.handleDecrease.bind(this);
  }
  state = {
    number: 0,
  };

  handleIncrease = () => {
    this.setState({
      number: this.state.number + 1,
    });
  };

  handleDecrease = () => {
    this.setState({
      number: this.state.number - 1,
    });
  };

  render() {
      /*
      이벤트 이름을 calemCase로 설정해야함. ex) onClick
      메소드를 호출 하면 안됨. 함수 자체를 넘겨야함
      */
    return (
      <div>
        <h1>카운터</h1>
        <div>값: {this.state.number}</div>
        <button onClick={this.handleIncrease}>+</button>
        <button onClick={this.handleDecrease}>-</button>
      </div>
    );
  }
}

export default Counter;
