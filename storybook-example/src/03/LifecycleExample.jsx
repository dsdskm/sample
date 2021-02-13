import React, { Component } from 'react';

class LifecycleExample extends Component {
    static getDerivedStateFromPrpos(){
        console.log('getDerivedStateFromPrpos 호출');
        return {};
    }

    constructor(props){
        super(props);
        this.state={};
        console.log("constructor");
    }

    componentDidMount(){
        console.log("componentDidMount");
    }
    
    componentDidUpdate(){
        console.log("componentDidUpdate");
    }

    componentWillUnmount(){
        console.log("componentWillUnmount");
    }

    getSnapshotBeforeUpdate(){
        console.log("getSnapshotBeforeUpdate");
        return {};
    }

    shouldComponentUpdate(){
        console.log("shouldComponentUpdate");
        return true;
    }

    render() {
        console.log("render");
        return null;
    }
}

export default LifecycleExample;